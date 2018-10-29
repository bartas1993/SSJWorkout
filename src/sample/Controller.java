package sample;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import facebook4j.User;
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
    private ObservableList<String> exercisesBic = FXCollections.observableArrayList();
    @FXML public ProgressBar levelBar;
    @FXML public ProgressBar staminaBar;
    @FXML public ProgressBar strengthBar;
    @FXML public Label lv,class1,userExp,userExp2,totalExp;
    @FXML public ImageView itsOver9000,itsover15000,facebookLogIn;
    @FXML public Tab achievement;
    @FXML public ComboBox<String> bodyPart,exerciseBox;

    private void comboboxBodyParts() {
        //Initialize Connection//
        Connection con = null;
        PreparedStatement pst;
        ResultSet rs;
        boolean isIt = false;
        try {
            con = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/exType?verifyServerCertificate=false&useSSL=false", "bartoszkepke09", "bartoszkepke00099912");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(con!=null)
        {

            System.out.println("Succesfull connection");
            try {
                pst = con.prepareStatement("select * from bodytype");
                rs = pst.executeQuery();
                while (rs.next()){
                    exercises.addAll(rs.getString("name"));
                    bodyPart.setItems(exercises);
                    isIt=true;

                }
                pst.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
    public void getTriceps()
    {
            Connection con2;
            PreparedStatement pst2;
            ResultSet rs2;
            try {
                con2 = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/exType?verifyServerCertificate=false&useSSL=false", "bartoszkepke09", "bartoszkepke00099912");
                pst2 = con2.prepareStatement("Select * from triceps");
                rs2 = pst2.executeQuery();
                while (rs2.next()){
                    exercisesBic.addAll(rs2.getString("name"));
                    exerciseBox.setItems(exercisesBic);
                }
                con2.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
   public void getBiceps() {

                    Connection con;
                    PreparedStatement pst;
                    ResultSet rs;
                    try {
                        con = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/exType?verifyServerCertificate=false&useSSL=false", "bartoszkepke09", "bartoszkepke00099912");
                        pst = con.prepareStatement("Select * from biceps");
                        rs = pst.executeQuery();
                        while (rs.next()){
                            exercisesBic.addAll(rs.getString("name"));
                            exerciseBox.setItems(exercisesBic);
                        }
                        con.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

    private boolean testConnection()
    {
        //test Connection//
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/exType?verifyServerCertificate=false&useSSL=false", "bartoszkepke09", "bartoszkepke00099912");

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        testConnection();
        if(testConnection()) {
            comboboxBodyParts(); //Add elements to combobox from database

        }
        //LEVEL SYSTEM//
        String [] classes = {"KaioKen","SSJ","SSJ2","SSJ3","SSG","SSB","SSBKaioken",
                "SSBKaiokenx20","Omen","UltraInstinct"};
        int levelup = 1;
        double totalExpNeed = 9000;
        userExp2.setText(String.valueOf(totalExpNeed));
        lv.setText(String.valueOf(levelup));
        double gotExp = 0;
        double gotExp2 = 0;
        double exp =gotExp+gotExp2;
        double totExp = gotExp+gotExp2;
        totalExp.setText(String.valueOf(totExp+1000));
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
            int result =levelup;
            result++;
            levelBar.setProgress(0);

            userExp.setText(String.valueOf(exp));
            totalExpNeed+=50;
            lv.setText(String.valueOf(result));

            userExp2.setText(String.valueOf(totalExpNeed));
            for(int a=0;a<classes.length;a++)
            {
                int i=0;
                class1.setText(classes[i]);
                i++;
                totalExpNeed+=50;
            }
        }
        if (exp>=1000 & exp<2500)
        {
            levelBar.setProgress(0.25);

        }
        if (exp>=2500 & exp<3500)
        {
            levelBar.setProgress(0.35);
        }
        if (exp>=3500 & exp<4500)
        {
            levelBar.setProgress(0.45);
        }
        if (exp>=4500 & exp<5500)
        {
            levelBar.setProgress(0.55);
        }
        if (exp>=5500 & exp<6500)
        {
            levelBar.setProgress(0.65);
        }
        if (exp>=6500 & exp<7500)
        {
            levelBar.setProgress(0.75);
        }
        if (exp>=7500 & exp<8500)
        {
            levelBar.setProgress(0.85);
        }
        if (exp>=8500 & exp<9000)
        {
            levelBar.setProgress(0.95);
        }

        if (exp>=9000){
            itsOver9000.setOpacity(1.0);
            achievement.setText("Achievements('OVER 9000!')");
            achievement.setStyle(String.valueOf(Color.ROYALBLUE));
        }
        if (exp>=15000){

            itsover15000.setOpacity(1.0);
            achievement.setText("Achievements(KAIOKEN REACHED!)");
            achievement.setStyle(String.valueOf(Color.ROYALBLUE));
        }
        achievement.setOnSelectionChanged(e->
                achievement.setText("Achievemnts"));

        facebookLogIn.setOnMouseClicked(e->{
            String accessToken = "EAAbkKFpcn0sBAIZCCrrBGmjXkzZATJPeZCJBrZB0tttmXyxIo5iBrsl6O42IZCfM3qZBkXWCpWoNhbUN9SeZCkMVtVtPZCdBdgtzO22SMAYY49XueBjpoMy5uUUCZAAZBnQC3H0a2i1xZC3SJ26u19FSBfBbbFVNXTlHZCHYdcRE6oZBTBSfZCHDHnzI5YUUbNQDUIRgSB61ufiVUZANAZDZD";
            String domain="http://bartekkepke.com/";
            String appID="1939711826108235";
            String pass = "3587c849df1d59aae9e069b30bbe075b";
            String access="";


        });

    }
}
