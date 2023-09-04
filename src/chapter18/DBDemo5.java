package chapter18;

import java.sql.*;

public class DBDemo5 {
  public static void main(String[] args) throws SQLException {
    Connection conn = makeConnection();
    String sql = "select * from person;";


    PreparedStatement preparedStatement = conn.prepareStatement(sql);

    ResultSet rs = preparedStatement.executeQuery();
    while (rs.next()) {
      System.out.print("name : " + rs.getString(1) + ",");
      System.out.print("phone : " + rs.getString("phone") + ",");
      System.out.println("email : " + rs.getString(3));
    }
    conn.close();
    preparedStatement.close();
  }

  static Connection makeConnection() {
    String url = "jdbc:mysql://127.0.0.1/sample?serverTimezone=Asia/Seoul";

    Connection conn = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("데이터베이스 연결중 ....");
      conn = DriverManager.getConnection(url, "root", "1111");
      System.out.println("데이터베이스 연결 성공!!!");
      //conn.close();
    } catch (ClassNotFoundException e) {
      //throw new RuntimeException(e);
      System.out.println("JDBC 드라이버를 찾지 못함");
    } catch (SQLException e) {
      //throw new RuntimeException(e);
      System.out.println("데이터베이스 연결 실패");
    }
    return conn;
  }
}
