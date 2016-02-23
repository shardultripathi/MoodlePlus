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

import java.util.Vector;

public class Course extends AppCompatActivity {
    private JSONSpecificCourse getInfo = new JSONSpecificCourse();
    String courseCode;
    Vector<JSONAssignment> assnList= new Vector<>();
    Vector<JSONGrade> gradeList = new Vector<>();
    Vector<JSONThread> threadList = new Vector<>();
    JSONRegistered registered = new JSONRegistered();
    //tab is useless
    //year and sem
    int yr;
    int semester;
    //JSONAssignment : String name, createdAt, deadline, description, file;
    //                  int regCourseId, lateDaysAllowed, type, id;
    //JSONGrade: int weightage, userId, outOf, regCourseId, score, id;
    //           String name;
    //JSONThread: int userId, regCourseId, id;
    //            String description, title, createdAt, updatedAt;
    //JSONRegistered: String startDate, endDate;
    //                int id, professor, sem, year, courseId;
    //Pass the assnId or threadId into the intent.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        courseCode = getIntent().getStringExtra("courseId");
        String URL1 = "http://10.192.58.152:8000/courses/course.json/"+courseCode+"/assignments";
        JsonObjectRequest jsObjRequest1 = new JsonObjectRequest(Request.Method.GET, URL1, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        getInfo.call(response);
                        assnList = getInfo.assnList;
                        Toast.makeText(Course.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Course.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        requestQueue1.add(jsObjRequest1);
        String URL2 = "http://10.192.58.152:8000/courses/course.json/"+courseCode+"/grades";
        JsonObjectRequest jsObjRequest2 = new JsonObjectRequest(Request.Method.GET, URL2, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        getInfo.call(response);
                        gradeList = getInfo.gradeList;
                        Toast.makeText(Course.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Course.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue2 = Volley.newRequestQueue(this);
        requestQueue2.add(jsObjRequest2);
        String URL3 = "http://10.192.58.152:8000/courses/course.json/"+courseCode+"/threads";
        JsonObjectRequest jsObjRequest3 = new JsonObjectRequest(Request.Method.GET, URL3, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        getInfo.call(response);
                        threadList = getInfo.threadList;
                        yr = getInfo.year;
                        semester = getInfo.sem;
                        Toast.makeText(Course.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Course.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue3 = Volley.newRequestQueue(this);
        requestQueue3.add(jsObjRequest3);
        // registered, course and other details can be accessed directly as getInfo.reg, getInfo.course, getInfo.tab, getInfo.sem, getInfo.year

    }
    public void createThread(String title,String desc){
        String URL = "http://10.192.58.152:8000/threads/new.json?title="+title+"&description="+desc+"&course_code="+courseCode;
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(Course.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Course.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsObjRequest);
    }
}
