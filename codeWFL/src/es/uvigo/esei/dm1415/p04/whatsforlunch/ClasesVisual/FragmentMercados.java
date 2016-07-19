package es.uvigo.esei.dm1415.p04.whatsforlunch.ClasesVisual;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import es.uvigo.esei.dm1415.p04.whatsforlunch.R;


public class FragmentMercados extends Fragment implements LocationListener {
    private WebView browser;
    LocationManager locationManager;
    MyLocater locater;

    @Override
    public void onPause() {
        super.onPause();
        Bundle b=new Bundle();
        int btnActual=R.id.btn_mercados;
        b.putInt("btnActual",R.id.btn_mercados);
        getActivity().getIntent().putExtras(b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_mercados, container, false);
        locater = new MyLocater();
        browser = (WebView) rootview.findViewById(R.id.web1);
//        inicializarComponenter(rootview);
        getLocation();
        setupBrowser();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        return rootview;
    }

    private void inicializarComponenter(final View rootview) {

    }

    @Override
    public void onDetach() {
        super.onDetach();
        // cut location service requests
        locationManager.removeUpdates(this);
    }

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        // cut location service requests
        locationManager.removeUpdates(this);
    }*/

    private void getLocation() {
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE); // use GPS (you must be outside)
        //criteria.setAccuracy(Criteria.ACCURACY_COARSE); // towers, wifi
        String provider = locationManager.getBestProvider(criteria, true);

        // In order to make sure the device is getting the location, request
        // updates [wakeup after changes of: 5 sec. or 10 meter]
        locationManager.requestLocationUpdates(provider, 5, 10, this);
        locater.setNewLocation(locationManager.getLastKnownLocation(provider));
/*        Location fake = new Location("fake");
        fake.setLatitude(42.344794);
        fake.setLongitude(-7.855467);
        locater.setNewLocation(fake);*/
    }

    private void setupBrowser() {
        final String centerMapURL = "javascript:centerAt("
                + locater.getLatitude() + ","
                + locater.getLongitude() + ")";


        // set up the browser to show location results

        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setDomStorageEnabled(true);
        browser.addJavascriptInterface(locater, "locater");

        browser.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                browser.loadUrl(centerMapURL);
            }
        });

        //browser.loadUrl("http://www.google.es/maps");
        browser.loadUrl("file:///android_asset/xxx.html");
        //browser.loadUrl("file:///android_asset/websearch.html");
        // Wait for the page to load then send the location information
    }

    @Override
    public void onLocationChanged(Location location) {
        String lat = String.valueOf(location.getLatitude());
        String lon = String.valueOf(location.getLongitude());
        Toast.makeText(getActivity().getApplicationContext(), lat + "\n" + lon, Toast.LENGTH_LONG).show();
        locater.setNewLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public class MyLocater {
        private Location mostRecentLocation;

        public void setNewLocation(Location newCoordinates){
            mostRecentLocation = newCoordinates;
        }

        public double getLatitude() {
            if (mostRecentLocation == null)
                return (0);
            else
                return mostRecentLocation.getLatitude();
        }

        public double getLongitude() {
            if (mostRecentLocation == null)
                return (0);
            else
                return mostRecentLocation.getLongitude();
        }
    }// MyLocater
}