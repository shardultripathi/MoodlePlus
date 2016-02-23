package com.example.shardultripathi.moodleplus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created by Aditi Singla on 22-Feb-16.
 */
public class JSONThreadInfo {
    JSONCourse course = new JSONCourse();
    Vector<JSONComment> comments = new Vector<>();
    String timesReadable;
    JSONThread thr = new JSONThread();
    Vector<JSONUser> commentUsers = new Vector<>();
    public void call(JSONObject response) {
        try {
            //course
            JSONObject obj = response.getJSONObject("course");
            course.code = obj.getString("code");
            course.name = obj.getString("name");
            course.description = obj.getString("description");
            course.credits = obj.getInt("credits");
            course.id = obj.getInt("id");
            course.ltp = obj.getString("l_t_p");
        } catch (JSONException en) {
            en.printStackTrace();
        }
        try {
            //thread
            JSONObject obj = response.getJSONObject("thread");
            thr.userId = obj.getInt("user_id");
            thr.description = obj.getString("description");
            thr.title = obj.getString("title");
            thr.createdAt = obj.getString("created_at");
            thr.regCourseId = obj.getInt("registered_course_id");
            thr.updatedAt = obj.getString("updated_at");
            thr.id = obj.getInt("id");
        } catch (JSONException et) {
            et.printStackTrace();
        }
        try {
            //comments
            JSONArray commentArray = response.getJSONArray("comments");
            for (int i = 0; i < commentArray.length(); i++) {
                JSONComment c = new JSONComment();
                JSONObject obj = commentArray.getJSONObject(i);
                c.userId = obj.getInt("user_id");
                c.description = obj.getString("description");
                c.threadId = obj.getInt("thread_id");
                c.id = obj.getInt("id");
                c.createdAt = obj.getString("created_at");
                comments.add(c);
            }
        } catch (JSONException em) {
            em.printStackTrace();
        }
        try {
            //commentUsers
            JSONArray userArray = response.getJSONArray("comment_users");
            for (int i = 0; i < userArray.length(); i++) {
                JSONUser c = new JSONUser();
                JSONObject obj = userArray.getJSONObject(i);
                c.lastName = obj.getString("last_name");
                c.resetPasswordKey = obj.getString("reset_password_key");
                c.registrationKey = obj.getString("registration_key");
                c.id = obj.getInt("id");
                c.firstName = obj.getString("first_name");
                c.entryNo = obj.getString("entry_no");
                c.email = obj.getString("email");
                c.username = obj.getString("username");
                c.registrationId = obj.getString("registration_id");
                c.password = obj.getString("password");
                c.type = obj.getInt("type_");
                commentUsers.add(c);
            }
        } catch (JSONException el) {
            el.printStackTrace();
        }
        try {
            JSONArray timeReadableArray = response.getJSONArray("times_readable");
            String obj = timeReadableArray.getString(0);
            timesReadable = obj;
        } catch (JSONException elt) {
            elt.printStackTrace();
        }
    }
}
