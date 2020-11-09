package UPDATE_MySQL_JAVA.Exam2;
import java.sql.*;
public class updateProduct {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","");
                Statement stmt = conn.createStatement();
        ){
            ResultSet rset = stmt.executeQuery("select * from products where CategoryID in (5,7,8) ");

            ResultSetMetaData rsetMD = rset.getMetaData();;

            int numColums = rsetMD.getColumnCount();

            for (int i =1; i < numColums; i++){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();

            while (rset.next()){
                for (int i =1;i < numColums; i++){
                    System.out.printf("%-30s",rset.getString(i));
                }
                System.out.println();
            }

            String strUpdate1 = "update products set UnitPrice = UnitPrice * 1.1 where CategoryID in (5,7,8)  ";
            System.out.println("The SQL statement is : " + strUpdate1);
            int countUpdated1 = stmt.executeUpdate(strUpdate1);
            System.out.println(countUpdated1 + " record affected");

            for (int i =1; i < numColums; i++){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();

            ResultSet rset1 = stmt.executeQuery("select * from products where CategoryID in (5,7,8)");
            while (rset1.next()){
                for (int i =1;i < numColums; i++){
                    System.out.printf("%-30s",rset1.getString(i));
                }
                System.out.println();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
