package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private ObservableList<String> exercises = FXCollections.observableArrayList();
    private ObservableList<String> repOB = FXCollections.observableArrayList();
    private ObservableList<String> setBoxOB = FXCollections.observableArrayList();
    private ObservableList<String> addToWorkout = FXCollections.observableArrayList();
    @FXML public TableView workoutTable = new TableView();
    @FXML public TableColumn Exercise = new TableColumn();
    @FXML public TableColumn BodyParts = new TableColumn();
    @FXML public TableColumn Repss = new TableColumn();
    @FXML public TableColumn Setss = new TableColumn();
    @FXML public TableColumn Weight = new TableColumn();
    @FXML public TableColumn Time = new TableColumn();
    @FXML public TableColumn Experience = new TableColumn();
    @FXML public ProgressBar levelBar;
    @FXML public ProgressBar staminaBar;
    @FXML public ProgressBar strengthBar;
    @FXML public Label lv,class1,userExp,userExp2,totalExp,kaio,kaio1;
    @FXML public ImageView facebookLogIn,scouterImg,kaiokenImg;
    @FXML public Tab achievement;
    @FXML public ComboBox<String> bodyPart,exerciseBox,repBox,setBox;
    @FXML public Button addExp,addEX;

    public Controller() {

    }

    private void comboboxBodyParts() {
        Connection con = null;
        PreparedStatement pst;
        ResultSet rs;
        try {
            con = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/extype?verifyServerCertificate=false&useSSL=false", "bartoszkepke09", "bartoszkepke00099912");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(con!=null)
        {

            System.out.println("Succesfull connection");
            try {
                pst = con.prepareStatement("select * from bodypart");
                rs = pst.executeQuery();
                while (rs.next()){
                    exercises.addAll("NAME:"+ rs.getString("exname") +" /BODYPART:"+ rs.getString("bodypart") + " /EXP:"+ rs.getString("exp")+" /ENDURANCE:"
                            +rs.getString("endurance")+" /STRENGTH:"+rs.getString("strength") +" /SPEED:" +rs.getString("speed"));
                    exerciseBox.setItems(exercises);
                }
                pst.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
    //test Connection/////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean testConnection()
    {

        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/extype?verifyServerCertificate=false&useSSL=false", "bartoszkepke09", "bartoszkepke00099912");

        } catch (SQLException e) {
            e.printStackTrace();
        }
            if(con!=null)
            {
               System.out.println("Tested working");

               return true;

            }
        return false;
    }
    //EXPERIENCE AND LEVELING SYSTEM//////////////////////////////////////////////////////////////////////////////////////
    private void levelAndExpSystem(){
        String [] classes = {"KaioKen","SSJ","Ultra SSJ","SSJ2","SSJ3","SSJRage","SSG","SSB","SSBKaioken","SSBKaiokenX10",
                "SSBKaiokenx20","Mastered SSB","Omen","UltraInstinct"};
        int levelup = 1;
        double totalExpNeed = 9000;
        userExp2.setText(String.valueOf(totalExpNeed));
        lv.setText(String.valueOf(levelup));
        double gotExp = 1500;
        double gotExp2 = 0;
        double exp =gotExp+gotExp2;
        double totExp = gotExp+gotExp2;
        double zero = 1000;
        double one = 2500;
        double two = 3500;
        double three = 4500;
        double four = 5500;
        double five = 6500;
        double six = 7500;
        double seven = 8500;
        double eight = 9000;
        totalExp.setText(String.valueOf(totExp*1.01));
        userExp.setText(String.valueOf(exp));
        if(totalExpNeed >= 999999998)
        {
            int result =levelup;
            result++;
            levelBar.setProgress(0);

            userExp.setText(String.valueOf(exp));
            totalExpNeed+=50;
            lv.setText(String.valueOf(result));

            userExp2.setText(String.valueOf(totalExpNeed));
            class1.setText(classes[9]);
        }
        if(exp>=totalExpNeed)
        {
            totalExpNeed+=1000;
            int result =levelup;
            result++;
            userExp.setText(String.valueOf(exp));
            lv.setText(String.valueOf(result));
            userExp2.setText(String.valueOf(totalExpNeed));
            zero +=111;
            one +=111;
            two +=111;
            three +=111;
            four +=111;
            five +=111;
            six +=111;
            seven +=111;
            eight +=111;
            for(int a=0;a<classes.length;a++)
            {
                int i=0;
                class1.setText(classes[i]);
                i++;
            }
        }
        if (exp>=zero & exp<one)
        {
            levelBar.setProgress(0.25);
        }
        if (exp>=one & exp<two)
        {
            levelBar.setProgress(0.35);
        }
        if (exp>=two & exp<three)
        {
            levelBar.setProgress(0.45);
        }
        if (exp>=three & exp<four)
        {
            levelBar.setProgress(0.55);
        }
        if (exp>=four & exp<five)
        {
            levelBar.setProgress(0.65);
        }
        if (exp>=five & exp<six)
        {
            levelBar.setProgress(0.75);
        }
        if (exp>=six & exp<seven)
        {
            levelBar.setProgress(0.85);
        }
        if (exp>=seven & exp<eight)
        {
            levelBar.setProgress(0.95);
        }

        if (exp>=9000){
            scouterImg.setOpacity(1.0);
            achievement.setText("Achievements('ITS...ITS OVER 9000!!')");
            achievement.setStyle(String.valueOf(Color.ROYALBLUE));
        }
        if (exp>=18000){

            kaiokenImg.setOpacity(1.0);
            achievement.setText("Achievements(KAIOKENNN!!)");
            achievement.setStyle(String.valueOf(Color.ROYALBLUE));
        }

    }
    public void setRepsAndSets()
    {
        int [] reps ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,
                37,38,39,40,41,42,43,44,45,46,47,48,49};
        int [] sets ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

        for(int a=0;a<reps.length;a++)
        {
            repOB.addAll(String.valueOf(reps[a]));
            repBox.setItems(repOB);
        }
        for(int a=0;a<sets.length;a++)
        {
            setBoxOB.addAll(String.valueOf(sets[a]));
            setBox.setItems(setBoxOB);
        }
    }
    public void initializeGUIComponnents()
    {
        achievement.setOnSelectionChanged(e->
                achievement.setText("Achievements"));
        scouterImg.setOnMouseEntered(event -> {
            scouterImg.setScaleY(1.1);
            scouterImg.setScaleZ(1.1);
            scouterImg.setScaleX(1.1);
            kaio1.setVisible(true);
        });
        scouterImg.setOnMouseExited(event -> {
            scouterImg.setScaleY(1);
            scouterImg.setScaleZ(1);
            scouterImg.setScaleX(1);
            kaio1.setVisible(false);
        });
        kaiokenImg.setOnMouseEntered(event -> {
            kaiokenImg.setScaleY(1.1);
            kaiokenImg.setScaleZ(1.1);
            kaiokenImg.setScaleX(1.1);
            kaio.setVisible(true);
        });
        kaiokenImg.setOnMouseExited(event -> {
            kaiokenImg.setScaleY(1);
            kaiokenImg.setScaleZ(1);
            kaiokenImg.setScaleX(1);
            kaio.setVisible(false);
        });
        addEX.setOnMouseClicked(event ->
        {

        });
    }
    public void disclai()
    {
        Alert alerto = new Alert(Alert.AlertType.INFORMATION);
        alerto.setHeaderText("DEAR USER!");
        alerto.setTitle("IMPORTANT");
        alerto.setContentText("It's important you train with your own health and safety on mind \n"+
                "We are not responsible for any injuries acquired before,during or after training \n"+
                "Don't forget to eat well, sleep well and train well \n"+
                "Have fun and stay HEALTHLY!!");
        alerto.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(testConnection()) {
                disclai(); //Initialize information for the user
                initializeGUIComponnents(); //Initialize GUI components and its behaviours
                levelAndExpSystem();//Initialize Experience and Level System flow
                comboboxBodyParts(); //Add elements to Combo Box Body Parts from database
                setRepsAndSets(); //Set values for Reps and Sets Combo Boxes



        }


    }
}
