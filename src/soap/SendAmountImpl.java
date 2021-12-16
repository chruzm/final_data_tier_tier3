package soap;

import Database.DatabaseConnection;
import models.MenuObject;
import models.OrderObject;
import models.ReviewObject;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.Interface")
public class SendAmountImpl implements Interface {
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

    @Override
    public ReviewObject sendReview(int a) {
        return null;
    }

    @Override
    public ReviewObject addReview(ReviewObject r) {
        return null;
    }
}
