package es.uvigo.esei.dm1415.p04.whatsforlunch.Database;

/**
 * Created by AliothAntonio on 29/12/2014.
 */
public class MANAGER_TIPO_COMIDA {
    public static final String TABLE_NAME="TIPOCOMIDA";
    public static final String CN_idTipoComida="_id";
    public static final String CN_nombreTipoComida="nombretipocomida";
    public static final String CREATE_TABLE ="CREATE  TABLE "+TABLE_NAME+" ("+CN_idTipoComida+" INTEGER PRIMARY KEY  autoincrement, "+CN_nombreTipoComida+" TEXT);";

    public static String[] getColumnas() {
        return new String[]{
                CN_idTipoComida,
                CN_nombreTipoComida
        };
    }
}
