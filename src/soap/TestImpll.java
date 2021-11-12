package soap;


import javax.jws.WebService;

@WebService(endpointInterface = "soap.ITest")
public class TestImpll implements ITest{


    @Override
    public Tester getTester() {
        Tester tst = new Tester();
        tst.setName("hello from tier3");
        tst.setPhoneNo("909090");

        return tst;
    }
}
