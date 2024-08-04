package Algorithims;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable  {
   @FXML
    private Button addPro ;
    @FXML
    private Button SF ;
   @FXML
   private Button ROR ;
    @FXML
    private Button GA ;
    @FXML
    private TextField AvgTA;
    @FXML
    private TextField WTAA;
   @FXML
    private TableColumn<Process_ATTributes,Integer> PID ;
    @FXML
    private TableColumn<Process_ATTributes,Integer> AT ;
    @FXML
    private TableColumn<Process_ATTributes,Integer> BT ;
    @FXML
    private TableColumn<Process_ATTributes,Double> WTA ;
    @FXML
    private TableColumn<Process_ATTributes,Integer> TA ;
    @FXML
    private TableColumn<Process_ATTributes,Integer> FT ;
    @FXML
    private TableColumn<Process_ATTributes,Integer> DE ;
    @FXML
    private TableColumn<Process_ATTributes,Integer> RE ;
    @FXML
    private TableColumn<Process_ATTributes,Integer> WT ;
    @FXML
    private TableColumn<Process_ATTributes,Integer> PR ;
    @FXML
    private TextField time ;
    @FXML
    private  TextField AvgWA;
    static ArrayList<Integer> gain;
    @FXML
    private TableView <Process_ATTributes> TV;
    static ObservableList<Process_ATTributes> data = FXCollections.observableArrayList();
    private ArrayList<Process_ATTributes> list ;
    @FXML
    private Button SRR ;
 @FXML
 public void AddPro() throws FileNotFoundException {
   readfile r = new readfile();
   r.openfile();
   list = r.readfile();
   r.closefile();
   for(int i =0; i<list.size();i++)
       data.add(list.get(i));
    }

    @Override
 public void initialize(URL location, ResourceBundle resources) {
      try {

          PID.setCellValueFactory(new PropertyValueFactory<>("PID"));
          AT.setCellValueFactory(new PropertyValueFactory<>("Arrival_time"));
          BT.setCellValueFactory(new PropertyValueFactory<>("burst_time"));
          PR.setCellValueFactory(new PropertyValueFactory<>("interval_time"));
          RE.setCellValueFactory(new PropertyValueFactory<>("rebeat"));
          DE.setCellValueFactory(new PropertyValueFactory<>("Deadline"));
          TV.setItems(data);
          TV.setEditable(true);
      }
      catch (NullPointerException exe){
          System.out.println(exe);
      }
  }
  public void ROR(){

       list=RR.get_calculation(list,Integer.valueOf(time.getText()));
       Process_ATTributes.Calculation(list);
       gain=RR.getGain();
       FT.setCellValueFactory(new PropertyValueFactory<>("Finished_Time"));
       TA.setCellValueFactory(new PropertyValueFactory<>("TA"));
       WT.setCellValueFactory(new PropertyValueFactory<>("wait"));
       WTA.setCellValueFactory(new PropertyValueFactory<>("WTA"));
       TV.refresh();
       AvgTA.setText(String.valueOf(list.get(0).get_Tatavg()));
       AvgWA.setText(String.valueOf(list.get(0).get_Waitavg()));
       WTAA.setText(String.valueOf(list.get(0).get_WTavg()));
  }
  public void SRRJF(){
    list=SRJF.get_calculation(list);
    Process_ATTributes.Calculation(list);
    gain=SRJF.get_gain();
      FT.setCellValueFactory(new PropertyValueFactory<>("Finished_Time"));
      TA.setCellValueFactory(new PropertyValueFactory<>("TA"));
      WT.setCellValueFactory(new PropertyValueFactory<>("wait"));
      WTA.setCellValueFactory(new PropertyValueFactory<>("WTA"));
      TV.refresh();
      AvgTA.setText(String.valueOf(list.get(0).get_Tatavg()));
      AvgWA.setText(String.valueOf(list.get(0).get_Waitavg()));
      WTAA.setText(String.valueOf(list.get(0).get_WTavg()));
  }
  public void FCF(){
      FCFS.get_calculation(list);
      Process_ATTributes.Calculation(list);
      gain=FCFS.getGain();
      FT.setCellValueFactory(new PropertyValueFactory<>("Finished_Time"));
      TA.setCellValueFactory(new PropertyValueFactory<>("TA"));
      WT.setCellValueFactory(new PropertyValueFactory<>("wait"));
      WTA.setCellValueFactory(new PropertyValueFactory<>("WTA"));
      TV.refresh();
      AvgTA.setText(String.valueOf(list.get(0).get_Tatavg()));
      AvgWA.setText(String.valueOf(list.get(0).get_Waitavg()));
      WTAA.setText(String.valueOf(list.get(0).get_WTavg()));
  }
  @FXML
    public void EPP(){
        EP.get_calculation(list);
        Process_ATTributes.Calculation(list);
        gain=EP.getGain();
        FT.setCellValueFactory(new PropertyValueFactory<>("Finished_Time"));
        TA.setCellValueFactory(new PropertyValueFactory<>("TA"));
        WT.setCellValueFactory(new PropertyValueFactory<>("wait"));
        WTA.setCellValueFactory(new PropertyValueFactory<>("WTA"));
        TV.refresh();
        AvgTA.setText(String.valueOf(list.get(0).get_Tatavg()));
        AvgWA.setText(String.valueOf(list.get(0).get_Waitavg()));
        WTAA.setText(String.valueOf(list.get(0).get_WTavg()));
    }
public  void GA()  {

         try {

             Stage primary = new Stage();
             Pane root = (Pane) FXMLLoader.load(getClass().getResource("GainChart.fxml"));
             Scene scene = new Scene(root);
             primary.setTitle("Gain Chart");
             primary.setScene(scene);
             primary.show();

         }
         catch (IOException exe){
             System.out.println(exe);
         }

  }
  @FXML
  public void SF(){
      SJF.get_Calculations(list);
      Process_ATTributes.Calculation(list);
      gain=SJF.getGain();
      FT.setCellValueFactory(new PropertyValueFactory<>("Finished_Time"));
      TA.setCellValueFactory(new PropertyValueFactory<>("TA"));
      WT.setCellValueFactory(new PropertyValueFactory<>("wait"));
      WTA.setCellValueFactory(new PropertyValueFactory<>("WTA"));
      TV.refresh();
      AvgTA.setText(String.valueOf(list.get(0).get_Tatavg()));
      AvgWA.setText(String.valueOf(list.get(0).get_Waitavg()));
      WTAA.setText(String.valueOf(list.get(0).get_WTavg()));



  }
  public static ArrayList<Integer> getGain(){
     return gain;
  }
    @FXML
    public void EPN(){
        EPNon.get_calculation(list);
        Process_ATTributes.Calculation(list);
        gain=EPNon.getGain();
        FT.setCellValueFactory(new PropertyValueFactory<>("Finished_Time"));
        TA.setCellValueFactory(new PropertyValueFactory<>("TA"));
        WT.setCellValueFactory(new PropertyValueFactory<>("wait"));
        WTA.setCellValueFactory(new PropertyValueFactory<>("WTA"));
        TV.refresh();
        AvgTA.setText(String.valueOf(list.get(0).get_Tatavg()));
        AvgWA.setText(String.valueOf(list.get(0).get_Waitavg()));
        WTAA.setText(String.valueOf(list.get(0).get_WTavg()));
    }

}
