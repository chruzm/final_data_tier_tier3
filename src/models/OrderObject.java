package models;

import com.google.gson.Gson;

public class OrderObject {
    private static final Gson gson = new Gson();
    private int ordernumber;
    private int price;
    private int items;

    public OrderObject(){
    }

    public OrderObject newOrder(int ordern, int price, int items){
        OrderObject neworder = new OrderObject();
        neworder.setOrdernumber(ordernumber);
        neworder.setPrice(price);
        neworder.setItems(items);
        return neworder;
    }

    public void setOrdernumber( int ordern )
    {
        this.ordernumber = ordern;
    }
    public void setPrice( int price )
    {
        this.price = price;
    }
    public void setItems( int items )
    {
        this.items = items;
    }
    public int getPrice()
    {
        return price;
    }
    public int getOrderNumber()
    {
        return ordernumber;
    }
    public int getItems()
    {
        return items;
    }
    public String toJson()
    {
        return gson.toJson( this );
    }
    public static MenuObject fromJson(String json )
    {
        return gson.fromJson( json, MenuObject.class );
    }
}
