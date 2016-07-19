package es.uvigo.esei.dm1415.p04.whatsforlunch.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Comida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Ingrediente;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Receta;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.RecetaIngrediente;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.TipoComida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Unidad;
import es.uvigo.esei.dm1415.p04.whatsforlunch.R;

/**
 * Created by AliothAntonio on 29/12/2014.
 */
public class DataBaseHelper extends SQLiteOpenHelper{
    private static final String DB_NAME="bdcomidas.sqlite";
    private static final int DB_SCHEME_VERSION=1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MANAGER_TIPO_COMIDA.CREATE_TABLE);
        db.execSQL(MANAGER_COMIDA.CREATE_TABLE);
        db.execSQL(MANAGER_INGREDIENTE.CREATE_TABLE);
        db.execSQL(MANAGER_RECETA.CREATE_TABLE);
        db.execSQL(MANAGER_UNIDAD.CREATE_TABLE);
        db.execSQL(MANAGER_RECETA_HAS_INGREDIENTE.CREATE_TABLE);
        introducirRegistros(db);
    }

    private void introducirRegistros(SQLiteDatabase db) {
        /*TODO: AQUI PONEMOS TODOS LOS REGISTROS CON QUE QUERAMOS INICIALIZAR LA BASE DE DATOS*/
        Ingrediente arroz=new Ingrediente(1,"arroz",R.drawable.arroz);
        Ingrediente carne=new Ingrediente(2,"carne",R.drawable.carne);
        Ingrediente garbanzos=new Ingrediente(3,"garbanzos",R.drawable.garbanzos);
        Ingrediente huevo=new Ingrediente(4,"huevo",R.drawable.huevo);
        Ingrediente leche=new Ingrediente(5,"leche",R.drawable.leche);
        Ingrediente limon=new Ingrediente(6,"limon",R.drawable.limon);
        Ingrediente mariscos=new Ingrediente(7,"mariscos",R.drawable.mariscos);
        Ingrediente platanos=new Ingrediente(8,"platanos",R.drawable.platanos);
        Ingrediente pollo=new Ingrediente(9,"pollo",R.drawable.pollo);

        insertarIngrediente(arroz,db);
        insertarIngrediente(carne,db);
        insertarIngrediente(garbanzos,db);
        insertarIngrediente(huevo,db);
        insertarIngrediente(leche,db);
        insertarIngrediente(limon,db);
        insertarIngrediente(mariscos,db);
        insertarIngrediente(platanos,db);
        insertarIngrediente(pollo,db);




        Unidad vaso=new Unidad(1,"vaso");
        Unidad unidades=new Unidad(2,"unidades");
        Unidad litro=new Unidad(3,"Litro");
        Unidad gramo=new Unidad(4,"Gramo");

        insertarUnidad(vaso,db);
        insertarUnidad(unidades,db);
        insertarUnidad(litro,db);
        insertarUnidad(gramo,db);

        TipoComida postre=new TipoComida(1,"Postre");
        TipoComida comida=new TipoComida(2,"Comida");
        TipoComida cena=new TipoComida(3,"Cena");

        insertarTipoComida(postre,db);
        insertarTipoComida(comida,db);
        insertarTipoComida(cena,db);



        Receta recetaarrozalacubana=new Receta(1, "Cuece el arroz durante 20 minutos en abundante agua hirviendo con una pizca de sal. Escurre, refresca y resérvalo en un plato.\n" +
                "\n" +
                "Corta 2 dientes de ajo en láminas y ponlos a dorar en una cazuela con un poco de aceite. Agrega la panceta picada. Rehoga brevemente y vierte la salsa de tomate. Añade un poco de albahaca (1 cucharada de las de café). Cocina todo junto durante 5 minutos.\n" +
                "\n" +
                "En una sartén dora los otros dos dientes de ajo picados. Cuando se doren, añade el arroz. Saltea y mezcla bien.\n" +
                "\n" +
                "En otra sartén con abundante aceite, fríe los huevos. Pasa los plátanos por harina y fríelos en la misma sartén.");

        Receta recetaarrozconpollo=new Receta(2,"Pela el diente de ajo, pícalo en láminas, después en tiras y finalmente en daditos. Pica la cebolleta en daditos.\n" +
                "\n" +
                "Limpia el pimiento, aplástalo con la mano, retírale el tallo y las pepitas, córtalo en tiras y después en daditos.\n" +
                "\n" +
                "Pon 3 cucharadas de aceite en una cazuela amplia y baja, agrega la verdura y rehógala a fuego medio durante 4 minutos. Agrega el pollo troceado y dóralo junto con las verduras durante otros 4 minutos. Añade el arroz y rehógalo todo junto durante 2 minutos.\n" +
                "\n" +
                "Vierte el agua, 1/2 cucharadita de sal (a tu gusto) y unas hebras de azafrán. Cuece a fuego fuerte durante 3 minutos. Tapa la cazuela y deja cocer durante otros 15-17 minutos a fuego suave. Apaga el fuego y deja reposar tapado durante 5 minutos.\n" );
        Receta recetacocidogallego=new Receta(3,"Pon las alubias a remojo víspera. Escurre y reserva.\n" +
                "Pon a remojo en otro cuenco la costilla de cerdo, el tocino y el espinazo de víspera. Escurre. Pon abundante agua en la olla rápida, agrega el tocino, la costilla, el espinazo y el unto. Tapa y cuécelos durante 40 minutos.\n" +
                "Abre la olla, agrega las alubias, coloca la tapa y cuécelas durante 15 minutos más. Abre de nuevo la olla y añade las patatas peladas y cascadas. Agrega también los grelos troceados. Coloca la tapa y deja cocer el conjunto durante 10 minutos más. Abre la olla y retira el espinazo.\n" );

        Receta recetaflandehuevo=new Receta(4,"Para caramelizar el molde, pon dos cucharadas de azúcar, un poco de agua y unas gotas de limón en una sartén y deja cocer a fuego lento. Cuando empiece a tomar color castaño retíralo del fuego y espera a que casi desaparezcan las burbujas. Viértelo en el molde o los moldes y extiéndelo bien. \n" +
                "\n" +
                "Coloca los huevos en un bol y bátelos con una varilla manual. Añade 5 cucharadas de azúcar y sigue batiendo. Agrega la leche y remueve suavemente. Si quedara algún grumo puedes colar la mezcla. Rellena las flaneras. Pon a cocer al baño maría en el horno a 180º C durante 20 minutos. Deja templar y desmolda. \n" +
                "\n" +
                "Pon la nata líquida en un bol y monta con la batidora de varillas eléctrica (puedes hacerlo con la varilla manual). En el último momento, añade una cucharada de azúcar y bate un poco más. \n" +
                "\n" +
                "Sirve el flan de huevo acompañado con la nata montada y decora con una hojita de menta y un fruto rojo.");

        Receta recetapaellamariscos=new Receta(5,"En la paella (el recipiente para hacer el arroz), pochar o rehogar la verdura 5 minutos. Cuando este bien pochada, añadir el pescado, las gambas, y las almejas. Rehogar bien e incorporar el arroz.\n" +
                "\n" +
                "Moverlo y agregar el caldo.\n" +
                "\n" +
                "Probar de sal y cuando empiece a hervir, poner encima los langostinos y dejar cocer 15 minutos a fuego suave hasta que este hecha.");

        insertarReceta(recetaarrozalacubana,db);
        insertarReceta(recetaarrozconpollo,db);
        insertarReceta(recetacocidogallego,db);
        insertarReceta(recetaflandehuevo,db);
        insertarReceta(recetapaellamariscos,db);

        RecetaIngrediente riarrozalacubana1=new RecetaIngrediente(recetaarrozalacubana,arroz,400, gramo);
        RecetaIngrediente riarrozalacubana2=new RecetaIngrediente(recetaarrozalacubana,huevo,2,unidades);
        RecetaIngrediente riarrozalacubana3=new RecetaIngrediente(recetaarrozalacubana,platanos,3, unidades);

        RecetaIngrediente riarrozconpollo1=new RecetaIngrediente(recetaarrozconpollo,pollo,5,unidades);
        RecetaIngrediente riarrozconpollo2=new RecetaIngrediente(recetaarrozconpollo,arroz,600,gramo);

        RecetaIngrediente ricocidogallego1=new RecetaIngrediente(recetacocidogallego,garbanzos,400,gramo);
        RecetaIngrediente ricocidogallego2=new RecetaIngrediente(recetacocidogallego,carne,2000,gramo);

        RecetaIngrediente riflanhuevo1=new RecetaIngrediente(recetaflandehuevo,huevo,6,unidades);
        RecetaIngrediente riflanhuevo2=new RecetaIngrediente(recetaflandehuevo,leche,1,litro);

        RecetaIngrediente ripaellamarisco1=new RecetaIngrediente(recetapaellamariscos,arroz,500,gramo);
        RecetaIngrediente ripaellamarisco2=new RecetaIngrediente(recetapaellamariscos,mariscos,3000,gramo);
        RecetaIngrediente ripaellamarisco3=new RecetaIngrediente(recetapaellamariscos,limon,1,unidades);

        insertarRecetaHasIngrediente(riarrozalacubana1,db);
        insertarRecetaHasIngrediente(riarrozalacubana2,db);
        insertarRecetaHasIngrediente(riarrozalacubana3,db);
        insertarRecetaHasIngrediente(riarrozconpollo1,db);
        insertarRecetaHasIngrediente(riarrozconpollo2,db);
        insertarRecetaHasIngrediente(ricocidogallego1,db);
        insertarRecetaHasIngrediente(ricocidogallego2,db);
        insertarRecetaHasIngrediente(riflanhuevo1,db);
        insertarRecetaHasIngrediente(riflanhuevo2,db);
        insertarRecetaHasIngrediente(ripaellamarisco1,db);
        insertarRecetaHasIngrediente(ripaellamarisco2,db);
        insertarRecetaHasIngrediente(ripaellamarisco3,db);


        Comida arrozalacubana=new Comida(1,"Arroz a la cubana",R.drawable.arrozalacubana,recetaarrozalacubana,comida);
        Comida arrozconpollo=new Comida(2,"Arroz con pollo",R.drawable.arrozconpollo,recetaarrozconpollo,cena);
        Comida cocidogallego=new Comida(3,"Cocido Gallego",R.drawable.cocidogallego,recetacocidogallego,cena);
        Comida flandehuevo=new Comida(4,"Flan de Huevo",R.drawable.fladehuevo,recetaflandehuevo,postre);
        Comida paellamarisco=new Comida(5,"Paella de Mariscos",R.drawable.paellamarisco,recetapaellamariscos,comida);

        insertarComida(arrozalacubana,db);
        insertarComida(arrozconpollo,db);
        insertarComida(cocidogallego,db);
        insertarComida(flandehuevo,db);
        insertarComida(paellamarisco,db);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertarComida(Comida c, SQLiteDatabase db){
        db.insert(MANAGER_COMIDA.TABLE_NAME,null,valoresComida(c));
    }

    public void deleteComida(Comida c, SQLiteDatabase db){
        db.delete(MANAGER_COMIDA.TABLE_NAME, MANAGER_COMIDA.CN_ID + "=?", new String[]{c.getIdComida().toString()});
    }

    public void updateComida(Comida c, SQLiteDatabase db){
        db.update(MANAGER_COMIDA.TABLE_NAME,valoresComida(c),MANAGER_COMIDA.CN_ID+"=?",new String[]{c.getIdComida().toString()});
    }

    public ContentValues valoresComida(Comida c){
        ContentValues valores=new ContentValues();
        if(c.getIdComida()==null){
            valores.put(MANAGER_COMIDA.CN_NAME, c.getNombre());
            valores.put(MANAGER_COMIDA.CN_FOTO, c.getFoto());
            valores.put(MANAGER_COMIDA.CN_IDRECETA, c.getReceta().getIdReceta());
            valores.put(MANAGER_COMIDA.CN_TIPOCOMIDA, c.getTipoComida().getIdTipoComida());
        }else{
            valores.put(MANAGER_COMIDA.CN_ID, c.getIdComida());
            valores.put(MANAGER_COMIDA.CN_NAME, c.getNombre());
            valores.put(MANAGER_COMIDA.CN_FOTO, c.getFoto());
            valores.put(MANAGER_COMIDA.CN_IDRECETA, c.getReceta().getIdReceta());
            valores.put(MANAGER_COMIDA.CN_TIPOCOMIDA, c.getTipoComida().getIdTipoComida());
        }
        return valores;
    }

    public void insertarIngrediente(Ingrediente i, SQLiteDatabase db){
        db.insert(MANAGER_INGREDIENTE.TABLE_NAME,null,valoresIngredientes(i));
    }

    public void deleteIngrediente(Ingrediente i, SQLiteDatabase db){
        db.delete(MANAGER_INGREDIENTE.TABLE_NAME,MANAGER_INGREDIENTE.CN_idIngrediente+"=?",new String[]{i.getIdIgrediente().toString()});
    }

    public void updateIngrediente(Ingrediente i, SQLiteDatabase db){
        db.update(MANAGER_INGREDIENTE.TABLE_NAME,valoresIngredientes(i),MANAGER_INGREDIENTE.CN_idIngrediente+"=?",new String[]{i.getIdIgrediente().toString()});
    }

    public ContentValues valoresIngredientes(Ingrediente i){
        ContentValues valores=new ContentValues();
        if(i.getIdIgrediente()==null){
            valores.put(MANAGER_INGREDIENTE.CN_nombreIngrediente,i.getNombreIngrediente());
            valores.put(MANAGER_INGREDIENTE.CN_fotoIngrediente,i.getFotoIngrediente());
        }else{
            valores.put(MANAGER_INGREDIENTE.CN_idIngrediente,i.getIdIgrediente());
            valores.put(MANAGER_INGREDIENTE.CN_nombreIngrediente,i.getNombreIngrediente());
            valores.put(MANAGER_INGREDIENTE.CN_fotoIngrediente,i.getFotoIngrediente());
            valores.put(MANAGER_INGREDIENTE.CN_fotoIngrediente,i.getFotoIngrediente());
        }
        return valores;
    }

    public void insertarReceta(Receta r, SQLiteDatabase db){
        db.insert(MANAGER_RECETA.TABLE_NAME,null, valoresReceta(r));
    }

    public void deleteReceta(Receta r, SQLiteDatabase db){
        db.delete(MANAGER_RECETA.TABLE_NAME,MANAGER_RECETA.CN_idReceta+"=?",new String[]{r.getIdReceta().toString()});
    }

    public void updateReceta(Receta r, SQLiteDatabase db){
        db.update(MANAGER_RECETA.TABLE_NAME, valoresReceta(r), MANAGER_RECETA.CN_idReceta + "=?", new String[]{r.getIdReceta().toString()});
    }

    public ContentValues valoresReceta(Receta r){
        ContentValues valores = new ContentValues();
        if(r.getIdReceta()==null) {
            valores.put(MANAGER_RECETA.CN_descripcionreceta, r.getDescripcionReceta());
        }else{
            valores.put(MANAGER_RECETA.CN_idReceta, r.getIdReceta());
            valores.put(MANAGER_RECETA.CN_descripcionreceta, r.getDescripcionReceta());
        }
        return valores;
    }


    public void insertarRecetaHasIngrediente(RecetaIngrediente recetaIngrediente,SQLiteDatabase db){
        db.insert(MANAGER_RECETA_HAS_INGREDIENTE.TABLE_NAME,null,valoresRecetaHasIngrediente(recetaIngrediente));
    }
    public void deleteRecetaHasIngrediente(RecetaIngrediente recetaIngrediente, SQLiteDatabase db){
        db.execSQL("DELETE FROM "+MANAGER_RECETA_HAS_INGREDIENTE.TABLE_NAME+" WHERE "
                +MANAGER_RECETA_HAS_INGREDIENTE.CN_idingrediente+" = "+recetaIngrediente.getIngrediente().getIdIgrediente()+" AND "
                +MANAGER_RECETA_HAS_INGREDIENTE.CN_idReceta+" = "+recetaIngrediente.getReceta().getIdReceta()+";");
    }

    public void updateRecetaHasIngrediente(RecetaIngrediente recetaIngrediente,SQLiteDatabase db){
        String consulta="UPDATE "+MANAGER_RECETA_HAS_INGREDIENTE.TABLE_NAME+" SET "+
                MANAGER_RECETA_HAS_INGREDIENTE.CN_cantidad+" = "+recetaIngrediente.getCantidad()+", "+
                MANAGER_RECETA_HAS_INGREDIENTE.CN_idunidad+" = "+recetaIngrediente.getUnidad().getIdUnidad()+
                " WHERE " +MANAGER_RECETA_HAS_INGREDIENTE.CN_idingrediente+" = "+recetaIngrediente.getIngrediente().getIdIgrediente()+" AND "
                +MANAGER_RECETA_HAS_INGREDIENTE.CN_idReceta+" = "+recetaIngrediente.getReceta().getIdReceta()+";";
        System.out.println(consulta);
        db.execSQL(consulta);
    }



    public ContentValues valoresRecetaHasIngrediente(RecetaIngrediente recetaIngrediente){
        ContentValues valores=new ContentValues();
        valores.put(MANAGER_RECETA_HAS_INGREDIENTE.CN_cantidad,recetaIngrediente.getCantidad());
        valores.put(MANAGER_RECETA_HAS_INGREDIENTE.CN_idingrediente,recetaIngrediente.getIngrediente().getIdIgrediente());
        valores.put(MANAGER_RECETA_HAS_INGREDIENTE.CN_idReceta,recetaIngrediente.getReceta().getIdReceta());
        valores.put(MANAGER_RECETA_HAS_INGREDIENTE.CN_idunidad,recetaIngrediente.getUnidad().getIdUnidad());
        return valores;
    }

    public void insertarTipoComida(TipoComida tc, SQLiteDatabase db){
        db.insert(MANAGER_TIPO_COMIDA.TABLE_NAME,null,valoresTipoComida(tc));
    }

    public void deleteTipoComida(TipoComida tc, SQLiteDatabase db){
        db.delete(MANAGER_TIPO_COMIDA.TABLE_NAME,MANAGER_TIPO_COMIDA.CN_idTipoComida+"=?",new String[]{tc.getIdTipoComida().toString()});
    }

    public void updateTipoComida(TipoComida tc, SQLiteDatabase db){
        db.update(MANAGER_TIPO_COMIDA.TABLE_NAME, valoresTipoComida(tc), MANAGER_TIPO_COMIDA.CN_idTipoComida + "=?", new String[]{tc.getIdTipoComida().toString()});
    }

    public ContentValues valoresTipoComida(TipoComida tc){
        ContentValues valores=new ContentValues();
        if(tc.getIdTipoComida()==null)
            valores.put(MANAGER_TIPO_COMIDA.CN_nombreTipoComida,tc.getNombreTipoComida());
        else {
            valores.put(MANAGER_TIPO_COMIDA.CN_idTipoComida, tc.getIdTipoComida());
            valores.put(MANAGER_TIPO_COMIDA.CN_nombreTipoComida, tc.getNombreTipoComida());
        }
        return valores;
    }

    public void insertarUnidad(Unidad u, SQLiteDatabase db){
        db.insert(MANAGER_UNIDAD.TABLE_NAME,null,valoresUnidad(u));
    }
    public void deleteUnidad(Unidad u, SQLiteDatabase db){
        db.delete(MANAGER_UNIDAD.TABLE_NAME,MANAGER_UNIDAD.CN_idUnidad+"=?",new String[]{u.getIdUnidad().toString()});
    }

    public void updateUnidad(Unidad u, SQLiteDatabase db){
        db.update(MANAGER_UNIDAD.TABLE_NAME, valoresUnidad(u), MANAGER_UNIDAD.CN_idUnidad + "=?", new String[]{u.getIdUnidad().toString()});
    }

    public ContentValues valoresUnidad(Unidad u) {
        ContentValues valores = new ContentValues();
        if(u.getIdUnidad()==null)
            valores.put(MANAGER_UNIDAD.CN_nombreUnidad,u.getNombreunidad());
        else{
            valores.put(MANAGER_UNIDAD.CN_idUnidad,u.getIdUnidad());
            valores.put(MANAGER_UNIDAD.CN_nombreUnidad,u.getNombreunidad());
        }
        return valores;
    }

    //LISTAR DE LA BASE DE DATOS
    public Cursor ListarUnidad(SQLiteDatabase db){
        return  db.query(MANAGER_UNIDAD.TABLE_NAME,MANAGER_UNIDAD.getColumnas(),null,null,null,null,null);
    }

    public Cursor ListarIngredientes(SQLiteDatabase db){
        return  db.query(MANAGER_INGREDIENTE.TABLE_NAME,MANAGER_INGREDIENTE.getColumnas(),null,null,null,null,null);
    }

    public Cursor ListarComida(SQLiteDatabase db){
        return  db.query(MANAGER_COMIDA.TABLE_NAME,MANAGER_COMIDA.getColumnas(),null,null,null,null,null);
    }

    public Cursor ListarReceta(SQLiteDatabase db){
        return  db.query(MANAGER_RECETA.TABLE_NAME,MANAGER_RECETA.getColumnas(),null,null,null,null,null);
    }

    public Cursor ListarRecetaHasIngrediente(SQLiteDatabase db){
        return  db.query(MANAGER_RECETA_HAS_INGREDIENTE.TABLE_NAME,MANAGER_RECETA_HAS_INGREDIENTE.getColumnas(),null,null,null,null,null);
    }

    public Cursor ListarTipoComida(SQLiteDatabase db){
        return  db.query(MANAGER_TIPO_COMIDA.TABLE_NAME,MANAGER_TIPO_COMIDA.getColumnas(),null,null,null,null,null);
    }

    public Cursor ListarIngredientesDeUnaComida(SQLiteDatabase db, String id_receta){
        return  db.query(MANAGER_RECETA_HAS_INGREDIENTE.TABLE_NAME,MANAGER_RECETA_HAS_INGREDIENTE.getColumnas(),MANAGER_RECETA_HAS_INGREDIENTE.CN_idReceta+"=?",new String[]{id_receta},null,null,null);
    }
    //BUSCAR POR LAS CLAVES
    public Cursor findComidaById(String id,SQLiteDatabase db){
        return db.query(MANAGER_COMIDA.TABLE_NAME,MANAGER_COMIDA.getColumnas(),MANAGER_COMIDA.CN_ID+"=?",new String[]{id.toString()},null,null,null);
    }

    public Cursor findIngredienteById(String id,SQLiteDatabase db){
        return db.query(MANAGER_INGREDIENTE.TABLE_NAME,MANAGER_INGREDIENTE.getColumnas(),MANAGER_INGREDIENTE.CN_idIngrediente+"=?",new String[]{id.toString()},null,null,null);
    }

    public Cursor findRecetaById(String id,SQLiteDatabase db){
        return db.query(MANAGER_RECETA.TABLE_NAME,MANAGER_RECETA.getColumnas(),MANAGER_RECETA.CN_idReceta+"=?",new String[]{id.toString()},null,null,null);
    }

    public Cursor findRecetaHasIngredienteById(String id_receta, String id_ingrediente,SQLiteDatabase db){
        return db.query(MANAGER_RECETA_HAS_INGREDIENTE.TABLE_NAME,MANAGER_RECETA_HAS_INGREDIENTE.getColumnas(),MANAGER_RECETA_HAS_INGREDIENTE.CN_idReceta+"=? AND "+MANAGER_RECETA_HAS_INGREDIENTE.CN_idingrediente+"=?",new String[]{id_receta.toString(),id_ingrediente.toString()},null,null,null);
    }

    public Cursor findTipoComidaById(String id,SQLiteDatabase db){
        return db.query(MANAGER_TIPO_COMIDA.TABLE_NAME,MANAGER_TIPO_COMIDA.getColumnas(),MANAGER_TIPO_COMIDA.CN_idTipoComida+"=?",new String[]{id.toString()},null,null,null);
    }

    public Cursor findUnidadById(String id,SQLiteDatabase db){
        return db.query(MANAGER_UNIDAD.TABLE_NAME,MANAGER_UNIDAD.getColumnas(),MANAGER_UNIDAD.CN_idUnidad+"=?",new String[]{id.toString()},null,null,null);
    }









}
