package main;

import Database.DatabaseConnection;
import models.OrderObject;
import models.Tester;
import soap.*;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;


public class RunServer {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        //Tester ts = new Tester();
        //ts.setName("testtiiiiii");
        //ts.setPhoneNo("t90");
        db.connectDB();
        //db.getNames();
        db.getMenu();
        db.storeOrder();
        db.getOrder();
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
        System.out.println("soap service skabt i adresse: http://localhost:9990/ws/getmenu");
        System.out.println("soap service skabt i adresse: http://localhost:9990/ws/addorder");

        db.convertStringToBinary("nothoty");
        System.out.println(db.prettyBinary("1: "+db.convertStringToBinary("nothoty"), 8, " "));
        System.out.println(db.binToBigInt(db.prettyBinary(db.convertStringToBinary("nothoty"), 8, " ")));
        System.out.println("1: "+db.binToText(db.prettyBinary(db.convertStringToBinary("nothoty"), 8, " ")));
    }
}
