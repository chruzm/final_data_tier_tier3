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
        db.getNames();
        db.getTests();
        db.getMenu();
        db.storeOrder();
        //System.out.println(db.sendMenu(0).getFood());
        //at.addTester(ts);

        //Endpoint.publish("http://localhost:9999/ws/tst", new TestImpll());
        //Endpoint.publish("http://localhost:9999/ws/tstadd", new AddTestImpl());
        //Endpoint.publish("http://localhost:9999/ws/getlist", new GetTestListImpl());
        Endpoint.publish("http://localhost:9999/ws/getmenu", new GetMenuImpl());
        Endpoint.publish("http://localhost:9999/ws/addorder", new AddOrderImpl());
        //System.out.println("soap service skabt i adresse: http://localhost:9999/ws/tst");
        //System.out.println("soap service skabt i adresse: http://localhost:9999/ws/tstadd");
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/getlist");
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/getmenu");
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/addorder");
    }
}
