package com.example.shardultripathi.moodleplus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created by Aditi Singla on 22-Feb-16.
 */
public class SpecificCourse {
    Vector<Assignment> assnList;
    Registered reg;
    Vector<Thread> threadList;
    Course course;
    Vector<Grade> gradeList;
    String tab;
    int year;
    int sem;
    public void call(JSONObject response) {
        try {
            //assignments
            JSONArray assnArray = response.getJSONArray("assignments");
            for (int i = 0; i < assnArray.length(); i++) {
                Assignment assn = new Assignment();
                JSONObject obj = assnArray.getJSONObject(i);
                assn.name = obj.getString("name");
                assn.file = obj.getString("file_");
                assn.createdAt = obj.getString("created_at");
                assn.regCourseId = obj.getInt("registered_course_id");
                assn.lateDaysAllowed = obj.getInt("late_days_allowed");
                assn.type = obj.getInt("type_");
                assn.deadline = obj.getString("deadline");
                assn.id = obj.getInt("id");
                assn.description = obj.getString("description");
                assnList.add(assn);
            }

            //registered
            JSONObject register = response.getJSONObject("registered");
            reg.startDate = register.getString("starting_date");
            reg.id = register.getInt("id");
            reg.professor = register.getInt("professor");
            reg.sem = register.getInt("semester");
            reg.endDate = register.getString("ending_date");
            reg.year = register.getInt("year_");
            reg.courseId = register.getInt("course_id");

            //course_threads
            JSONArray threadArray = response.getJSONArray("course_threads");
            for (int i = 0; i < threadArray.length(); i++) {
                Thread thr = new Thread();
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

            //course
            JSONObject obj = response.getJSONObject("course");
            course.code = obj.getString("code");
            course.name = obj.getString("name");
            course.description = obj.getString("description");
            course.credits = obj.getInt("credits");
            course.id = obj.getInt("id");
            course.ltp = obj.getString("l_t_p");

            //grades
            JSONArray gradeArray = response.getJSONArray("grades");
            for (int i = 0; i < gradeArray.length(); i++) {
                Grade g = new Grade();
                JSONObject object = gradeArray.getJSONObject(i);
                g.weightage = object.getInt("weightage");
                g.userId = object.getInt("user_id");
                g.name = object.getString("name");
                g.outOf = object.getInt("out_of");
                g.regCourseId = object.getInt("registered_course_id");
                g.score = obj.getInt("score");
                g.id = obj.getInt("id");
                gradeList.add(g);
            }

            tab =  response.getString("tab");

            year = response.getInt("year");

            sem = response.getInt("sem");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
