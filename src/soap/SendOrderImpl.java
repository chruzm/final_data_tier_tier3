package soap;

import Database.DatabaseConnection;
import models.MenuObject;
import models.OrderObject;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.Interface")
public class SendOrderImpl implements Interface {
    DatabaseConnection db = new DatabaseConnection();

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
        System.out.println(db.sendOrder(2).getOrderNumber());
        return db.sendOrder(a);
    }

    @Override
    public int sendAmount() {
        return 0;
    }
}
