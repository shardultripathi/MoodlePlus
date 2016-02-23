package com.example.shardultripathi.moodleplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Assignment extends AppCompatActivity {

    private JSONAssignmentDetails getAssn = new JSONAssignmentDetails();
    String assnId;
    JSONAssignment assn1 = new JSONAssignment();
    JSONRegistered reg1 = new JSONRegistered();
    JSONCourse course1 = new JSONCourse();
    //JSONAssignment: String name, createdAt, deadline, description, file;
    //                int regCourseId, lateDaysAllowed, type, id;
    //JSONRegistered: String startDate, endDate;
    //                int id, professor, sem, year, courseId;
    //JSONCourse:    String code, name, description, ltp;
    //               int credits, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        assnId = getIntent().getStringExtra("assnId");
        String URL = "http://10.192.58.152:8000/courses/assignment.json/"+assnId;
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        getAssn.call(response);
                        assn1 = getAssn.assn;
                        reg1 = getAssn.reg;
                        course1 = getAssn.course;
                        Toast.makeText(Assignment.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Assignment.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsObjRequest);
    }
}
