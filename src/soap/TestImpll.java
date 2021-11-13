package soap;


import javax.jws.WebService;
import javax.swing.*;
import java.util.List;

@WebService(endpointInterface = "soap.ITest")
public class TestImpll implements ITest{

    private ITest it;
    List<Tester> Tests;

    @Override
    public Tester getTester() {
        Tester tst = new Tester();
        tst.setName("hello from tier3");
        tst.setPhoneNo("909090");

        return tst;
    }

    @Override
    public Tester addTester(Tester tst){
        return null;
    }
}
