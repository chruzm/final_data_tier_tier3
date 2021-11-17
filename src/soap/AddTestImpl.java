package soap;

import models.Tester;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "soap.ITest")
public class AddTestImpl implements ITest {

    //Tester test2 = new Tester();
    Tester test1 = new Tester();
    //private int x;
    ArrayList<Tester> testfratier2 = new ArrayList<>();

    @Override
    public Tester getTester() {
        return test1;
    }

    @Override
    public Tester addTester(Tester tst) {

        System.out.println("current size of tests list: "+testfratier2.size()+"///"+testfratier2);
        testfratier2.add(tst);
        for (int x = 0; x < testfratier2.size(); x++ ) {
            System.out.println("current size of tests list: " + testfratier2.size() + "///" + testfratier2.get(x).getPhoneNo()+", " +
                    testfratier2.get(x).getName());
        }
        return tst;
    }

    @Override
    public String getTestList() {
        return "";
    }
}
