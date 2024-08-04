package Algorithims;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import java.util.ArrayList;


public class GainController {
    @FXML
    private ScrollPane S;
    @FXML
    private HBox HB;
    @FXML
    private Button SH;
    static ArrayList<Integer>gain=new ArrayList<>();
    public void Show(){

        S.setContent(HB);
        gain=Controller.getGain();
        for(int j=0;j<gain.size();j++) {
            TextField t = new TextField();
            t.setMaxSize(30,20);
            t.setMinSize(30,20);
            t.setText(String.valueOf(gain.get(j).intValue()));
            HB.getChildren().add(t);
        }
        }

}
