package main;

import Database.DatabaseConnection;
import soap.AddTestImpl;
import soap.GetTestListImpl;
import soap.TestImpll;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;


public class RunServer {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        GetTestListImpl gt = new GetTestListImpl();
        db.connectDB();
        db.getNames();
        db.GetTests();
        Endpoint.publish("http://localhost:9999/ws/tst", new TestImpll());
        Endpoint.publish("http://localhost:9999/ws/tstadd", new AddTestImpl());
        Endpoint.publish("http://localhost:9999/ws/getlist", new GetTestListImpl());
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/tst");
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/tstadd");
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/getlist");
    }
}
