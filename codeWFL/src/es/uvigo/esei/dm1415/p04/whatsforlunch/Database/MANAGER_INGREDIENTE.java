package es.uvigo.esei.dm1415.p04.whatsforlunch.Database;

/**
 * Created by AliothAntonio on 29/12/2014.
 */
public class MANAGER_INGREDIENTE {
    public static final String TABLE_NAME="INGREDIENTE";
    public static final String CN_idIngrediente="_id";
    public static final String CN_nombreIngrediente="nombreingrediente";
    public static final String CN_fotoIngrediente="fotoingrediente";
    public static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("
            +CN_idIngrediente+" integer primary key autoincrement, "
            +CN_nombreIngrediente+" text not null, "
            +CN_fotoIngrediente+" text);";
    public static String[] getColumnas() {
        return new String[]{
                CN_idIngrediente,
                CN_nombreIngrediente,
                CN_fotoIngrediente
        };
    }
}
