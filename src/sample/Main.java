package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import netflix.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Control Panel");
        primaryStage.setScene(new Scene(root, 750, 550));
        primaryStage.show();
    }

/** Main function to launch basic settings and start simulation and Control Window*/
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ControlPanel system = new ControlPanel();

        Date dat = new Date ();

        Calendar c = Calendar.getInstance();
        c.setTime(dat);
        c.add(Calendar.DATE, -3600);
        Date beginDate = c.getTime();
        c.add(Calendar.DATE, +7200);
        Date endDate = c.getTime();

        Promotion standard = new Promotion("Standard", beginDate,endDate,0);
        system.addPromotion(standard);
        Promotion sale = new Promotion("Sale", beginDate,endDate,20);
        system.addPromotion(sale);
        Promotion sale2 = new Promotion("ExtraSale", beginDate,endDate,40);
        system.addPromotion(sale2);

        Subscription unsubscribe = new Subscription("Unsubscribe", 0, 1, 720 );
        system.addSubscription(unsubscribe);
        Subscription basic = new Subscription("Basic", 25, 1, 720 );
        system.addSubscription(basic);
        Subscription family = new Subscription("Family", 40, 4, 1080 );
        system.addSubscription(family);
        Subscription premium = new Subscription("Premium", 55, 5, 2160 );
        system.addSubscription(premium);


        system.readFile();

        Thread simulation = new Thread(system);
        simulation.setDaemon(true);
        simulation.start();


        launch(args);

    }
}
