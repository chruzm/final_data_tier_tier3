package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection
{

  private Connection c = null;
  private Statement stmt = null;


  public void startDB()
  {
    c = null;
    try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres",
              "postgres", "mxn88scrhder883");
      c.setAutoCommit(false);
      System.out.println("forbundet til database: jdbc:postgresql://localhost:5432/postgres.");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}



