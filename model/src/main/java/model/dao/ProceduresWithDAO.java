package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class ProceduresWithDAO extends AbstractDAO {

    /**
     * 
     *  WE PUT EVERYTHING IN ONE CHART : X, Y, IDLEVEL AND THE SPRITE SUPPOSED TO BE HERE !
     * 
     */
    private static String sqlLevelById   = "{call getLevelCompById(?)}";
    private static int    ColumnX  = 1;  
    private static int    ColumnY  = 2;
    private static int    ColumnSprite  = 3;
    private static ResultSet result;
    
    
   public static ResultSet getLevelCompById(final int idlevel) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlLevelById);
        callStatement.setInt(1, idlevel); //define the first variable of the stored procedure to idlevel to choose the level to load
        
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
        }
		return result;
    }

	public static int getColumnX() {
		return ColumnX;
	}

	public static void setColumnX(int columnX) {
		ColumnX = columnX;
	}

	public static int getColumnY() {
		return ColumnY;
	}

	public static void setColumnY(int columnY) {
		ColumnY = columnY;
	}

	public static int getColumnSprite() {
		return ColumnSprite;
	}

	public static void setColumnSprite(int columnSprite) {
		ColumnSprite = columnSprite;
	}
   
   
}
