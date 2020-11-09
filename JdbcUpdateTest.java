package UPDATE_MySQL_JAVA;
import java.sql.*;
public class JdbcUpdateTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String strupdate = "update books set price = price *0.7,qty = qty +1 where id =1001";
            System.out.println("The SQL statement is : " + strupdate);
            int countUpdated = stmt.executeUpdate(strupdate);
            System.out.println(countUpdated + "records affected.\n");

            String strSelect ="select * from books where id = 1001";
            System.out.println("The SQL statement is : " + strSelect);
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                System.out.println(rset.getInt("id")+","+
                        rset.getString("author")+","+
                        rset.getString("title")+","+
                        rset.getDouble("price")+","+
                        rset.getInt("qty"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}