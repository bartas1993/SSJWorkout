package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private ObservableList<String> exercises = FXCollections.observableArrayList();
    private ObservableList<String> repOB = FXCollections.observableArrayList();
    private ObservableList<String> setBoxOB = FXCollections.observableArrayList();
   // private ObservableList<String> addToWorkout = FXCollections.observableArrayList();//
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
    @FXML public Label lv,class1,userExp,userExp2,totalExp,kaio,kaio1,desc,warning,warning1,warning2,warning3;
    @FXML public ImageView facebookLogIn,scouterImg,kaiokenImg,gokuLogin;
    @FXML public Tab achievement,AvatarTab,WorkoutsTab,LogTab,GlobalTab;
    @FXML public ComboBox<String> bodyPart,exerciseBox,repBox,setBox;
    @FXML public Button addEX,loginBtn,registerBtn;
    @FXML public TextField usernameF;
    @FXML public PasswordField passwordF;
    @FXML public WebView website;


    public Controller() {

    }
    private boolean isLoggedin = false;
    private boolean tableCreated= false;
    private double gotExp;
    private double gotExp2;
    private double exp =gotExp+gotExp2;
    private double totExp = gotExp+gotExp2;
    private double zero;
    private double one;
    private double two;
    private double three;
    private double four;
    private double five;
    private double six;
    private double seven;
    private double eight;

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
                    isLoggedin = true;
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
               System.out.println("Connection Established!");

               return true;

            }
        return false;
    }
    //EXPERIENCE AND LEVELING SYSTEM//////////////////////////////////////////////////////////////////////////////////////
   //public void levelAndExpSystem(){


    //}
    private void setRepsAndSets()
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
    private void initializeGUIComponnents()
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
    private void disclai()
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
    public void userLogIn()
    {
        //levelAndExpSystem();//Initialize Experience and Level System flow
        Connection con;
        Connection con2;
        PreparedStatement pst;
        Statement pstTable;
        String tableName = usernameF.getText()+"Table";
        ResultSet rs;
        String sqlStatement = "SELECT username and password from users WHERE username=? and password =?";
        String sqlStatement2 = "CREATE TABLE IF NOT EXISTS " +tableName+
                "(endurance      DOUBLE,"+
                "strength       DOUBLE,"+
                "speed          DOUBLE)";
        try {
            con = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/extype?verifyServerCertificate=false&useSSL=false", "bartoszkepke09", "bartoszkepke00099912");
            pst = con.prepareStatement(sqlStatement);
            pst.setString(1,usernameF.getText());
            pst.setString(2,passwordF.getText());
            rs = pst.executeQuery();
            LogTab.setDisable(true);
            AvatarTab.setDisable(false);
            GlobalTab.setDisable(false);
            WorkoutsTab.setDisable(false);
            LogTab.setDisable(false);
            achievement.setDisable(false);
            if(!rs.next())
            {
                Alert alerto = new Alert(Alert.AlertType.WARNING);
                alerto.setHeaderText("DEAR USER!");
                alerto.setTitle("IMPORTANT");
                alerto.setContentText("Wrong User Details \n" + "Please Try Again");
                alerto.showAndWait();
            }
            else
                {
                    tableCreated=false;
                    con2 = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/extype?verifyServerCertificate=false&useSSL=false", "bartoszkepke09", "bartoszkepke00099912");
                    pstTable =con2.createStatement();
                    pstTable.executeUpdate(sqlStatement2);
                    System.out.println("Table for user " + usernameF.getText() + " created");
                    System.out.println("Table name is: " + tableName);
                    isLoggedin = true;
                    tableCreated=true;
                    pstTable.close();
                    String [] classes = {"KaioKen","SSJ","Ultra SSJ","SSJ2","SSJ3","SSJRage","SSG","SSB","SSBKaioken","SSBKaiokenX10",
                            "SSBKaiokenx20","Mastered SSB","Omen","UltraInstinct"};
                    int levelup = 1;
                    double totalExpNeed = 9000;
                    userExp2.setText(String.valueOf(totalExpNeed));
                    lv.setText(String.valueOf(levelup));
                    exp =gotExp+gotExp2;
                    totExp = gotExp+gotExp2;
                    zero = 1000;
                    one = 2500;
                    two = 3500;
                    three = 4500;
                    four = 5500;
                    five = 6500;
                    six = 7500;
                    seven = 8500;
                    eight = 9000;
                    Connection con3;
                    con3 = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/extype?verifyServerCertificate=false&useSSL=false", "bartoszkepke09", "bartoszkepke00099912");
                    String sqlQuery3 = "Select * from AdminTable";
                    Statement psts = con3.createStatement();
                    ResultSet rsx = psts.executeQuery(sqlQuery3);

                    while (rsx.next())
                    {
                        gotExp= rsx.getDouble("endurance");
                        gotExp2= rsx.getDouble("strength");
                        exp = rsx.getDouble("speed");
                        System.out.println("DATA SET");
                        userExp.setText(String.valueOf(exp+2500));
                        totalExp.setText(String.valueOf(exp + 2450 *1.01));
                        usernameF.setVisible(false);
                        passwordF.setVisible(false);
                        loginBtn.setVisible(false);
                        desc.setVisible(false);
                        warning.setVisible(false);
                        warning1.setVisible(false);
                        warning2.setVisible(false);
                        warning3.setVisible(false);
                        registerBtn.setVisible(false);
                        gokuLogin.setOpacity(1);
                        website.setVisible(true);
                        totalExpNeed = 9000;
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
                            levelBar.setProgress(0.45);
                        }
                        if (exp>=one & exp<two)
                        {
                            levelBar.setProgress(0.55);
                        }
                        if (exp>=two & exp<three)
                        {
                            levelBar.setProgress(0.65);
                        }
                        if (exp>=three & exp<four)
                        {
                            levelBar.setProgress(0.75);
                        }
                        if (exp>=four & exp<five)
                        {
                            levelBar.setProgress(0.85);
                        }
                        if (exp>=five & exp<six)
                        {
                            levelBar.setProgress(0.88);
                        }
                        if (exp>=six & exp<seven)
                        {
                            levelBar.setProgress(0.90);
                        }
                        if (exp>=seven & exp<eight)
                        {
                            levelBar.setProgress(0.92);
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


                }


        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }
    private void playMusic()
    {
        final URL resource = getClass().getResource("theme.mp3");
        final Media media = new Media(resource.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.isAutoPlay();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)  {
                disclai(); //Initialize information for the user
            if (testConnection()) {
                isLoggedin=true;
                playMusic();
                initializeGUIComponnents(); //Initialize GUI components and its behaviours
                comboboxBodyParts(); //Add elements to Combo Box Body Parts from database
                setRepsAndSets(); //Set values for Reps and Sets Combo Boxes

                /**/
    }



}}
