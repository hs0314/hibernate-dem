package me.heesu.aop;

import me.heesu.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseDao {
    public void addCourse(Course c, boolean flag){
        System.out.println("####### ADD Course addCourse() executed : " + c.toString());
    }

    public void testMethod(){
        System.out.println("####### TEST METHOD()!!!");
    }

    public void testMethodForMethodSignature(String arg1, Course c){
        System.out.println("####### TEST METHOD FOR METHOD SIGNATURE!!!");
    }

    public List<Course> getCourses(){
        Course c1 = new Course("testcourse1");
        Course c2 = new Course("testcourse2");

        List<Course> courses = new ArrayList<>();

        courses.add(c1);
        courses.add(c2);

        return courses;
    }
}
