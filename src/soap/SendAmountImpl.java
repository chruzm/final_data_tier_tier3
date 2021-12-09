package soap;

import Database.DatabaseConnection;
import models.MenuObject;
import models.OrderObject;
import models.Tester;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.ITest")
public class SendAmountImpl implements ITest {
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
        return null;
    }

    @Override
    public OrderObject sendOrder(int a) {
        return null;
    }

    @Override
    public int sendAmount() {
        return db.sendAmount();
    }
}
