package fr.univ_lille1.iut_info.moreaut.astiko;

import android.app.Activity;
import android.util.Log;

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

public class CommServer extends Activity{

    public void sendServer(RequestQueue queue, HashMap<String,String> map, String url) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                new JSONObject(map),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("abd", "Error: " + error
                                + ">>" + error.getMessage());
                    }
                });
        queue.add(request);
    }
}
