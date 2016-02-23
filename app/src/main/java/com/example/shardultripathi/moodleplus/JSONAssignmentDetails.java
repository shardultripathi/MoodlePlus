package com.example.shardultripathi.moodleplus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created by Aditi Singla on 24-Feb-16.
 */
public class JSONAssignmentDetails {
    JSONAssignment assn = new JSONAssignment();
    JSONRegistered reg = new JSONRegistered();
    Vector<String> submissions = new Vector<>();
    JSONCourse course = new JSONCourse();
    public void call(JSONObject response) {
        try {
            //assignment
            JSONObject obj = response.getJSONObject("assignment");
            assn.name = obj.getString("name");
            assn.file = obj.getString("file_");
            assn.createdAt = obj.getString("created_at");
            assn.regCourseId = obj.getInt("registered_course_id");
            assn.lateDaysAllowed = obj.getInt("late_days_allowed");
            assn.type = obj.getInt("type_");
            assn.deadline = obj.getString("deadline");
            assn.id = obj.getInt("id");
            assn.description = obj.getString("description");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            //registered
            JSONObject register = response.getJSONObject("registered");
            reg.startDate = register.getString("starting_date");
            reg.id = register.getInt("id");
            reg.professor = register.getInt("professor");
            reg.sem = register.getInt("semester");
            reg.endDate = register.getString("ending_date");
            reg.year = register.getInt("year_");
            reg.courseId = register.getInt("course_id");
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        try{
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
        //Submission part is skipped
    }
}
