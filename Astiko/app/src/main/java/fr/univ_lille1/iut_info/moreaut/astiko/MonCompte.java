package fr.univ_lille1.iut_info.moreaut.astiko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by moreaut on 27/03/17.
 */
public class MonCompte extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_compte);

        TextView compteNom, comptePrenom, compteBirth, compteAdresse, compteVille, compteMail, compteTel;

        compteNom = (TextView) findViewById(R.id.MonCompteNom);
        comptePrenom = (TextView) findViewById(R.id.MonComptePrenom);
        compteBirth = (TextView) findViewById(R.id.MonCompteNaissance);
        compteAdresse = (TextView) findViewById(R.id.MonCompteAdresse);
        compteVille = (TextView) findViewById(R.id.MonCompteVille);
        compteMail = (TextView) findViewById(R.id.MonCompteMail);
        compteTel = (TextView) findViewById(R.id.MonCompteTel);


    }

    public void GoModifier(View view){
        Intent intent = new Intent(MonCompte.this, ModifCompte.class);
        startActivity(intent);
    }

    public void GoRetour(View view){
        Intent intent = new Intent(MonCompte.this, Accueil.class);
        intent.putExtra("login",(String) getIntent().getSerializableExtra("login") );
        startActivity(intent);
    }

}