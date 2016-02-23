package com.example.shardultripathi.moodleplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Vector;

public class Notifications extends AppCompatActivity {
    private JSONNotifications getN = new JSONNotifications();
    Vector<JSONSingleNotification> notL = new Vector<>();
    //SingleNotification: int userId,is_seen,id;
    //                    String description,createdAt;
    // pass the threadId as string into intent to move a specific thread => "threadId"
    //the id is in the description.'/threads/thread/1or2' Jost pass it as the id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        String URL = "http://10.192.58.152:8000/default/notifications.json";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        getN.call(response);
                        notL = getN.notList;
                        Toast.makeText(Notifications.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Notifications.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsObjRequest);
    }
}
