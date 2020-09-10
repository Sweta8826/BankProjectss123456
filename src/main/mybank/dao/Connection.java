package dao;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection {
    private String url = "jdbc:h2:C:\\Users\\an20090319\\h2db";
    private String uname = "ankit";
    private String pass = "ankit";
    private  String driver = "org.h2.Driver";


    public java.sql.Connection getConnection()
    {
        java.sql.Connection conn =  null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, uname, pass);
        }catch (SQLException | ClassNotFoundException sql){
            sql.printStackTrace();
        }
        return conn;
    }
    public void closeConnection(java.sql.Connection conn){
        try {
            conn.close();
        }catch (SQLException sql)
        {
            sql.printStackTrace();
        }
    }
}
