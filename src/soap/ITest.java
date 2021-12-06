package soap;

import models.MenuObject;
import models.OrderObject;
import models.Tester;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ITest {
    @WebMethod
    Tester getTester();
    @WebMethod
    Tester addTester(Tester tst);
    @WebMethod
    String getTestList();
    @WebMethod
    MenuObject getMenu(int a);
    @WebMethod
    OrderObject addOrder(OrderObject o);
    @WebMethod
    OrderObject sendOrder(int a);

}