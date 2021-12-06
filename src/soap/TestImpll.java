package soap;


import models.MenuObject;
import models.OrderObject;
import models.Tester;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "soap.ITest")
public class TestImpll implements ITest{

    private ITest it;

    @Override
    public Tester getTester() {
        Tester tst = new Tester();
        tst.setName("hello from tier3");
        tst.setPhoneNo("909090");

        return tst;
    }

    @Override
    public Tester addTester(Tester tst){
        return tst;
    }

    @Override
    public String getTestList() {
        return "";
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
    public OrderObject sendOrder(int a){return null;};
}
