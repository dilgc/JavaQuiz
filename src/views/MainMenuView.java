package views;

import SampleQuizzes.SampleQuizzes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import model.Quiz;
import model.QuizBag;
import util.MenuData;

import java.util.ArrayList;
import java.util.Iterator;

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

    //Declare the QuizBag
    private QuizBag quizBag;

    //Declare the menu bar and its contents
    private MenuBar menuBar;
    private Menu fileMenu;
    private MenuItem importSamplesItem;

    //Declare the arraylist that will have the current page's quizzes
    private ArrayList<Quiz> currentPageQuizzes;
    private Quiz sampleQuiz;
    /**
     * Puts together the stage for the main menu
     */
    public MainMenuView(){

        quizBag = new QuizBag();
        //FIXME: Add try/catch loading, instead of generating a new quiz bag each time the program is run

        //Initialize the menu bar and its contents
        menuBar = new MenuBar();
        fileMenu = new Menu("File");
        importSamplesItem = new MenuItem("Import Samples");

        fileMenu.getItems().add(importSamplesItem);
        menuBar.getMenus().add(fileMenu);

        //Create what happens when you press File > Import Samples
        importSamplesItem.setOnAction(event -> {
            currentPageQuizzes = new ArrayList<>();
            sampleQuiz = new Quiz(SampleQuizzes.Sample_WhichDangan());
            quizBag.insertQuiz(sampleQuiz);
            currentPageQuizzes = quizBag.getPageQuizzes(1);
            fillSlots();
        });

        //Initialize the labels
        pageNumLabel = new Label("Page #:");
        titleLabel = new Label("JavaQuiz by Charles Dilger");
        selectionLabel = new Label("Our quiz selection: ");

        //Format the labels
        titleLabel.setFont(Font.font(20));

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

        pagesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                currentPageQuizzes = quizBag.getPageQuizzes(newValue);
                fillSlots();
            }
        });

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
        root = new VBox(10, menuBar, titleBox, new Line(20, 0, 500, 0), contentBox);
        root.setAlignment(Pos.CENTER);

     }

    /**
     * @return the root of the stage
     */
    public VBox getRoot(){
        return root;
     }


    /**
     * Updates the quizzes on the menu (for when the user changes the page)
     */
    public void fillSlots(){
        Iterator<Quiz> pageQuizIterator= currentPageQuizzes.listIterator();
        Button[] buttonArray = {selection1Button, selection2Button, selection3Button, selection4Button};
        int buttonCounter = 0;
        while(pageQuizIterator.hasNext() && buttonCounter < 4){
            Quiz quiz = pageQuizIterator.next();
            System.out.println(quiz.getTitle());
            buttonArray[buttonCounter++].setText(quiz.getTitle());
        }
        while(buttonCounter < 4){
            buttonArray[buttonCounter++].setText("[ EMPTY ]");
        }
     }

}
