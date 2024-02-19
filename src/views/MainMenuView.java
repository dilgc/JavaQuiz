package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import util.MenuData;

public class MainMenuView implements MenuData {
    //Declare the labels
    private Label pageNumLabel;
    private Label titleLabel;
    private Label selectionLabel;

   //Declare the 4 buttons that will display quiz options on the right side
    private Button selection1Button;
    private Button selection2Button;
    private Button selection3Button;
    private Button selection4Button;

   //Declare the observable list which will hold the page numbers
    private ObservableList<Integer> pages;

    //Declare the list view which the observable list will be inside of
    private ListView<Integer> pagesListView;

   //Declare the VBoxes
    private VBox pageBox;
    private VBox buttonBox;
    private VBox selectionBox;
    private VBox titleBox;
    private VBox root;

    //Declare the HBoxes
    private HBox contentBox;


    /**
     * Puts together the stage for the main menu
     */
    public MainMenuView(){
        //Initialize the labels
        pageNumLabel = new Label("Page #:");
        titleLabel = new Label("JavaQuiz by Charles Dilger");
        selectionLabel = new Label("Our quiz selection: ");

        //FIXME add formatting for the labels

        //Initialize the buttons
        selection1Button = new Button("[ EMPTY ]");
        selection2Button = new Button("[ EMPTY ]");
        selection3Button = new Button("[ EMPTY ]");
        selection4Button = new Button("[ EMPTY ]");

        //Add formatting for the buttons
        selection1Button.setMinWidth(BUTTON_WIDTH);
        selection2Button.setMinWidth(BUTTON_WIDTH);
        selection3Button.setMinWidth(BUTTON_WIDTH);
        selection4Button.setMinWidth(BUTTON_WIDTH);

        selection1Button.setPrefHeight(BUTTON_LENGTH);
        selection2Button.setPrefHeight(BUTTON_LENGTH);
        selection3Button.setPrefHeight(BUTTON_LENGTH);
        selection4Button.setPrefHeight(BUTTON_LENGTH);

        //Initialize and fill the observable arraylist
        pages = FXCollections.observableArrayList();
        for(int i = 0; i < DEFAULT_NUMPAGES; i++){
           pages.add(i+1);
        }

        //Initialize and fill the list view of page numbers
        pagesListView = new ListView<>(pages);

        //Initialize the VBoxes and HBoxes
        pageBox = new VBox(5, pageNumLabel, pagesListView);
        buttonBox = new VBox(2, selection1Button, selection2Button, selection3Button, selection4Button);
        selectionBox = new VBox(5, selectionLabel, buttonBox);
        titleBox = new VBox(0, titleLabel);
        HBox contentBox = new HBox(10, pageBox, new Line(10, 10, 10, 250), selectionBox);

        //Format the VBoxes
        titleBox.setAlignment(Pos.CENTER);
        pageBox.setMaxWidth(100);
        pageBox.setPadding(new Insets(10));
        selectionBox.setPadding(new Insets(10));
        buttonBox.setPrefWidth(355);

        //Create the root
        root = new VBox(10, titleBox, contentBox);
        root.setAlignment(Pos.CENTER);

     }

    /**
     * @return the root of the stage
     */
    public VBox getRoot(){
        return root;
     }

}
