package soap;

import Database.DatabaseConnection;
import models.MenuObject;
import models.OrderObject;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.Interface")
public class GetMenuImpl  implements Interface {

    private DatabaseConnection db = new DatabaseConnection();

    @Override
    public String getTestList() {
        return null;
    }

    @Override
    public MenuObject getMenu(int a) {
        return db.sendMenu(a);
    }

    @Override
    public OrderObject addOrder(OrderObject o) {
        return null;
    }

    @Override
    public OrderObject sendOrder(int a){return null;}

    @Override
    public int sendAmount() {
        return 0;
    }

    ;
}
