package com.example.shardultripathi.moodleplus;

import java.util.Vector;

/**
 * Created by Dhairya on 23-02-2016.
 */
public class recycler_courses {
    String title;

    public recycler_courses(String str) {
        title = str;
    }

    public static Vector<recycler_courses> createCourses(Vector<String> titles) {
        Vector<recycler_courses> courses = new Vector<>();
        recycler_courses temp;
        for(int i=0;i<titles.size();i++) {
            temp = new recycler_courses(titles.get(i));
            courses.add(temp);
        }
        return courses;
    }
}
