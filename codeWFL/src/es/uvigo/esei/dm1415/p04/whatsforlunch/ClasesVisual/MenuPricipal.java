package es.uvigo.esei.dm1415.p04.whatsforlunch.ClasesVisual;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Comida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.R;

public class MenuPricipal extends Activity implements View.OnTouchListener{
    private ImageButton btnComidaAletoria, btnMercado, btnComidas;
    private FragmentComidaAleatoria comidaAleatoria;
    private FragmentListarComidas comida;
    private FragmentMercados mercados;
    private int btnActual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pricipal);
        inicializarComponente();
        this.btnActual=getIntent().getExtras().getInt("btnActual");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.btnActual=getIntent().getExtras().getInt("btnActual");
        cambiarFragmento(btnActual);
    }

    private void inicializarComponente() {
        btnComidaAletoria=(ImageButton)findViewById(R.id.btn_comidaaleatoria);
        btnComidaAletoria.setOnTouchListener(this);
        btnMercado=(ImageButton)findViewById(R.id.btn_mercados);
        btnMercado.setOnTouchListener(this);
        btnComidas=(ImageButton)findViewById(R.id.btn_comidas);
        btnComidas.setOnTouchListener(this);
        if(btnActual==-1){
            Comida c=(Comida)getIntent().getExtras().getSerializable("comida");
            Fragment fragment=FragmentVerComida.newInstance(c);
            cargarFragmento(fragment);
        }else{
            if (btnActual == 0)
                cargarFragmento(getFragmentComidaAleatoria());
            else
                cambiarFragmento(btnActual);
        }
    }

    private void cargarFragmento(Fragment fragmento) {
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.contenedor,fragmento);
        transaction.commit();
    }


    public FragmentComidaAleatoria getFragmentComidaAleatoria() {
        if(comidaAleatoria==null){
            comidaAleatoria=new FragmentComidaAleatoria();
        }
        return comidaAleatoria;
    }

    public FragmentListarComidas getFragmentComida() {
        if (comida==null){
            comida=new FragmentListarComidas();
        }
        return comida;
    }

    public FragmentMercados getFragmentMercados() {
        if(mercados==null){
            mercados=new FragmentMercados();
        }
        return mercados;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_pricipal, menu);
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageButton btn=(ImageButton) v;
        int actionMasked =event.getActionMasked();
        switch (actionMasked){
            case MotionEvent.ACTION_DOWN:
                btn.setColorFilter(R.color.entintado_oscuro);
                btn.invalidate();
                cambiarFragmento(btn.getId());
                break;
            case MotionEvent.ACTION_UP:
                btn.clearColorFilter();
                btn.invalidate();
                break;
        }
        return true;
     }

    private void cambiarFragmento(int btn) {
        switch (btn){
            case -1:
                Comida c=(Comida)getIntent().getExtras().getSerializable("comida");
                Fragment fragment=FragmentVerComida.newInstance(c);
                cargarFragmento(fragment);
                break;
            case R.id.btn_comidaaleatoria: cargarFragmento(getFragmentComidaAleatoria());break;
            case R.id.btn_comidas: cargarFragmento(getFragmentComida()); break;
            case R.id.btn_mercados: cargarFragmento(getFragmentMercados());break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.acercade:
                Intent intent=new Intent(MenuPricipal.this, Acercade.class);
                startActivity(intent);
                break;
        }
        return true;
    }


}
