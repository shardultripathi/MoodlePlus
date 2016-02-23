package com.example.shardultripathi.moodleplus;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Aditi Singla on 22-Feb-16.
 */
public class ThreadInfo {
    String form;
    public void call(JSONObject response) {
        try {
            //form
            form = response.getString("form");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
