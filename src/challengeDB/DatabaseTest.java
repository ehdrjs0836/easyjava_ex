package challengeDB;

import java.sql.*;
import java.util.Scanner;

public class DatabaseTest {
  public static void main(String[] args) throws SQLException {
    Connection conn = makeConnection();
    Scanner in = new Scanner(System.in);
    int cmdNo = 0;

    while (true) {
      System.out.println("");
      System.out.println("원하는 메뉴를 선택하십시오. (종료하려면 -1)");
      System.out.println("조회 1.도서리스트 2. 고객리스트 3.주문리스트 ");
      System.out.println("등록 11.도서추가등록 12. 고객추가등록 13.주문등록");
      System.out.println("수정 21.도서정보수정 22. 고객정보수정 23.주문정보수정");
      System.out.println("삭제 31.도서정보삭제 32. 고객정보삭제 33.주문정보삭제");
      cmdNo = in.nextInt();

      if (cmdNo == 1) {
        selectBook();
      } else if (cmdNo == 2) {
        selectCustomer();
      } else if (cmdNo == 3) {
        selectOrders();
      } else if (cmdNo == 11) {
          insertBook();
      } else if (cmdNo == 12) {
          insertCustomer();
      } else if (cmdNo == 13) {
        insertOrders();
      } else if (cmdNo == 21) {
        changeBook();
      } else if (cmdNo == 22) {
        changeCustomer();
      } else if (cmdNo == 23) {
        changeOrders();
      } else if (cmdNo == 31) {
        removeBook();
      } else if (cmdNo == 32) {
        removeCustomer();
      } else if (cmdNo == 33) {
        removeOrders();
      } else {
        in.close();
        break;
      }
    }
  }

  static void selectBook() throws SQLException {
    Connection conn = makeConnection();
    String sql = "select * from book";
    PreparedStatement psmt = conn.prepareStatement(sql);

    ResultSet rs = psmt.executeQuery();
    System.out.println("-------------------------------------");
    System.out.println("bookid | bookname | publisher | price");
    System.out.println("-------------------------------------");
    while (rs.next()) {
      System.out.print("\t" + rs.getString("bookid") + "\t");
      System.out.print("\t" + rs.getString("bookname") + "\t");
      System.out.print("\t" + rs.getString("publisher") + "\t");
      System.out.println("\t" + rs.getString("price") + "\t");
    }
    conn.close();
    psmt.close();
  }

  static void selectCustomer() throws SQLException {
    Connection conn = makeConnection();
    String sql = "select * from customer";
    PreparedStatement psmt = conn.prepareStatement(sql);

    ResultSet rs = psmt.executeQuery();
    System.out.println("-------------------------------------");
    System.out.println("custid | name | address | phone");
    System.out.println("-------------------------------------");
    while (rs.next()) {
      System.out.print("\t" + rs.getString("custid") + "\t");
      System.out.print("\t" + rs.getString("name") + "\t");
      System.out.print("\t" + rs.getString("address") + "\t");
      System.out.println("\t" + rs.getString("phone") + "\t");
    }
    conn.close();
    psmt.close();
  }

  static void selectOrders() throws SQLException {
    Connection conn = makeConnection();
    String sql = "select * from orders";
    PreparedStatement psmt = conn.prepareStatement(sql);

    ResultSet rs = psmt.executeQuery();
    System.out.println("-------------------------------------");
    System.out.println("orderid | custid | bookid | saleprice | orderdate | bname");
    System.out.println("-------------------------------------");
    while (rs.next()) {
      System.out.print("\t" + rs.getString("orderid") + "\t");
      System.out.print("\t" + rs.getString("custid") + "\t");
      System.out.print("\t" + rs.getString("bookid") + "\t");
      System.out.print("\t" + rs.getString("saleprice") + "\t");
      System.out.print("\t" + rs.getString("orderdate") + "\t");
      System.out.println("\t" + rs.getString("bname")+ "\t");
    }
    conn.close();
    psmt.close();
  }

  static void insertBook() throws SQLException {
    Connection conn = makeConnection();
    String sqlMax = "select max(bookid) from book";
    PreparedStatement psmtMax = conn.prepareStatement(sqlMax);

    ResultSet rsMax =  psmtMax.executeQuery();
    System.out.println("-------------------------------------");
    System.out.println("bookid | bookname | publisher | price");
    System.out.println("-------------------------------------");
//    while (rsMax.next()) {
//      System.out.println("\t" + rsMax.getInt("max(bookid)") + "\t");
//    }
    rsMax.next();
    int bookid = rsMax.getInt("max(bookid)");
    Scanner in = new Scanner(System.in);
    System.out.printf("추가할 도서명 : ");
    String addBookName = in.nextLine();
    System.out.printf("출판사명 : ");
    String addPublisher = in.nextLine();
    System.out.printf("도서 가격: ");
    int addPrice = in.nextInt();

    String sql = "insert into book values (?, ?, ?, ?);";
    PreparedStatement psmt = conn.prepareStatement(sql);
    psmt.setInt(1, bookid+1);
    psmt.setString(2,addBookName);
    psmt.setString(3,addPublisher);
    psmt.setInt(4,addPrice);
    int i = psmt.executeUpdate();
    if (i == 1) System.out.println("데이터 추가 성공");
    else System.out.println("데이터 추가 실패");
    conn.close();
    psmtMax.close();
    psmt.close();
  }

