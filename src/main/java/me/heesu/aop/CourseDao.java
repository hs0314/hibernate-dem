package me.heesu.aop;

import me.heesu.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseDao {
    public void addCourse(Course c, boolean flag){
        System.out.println("####### add Course : " + c.toString());
    }

    public void testMethod(){
        System.out.println("####### TEST METHOD()!!!");
    }
    
    public Course getCourse(){
        Course c = new Course("testcourse");

        return c;
    }
}
