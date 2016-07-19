package es.uvigo.esei.dm1415.p04.whatsforlunch.Utils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.DataBaseHelper;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.MANAGER_COMIDA;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.MANAGER_INGREDIENTE;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.MANAGER_RECETA;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.MANAGER_RECETA_HAS_INGREDIENTE;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.MANAGER_TIPO_COMIDA;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.MANAGER_UNIDAD;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Comida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Ingrediente;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Receta;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.RecetaIngrediente;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.TipoComida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Unidad;

/**
 * Created by AliothAntonio on 01/01/2015.
 */
public class Utils {

    public static ArrayList<Comida> convertirCursor2ArrayComida(Cursor c, DataBaseHelper helper, SQLiteDatabase db){
        ArrayList<Comida> lista=new ArrayList<>();
        if (c.moveToFirst() == false){
            return lista;
        }else{
            int indiceIdComida=c.getColumnIndex(MANAGER_COMIDA.CN_ID);
            Integer idComida=Integer.parseInt(c.getString(indiceIdComida));
            int indiceName=c.getColumnIndex(MANAGER_COMIDA.CN_NAME);
            String nombre=c.getString(indiceName);
            int indiceFoto=c.getColumnIndex(MANAGER_COMIDA.CN_FOTO);
            Integer foto=Integer.parseInt(c.getString(indiceFoto));
            int indiceIDReceta=c.getColumnIndex(MANAGER_COMIDA.CN_IDRECETA);
            int indiceidTipoComida=c.getColumnIndex(MANAGER_COMIDA.CN_TIPOCOMIDA);
            Cursor cursorreceta=helper.findRecetaById(c.getString(indiceIDReceta),db);
            Receta r=convertirCursor2Receta(cursorreceta);
            Cursor cursortipocomida=helper.findTipoComidaById(c.getString(indiceidTipoComida), db);
            TipoComida tc=convertirCursor2TipoComida(cursortipocomida);
            //Comida(Integer idComida, String nombre, Integer foto, Receta receta, TipoComida tipoComida)
            Comida temp=new Comida(idComida,nombre,foto,r,tc);
            lista.add(temp);
        }

        while(c.moveToNext()){
            int indiceIdComida=c.getColumnIndex(MANAGER_COMIDA.CN_ID);
            Integer idComida=Integer.parseInt(c.getString(indiceIdComida));
            int indiceName=c.getColumnIndex(MANAGER_COMIDA.CN_NAME);
            String nombre=c.getString(indiceName);
            int indiceFoto=c.getColumnIndex(MANAGER_COMIDA.CN_FOTO);
            Integer foto=Integer.parseInt(c.getString(indiceFoto));
            int indiceIDReceta=c.getColumnIndex(MANAGER_COMIDA.CN_IDRECETA);
            int indiceidTipoComida=c.getColumnIndex(MANAGER_COMIDA.CN_TIPOCOMIDA);
            Cursor cursorreceta=helper.findRecetaById(c.getString(indiceIDReceta),db);
            Receta r=convertirCursor2Receta(cursorreceta);
            Cursor cursortipocomida=helper.findTipoComidaById(c.getString(indiceidTipoComida), db);
            TipoComida tc=convertirCursor2TipoComida(cursortipocomida);
            //Comida(Integer idComida, String nombre, Integer foto, Receta receta, TipoComida tipoComida)
            Comida temp=new Comida(idComida,nombre,foto,r,tc);
            lista.add(temp);
        }
        return lista;
    }

    public static Comida convertirCursor2Comida(Cursor c, DataBaseHelper helper, SQLiteDatabase db){
        if (c.moveToFirst() != false){
            int indiceIdComida=c.getColumnIndex(MANAGER_COMIDA.CN_ID);
            Integer idComida=Integer.parseInt(c.getString(indiceIdComida));
            int indiceName=c.getColumnIndex(MANAGER_COMIDA.CN_NAME);
            String nombre=c.getString(indiceName);
            int indiceFoto=c.getColumnIndex(MANAGER_COMIDA.CN_FOTO);
            Integer foto=Integer.parseInt(c.getString(indiceFoto));
            int indiceIDReceta=c.getColumnIndex(MANAGER_COMIDA.CN_IDRECETA);
            int indiceidTipoComida=c.getColumnIndex(MANAGER_COMIDA.CN_TIPOCOMIDA);
            Cursor cursorreceta=helper.findRecetaById(c.getString(indiceIDReceta),db);
            Receta r=convertirCursor2Receta(cursorreceta);
            Cursor cursortipocomida=helper.findTipoComidaById(c.getString(indiceidTipoComida), db);
            TipoComida tc=convertirCursor2TipoComida(cursortipocomida);
            //Comida(Integer idComida, String nombre, Integer foto, Receta receta, TipoComida tipoComida)
            Comida temp=new Comida(idComida,nombre,foto,r,tc);
            return temp;
        }
        return null;

    }

    private static TipoComida convertirCursor2TipoComida(Cursor c) {
        if (c.moveToFirst() != false){
            int indiceid=c.getColumnIndex(MANAGER_TIPO_COMIDA.CN_idTipoComida);
            Integer idTipoComida=Integer.parseInt(c.getString(indiceid));
            int indiceNombreTipoComida=c.getColumnIndex(MANAGER_TIPO_COMIDA.CN_nombreTipoComida);
            String nombreTipoComida=c.getString(indiceNombreTipoComida);
            return new TipoComida(idTipoComida, nombreTipoComida);
        }
        return null;
    }

