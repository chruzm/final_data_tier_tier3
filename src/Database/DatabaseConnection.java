package Database;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {

  private static ArrayList<String> testlist = new ArrayList<>();
  private Connection c = null;
  private Statement stmt = null;
  public String S;


  public void connectDB() throws SQLException {
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
  }

  public void getNames() throws SQLException {
    String SQL = "SELECT * FROM Sep3 . test";

    Statement stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery(SQL);

    try {
      while (rs.next()) {
        String name = rs.getString("name");
        String phoneNumba = rs.getString("phoneNo");
        //System.out.println( name + "    " + phoneNumba);
        System.out.println("NAME: "+""+name+", "+"PHONE: "+""+phoneNumba);
        testlist.add("\n"+"name: "+name+", phoneNo: "+phoneNumba);
      }
      System.out.println();
    }
    catch(SQLException e){
      System.out.println("SQL exception occured" + e);
    }
    //System.out.println(testlist);
    //return testlist;
  }

  public String GetTests(){
    //System.out.println(testlist.size());
    //testlist.add("ass");
    //testlist.add("ass");
    //testlist.add("ass");
    //testlist.add("ass");
    /*String S = "Tests: \n\"";
    int x;
    for (x = 0; x < testlist.size(); x++){
     S += testlist.get(x);
    }*/
    return testlist.toString();
  }
}


