package es.uvigo.esei.dm1415.p04.whatsforlunch.Database;

/**
 * Created by AliothAntonio on 29/12/2014.
 */
public class MANAGER_UNIDAD {
    public static final String TABLE_NAME="UNIDAD";
    public static final String CN_idUnidad="_id";
    public static final String CN_nombreUnidad="nombreunidad";
    public static final String CREATE_TABLE="CREATE  TABLE "+TABLE_NAME+" ("+CN_idUnidad+" INTEGER PRIMARY KEY  autoincrement, "+CN_nombreUnidad+" TEXT);";
    public static String[] getColumnas() {
        return new String[]{
                CN_idUnidad,
                CN_nombreUnidad
        };
    }
}
