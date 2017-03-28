package fr.univ_lille1.iut_info.moreaut.astiko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by moreaut on 23/03/17.
 */
import android.widget.*;

import com.google.android.gms.maps.MapFragment;

public class Accueil extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Button compte = (Button) findViewById(R.id.compte);
        final Spinner commander = (Spinner) findViewById(R.id.commander);
        TextView bienvenue = (TextView) findViewById(R.id.Bienvenue);
        bienvenue.setText("Bienvenue "+(String) getIntent().getSerializableExtra("login"));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Commander, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        commander.setAdapter(adapter);

        commander.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String choix = String.valueOf(commander.getSelectedItem());
                if(!choix.equals("Choix de la formule de lavage")) {
                    Toast.makeText(Accueil.this, "Vous avez choisi l'option : " + choix, Toast.LENGTH_SHORT).show();
                    if(choix.equals("Commander maintenant")){
                        Intent intent = new Intent(Accueil.this, CommanderMaintenant.class);
                        intent.putExtra("login",(String) getIntent().getSerializableExtra("login") );
                        startActivity(intent);
                     }
                    if(choix.equals("Planifier commande")){
                        Intent intent = new Intent(Accueil.this, PlanifierCommande.class);
                        intent.putExtra("login",(String) getIntent().getSerializableExtra("login") );
                        startActivity(intent);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Accueil.this, "Bienvenue dans l'accueil "+ (String) getIntent().getSerializableExtra("login")
                        , Toast.LENGTH_SHORT).show();
            }

        });



    }

    public void doDeconnecte(View view){
        Intent intent = new Intent(Accueil.this, LoginActivityAstiko.class);
        intent.putExtra("login",(String) getIntent().getSerializableExtra("login"));
        startActivity(intent);
    }

    public void goMonCompte(View view){
        Intent intent = new Intent(Accueil.this, MonCompte.class);
        intent.putExtra("login",(String) getIntent().getSerializableExtra("login") );
        startActivity(intent);
    }

    public void onMap(View view){
        Intent intent = new Intent(Accueil.this, MapsActivity.class);
        startActivity(intent);
    }

}
