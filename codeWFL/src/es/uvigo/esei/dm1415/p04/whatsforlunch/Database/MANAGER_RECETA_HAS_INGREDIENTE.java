package es.uvigo.esei.dm1415.p04.whatsforlunch.Database;

/**
 * Created by AliothAntonio on 29/12/2014.
 */
public class MANAGER_RECETA_HAS_INGREDIENTE {
    public static final String TABLE_NAME="RECETAHASINGREDIENTES";
    public static final String CN_idReceta="_id";
    public static final String CN_idingrediente="_idingrediente";
    public static final String CN_cantidad="cantidad";
    public static final String CN_idunidad="_idunidad";

    public static final String CREATE_TABLE="CREATE  TABLE "+TABLE_NAME+" ("
        +CN_idReceta+" INTEGER NOT NULL , "
        +CN_idingrediente+ " INTEGER NOT NULL , "
        +CN_cantidad+" INTEGER, "
        +CN_idunidad+" INTEGER, PRIMARY KEY ("+CN_idReceta+", "+CN_idingrediente+"));";
    public static String[] getColumnas() {
        return new String[]{
                CN_idReceta,
                CN_idingrediente,
                CN_cantidad,
                CN_idunidad,
        };
    }
}
