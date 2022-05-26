package ticTacToe;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class TicTacToeApplication extends Application {

    private int turnNumber;
    private String mark;

    public TicTacToeApplication (){
        this.turnNumber = 1;
        this.mark = "X";
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
  
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 1.1 Create layout
        BorderPane layout = new BorderPane();

        // 1.2 Create labels
        
        Label turn = new Label("Turn: X"); // default turn is X
        turn.setFont(Font.font("Monospaced", 50));

        // 2.0 Add to main layout
            // refer to method '.getTicTacGrind(Label turn)'

        // 2.4 add views
        layout.setTop(turn);
        layout.setCenter(getTicTacGrid(turn));

        // 3.0 Set scene
        Scene view = new Scene(layout);
        // ENDED: part 1 ==========


        // X.0 setUp
        primaryStage.setScene(view);
        primaryStage.show();

    }

    private GridPane getTicTacGrid(Label turn) {
        GridPane gameGP = new GridPane();

        // 2.2 Add components

        for (int x = 0; x < 3; x++){ 
            for (int y = 0; y < 3; y++) {
                Button btn = new Button(" ");
                btn.setFont(Font.font("Monospaced", 40));
                btn.setOnMouseClicked((event) -> {

                    if (!btn.getText().replaceAll(" ", "").isEmpty()) {
                        return;
                    }


                    btn.setText(String.format("%s", mark));
                    turnNumber++;

                    if (turnNumber % 2 != 0) { // turn X
                        mark = "X";
                    } else { // turn 0
                        mark = "O";
                    }

                    turn.setText(String.format("Turn: %s", mark));
                    

                    if (turnNumber > 9) {
                        turn.setText("The end!");
                    }

                });
                    
                gameGP.add(btn, x, y);

            }

        }

        // 2.3 Stylize
        gameGP.setPadding(new Insets(20, 20, 20, 20));
        gameGP.setHgap(20);
        gameGP.setVgap(20);

        return gameGP;
    }

    
}
