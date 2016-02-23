package com.example.shardultripathi.moodleplus;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class AllCourses extends AppCompatActivity {
    TextView textview;
    TextView Logout;
    ArrayList<String> codeNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_all_courses);
        textview = (TextView) findViewById(R.id.button_grades);
        textview.setPaintFlags(textview.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grades();
            }
        });
        Logout = (TextView) findViewById(R.id.logout);
        Logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                logout();
            }
        });
        String URL = "http://10.192.58.152:8000/courses/list.json";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                     //   Toast.makeText(AllCourses.this, response.toString(), Toast.LENGTH_LONG).show();
                        JSONCoursesList courses=new JSONCoursesList();
                        courses.call(response);
                        Vector<JSONCourse> tempList = courses.list;
                        JSONCourse tempCourse;

                        String codeName;

                        for (int i=0; i<tempList.size(); i++)
                        {
                            tempCourse = tempList.get(i);
                            codeName = tempCourse.code + ": " + tempCourse.name;
                            Toast.makeText(AllCourses.this, codeName, Toast.LENGTH_LONG).show();
                            codeNames.add(codeName);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AllCourses.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsObjRequest);
    }
    public void grades() {
        Intent intent = new Intent(AllCourses.this, AllGrades.class);
        startActivity(intent);
    }
    public void logout(){
        Intent intent = new Intent(AllCourses.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

