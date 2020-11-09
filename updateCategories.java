package UPDATE_MySQL_JAVA.Exam2;
import java.sql.*;
public class updateCategories {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String strupdate = "update categories set CategoryName = 'Seafood VN' where CategoryName = 'Seafood'";
            stmt.executeUpdate(strupdate);
            System.out.println("Updated the SQL statement: "+strupdate);

            String strselect = "Select * from categories";
            ResultSet rst = stmt.executeQuery(strselect);
            ResultSetMetaData rstMD = rst.getMetaData();
            for(int i =  1 ; i<rstMD.getColumnCount();i++){
                System.out.printf("%-30s",rstMD.getColumnName(i));
            }
            System.out.println();
            while (rst.next()){
                for(int i =1;i<rstMD.getColumnCount();i++){
                    System.out.printf("%-30s",rst.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
