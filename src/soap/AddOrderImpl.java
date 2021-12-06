package soap;

import Database.DatabaseConnection;
import models.MenuObject;
import models.OrderObject;
import models.Tester;

import javax.jws.WebService;
import java.sql.SQLException;
import java.util.Random;

@WebService(endpointInterface = "soap.ITest")
public class AddOrderImpl implements ITest{
    private DatabaseConnection db = new DatabaseConnection();
    @Override
    public Tester getTester() {
        return null;
    }

    @Override
    public Tester addTester(Tester tst) {
        return null;
    }

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
        Random number = new Random();
        o.setOrdernumber(number.nextInt(100000)+1);
        System.out.println("adding order");
        //db.getOrder() tilføjer OrderObject O til listen af orders i databaseconnection class
        db.getOrder(o);
        db.storeOrder();
        System.out.println(o.getOrderNumber());
        return o;
    }

    @Override
    public OrderObject sendOrder(int a){return null;};
}
