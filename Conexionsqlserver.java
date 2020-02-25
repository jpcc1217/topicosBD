package conexionsqlserver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexionsqlserver {
    private static Connection cn;
	
    public static Connection getConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://Sqlaulas.tic.upb;databaseName=BDMascotas","sa","Mae$tro01");
        } catch(Exception e){
        	cn=null;
        }
        return cn;
    }
    public static void main(String[] args) throws SQLException{
        Connection pruebaCn = Conexionsqlserver.getConnection();
        if(pruebaCn!=null){
            System.out.println("Conectado");
            System.out.println(pruebaCn);
            Statement stm = pruebaCn.createStatement();
            operaciones abc = new operaciones();
            
            ResultSet rst = abc.opSelect(stm,"Tienda.Cliente");
            while(rst.next()){
                System.out.println("Id"+rst.getInt(1)+" Nombre: "+rst.getString(2)+" Telefono: "+rst.getString(3));
            }
            
            abc.opInsert(stm, "Tienda.Cliente","('asd','asd','asddas')");
            
            abc.opSelect(stm, nombretabla);
            
            abc.opUpdate(stm, nombretabla, campoupdate, update, campoid, id);
            
        }else{
            System.out.println("Desconectado");
        }
    }
    
}

