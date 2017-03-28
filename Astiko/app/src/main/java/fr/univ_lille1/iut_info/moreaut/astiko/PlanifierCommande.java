package fr.univ_lille1.iut_info.moreaut.astiko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import static fr.univ_lille1.iut_info.moreaut.astiko.R.styleable.View;

/**
 * Created by moreaut on 27/03/17.
 */

public class PlanifierCommande extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planifier_commande);

       //getVoitures();

        /*for(Car c : cars)
            System.out.println(c.toString());
*/
        final Spinner choixLavage = (Spinner) findViewById(R.id.spinnerOptionLavage);

        ArrayAdapter<CharSequence> adapterLavage = ArrayAdapter.createFromResource(this, R.array.Formules, android.R.layout.simple_spinner_item);
        adapterLavage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choixLavage.setAdapter(adapterLavage);

        Spinner voitures = (Spinner) findViewById(R.id.spinnerVoitures);

        ArrayAdapter<CharSequence> adapterVoiture = ArrayAdapter.createFromResource(this, R.array.Voitures, android.R.layout.simple_spinner_item);
        adapterVoiture.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        voitures.setAdapter(adapterVoiture);

        final Spinner choixLieu = (Spinner) findViewById(R.id.spinnerLieuNow);

        ArrayAdapter<CharSequence> adapterLieu = ArrayAdapter.createFromResource(this, R.array.Lieu, android.R.layout.simple_spinner_item);
        adapterLieu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choixLieu.setAdapter(adapterLieu);
    }



    public void doRetour(View view){
        Intent intent = new Intent(PlanifierCommande.this, Accueil.class);
        intent.putExtra("login",(String) getIntent().getSerializableExtra("login") );
        startActivity(intent);
    }

    public void doPaiement(View view){
        Intent intent = new Intent(PlanifierCommande.this, Accueil.class);
        intent.putExtra("login",(String) getIntent().getSerializableExtra("login") );
        Toast.makeText(PlanifierCommande.this, "Le paiement a bien été effectué" , Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    /*public void getVoitures(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, getString(R.string.urlCar) + (String) getIntent().getSerializableExtra("login"),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new GsonBuilder().create();
                        cars = gson.fromJson(response, new TypeToken<List<String>>(){}.getType());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);
    }*/

}
