package soap;

import Database.DatabaseConnection;
import models.MenuObject;
import models.OrderObject;
import models.ReviewObject;

import javax.jws.WebService;
import java.util.Random;


@WebService(endpointInterface = "soap.Interface")
public class AddReviewImpl implements Interface {
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
        return 0;
    }

    @Override
    public ReviewObject sendReview(int a) {
        return null;
    }

    @Override
    public ReviewObject addReview(ReviewObject r) {
        Random number = new Random();
        //o.setOrdernumber(number.nextInt(100000)+1);
        System.out.println("adding review #"+r.getId());
        //db.getOrder() tilføjer OrderObject O til listen af orders i databaseconnection class
        db.getReviews(r);
        System.out.println("received review: "+r.getId());
        db.storeReview();
        System.out.println(r.getReview());

        /*try {
            db.retrieveOrders();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
        return r;
    }
}
