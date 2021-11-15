package Database;

import java.sql.*;

public class DatabaseConnection {

  private Connection c = null;
  private Statement stmt = null;


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
        System.out.println( name + "    " + phoneNumba);
      }
      System.out.println();
    }
    catch(SQLException e){
      System.out.println("SQL exception occured" + e);
    }
  }
}

