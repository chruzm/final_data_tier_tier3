package soap;

import Database.DatabaseConnection;
import models.MenuObject;
import models.OrderObject;
import models.Tester;

import javax.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;

@WebService(endpointInterface = "soap.ITest")
public class GetTestListImpl implements ITest  {

    private DatabaseConnection db = new DatabaseConnection();

    @Override
    public Tester getTester() {
        Tester dummytest = new Tester();
        return dummytest;
    }

    @Override
    public Tester addTester(Tester tst) {
        Tester dummytest = new Tester();
        return dummytest;
    }

    @Override
    public String getTestList()  {
        //System.out.println(testlist.size());
        return "whatever";
    }

    @Override
    public MenuObject getMenu(int a) {
        return null;
    }

    @Override
    public OrderObject addOrder(OrderObject o) {
        return null;
    }
}
