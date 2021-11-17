package models;

import com.google.gson.Gson;

public class TestList {
    private static final Gson gson = new Gson();

    private String listnumber;
    private String listelement;

    public TestList(){
    }

    public TestList newTestLIst(String listnunmber, String listelement){
        TestList newList = new TestList();
        newList.setListnumber(listnunmber);
        newList.setElement(listelement);
        return newList;
    }

    public void setListnumber( String listnumber )
    {
        this.listnumber = listnumber;
    }
    public void setElement( String listelement )
    {
        this.listelement = listelement;
    }
    public String getListnumber()
    {
        return listnumber;
    }
    public String getElement()
    {
        return listelement;
    }
    public String toJson()
    {
        return gson.toJson( this );
    }
    public static TestList fromJson(String json )
    {
        return gson.fromJson( json, TestList.class );
    }
}
