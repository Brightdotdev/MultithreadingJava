package org.example.multithreadingjavapractive;

import javafx.fxml.FXML;
import javafx.scene.Cursor;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.multithreadingjavapractive.Utils.DictionarySearcher;
import org.example.multithreadingjavapractive.Utils.WordObject;
import java.util.List;
public class HelloController {
    @FXML
    private Text word;
    @FXML
    private Text wordType;
    @FXML
    private Text definition;
    @FXML
    private TextField inputType;

    @FXML
    private ScrollPane scrollPaneContainer;
    @FXML
    private VBox suggestions;
    private Stage stage;
    @FXML
    private Label welcomeText;

    public  HelloController(){}


    public  Text newTextElement(WordObject object){
        Text newTextElement = new Text();
        newTextElement.setCursor(Cursor.HAND);
        newTextElement.setFont(Font.font("Poppins",18));
        newTextElement.setStyle("-fx-padding: 10 20 10 20;");
        newTextElement.setText(String.valueOf(object.getWord()));
        newTextElement.setOnMouseClicked(e ->{
            word.setText(object.getWord());
            definition.setText(object.getWordDefinition());
            wordType.setText(object.getWordType());
        });

        return  newTextElement;
    }

    public void vboxPopulate(List<WordObject> wordObjectList){
        suggestions.getChildren().clear();
        for (WordObject wordObject : wordObjectList){
            suggestions.getChildren().add(newTextElement(wordObject));
        }
    }


    public void initialize() {
        DictionarySearcher searcher = new DictionarySearcher(1);

        inputType.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
              scrollPaneContainer.setVisible(true);

               List<WordObject> wordObjectList = searcher.searchDefinition(newValue);
               if(wordObjectList.isEmpty()){
                   Text noSuggestions =new Text("No suggestions");
                   noSuggestions.setFont(Font.font("Poppins",18));
                   noSuggestions.setStyle("-fx-padding: 10 20 10 20;");
                   suggestions.getChildren().clear();
                   suggestions.getChildren().add(noSuggestions);
               }else {
               vboxPopulate(wordObjectList);
               }
            } else {
                Text noSuggestions =new Text("No suggestions");
                noSuggestions.setFont(Font.font("Poppins",18));
                noSuggestions.setStyle("-fx-padding: 10 20 10 20;");
                suggestions.getChildren().clear();
                suggestions.getChildren().add(noSuggestions);
                System.out.println("omo");
            }
        });
    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}