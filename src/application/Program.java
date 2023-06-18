package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
  public static void main(String[] args) {
    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
      conn = DB.getConnection();
      statement = conn.createStatement();

      resultSet = statement.executeQuery("SELECT * FROM department");

      while (resultSet.next()) {
        System.out.println(
                resultSet.getInt("Id") + ", " + resultSet.getString("Name")
        );
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      DB.closeResultSet(resultSet);
      DB.closeStatement(statement);
      DB.closeConnection();
    }
  }
}
