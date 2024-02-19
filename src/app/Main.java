package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.*;

/**
 * Main class for the project, which will simply start the stage at runtime.
 *
 * @author Charles Dilger
 */
public class Main extends Application {

    /**
     * The main class, which will be ignored by nature of JavaFX applications
     * @param args
     */
    public static void main(String[] args) { launch(args); }

    /**
     * The start method, where the scene is set up on the primary stage
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        //Set the scene with the main menu
        VBox root = new MainMenuView().getRoot();

        Scene scene = new Scene(root, 500, 300);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}