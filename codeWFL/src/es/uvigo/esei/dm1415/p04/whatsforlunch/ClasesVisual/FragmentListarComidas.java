package es.uvigo.esei.dm1415.p04.whatsforlunch.ClasesVisual;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import es.uvigo.esei.dm1415.p04.whatsforlunch.Adapter.AdapterComida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.DataBaseHelper;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Comida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.R;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Utils.Utils;


public class FragmentListarComidas extends Fragment {
    SQLiteDatabase db;
    DataBaseHelper helper;
    Activity activity;
    ListView lista;
       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootview=inflater.inflate(R.layout.fragment_listar_comidas,container,false);
       helper=new DataBaseHelper(rootview.getContext());
       db=helper.getWritableDatabase();
       inicializarComponentes(rootview);
       return rootview;
    }

    @Override
    public void onPause() {
        super.onPause();
        Bundle b=new Bundle();
        int btnActual=R.id.btn_comidas;
        b.putInt("btnActual",R.id.btn_comidas);
        getActivity().getIntent().putExtras(b);
    }

    private void inicializarComponentes(View rootview) {
        lista = (ListView) rootview.findViewById(R.id.listView);
        Cursor c= helper.ListarComida(db);
        ArrayList<Comida> arraydir =Utils.convertirCursor2ArrayComida(c,helper,db);
        AdapterComida adapter = new AdapterComida(getActivity(), arraydir);
        lista.setAdapter(adapter);
    }



}
