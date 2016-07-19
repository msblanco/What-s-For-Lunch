package es.uvigo.esei.dm1415.p04.whatsforlunch.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Comida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Ingrediente;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.RecetaIngrediente;
import es.uvigo.esei.dm1415.p04.whatsforlunch.R;

/**
 * Created by AliothAntonio on 01/01/2015.
 */
public class AdapterIngrediente extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<RecetaIngrediente> items;

    public AdapterIngrediente(Activity activity, ArrayList<RecetaIngrediente> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getIngrediente().getIdIgrediente();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Generamos una convertView por motivos de eficiencia
        View v = convertView;
        //Asociamos el layout de la lista que hemos creado
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.itemlistaingrediente, null);
        }

        // Creamos un objeto directivo
        RecetaIngrediente i = items.get(position);
        //Rellenamos la fotografía
        //System.out.println(i);
        ImageView foto = (ImageView) v.findViewById(R.id.imageViewIngrediente);
        foto.setImageDrawable(activity.getResources().getDrawable(i.getIngrediente().getFotoIngrediente()));
        //Rellenamos el nombre
        TextView nombre = (TextView) v.findViewById(R.id.textViewNombreIngrediente);
        nombre.setText(i.getIngrediente().getNombreIngrediente());

        TextView cantidad=(TextView) v.findViewById(R.id.textviewcantingrediente);
        cantidad.setText(""+i.getCantidad());
        TextView unidad=(TextView) v.findViewById(R.id.textViewunudadingrediente);
        unidad.setText(i.getUnidad().getNombreunidad());
        // Retornamos la vista*/
        return v;
    }
}
