package soap;


import com.google.gson.Gson;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


public class Tester {

    private static final Gson gson = new Gson();

    private String phoneNo;
    private String name;

    public Tester(){
    }
    /*public Tester(String phoneNo, String name)
    {a
        this.phoneNo = phoneNo;
        this.name = name;
    }*/

    public Tester newTester(String phoneNo, String name){
        Tester newtest = new Tester();
        newtest.setPhoneNo(phoneNo);
        newtest.setName(name);
        return newtest;
    }

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
    public String toJson()
    {
        return gson.toJson( this );
    }
    public static Tester fromJson(String json )
    {
        return gson.fromJson( json, Tester.class );
    }
}
