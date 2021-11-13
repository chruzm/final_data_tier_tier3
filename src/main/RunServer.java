package main;

import Database.DatabaseConnection;
import soap.AddTestImpl;
import soap.TestImpll;

import javax.xml.ws.Endpoint;


public class RunServer {
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        db.startDB();
        Endpoint.publish("http://localhost:9999/ws/tst", new TestImpll());
        Endpoint.publish("http://localhost:9999/ws/tstadd", new AddTestImpl());
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/tst");
        System.out.println("soap service skabt i adresse: http://localhost:9999/ws/tstadd");

    }
}
