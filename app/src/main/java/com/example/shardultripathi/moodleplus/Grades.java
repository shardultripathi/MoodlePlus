package com.example.shardultripathi.moodleplus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created by Aditi Singla on 22-Feb-16.
 */
public class Grades {
    Vector<Course> coursel;
    Vector<Grade>  gradel;
    public void call(JSONObject response) {
        try {
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
                coursel.add(c);
            }

            //grades
            JSONArray gradeArray = response.getJSONArray("grades");
            for (int i = 0; i < gradeArray.length(); i++) {
                Grade g = new Grade();
                JSONObject obj = gradeArray.getJSONObject(i);
                g.weightage = obj.getInt("weightage");
                g.userId = obj.getInt("user_id");
                g.name = obj.getString("name");
                g.outOf = obj.getInt("out_of");
                g.regCourseId = obj.getInt("registered_course_id");
                g.score = obj.getInt("score");
                g.id = obj.getInt("id");
                gradel.add(g);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
