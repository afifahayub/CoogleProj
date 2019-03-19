package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection
{
    private static final String username="";
    private static final String pass="";
    private static final String DBCONN= "jdbc:sqlite:FinalProjectTable.sqlite";

    public static Connection conn() throws SQLException
    {
        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(DBCONN);
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
