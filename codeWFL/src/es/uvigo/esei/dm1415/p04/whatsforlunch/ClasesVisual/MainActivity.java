package es.uvigo.esei.dm1415.p04.whatsforlunch.ClasesVisual;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.DataBaseHelper;
import es.uvigo.esei.dm1415.p04.whatsforlunch.R;

public class MainActivity extends Activity {
    SQLiteOpenHelper helper;
    SQLiteDatabase db;
    private long splashDelay = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new DataBaseHelper(this);
        db=helper.getWritableDatabase();
        new CrearBaseBatos(this).execute();
        /*TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent().setClass(MainActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();//Destruimos esta activity para prevenir que el usuario retorne aqui presionando el boton Atras.
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);//Pasado los 6 segundos dispara la tarea*/
    }



    private class CrearBaseBatos extends AsyncTask<Void,Void,Void> {

        Context context;

        private CrearBaseBatos(Context context) {
            this.context = context;
        }


        @Override
        protected Void doInBackground(Void... params) {
            helper=new DataBaseHelper(context);
            db=helper.getWritableDatabase();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent intent=new Intent(MainActivity.this, MenuPricipal.class);
            Bundle b=new Bundle();
            b.putInt("btnActual",0);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
