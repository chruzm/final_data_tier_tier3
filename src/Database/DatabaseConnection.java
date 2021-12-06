package Database;

import models.MenuObject;
import models.OrderObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.BitSet;

public class DatabaseConnection {
  private MenuObject m = new MenuObject();
  private static ArrayList<String> testlist = new ArrayList<>();
  private static ArrayList<MenuObject> menu = new ArrayList<>();
  private static ArrayList<OrderObject> orders = new ArrayList<>();
  private static ArrayList<OrderObject> retrievedOrders = new ArrayList<>();
  private static ArrayList<byte[]> byteholder = new ArrayList<>();
  private OrderObject o = new OrderObject();
  private Connection c = null;
  private Statement stmt = null;
  public String S;
  private int x;


  //connect database virker
  public Connection connectDB() throws SQLException {
    c = null;
    try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
              .getConnection("jdbc:postgresql://localhost:5432/postgres",
                      "postgres", "mxn88scrhder883");
      c.setAutoCommit(false);
      System.out.println("forbundet til database: jdbc:postgresql://localhost:5432/postgres");
      System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return c;
  }

  /*
  //****************TESTS
  public void getNames() throws SQLException {
    String SQL = "SELECT * FROM Sep3 . test";

    Statement stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery(SQL);

    try {
      while (rs.next()) {
        String name = rs.getString("name");
        String phoneNumba = rs.getString("phoneNo");
        //System.out.println( name + "    " + phoneNumba);
        //System.out.println(phoneNumba+", "+name);
        testlist.add("\n" + phoneNumba + ", " + name);
      }
      System.out.println(testlist.size() + "<---- number of elements in getNames(test) metode");
    } catch (SQLException e) {
      System.out.println("SQL exception occured" + e);
    }
    //System.out.println(testlist);
    //return testlist;
  }
  public String getTests() {
    //System.out.println(testlist.size());
    //testlist.add("ass");
    //testlist.add("ass");
    //testlist.add("ass");
    //testlist.add("ass");
    /*String S = "Tests: \n\"";
    int x;
    for (x = 0; x < testlist.size(); x++){
     S += testlist.get(x);
    }
    return testlist.toString();
  }
  //****************TESTS
  */

  //getmenu virker
  public void getMenu() throws SQLException {
    String SQL = "SELECT * FROM Sep3 . menu";

    Statement stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery(SQL);

    try {
      while (rs.next()) {
        int number = rs.getInt("number");
        int price = rs.getInt("price");
        String food = rs.getString("food");
        //System.out.println( name + "    " + phoneNumba);
        System.out.println(number + ".  " + price + "DKK, " + food);
        //m.newmenuobject(price,food);
        menu.add(m.newmenuobject(number, price, food));
        //System.out.println(menu.get(0).getNumber());
      }
      System.out.println(menu.get(2).getNumber());
    } catch (SQLException e) {
      System.out.println("SQL exception occured" + e);
    }
    //System.out.println(testlist);
    //return testlist;
  }
  //sendmenu virker
  public MenuObject sendMenu(int a) {
    System.out.println("---");
    for (int y = 0; y < menu.size(); y++)
      System.out.println(menu.get(y).getFood());

    return menu.get(a);
  }

  //virker, bruges i en metode i en soap metode, RØR IKKE!!!
  public void getOrderList(OrderObject ordo) {
    orders.add(ordo);
  }

  //virker
  public synchronized void storeOrder() throws SQLException {
    //ArrayList<OrderObject> orderlist = new ArrayList<>();
    //orderlist.add(ordo);
    //o.setOrdernumber(101998877);
    //o.setPrice(101010101);
    //o.setItems("testeritemeatdatcoochie");
    //o.seAdr("testeradressbigbooty");
    //orders.add(o);
    String SQL = "INSERT INTO orders(ordernumber,price,foods,adr) VALUES (";

    // åben forbindelse
    try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "mxn88scrhder883");
        Statement stmt = conn.createStatement();
    ){
      for (int a = 0; x < orders.size(); x++){
        // Execute a query
        System.out.println("tilføjer ordrer nummer #"+orders.get(a).getOrderNumber());
        int x = orders.get(a).getOrderNumber();
        int y = orders.get(a).getPrice();
        String s = orders.get(a).getItems();
        String adr = orders.get(a).getAdr();

        System.out.println(SQL+x+","+y+","+getBytesFBG(s)+","+getBytesABG(adr)+")");
        stmt.executeQuery(SQL+x+","+y+","+getBytesFBG(s)+","+getBytesABG(adr)+")");
        orders.clear();
      }
    }
    catch (SQLException ex){
      System.out.println(ex);
    }
  }

  public synchronized void retrieveOrders() throws SQLException {
    String SQL = "SELECT * FROM orders";

    try (Connection conn = connectDB();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(SQL)) {
      // display actor information
      displayActor(rs);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  private void displayActor(ResultSet rs) throws SQLException {
    while (rs.next()) {
      System.out.println(rs.getInt("ordernumber") + "\t"
              + rs.getInt("price") + "\t"
              + rs.getBigDecimal("foods"));
    }
  }

  public synchronized BigInteger getBytesFBG(String s){
    //converts string to bytes
    String string = "";
    for (int x = 0; x < orders.size(); x++){
      s = orders.get(x).getItems();
    }
    byte[] array = s.getBytes(StandardCharsets.UTF_8);
    byteholder.add(array);
    System.out.println(s+" konverteret til bytes: "+array);
    for (byte b : array){
      string+=b;
    }
    BigInteger BI = new BigInteger(string);
    //System.out.println(BI);
    return BI;
  }

  public synchronized BigInteger getBytesABG(String s){
    //converts string to bytes
    String string = "";
    for (int x = 0; x < orders.size(); x++){
      s = orders.get(x).getAdr();
    }
    byte[] array = s.getBytes(StandardCharsets.UTF_8);
    byteholder.add(array);
    System.out.println(s+" konverteret til bytes: "+array);
    for (byte b : array){
      string+=b;
    }
    BigInteger BI = new BigInteger(string);
    //System.out.println(BI);
    return BI;
  }

  public synchronized void reConvert(byte [] b){
    int x = 0;
    String string = new String(b, 0);
    System.out.println(string);
  }
}










