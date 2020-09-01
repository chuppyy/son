package DAO;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//class connection Ä‘á»ƒ
//káº¿t ná»‘i csdl 
//thá»±c hiá»‡n cÃ¡c lá»‡nh truy váº¥n 
//insert update delete
//select
public class connection {
//    táº¡o chuá»—i háº¿t ná»‘i

    private static String DB_URL = "jdbc:sqlserver://localhost;"
            + "databaseName=QuanLyKhachSan;";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "123";
    public static Connection conn = null;

    static PreparedStatement preparedStatement(String cauTruyVan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public connection() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully(káº¿t ná»‘i thÃ nh cÃ´ng)");
        } catch (ClassNotFoundException ex) {
            System.out.println("lá»—i thiáº¿u thÆ° viá»‡n");
        } catch (SQLException ex) {
            System.out.println("lá»—i káº¿t ná»‘i csdl");
        }

    }


    //hÃ m thá»±c thi cÃ¢u lá»‡nh select
    public static ResultSet Getdata(String cauTruyVan){
        try {
            Statement stm=conn.createStatement();
            //thá»±c thicaau truy váº¥n select dc truyá»�n vÃ o tá»«
            //tham sá»‘ cautruyvan
            //tráº£ vá»� káº¿t quáº£ lÃ  ResultSet
            ResultSet rs=stm.executeQuery(cauTruyVan);
            return rs;//tráº£ vá»� resultset náº¿u thÃ nh cÃ´ng
        } catch (SQLException ex) {
            System.out.println("lá»—i truy váº¥n");
            return null;
        }
    
    }
    // hÃ m thá»±c thi 3 cÃ¢u lá»‡nh insert delete update
    public static int ExecuteTruyVan(String cauTruyVan){
        try {
            Statement stm= conn.createStatement();
            return stm.executeUpdate(cauTruyVan);
            
        } catch (SQLException ex) {
            System.out.println("lá»—i thá»±c thi truy váº¥n");
            return -1;
        }
    }
}
