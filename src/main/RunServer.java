package main;

import Database.DatabaseConnection;
import models.OrderObject;
import models.Tester;
import soap.*;

import javax.sound.midi.SysexMessage;
import javax.xml.ws.Endpoint;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Arrays;


public class RunServer {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        //Tester ts = new Tester();
        //ts.setName("testtiiiiii");
        //ts.setPhoneNo("t90");
        db.connectDB();
        db.getMenu();
        db.storeOrder();
        //db.convertStringToBinary("asasasasas");
        //System.out.println(db.sendMenu(0).getFood());
        //at.addTester(ts);

        //Endpoint.publish("http://localhost:9999/ws/tst", new TestImpll());
        //Endpoint.publish("http://localhost:9999/ws/tstadd", new AddTestImpl());
        //Endpoint.publish("http://localhost:9999/ws/getlist", new GetTestListImpl());
        //getmenu fra databasen virker, sendes til tier2
        Endpoint.publish("http://localhost:9990/ws/getmenu", new GetMenuImpl());
        //tilføj order til databasen virker, modtages fra tier2
        Endpoint.publish("http://localhost:9990/ws/addorder", new AddOrderImpl());
        //System.out.println("soap service skabt i adresse: http://localhost:9999/ws/tst");
        //System.out.println("soap service skabt i adresse: http://localhost:9999/ws/tstadd");
        //System.out.println("soap service skabt i adresse: http://localhost:9990/ws/getlist");
        System.out.println("soap service skabt i adresse: http://localhost:9990/ws/getmenu");
        System.out.println("soap service skabt i adresse: http://localhost:9990/ws/addorder");

        String s = "ass blum blam blam blum blum blam blam";
        System.out.println(s.getBytes(StandardCharsets.UTF_8));
        String string = new String(s.getBytes(StandardCharsets.UTF_8), 0);
        System.out.println(string);
    }
}
