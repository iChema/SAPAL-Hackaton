package com.example.ichema.sapal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap Map) {
        mMap = Map;
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MapsActivity.this);
                builder.setTitle(marker.getTitle());
                final Item[] items = {
                        new Item("Temperatura", R.mipmap.ic_temp),
                        new Item("Humedad Relativa", R.mipmap.ic_hume),
                        new Item("Presión Barométrica", R.mipmap.ic_pres),
                        new Item("Probabilidad de Precipitación", R.mipmap.ic_lluv)
                };
                ListAdapter adapter = new ArrayAdapter<Item>(getApplicationContext(),android.R.layout.select_dialog_item,android.R.id.text1,items){
                    public View getView(int position, View convertView, ViewGroup parent) {
                        //Use super class to create the View
                        View v = super.getView(position, convertView, parent);
                        TextView tv = (TextView)v.findViewById(android.R.id.text1);

                        //Put the image on the TextView
                        tv.setCompoundDrawablesWithIntrinsicBounds(items[position].icon, 0, 0, 0);

                        //Add margin between image and text (support various screen densities)
                        int dp5 = (int) (5 * getResources().getDisplayMetrics().density + 0.5f);
                        tv.setCompoundDrawablePadding(dp5);

                        return v;
                    }
                };
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {}
                });

                String positiveText = getString(android.R.string.ok);
                builder.setPositiveButton(positiveText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // positive button logic
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        LatLng presa = new LatLng(21.1713888889, -101.688055556);
        Marker markerPresa = mMap.addMarker(new MarkerOptions().position(presa).title("Presa el Palote"));

        LatLng blvd = new LatLng(21.1641666667, -101.648333333);
        Marker markerBlvd = mMap.addMarker(new MarkerOptions().position(blvd).title("Blvd Morelos-Madrazo"));

        LatLng faro = new LatLng(21.125, -101.725);
        Marker markerFaro = mMap.addMarker(new MarkerOptions().position(faro).title("El Faro"));

        LatLng centro = new LatLng(21.1266666667, -101.690277778);
        Marker markerCentro = mMap.addMarker(new MarkerOptions().position(centro).title("Centro"));

        LatLng explora = new LatLng(21.1094444444, -101.658611111);
        Marker markerExplora = mMap.addMarker(new MarkerOptions().position(explora).title("Explora"));

        LatLng amalia = new LatLng(21.0988888889, -101.73);
        Marker markerAmalia = mMap.addMarker(new MarkerOptions().position(amalia).title("Amalias"));

        LatLng sapal = new LatLng(21.0975, -101.666783333);
        Marker markerSapal = mMap.addMarker(new MarkerOptions().position(sapal).title("Sapal Torres Landa"));

        LatLng ibero = new LatLng(21.1288888889, -101.626111111);
        Marker markerIbero = mMap.addMarker(new MarkerOptions().position(ibero).title("Ibero"));


        LatLng cerrito = new LatLng(21.086854, -101.632367);
        Marker markerCerrito = mMap.addMarker(new MarkerOptions().position(cerrito).title("Cerrito de Jerez"));


        LatLng villas = new LatLng(21.0877777778, -101.595277778);
        Marker markerVillas = mMap.addMarker(new MarkerOptions().position(villas).title("Villas de San Juan"));


        LatLng rosa = new LatLng(21.0689166667, -101.725);
        Marker markerRosa = mMap.addMarker(new MarkerOptions().position(rosa).title("Santa Rosa Plan de Ayala"));


        LatLng ciudad = new LatLng(21.0627777778, -101.686111111);
        Marker markerCiudad = mMap.addMarker(new MarkerOptions().position(ciudad).title("Ciudad Industrial"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(centro));
        mMap.setMinZoomPreference(12);
        mMap.setMaxZoomPreference(12);
    }
}
