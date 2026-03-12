import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.scene.image.WritableImage;
import javafx.scene.SnapshotParameters;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PixelController {
    @FXML private GridPane gridContainer;
    @FXML private Slider gridSize;
    @FXML private Label sizeValue;
    @FXML private ColorPicker colorPicker;
    @FXML private ToggleButton eraserBtn;

    private final double CANVAS_SIZE = 600.0;
    private final String CELL_BG = "#001a33";  

    @FXML
    public void initialize() {
        gridSize.valueProperty().addListener((obs, old, val) -> {
            sizeValue.setText(val.intValue() + " x " + val.intValue());
        });

        // Initial brush color
        colorPicker.setValue(Color.web("#ffcc00"));

        gridContainer.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.C) handleClear();
                    if (event.getCode() == KeyCode.E) eraserBtn.setSelected(!eraserBtn.isSelected());
                });
            }
        });

        handleGenerate(); 
    }

    @FXML
    private void handleGenerate() {
        gridContainer.getChildren().clear();
        int size = (int) gridSize.getValue();
        double cellSize = CANVAS_SIZE / size; // fixed math

        gridContainer.setHgap(1);
        gridContainer.setVgap(1);
        gridContainer.setStyle("-fx-background-color: rgba(0, 10, 30, 0.5); -fx-padding: 3;");  

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle cell = new Rectangle(cellSize, cellSize, Color.web(CELL_BG));

                cell.setOnMousePressed(e -> paintCell(cell));
                cell.setOnDragDetected(e -> cell.startFullDrag());
                cell.setOnMouseDragEntered(e -> paintCell(cell));

                gridContainer.add(cell, col, row);
            }
        }
    }

    private void paintCell(Rectangle cell) {
        if (eraserBtn.isSelected()) {
            cell.setFill(Color.web(CELL_BG));
        } else {
            cell.setFill(colorPicker.getValue());
        }
    }

    @FXML
    private void handleClear() {
        gridContainer.getChildren().forEach(n -> {
            if (n instanceof Rectangle) ((Rectangle) n).setFill(Color.web(CELL_BG));
        });
    }

    @FXML
    private void handleSave() {
        WritableImage snapshot = gridContainer.snapshot(new SnapshotParameters(), null);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Pixel Art");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files", "*.png"));
        File file = fileChooser.showSaveDialog(gridContainer.getScene().getWindow());

        if (file != null) {
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
