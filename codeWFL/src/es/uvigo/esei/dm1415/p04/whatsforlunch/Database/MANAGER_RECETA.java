package es.uvigo.esei.dm1415.p04.whatsforlunch.Database;

/**
 * Created by AliothAntonio on 29/12/2014.
 */
public class MANAGER_RECETA {
    public static final String TABLE_NAME="RECETA";
    public static final String CN_idReceta="_id";
    public static final String CN_descripcionreceta="descripcionreceta";
    public static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("
            +CN_idReceta+" integer primary key autoincrement, "
            +CN_descripcionreceta+" text);";
    public static String[] getColumnas() {
        return new String[]{
                CN_idReceta,
                CN_descripcionreceta
        };
    }
}
