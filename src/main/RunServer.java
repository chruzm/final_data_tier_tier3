package main;

import Database.DatabaseConnection;
import models.Tester;
import soap.AddTestImpl;
import soap.GetTestListImpl;
import soap.TestImpll;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;


public class RunServer {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        GetTestListImpl gt = new GetTestListImpl();
        AddTestImpl at = new AddTestImpl();
        Tester ts = new Tester();
        ts.setName("testtiiiiii");
        ts.setPhoneNo("t90");
        db.connectDB();
        db.getNames();
        db.GetTests();
        at.addTester(ts);

        Endpoint.publish("http://localhost:9999/ws/tst", new TestImpll());
        Endpoint.publish("http://localhost:9999/ws/tstadd", new AddTestImpl());
        Endpoint.publish("http://localhost:9999/ws/getlist", new GetTestListImpl());
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/tst");
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/tstadd");
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/getlist");
    }
}
