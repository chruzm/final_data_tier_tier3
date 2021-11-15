package soap;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "soap.ITest")
public class AddTestImpl implements ITest {

    Tester test2 = new Tester();
    Tester test1 = new Tester();
    private int x;
    ArrayList<Tester> tests = new ArrayList<>();

    @Override
    public Tester getTester() {
        return test1;
    }

    @Override
    public Tester addTester(Tester tst) {
        test1.setPhoneNo("111");
        test1.setName("test1");
        test1.setPhoneNo("122");
        test1.setName("test22");
        tests.add(test1);
        tests.add(test2);
        System.out.println("current size of tests list: "+tests.size()+"///"+tests.toString());
        tests.add(tst);
        System.out.println("current size of tests list: "+tests.size()+"///"+tests.toString());

        return tst;
    }
}
