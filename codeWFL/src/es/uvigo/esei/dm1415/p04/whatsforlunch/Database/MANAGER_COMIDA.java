package es.uvigo.esei.dm1415.p04.whatsforlunch.Database;

/**
 * Created by AliothAntonio on 29/12/2014.
 */
public class MANAGER_COMIDA {
    public static final String TABLE_NAME="COMIDA";
    public static final String CN_ID="_id";
    public static final String CN_NAME="nombre";
    public static final String CN_FOTO="foto";
    public static final String CN_IDRECETA="_idreceta";
    public static final String CN_TIPOCOMIDA="tipocomida";
    public static final String CREATE_TABLE="CREATE TABLE "+ TABLE_NAME + " ("
            +CN_ID+" integer primary key autoincrement, "
            +CN_NAME+" text not null, "
            +CN_FOTO+" text, "
            +CN_IDRECETA+" integer, "
            +CN_TIPOCOMIDA+" integer);";
    public static String[] getColumnas(){
        return new String[]{
                CN_ID,
                CN_NAME,
                CN_FOTO,
                CN_IDRECETA,
                CN_TIPOCOMIDA
        };
    }
}
