package soap;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "soap.ITest")
public class AddTestImpl implements ITest {


    ArrayList<Tester> tests = new ArrayList<>();

    @Override
    public Tester getTester() {
        return null;
    }

    @Override
    public Tester addTester(Tester tst) {
        Tester test1 = new Tester();
        test1.setPhoneNo("111");
        test1.setName("test1");
        Tester test2 = new Tester();
        test1.setPhoneNo("122");
        test1.setName("test22");
        tests.add(test1);
        tests.add(test2);
        tests.add(tst);
        System.out.println(tests.size());

        return tst;
    }



    /*@Override
    public Tester addTester(Tester tst){
        return null;
    }*/
}
