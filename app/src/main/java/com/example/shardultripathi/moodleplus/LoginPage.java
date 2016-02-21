package com.example.shardultripathi.moodleplus;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by Aditi Singla on 22-Feb-16.
 */
public class LoginPage {
    User name;
    Boolean success;
    public void call(JSONObject response) {
        try {
            //success
            success = response.getBoolean("success");

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
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
