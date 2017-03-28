package fr.univ_lille1.iut_info.moreaut.astiko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by moreaut on 27/03/17.
 */

public class ModifCompte extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_compte);

        EditText monCompteEditNom = (EditText) findViewById(R.id.MonCompteEditNom);
        EditText monCompteEditPrenom = (EditText) findViewById(R.id.MonCompteEditPrenom);
        EditText monCompteEditNaissance = (EditText) findViewById(R.id.MonCompteEditBirth);
        EditText monCompteEditAdresse = (EditText) findViewById(R.id.MonCompteEditAdresse);
        EditText monCompteEditVille = (EditText) findViewById(R.id.MonCompteEditVille);
        EditText monCompteEditMail = (EditText) findViewById(R.id.MonCompteEditMail);
        EditText monCompteEditTel = (EditText) findViewById(R.id.MonCompteEditTel);

        /*monCompteEditNom.setText((String) getIntent().getSerializableExtra("nom"));
        monCompteEditPrenom.setText((String) getIntent().getSerializableExtra("prenom"));
        monCompteEditNaissance.setText((String) getIntent().getSerializableExtra("naissance"));
        monCompteEditAdresse.setText((String) getIntent().getSerializableExtra("adresse"));
        monCompteEditVille.setText((String) getIntent().getSerializableExtra("ville"));
        monCompteEditMail.setText((String) getIntent().getSerializableExtra("mail"));
        monCompteEditTel.setText((String) getIntent().getSerializableExtra("tel")); */
    }

    public void doValider(View view){
        // on change les infos dans la base de données
        Intent intent = new Intent(ModifCompte.this, MonCompte.class);
        intent.putExtra("login",(String) getIntent().getSerializableExtra("login") );
        startActivity(intent);
    }

    public void doRetour(View view){
        Intent intent = new Intent(ModifCompte.this, MonCompte.class);
        intent.putExtra("login",(String) getIntent().getSerializableExtra("login") );
        startActivity(intent);
    }
}