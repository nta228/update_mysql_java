package UPDATE_MySQL_JAVA.Exam2;
import java.sql.*;
public class updateCustomer {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","");
                Statement stmt = conn.createStatement();
        ){
            ResultSet rset = stmt.executeQuery("select * from customers where CustomerID = \'FRANK\'");

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

            String strUpdate1 = "update customers set Address  = \'1A Yet Kieu - Ha Noi\' where CustomerID = \'FRANK\' ";
            System.out.println("The SQL statement is : " + strUpdate1);
            int countUpdated1 = stmt.executeUpdate(strUpdate1);
            System.out.println(countUpdated1 + " record affected");

            for (int i =1; i < numColums; i++){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();

            ResultSet rset1 = stmt.executeQuery("select * from customers where CustomerID = \'FRANK\'");
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
