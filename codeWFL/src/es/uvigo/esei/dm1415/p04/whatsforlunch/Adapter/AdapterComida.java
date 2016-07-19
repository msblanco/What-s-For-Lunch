package es.uvigo.esei.dm1415.p04.whatsforlunch.Adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import es.uvigo.esei.dm1415.p04.whatsforlunch.ClasesVisual.FragmentVerComida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Comida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.R;

/**
 * Created by AliothAntonio on 31/12/2014.
 */
public class AdapterComida extends BaseAdapter{
    protected Activity activity;
    protected ArrayList<Comida> items;

    public AdapterComida(Activity activity, ArrayList<Comida> items) {
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
        return items.get(position).getIdComida();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Generamos una convertView por motivos de eficiencia
        View v = convertView;

        //Asociamos el layout de la lista que hemos creado
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.itemlistacomidas, null);
        }

        // Creamos un objeto directivo
        final Comida c = items.get(position);
        //Rellenamos la fotografía
        ImageView foto = (ImageView) v.findViewById(R.id.imageView3);
        foto.setImageDrawable(activity.getResources().getDrawable(c.getFoto()));
        //Rellenamos el nombre
        TextView nombre = (TextView) v.findViewById(R.id.textView2);
        nombre.setText(c.getNombre());
        //Rellenamos el cargo
        TextView cargo = (TextView) v.findViewById(R.id.textView3);
        cargo.setText(c.getTipoComida().getNombreTipoComida());
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager=activity.getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.contenedor,FragmentVerComida.newInstance(c)/*new FragmentVerComida()*/);
                transaction.commit();
            }
        });
        // Retornamos la vista
        return v;
    }


}
