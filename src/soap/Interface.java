package soap;

import models.MenuObject;
import models.OrderObject;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Interface {
    @WebMethod
    String getTestList();
    @WebMethod
    MenuObject getMenu(int a);
    @WebMethod
    OrderObject addOrder(OrderObject o);
    @WebMethod
    OrderObject sendOrder(int a);
    @WebMethod
    int sendAmount();

}