package fr.univ_lille1.iut_info.moreaut.astiko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;


/**
 * Created by moreaut on 23/03/17.
 */

public class NewAccount extends Activity {

    EditText login, mdp, mdp2, prenom, nom, birthday, adresse, ville, mail, tel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        Button next = (Button) findViewById(R.id.Subscribe);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifAuto();
            }
        });


    }
    private void verifAuto() {

        login = (EditText) findViewById(R.id.Login);
        mdp = (EditText) findViewById(R.id.mdp);
        mdp2 = (EditText) findViewById(R.id.mdp2);
        prenom = (EditText) findViewById(R.id.prenom);
        nom = (EditText) findViewById(R.id.nom);
        birthday = (EditText) findViewById(R.id.birthday);
        adresse = (EditText) findViewById(R.id.adresse);
        ville = (EditText) findViewById(R.id.Ville);
        mail = (EditText) findViewById(R.id.mail);
        tel = (EditText) findViewById(R.id.tel);



        // Reset errors.
        login.setError(null);
        mdp.setError(null);
        mdp2.setError(null);
        prenom.setError(null);
        nom.setError(null);
        birthday.setError(null);
        adresse.setError(null);
        ville.setError(null);
        mail.setError(null);
        tel.setError(null);


        // Store values at the time of the login attempt.
        String logins = login.getText().toString();
        String mdps = mdp.getText().toString();
        String mdp2s = mdp2.getText().toString();
        String prenoms = prenom.getText().toString();
        String noms = nom.getText().toString();
        String birthdays = birthday.getText().toString();
        String adresses = adresse.getText().toString();
        String villes = ville.getText().toString();
        String mails = mail.getText().toString();
        String tels = tel.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(logins) || (logins.length()<4 || logins.contains(" ")))  {
            login.setError("Login incorrect");
            focusView = login;
            cancel = true;
        }

        if (TextUtils.isEmpty(mdps) || mdps.length()<5 || mdps.contains(" "))  {
            mdp.setError("Le mot de passe doit contenir au moins 5 caractères ");
            focusView = mdp;
            cancel = true;
        }
        if(!mdp2s.equals(mdps)){
            mdp2.setError("Le mot de passe n'est pas identique au premier");
            focusView = mdp2;
            cancel = true;
        }

        if (TextUtils.isEmpty(prenoms) || !verifString(prenoms))  {
            prenom.setError("Le prénom est incorrect ");
            focusView = prenom;
            cancel = true;
        }

        if (TextUtils.isEmpty(noms) || !verifString(noms))  {
            nom.setError("Le nom est incorrect ");
            focusView = nom;
            cancel = true;
        }

        //date de naissance

        if (TextUtils.isEmpty(adresses) || !verif_adresse(adresses))  {
            adresse.setError("L'adresse est incorrecte ");
            focusView = adresse;
            cancel = true;
        }

        if (TextUtils.isEmpty(villes) || !verifString(villes))  {
            ville.setError("La ville est incorrecte ");
            focusView = ville;
            cancel = true;
        }

        if(TextUtils.isEmpty(mails) || !mails.contains("@") || !mails.contains(".")){
            mail.setError("Adresse mail non valide : example@test.ex");
            focusView = mail;
            cancel = true;
        }

        if(TextUtils.isEmpty(tels)){
            tel.setError("Telephone invalide");
            focusView = tel;
            cancel = true;
        }

        if(TextUtils.isEmpty(birthdays) || !birthdays.matches("\\d{1,2}\\/\\d{1,2}\\/\\d{4}")){
            birthday.setError("Année de naissance invalide : 01/02/1987");
            focusView = birthday;
            cancel = true;
        }

/*
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
*/
        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.

            Intent intent = new Intent(NewAccount.this, NewAuto.class);
            //On envoi la voiture a la base de données
            startActivity(intent);
        }
    }

    public boolean verif_adresse(String chaine){
        int nbcar = 0, nbInt = 0;
        for(int i=0; i<chaine.length(); i++){
            if ( !(chaine.charAt(i)>='a' && chaine.charAt(i)<='z') && !(chaine.charAt(i)>='A' && chaine.charAt(i)<='Z') && !(chaine.charAt(i)>='0' && chaine.charAt(i)<='9') && !(chaine.charAt(i) == ' '))
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
            if ( !(chaine.charAt(i)>='a' && chaine.charAt(i)<='z') && !(chaine.charAt(i)>='A' && chaine.charAt(i)<='Z') && !((int)chaine.charAt(i)>=128 && (int)chaine.charAt(i)<=165) && !(chaine.charAt(i)=='-') && !(chaine.charAt(i)==' '))
                return false;
        }
        return true;
    }
}
