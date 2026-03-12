import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.animation.FadeTransition;

public class PixelArtApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // --- Minimalist Splash Screen ---
        Label splashLabel = new Label("Pixel Art Studio");
        splashLabel.setStyle(
            "-fx-font-size: 45; " +
            "-fx-text-fill: #e5ff7c; " +
            "-fx-font-family: 'Bradley Hand ITC', 'Segoe UI', sans-serif;"
        );

        StackPane splashRoot = new StackPane(splashLabel);
        splashRoot.setStyle("-fx-background-color: #001a33;");
        Scene splashScene = new Scene(splashRoot, 1100, 950);

        stage.setScene(splashScene);
        stage.setTitle("Pixel Art Studio");
        stage.setResizable(false);
        stage.show();

        // Subtle fade-in
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1.5), splashLabel);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setOnFinished(e -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/pixel.fxml"));
                Scene scene = new Scene(root, 1100, 950);
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        fadeIn.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
