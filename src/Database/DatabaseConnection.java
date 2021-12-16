package Database;

import models.MenuObject;
import models.OrderObject;
import models.ReviewObject;

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
  private static ArrayList<OrderObject> OTOCHEF = new ArrayList<>();
  private static ArrayList<ReviewObject> rews = new ArrayList<>();
  private static ArrayList<ReviewObject> reviews2client = new ArrayList<>();
  private OrderObject o = new OrderObject();
  private Connection c = null;
  private Statement stmt = null;
  public String S;
  private int x;


  //connect database virker
  public synchronized Connection connectDB() throws SQLException {
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


  //getmenu virker
  public synchronized void getMenu() throws SQLException {
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
  public synchronized MenuObject sendMenu(int a) {
    System.out.println("---");
    for (int y = 0; y < menu.size(); y++)
      System.out.println(menu.get(y).getFood());

    return menu.get(a);
  }

  //virker
  public synchronized void getOrder(OrderObject ordo)
  {
    orders.clear();
    orders.add(ordo);
  }

  //virker
  public synchronized void getReviews(ReviewObject rew)
  {
    rews.clear();
    rews.add(rew);
  }

  //works
  public synchronized void storeOrder() {
    String SQL_INSERT = "INSERT INTO orders (ordernumber, price, foods, adr, email, tlf) VALUES (?,?,?,?,?,?)";

    try (Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/postgres", "postgres", "mxn88scrhder883");
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

      for (int a = 0; a < orders.size(); a++) {
        preparedStatement.setInt(1, orders.get(a).getOrderNumber());
        preparedStatement.setInt(2, orders.get(a).getPrice());
        preparedStatement.setBytes(3, orders.get(a).getItems().getBytes());
        preparedStatement.setBytes(4, orders.get(a).getAdr().getBytes());
        preparedStatement.setBytes(5, orders.get(a).getEmail().getBytes());
        preparedStatement.setBytes(6, orders.get(a).getPhone().getBytes());


        int row = preparedStatement.executeUpdate();

        // rows affected
        System.out.println("rows påvirket i databasetabel 'orders': "+row); //1
      }
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public synchronized void storeReview() {
    String SQL_INSERT = "INSERT INTO reviews (id, name, review) VALUES (?,?,?)";

    try (Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/postgres", "postgres", "mxn88scrhder883");
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

      for (int a = 0; a < rews.size(); a++) {
        preparedStatement.setInt(1, rews.get(a).getId());
        preparedStatement.setBytes(2, rews.get(a).getName().getBytes());
        preparedStatement.setBytes(3, rews.get(a).getReview().getBytes());


        int row = preparedStatement.executeUpdate();

        // rows affected
        System.out.println("rows påvirket i databasetabel 'orders': "+row); //1
      }
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //CONNECTED*****************************************************
  public synchronized void retrieveOrders() throws SQLException {
    String SQL = "SELECT * FROM orders";
    //for at se om der bliver tilføjet i listen når klient tilføjkr order
    try (Connection conn = connectDB();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(SQL)) {
      // display actor information
      displayO(rs);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }
    private synchronized void displayO(ResultSet rs) throws SQLException {
    OTOCHEF.clear();
      while (rs.next()) {
        OrderObject otochef = new OrderObject();
        /*System.out.println("ordernumber: "+rs.getInt("ordernumber") + "\t"
                + "Price: "+rs.getInt("price") + "\t"
                + "items(encoded): "+rs.getBytes("foods")+ "\t"
                + "adress(encoded): "+rs.getBytes("adr")
        );*/
        otochef.setOrdernumber(rs.getInt("ordernumber"));
        otochef.setPrice(rs.getInt("price"));
        otochef.setItems(convertByte(rs.getBytes("foods")));
        otochef.setAdr(convertByte(rs.getBytes("adr")));
        OTOCHEF.add(otochef);
      }
      //System.out.println("db.retrieveorders() triggerd af launch/eller ny order fra kunde: size "+OTOCHEF.size()+" adresse af nyeste order: "+OTOCHEF.get(OTOCHEF.size()-1).getAdr());
    }
    //CONNECTED******************************************************


  public synchronized String convertByte(byte[] bytes){
      String s = new String(bytes, StandardCharsets.UTF_8);
      //System.out.println("Output : " + s);
      return s;
    }

  //sendorder virker nu
  public OrderObject sendOrder(int a) {
    System.out.println("---");
    for (int y = 0; y < OTOCHEF.size(); y++){
      System.out.println(OTOCHEF.size());
    }

    //System.out.println("size of list holding orders2chef: "+OTOCHEF.size());
    return OTOCHEF.get(a);
  }

  //
  public synchronized int sendAmount() {
    System.out.println("size of list holding orders2chef: "+OTOCHEF.size());
    return OTOCHEF.size();
  }


  }











