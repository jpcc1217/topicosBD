package conexionsqlserver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class operaciones {
    
    ResultSet opSelect(Statement stm,String nombretabla) throws SQLException{
        return stm.executeQuery("Select * from "+nombretabla); 
    }
    
    ResultSet opInsert(Statement stm,String nombretabla,String valores) throws SQLException{
        return stm.executeQuery("INSERT INTO "+nombretabla +"VALUES "+valores); 
        //(100, 'Zara', 'Ali', 18) formato insercion
    }
    
    ResultSet opUpdate(Statement stm,String nombretabla,String campoupdate,String update,String campoid,String id) throws SQLException{
        return stm.executeQuery("update "+nombretabla+" set"+campoupdate+"='"+update+"' where"+campoid+"="+id ); 
    }
    
    ResultSet opDelete(Statement stm,String nombretabla,String campoupdate,String update,String campoid,String id) throws SQLException{
        return stm.executeQuery("delete from "+nombretabla+"where "+campoid+"="+id); 
    }
}
