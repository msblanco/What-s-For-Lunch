package es.uvigo.esei.dm1415.p04.whatsforlunch.ClasesVisual;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.DataBaseHelper;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Comida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.R;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Utils.Utils;


public class FragmentComidaAleatoria extends Fragment implements View.OnClickListener {
    private Button btnGenerar;
    DataBaseHelper helper;
    SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_comida_aleatoria,container,false);
        inicializarComponenter(rootview);
        helper=new DataBaseHelper(getActivity());
        db=helper.getWritableDatabase();
        return rootview;
    }

    @Override
    public void onPause() {
        super.onPause();
        Bundle b=new Bundle();
        int btnActual=R.id.btn_comidaaleatoria;
        b.putInt("btnActual",R.id.btn_comidaaleatoria);
        getActivity().getIntent().putExtras(b);
    }

    private void inicializarComponenter(final View rootview) {
        btnGenerar=(Button)rootview.findViewById(R.id.btnGenerar);
        btnGenerar.setOnClickListener(this);
     }


    @Override
    public void onClick(View v) {
        int i=helper.ListarComida(db).getCount();
        int aleatorio=((int)(Math.random()*i+1));
        Comida c= Utils.convertirCursor2Comida(helper.findComidaById(""+aleatorio,db),helper,db);
        System.out.println(c);
        FragmentManager manager=getActivity().getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.contenedor,FragmentVerComida.newInstance(c));
        transaction.commit();
        //Toast.makeText(getActivity(),""+aleatorio, Toast.LENGTH_SHORT).show();
    }
}
