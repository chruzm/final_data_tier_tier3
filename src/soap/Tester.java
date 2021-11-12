package soap;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


public class Tester {

    //private static final  Gson gson = new Gson();

    private String phoneNo;
    private String name;

    public Tester(){
    }
    /*public Tester(String phoneNo, String name)
    {
        this.phoneNo = phoneNo;
        this.name = name;
    }*/

    public void setPhoneNo( String phoneNo )
    {
        this.phoneNo = phoneNo;
    }
    public void setName( String name )
    {
        this.name = name;
    }
    public String getPhoneNo()
    {
        return phoneNo;
    }
    public String getName()
    {
        return name;
    }
}
