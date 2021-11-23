package soap;

import Database.DatabaseConnection;
import models.MenuObject;
import models.OrderObject;
import models.Tester;

import javax.jws.WebService;
import java.sql.SQLException;

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
        System.out.println("adding order");
        db.getOrder(o);
        try {
            db.storeOrder();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
}
