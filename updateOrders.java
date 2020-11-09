package UPDATE_MySQL_JAVA.Exam2;
import java.sql.*;
public class updateOrders {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String strupdate = "update products set UnitPrice = UnitPrice * 1.1 where CategoryID in (5,7,8)";
            stmt.executeUpdate(strupdate);
            System.out.println("Updated the SQL statement: "+strupdate);

            String strselect = "Select * from products where CategoryID in (5,7,8)";
            ResultSet rst = stmt.executeQuery(strselect);
            ResultSetMetaData rstMD = rst.getMetaData();
            for(int i =  1 ; i<rstMD.getColumnCount();i++){
                System.out.printf("%-40s",rstMD.getColumnName(i));
            }
            System.out.println();
            while (rst.next()){
                for(int i =1;i<rstMD.getColumnCount();i++){
                    System.out.printf("%-40s",rst.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
