package fr.univ_lille1.iut_info.moreaut.astiko;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;
import static fr.univ_lille1.iut_info.moreaut.astiko.R.id.login;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivityAstiko extends Activity {



    // UI references.
    private EditText loginText;
    private EditText passWordText;
    String log;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_astiko);
        System.setProperty("http.proxyHost","cache.univ-lille1.fr");
        System.setProperty("http.proxyPort","3128");
        // Set up the login form.
        loginText = (EditText) findViewById(login);
        passWordText = (EditText) findViewById(R.id.password);
        queue = Volley.newRequestQueue(this);

        Button authentButton = (Button) findViewById(R.id.authent_button);
        authentButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });



        Button newAccountButton = (Button) findViewById(R.id.INscription);
        newAccountButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivityAstiko.this, NewAccount.class);
                startActivity(intent);
            }
        });
    }


    /**
     * Verifie si on a implemente les champs
     */
    private void attemptLogin() {

        // Reset errors.
        loginText.setError(null);
        passWordText.setError(null);


        // Store values at the time of the login attempt.
        log = loginText.getText().toString();
        String password = passWordText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!isPasswordValid(password)) {
            passWordText.setError(getString(R.string.error_invalid_password));
            focusView = passWordText;
            cancel = true;
        }

        if(TextUtils.isEmpty(password)){
            passWordText.setError(getString(R.string.error_field_required));
            focusView = passWordText;
            cancel = true;
        }
        // Check for a valid email address.
        else if (TextUtils.isEmpty(log)) {
            loginText.setError("Veuillez remplir le champ login");
            focusView = loginText;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.

            StringRequest stringRequest = new StringRequest(Request.Method.GET, getString(R.string.urlUser),
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Gson gson = new GsonBuilder().create();
                            List<User> list = gson.fromJson(response, new TypeToken<List<User>>(){}.getType());
                            for (User u : list)
                                if (u.getLogin().equals(log)) {
                                    Intent intent = new Intent(LoginActivityAstiko.this, Accueil.class);
                                    intent.putExtra("login", log);
                                    startActivity(intent);
                                    break;
                                }else {
                                    Toast.makeText(LoginActivityAstiko.this, "Login ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                                }
                            loginText.setText("");
                            passWordText.setText("");
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            queue.add(stringRequest);
        }
    }

    private boolean isEmailValid(String email) {
        return (email.contains("@") && (email.contains(".")));
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }


}

