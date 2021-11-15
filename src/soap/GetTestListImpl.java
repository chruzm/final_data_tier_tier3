package soap;

import Database.DatabaseConnection;

import javax.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;

@WebService(endpointInterface = "soap.ITest")
public class GetTestListImpl implements ITest  {

    private DatabaseConnection db = new DatabaseConnection();
    private ArrayList<String> ass = new ArrayList<>();

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
        ass.add(db.GetTests());
        return ass.toString();
    }
}
