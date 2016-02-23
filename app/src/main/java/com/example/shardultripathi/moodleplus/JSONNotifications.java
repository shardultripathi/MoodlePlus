package com.example.shardultripathi.moodleplus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created by Aditi Singla on 22-Feb-16.
 */
public class JSONNotifications {
    Vector<JSONSingleNotification> notList = new Vector<>();
    public void call(JSONObject response) {
        try {
            //notifications
            JSONArray notArray = response.getJSONArray("notifications");
            for (int i = 0; i < notArray.length(); i++) {
                JSONSingleNotification not = new JSONSingleNotification();
                JSONObject obj = notArray.getJSONObject(i);
                not.userId = obj.getInt("user_id");
                not.description = obj.getString("description");
                not.createdAt = obj.getString("created_at");
                not.is_seen = obj.getInt("is_seen");
                not.id = obj.getInt("id");
                notList.add(not);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
