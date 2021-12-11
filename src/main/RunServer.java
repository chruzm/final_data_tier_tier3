package main;

import Database.DatabaseConnection;
import soap.*;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;


public class RunServer {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        db.connectDB();
        db.getMenu();
        db.storeOrder();
        //getmenu fra databasen virker, sendes til tier2
        Endpoint.publish("http://localhost:9990/ws/getmenu", new GetMenuImpl());
        //tilføj order til databasen virker, modtages fra tier2
        Endpoint.publish("http://localhost:9990/ws/addorder", new AddOrderImpl());
        //send order til chefen, og aomount til chefen
        Endpoint.publish("http://localhost:9990/ws/orders", new SendOrderImpl());
        Endpoint.publish("http://localhost:9990/ws/amount", new SendAmountImpl());
        System.out.println("serice: http://localhost:9990/ws/getmenu");
        System.out.println("serice:  http://localhost:9990/ws/addorder");
        System.out.println("serice: http://localhost:9990/ws/orders");
        System.out.println("serice: http://localhost:9990/ws/amount");
        db.retrieveOrders();
        db.sendAmount();


    }
}
