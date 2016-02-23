package com.example.shardultripathi.moodleplus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created by Aditi Singla on 22-Feb-16.
 */
public class JSONNotifications {
    Vector<JSONThread> threadList = new Vector<JSONThread>();
    public void call(JSONObject response) {
        try {
            //notifications
            JSONArray threadArray = response.getJSONArray("course_threads");
            for (int i = 0; i < threadArray.length(); i++) {
                JSONThread thr = new JSONThread();
                JSONObject obj = threadArray.getJSONObject(i);
                thr.userId = obj.getInt("user_id");
                thr.description = obj.getString("description");
                thr.title = obj.getString("title");
                thr.createdAt = obj.getString("created_at");
                thr.regCourseId = obj.getInt("registered_course_id");
                thr.updatedAt = obj.getString("updated_at");
                thr.id = obj.getInt("id");
                threadList.add(thr);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
