package es.uvigo.esei.dm1415.p04.whatsforlunch.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Gallery;

/**
 * Created by AliothAntonio on 02/01/2015.
 */
public class ImageAdapter extends BaseAdapter {
    //TODO: REVISAR ESTE CODIGO
    private Context mContext;
    private Integer[] thumbNail;

    public ImageAdapter(Context c, Integer[] thumbNail) {
        mContext = c;
        this.thumbNail = thumbNail;
    }

    public int getCount() {
        return thumbNail.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get a View to display image data
        ImageView iv = new ImageView(mContext);

        iv.setImageResource(thumbNail[position]);
        // try other params (width, height) such as 200, 150
        // see the effect of those settings on a real device
        iv.setLayoutParams(new Gallery.LayoutParams(100, 90));
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        // Image should be scaled somehow (options are...) try...
        // iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return iv;
    }



}//class
