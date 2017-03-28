package fr.univ_lille1.iut_info.moreaut.astiko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by moreaut on 27/03/17.
 */

public class CommanderMaintenant extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_commander_maintenant);

        final Spinner choixLavage = (Spinner) findViewById(R.id.spinnerOptionLavage);

        ArrayAdapter<CharSequence> adapterLavage = ArrayAdapter.createFromResource(this,R.array.Formules, android.R.layout.simple_spinner_item);
        adapterLavage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choixLavage.setAdapter(adapterLavage);

        final Spinner choixVoitures = (Spinner) findViewById(R.id.spinnerVoitures);

        ArrayAdapter<CharSequence> adapterVoiture = ArrayAdapter.createFromResource(this,R.array.Voitures, android.R.layout.simple_spinner_item);
        adapterVoiture.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choixVoitures.setAdapter(adapterVoiture);

        final Spinner choixLieu = (Spinner) findViewById(R.id.spinnerLieuNow);

        ArrayAdapter<CharSequence> adapterLieu = ArrayAdapter.createFromResource(this,R.array.Lieu, android.R.layout.simple_spinner_item);
        adapterLieu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choixLieu.setAdapter(adapterLieu);

    }

    public void doRetour(View view){
        Intent intent = new Intent(CommanderMaintenant.this, Accueil.class);
        intent.putExtra("login",(String) getIntent().getSerializableExtra("login") );
        startActivity(intent);
    }

    public void doValider(View view){
        Intent intent = new Intent(CommanderMaintenant.this, Accueil.class);
        intent.putExtra("login",(String) getIntent().getSerializableExtra("login") );
        Toast.makeText(CommanderMaintenant.this, "Le paiement a bien été effectué" , Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }


}
