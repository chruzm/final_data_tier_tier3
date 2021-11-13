package soap;


import javax.jws.WebService;
import javax.swing.*;

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
    public Tester addTester(){
        return it.addTester();
    }
}
