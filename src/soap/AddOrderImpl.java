package soap;

import Database.DatabaseConnection;
import models.MenuObject;
import models.OrderObject;

import javax.jws.WebService;
import java.sql.SQLException;
import java.util.Random;

@WebService(endpointInterface = "soap.Interface")
public class AddOrderImpl implements Interface {
    private DatabaseConnection db = new DatabaseConnection();

    @Override
    public String getTestList() {
        return null;
    }

    @Override
    public MenuObject getMenu(int a) {
        return null;
    }

    @Override
    public OrderObject addOrder(OrderObject o) {
        /*
        Random number = new Random();
        o.setOrdernumber(number.nextInt(100000)+1);*/
        System.out.println("adding order");
        //db.getOrder() tilføjer OrderObject O til listen af orders i databaseconnection class
        db.getOrder(o);
        db.storeOrder();
        System.out.println(o.getOrderNumber());
        try {
            db.retrieveOrders();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return o;
    }

    @Override
    public OrderObject sendOrder(int a){return null;}

    @Override
    public int sendAmount() {
        return 0;
    }

    ;
}
