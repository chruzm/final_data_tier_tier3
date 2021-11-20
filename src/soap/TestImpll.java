package soap;


import models.MenuObject;
import models.Tester;

import javax.jws.WebService;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
