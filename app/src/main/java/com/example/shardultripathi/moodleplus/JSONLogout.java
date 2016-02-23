package com.example.shardultripathi.moodleplus;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Aditi Singla on 22-Feb-16.
 */
public class JSONLogout {
    int count;
    public void call(JSONObject response) {
        try {
            //noti_count
            count = response.getInt("noti_count");

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
