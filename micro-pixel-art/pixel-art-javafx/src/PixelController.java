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
import java.util.Stack;

public class PixelController {
    @FXML private GridPane gridContainer;
    @FXML private Slider gridSize;
    @FXML private Label sizeValue;
    @FXML private ColorPicker colorPicker;
    @FXML private ToggleButton eraserBtn;

    private final double CANVAS_SIZE = 600.0;
    private final String CELL_BG = "#001a33";  

    // Undo/Redo stacks
    private final Stack<Action> undoStack = new Stack<>();
    private final Stack<Action> redoStack = new Stack<>();

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
                    if (event.isControlDown() && event.getCode() == KeyCode.Z) handleUndo();
                    if (event.isControlDown() && event.getCode() == KeyCode.Y) handleRedo();
                });
            }
        });

        handleGenerate(); 
    }

    @FXML
    private void handleGenerate() {
        gridContainer.getChildren().clear();
        int size = (int) gridSize.getValue();
        double cellSize = CANVAS_SIZE / size;

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
        Color oldColor = (Color) cell.getFill();
        Color newColor = eraserBtn.isSelected() ? Color.web(CELL_BG) : colorPicker.getValue();

        if (!oldColor.equals(newColor)) {
            cell.setFill(newColor);
            undoStack.push(new Action(cell, oldColor, newColor));
            redoStack.clear(); // once you paint, redo history resets
        }
    }

    @FXML
    private void handleClear() {
        gridContainer.getChildren().forEach(n -> {
            if (n instanceof Rectangle) {
                Rectangle cell = (Rectangle) n;
                Color oldColor = (Color) cell.getFill();
                cell.setFill(Color.web(CELL_BG));
                undoStack.push(new Action(cell, oldColor, Color.web(CELL_BG)));
                redoStack.clear();
            }
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

    @FXML
    private void handleUndo() {
        if (!undoStack.isEmpty()) {
            Action action = undoStack.pop();
            action.cell.setFill(action.oldColor);
            redoStack.push(action);
        }
    }

    @FXML
    private void handleRedo() {
        if (!redoStack.isEmpty()) {
            Action action = redoStack.pop();
            action.cell.setFill(action.newColor);
            undoStack.push(action);
        }
    }

    // Helper class to store actions
    private static class Action {
        Rectangle cell;
        Color oldColor;
        Color newColor;

        Action(Rectangle cell, Color oldColor, Color newColor) {
            this.cell = cell;
            this.oldColor = oldColor;
            this.newColor = newColor;
        }
    }
}
