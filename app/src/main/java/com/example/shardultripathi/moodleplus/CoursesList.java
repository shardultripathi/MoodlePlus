package com.example.shardultripathi.moodleplus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Aditi Singla on 22-Feb-16.
 */
public class CoursesList {
    int currentSem;
    Vector<Course> list;
    User name;
    int currentYr;
    public void call(JSONObject response) {
        try {
            //current_sem
            currentSem = response.getInt("current_sem");

            //courses
            JSONArray courseArray = response.getJSONArray("courses");
            for (int i = 0; i < courseArray.length(); i++) {
                Course c = new Course();
                JSONObject obj = courseArray.getJSONObject(i);
                c.code = obj.getString("code");
                c.name = obj.getString("name");
                c.description = obj.getString("description");
                c.credits = obj.getInt("credits");
                c.id = obj.getInt("id");
                c.ltp = obj.getString("l_t_p");
                list.add(c);
            }

            //user
            JSONObject user = response.getJSONObject("user");
            name.lastName = user.getString("last_name");
            name.resetPasswordKey = user.getString("reset_password_key");
            name.registrationKey = user.getString("registration_key");
            name.id = user.getInt("id");
            name.firstName = user.getString("first_name");
            name.entryNo = user.getString("entry_no");
            name.email = user.getString("email");
            name.username = user.getString("username");
            name.registrationId = user.getString("registration_id");
            name.password = user.getString("password");
            name.type = user.getInt("type_");

            //current_year
            currentYr = user.getInt("current_year");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
