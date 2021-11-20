package soap;

import Database.DatabaseConnection;
import models.MenuObject;
import models.Tester;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.ITest")
public class GetMenuImpl  implements ITest {

    private DatabaseConnection db = new DatabaseConnection();
    @Override
    public Tester getTester() {
        return null;
    }

    @Override
    public Tester addTester(Tester tst) {
        return null;
    }

    @Override
    public String getTestList() {
        return null;
    }

    @Override
    public MenuObject getMenu(int a) {
        return db.sendMenu(a);
    }
}
