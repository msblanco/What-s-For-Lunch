package es.uvigo.esei.dm1415.p04.whatsforlunch.ClasesVisual;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import es.uvigo.esei.dm1415.p04.whatsforlunch.Adapter.ImageAdapter;
import es.uvigo.esei.dm1415.p04.whatsforlunch.R;

public class Acercade extends Activity {

    //TODO:Revisar Este Codigo

        Integer[] thumbNail = { R.drawable.melania, R.drawable.alioth};
        Integer[] largeImages = {R.drawable.melania, R.drawable.alioth};

        ImageView selectedImage;
        TextView txtMsg;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_acercade);

            selectedImage = (ImageView) findViewById(R.id.selected_image);
            txtMsg = (TextView) findViewById(R.id.txtMsg);
            Gallery g = (Gallery) findViewById(R.id.gallery);

            // Set the adapter to our custom adapter
            g.setAdapter(new ImageAdapter(this, thumbNail));

            // Set an item click-listener and wait for user to make selection
            g.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                    // draw selected image (if possible use better resolution);
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(largeImages[position]);

                    Bitmap b = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(),
                            (int) (bitmapDrawable.getIntrinsicHeight() * 1.0),
                            (int) (bitmapDrawable.getIntrinsicWidth() * 1.0), false);

                    selectedImage.setImageBitmap(b);
                    selectedImage.setScaleType(ImageView.ScaleType.FIT_XY);

                    //SIMILAR TO ==> selectedImage.setImageResource(largeImages[position]);
                }
            });

            //
            g.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            // finger touches the screen => event.getAction() = 0
                            break;

                        case MotionEvent.ACTION_MOVE:
                            // finger moves on the screen => event.getAction() = 2
                            break;

                        case MotionEvent.ACTION_UP:
                            // finger leaves the screen => event.getAction() = 1
                            break;
                    }

                    return false;
                }
            });

        }// onCreate
    }//class
