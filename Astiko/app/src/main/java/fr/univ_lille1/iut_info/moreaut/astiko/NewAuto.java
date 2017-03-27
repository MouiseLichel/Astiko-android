package fr.univ_lille1.iut_info.moreaut.astiko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by moreaut on 23/03/17.
 */

public class NewAuto extends Activity {

    EditText marque, immat, couleur;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car);
        Button newCar = (Button) findViewById(R.id.plusieursVoitures);
        newCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifAuto(true);
            }
        });

        Button next = (Button) findViewById(R.id.validerVoiture);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifAuto(false);
            }
        });


    }
    private void verifAuto(boolean newCar) {

        marque = (EditText)findViewById(R.id.Marque);
        immat = (EditText)findViewById(R.id.Immat);
        couleur = (EditText)findViewById(R.id.Couleur);

        // Reset errors.
        marque.setError(null);
        immat.setError(null);
        couleur.setError(null);

        // Store values at the time of the login attempt.
        String marques = marque.getText().toString();
        String immats = immat.getText().toString();
        String couleurs = couleur.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(marques)) {
            marque.setError("Veuillez entrer la marque");
            focusView = marque;
            cancel = true;
        }
        if ( !verifString(marques)) {
            marque.setError("La marque est invalide");
            focusView = marque;
            cancel = true;
        }

        if(TextUtils.isEmpty(immats) || !verif_immat(immats)){
            immat.setError("Plaque d'immatriculation invalide");
            focusView = immat;
            cancel = true;
        }


        if (TextUtils.isEmpty(couleurs) ){
            couleur.setError("Veuillez entrer la couleur");
            focusView = couleur;
            cancel = true;
        }

        if (!verifString(couleurs)){
            couleur.setError("Couleur invalide");
            focusView = couleur;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            if(newCar) {
                Intent intent = new Intent(NewAuto.this, NewAuto.class);
                //On envoi la voiture a la base de données
                startActivity(intent);
            }else {
                Intent intent = new Intent(NewAuto.this, LoginActivityAstiko.class);
                //On envoi la voiture a la base de données
                startActivity(intent);
            }
        }
    }

    public boolean verif_immat(String chaine){
        int nbcar = 0, nbInt = 0;
        for(int i=0; i<chaine.length(); i++){
            if ( !(chaine.charAt(i)>='a' && chaine.charAt(i)<='z') && !(chaine.charAt(i)>='A' && chaine.charAt(i)<='Z') && !(chaine.charAt(i)>='0' && chaine.charAt(i)<='9'))
                return false;
            else{
                if(chaine.charAt(i)>='0' && chaine.charAt(i)<='9') nbInt++;
                else nbcar++;
            }
        }
        return (nbcar>0 && nbInt>0);
    }

    public boolean verifString(String chaine){
        for(int i=0; i<chaine.length(); i++){
            if ( !(chaine.charAt(i)>='a' && chaine.charAt(i)<='z') && !(chaine.charAt(i)>='A' && chaine.charAt(i)<='Z'))
                return false;
        }
        return true;
    }
}
