package com.example.shardultripathi.moodleplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class AllGrades extends AppCompatActivity {
    private JSONGrades getGrades = new JSONGrades();
    Vector<JSONGrade> gradeList = new Vector<>();
    Vector<JSONCourse> courseList = new Vector<>();
    // JSONCourse: String code, name, description, ltp;
    //              int credits, id;
    // JSONGrade: int weightage, userId, outOf, regCourseId, score, id;
    //              String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_grades);
        String URL = "http://10.192.58.152:8000/default/grades.json";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        getGrades.call(response);
                        gradeList = getGrades.gradel;
                        courseList = getGrades.coursel;
                        String s ="";
                        for (int i = 0; i < courseList.size(); i++) {
                            s += i + ". " + courseList.get(i).code + " : " + courseList.get(i).name + ": \n";
                            s += "\t" + gradeList.get(i).name + " : " + gradeList.get(i).weightage + "," + gradeList.get(i).id + "," + gradeList.get(i).outOf + "," + gradeList.get(i).score + "," + gradeList.get(i).regCourseId + "\n\n";
                        }
                        TextView list = (TextView) findViewById(R.id.textView);
                        list.setText(s);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AllGrades.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsObjRequest);
    }
}