  static void insertCustomer()throws SQLException {
    Connection conn = makeConnection();
    conn.close();
  }

  static void insertOrders()throws SQLException {
    Connection conn = makeConnection();

    conn.close();
  }

  private static void changeBook()throws SQLException {
    Connection conn = makeConnection();
    System.out.println("수정할 책의 ID를 입력하세요.");
    Scanner in = new Scanner(System.in);
    int bookId = in.nextInt();
    String sql = "select bookname, publisher, price from book where bookid = ?;";
    PreparedStatement psmt = conn.prepareStatement(sql);
    psmt.setInt(1, bookId);
    ResultSet rs = psmt.executeQuery();

    if(rs != null && rs.next()) {
      System.out.println(rs.getString(1) + ","
      + rs.getString(2) + ","
      + rs.getInt(3));
    }

//    System.out.println("책의 제목을 수정하려면 입력하세요.");
//    String bookName = in.next();
//    System.out.println("책의 출판사를 수정하려면 입력하세요.");
//    String publisher = in.next();
    System.out.println("책의 가격을 수정하려면 입력하세요.");
    String price = in.next();
    if(!price.equals("!")) {
      sql = "update book set price = ? where bookid = ?;";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1,Integer.parseInt(price));
      pstmt.setInt(2,bookId);
      int res = pstmt.executeUpdate();
      if(res == 1) System.out.println("수정완료");
    }
  }
  private static void changeCustomer() {

  }
  private static void changeOrders() {
  }
  private static void removeBook() {

  }
  private static void removeCustomer()throws SQLException {
    Connection conn = makeConnection();
    System.out.println("삭제할 고객의 ID를 입력하세요.");
    Scanner in = new Scanner(System.in);
    int customerId = in.nextInt();
    String sql = "select name, address, phone from customer where custid = ?;";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, customerId);
    ResultSet rs = pstmt.executeQuery();

    if(rs != null && rs.next()) {
      System.out.println(rs.getString(1) + ","
          + rs.getString(2) + ","
          + rs.getString(3));
    }

    sql = "SELECT bookname, saleprice, orderdate FROM vorders where custid = ?;";
    pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, customerId);
    rs = pstmt.executeQuery();
    if(rs != null) {
      System.out.println(" === 삭제하려는 주문 정보 ===");
      while(rs.next()) {
        System.out.println(rs.getString(1) + ","
            + rs.getInt(2) + ","
            + rs.getDate(3));
      }
    }

    System.out.println("삭제하시겠습니까? (Y/N)");
    String confirm = in.next();
    /* 고객정보 동일한 custid 부터 삭제 코드 */
    if(confirm.equalsIgnoreCase("Y")) {
      sql = "delete from orders where custid = ? ;";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1,customerId);
      int res1 = pstmt.executeUpdate();
      if(res1 > 0) {
        sql = "delete from customer where custid = ? ;";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,customerId);
        int res2 = pstmt.executeUpdate();
        if(res2 == 1) System.out.println("삭제완료!");
      }
    }
  }
  private static void removeOrders() throws SQLException {
    Connection conn = makeConnection();
    System.out.println("삭제할 주문의 ID를 입력하세요.");
    Scanner in = new Scanner(System.in);
    int orderId = in.nextInt();
    String sql = "select name, bookname, saleprice, orderdate from vorders where orderid = ?;";
    PreparedStatement psmt = conn.prepareStatement(sql);
    psmt.setInt(1, orderId);
    ResultSet rs = psmt.executeQuery();

    if(rs != null && rs.next()) {
      System.out.println(rs.getString(1) + ","
          + rs.getString(2) + ","
          + rs.getInt(3) + ","
          + rs.getDate(4));
    }

    System.out.println("삭제하시겠습니까? (Y/N)");
    String confirm = in.next();
    if(confirm.equalsIgnoreCase("Y")) {
      sql = "delete from orders where orderid = ?;";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1,orderId);
      int res = pstmt.executeUpdate();
      if(res == 1) System.out.println("삭제완료");
    }
  }

  static Connection makeConnection() {
    String url = "jdbc:mysql://127.0.0.1/madang?serverTimezone=Asia/Seoul";

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