    private static Ingrediente convertirCursor2Ingrediente(Cursor c) {
        if (c.moveToFirst() != false){
            //(Integer idIgrediente, String nombreIngrediente, Integer fotoIngrediente)
            int indiceidingrediente=c.getColumnIndex(MANAGER_INGREDIENTE.CN_idIngrediente);
            Integer idIngrediente=Integer.parseInt(c.getString(indiceidingrediente));
            int indicenombreingrediente=c.getColumnIndex(MANAGER_INGREDIENTE.CN_nombreIngrediente);
            String nombreIngrediente=c.getString(indicenombreingrediente);
            int indiceFotoIngrediente=c.getColumnIndex(MANAGER_INGREDIENTE.CN_fotoIngrediente);
            Integer fotoIngrediente=Integer.parseInt(c.getString(indiceFotoIngrediente));
            return new Ingrediente(idIngrediente,nombreIngrediente,fotoIngrediente);
        }
        return null;
    }


    public static Receta convertirCursor2Receta(Cursor c){
        if (c.moveToFirst() != false){
            int indiceid=c.getColumnIndex(MANAGER_RECETA.CN_idReceta);
            Integer idReceta=Integer.parseInt(c.getString(indiceid));
            int indiceDescripcionOferta=c.getColumnIndex(MANAGER_RECETA.CN_descripcionreceta);
            String descripcionReceta=c.getString(indiceDescripcionOferta);
            return new Receta(idReceta,descripcionReceta);
        }
        return null;
    }

    public static Unidad convertirCursor2Unidad(Cursor c){
        if (c.moveToFirst() != false){
            int indiceidunidad=c.getColumnIndex(MANAGER_UNIDAD.CN_idUnidad);
            Integer idUnidad=Integer.parseInt(c.getString(indiceidunidad));
            int indiceNombreUnidad=c.getColumnIndex(MANAGER_UNIDAD.CN_nombreUnidad);
            String nombreUnidad=c.getString(indiceNombreUnidad);
            return new Unidad(idUnidad,nombreUnidad);
        }
        return null;
    }

    public static ArrayList<RecetaIngrediente> convertirCursor2ArrayIngrediente(Cursor c, DataBaseHelper helper, SQLiteDatabase db) {
        /*  SE LE PASA UN CURSOR DE RECETAHASINGREDIENTE
            DEBE RETORNAR UNA LISTA DE INGREDIENTES
        */
        ArrayList<RecetaIngrediente> lista=new ArrayList<>();
        if (c.moveToFirst() == false){
            return lista;
        }else{
            Integer indiceIdReceta=c.getColumnIndex(MANAGER_RECETA_HAS_INGREDIENTE.CN_idReceta);
            String idReceta=c.getString(indiceIdReceta);
            Integer indiceCantidad=c.getColumnIndex(MANAGER_RECETA_HAS_INGREDIENTE.CN_cantidad);
            Integer cant=Integer.parseInt(c.getString(indiceCantidad));
            Integer indiceIdIngrente=c.getColumnIndex(MANAGER_RECETA_HAS_INGREDIENTE.CN_idingrediente);
            String idIngrediente=c.getString(indiceIdIngrente);
            Integer indiceIdUnidad=c.getColumnIndex(MANAGER_RECETA_HAS_INGREDIENTE.CN_idunidad);
            String idUnidad=c.getString(indiceIdUnidad);
            Receta receta=convertirCursor2Receta(helper.findRecetaById(idReceta,db));
            Ingrediente ingrediente=convertirCursor2Ingrediente(helper.findIngredienteById(idIngrediente,db));
            Unidad unidad=convertirCursor2Unidad(helper.findUnidadById(idUnidad,db));
            RecetaIngrediente temp=new RecetaIngrediente(receta,ingrediente, cant,unidad);
            lista.add(temp);
        }
        while(c.moveToNext()){
            Integer indiceIdReceta=c.getColumnIndex(MANAGER_RECETA_HAS_INGREDIENTE.CN_idReceta);
            String idReceta=c.getString(indiceIdReceta);
            Integer indiceCantidad=c.getColumnIndex(MANAGER_RECETA_HAS_INGREDIENTE.CN_cantidad);
            Integer cant=Integer.parseInt(c.getString(indiceCantidad));
            Integer indiceIdIngrente=c.getColumnIndex(MANAGER_RECETA_HAS_INGREDIENTE.CN_idingrediente);
            String idIngrediente=c.getString(indiceIdIngrente);
            Integer indiceIdUnidad=c.getColumnIndex(MANAGER_RECETA_HAS_INGREDIENTE.CN_idunidad);
            String idUnidad=c.getString(indiceIdUnidad);
            Receta receta=convertirCursor2Receta(helper.findRecetaById(idReceta,db));
            Ingrediente ingrediente=convertirCursor2Ingrediente(helper.findIngredienteById(idIngrediente,db));
            Unidad unidad=convertirCursor2Unidad(helper.findUnidadById(idUnidad,db));
            RecetaIngrediente temp=new RecetaIngrediente(receta,ingrediente, cant,unidad);
            lista.add(temp);
        }
        return lista;
    }
}
