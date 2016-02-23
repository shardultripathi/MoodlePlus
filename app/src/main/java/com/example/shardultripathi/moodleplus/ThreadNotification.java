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

public class ThreadNotification extends AppCompatActivity {
    private JSONThreadInfo getform = new JSONThreadInfo();
    JSONCourse course1 = new JSONCourse();
    String timeReadable1;
    Vector<JSONComment> comments1 = new Vector<>();
    JSONThread thread1 = new JSONThread();
    Vector<JSONUser> commentUsers1 = new Vector<>();
    String threadId;
    //JSONCourse:   String code, name, description, ltp;
    //              int credits, id;
    //JSONComment:  int userId,threadId,id;
    //              String description,createdAt;
    //JSONThread:   int userId, regCourseId, id;
    //              String description, title, createdAt, updatedAt;
    //JSONUser:     String lastName, resetPasswordKey, registrationKey , firstName , entryNo , email , username , registrationId , password;
    //              int id, type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_notification);
        threadId= getIntent().getStringExtra("threadId");
        String URL = "http://10.192.58.152:8000/threads/thread.json/"+threadId;
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        getform.call(response);
                        course1 = getform.course;
                        timeReadable1 = getform.timesReadable;
                        comments1 = getform.comments;
                        thread1 = getform.thr;
                        commentUsers1 = getform.commentUsers;
                        Toast.makeText(ThreadNotification.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ThreadNotification.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsObjRequest);
    }
    //str: description entered into the comment box
    public void addComment(String str){
        String URL = "http://10.192.58.152:8000/threads/post_comment.json?thread_id="+threadId+"&description="+str;
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(ThreadNotification.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ThreadNotification.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsObjRequest);
    }
}
