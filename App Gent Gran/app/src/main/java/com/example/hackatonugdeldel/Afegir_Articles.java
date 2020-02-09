package com.example.hackatonugdeldel;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;


public class Afegir_Articles extends AppCompatActivity {

    EditText edt_nom;
    EditText edt_descripcio;
    EditText edt_ubicacio;
    EditText edt_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir__articles);

         edt_nom = findViewById(R.id.edtNom);
         edt_descripcio = findViewById(R.id.edtDescripcion);
         edt_ubicacio = findViewById(R.id.edtUbicacio);
         edt_data = findViewById(R.id.edtData);



        Button btnAceptar = (Button) findViewById(R.id.btnOk);
        btnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    aceptarCambios();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void aceptarCambios() throws JSONException {


        String nom = edt_data.getText().toString();
        String descripcio = edt_descripcio.getText().toString();
        String ubicacio = edt_ubicacio.getText().toString();
        String data = edt_data.getText().toString();

        JSONObject obj = new JSONObject();
        obj.put("Name", nom );
        obj.put("Description", descripcio );
        obj.put("NumberOfParticipants", 0 );
        obj.put("Address", ubicacio );
        obj.put("Data", data );



        // Instantiate the RequestQueue.
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());

        //RequestQueue queue = Volley.newRequestQueue(this);
        RequestQueue queue = new RequestQueue(cache, network);
        queue.start();
      //  String url ="https://www.google.com";

        //La id ha de ser la del ordinador en la que s'executi la api
        String url ="192.168.16.15:44350/api/events";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(), "La conexio ha estat correcta", Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR: La conexion con el servidor ha fallado!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
