package me.heesu.mappingDemo.oneToMany;

import me.heesu.config.BaseDemo;
import me.heesu.entity.Course;
import me.heesu.entity.Instructor;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class GetInstructorCoursesDemo extends BaseDemo {

    public static void main(String[] args) {
        Session s = getSession();

        try{
            List<Instructor> instructorList = new ArrayList<>();

            s.beginTransaction();
            instructorList = s.createQuery("from Instructor where name='inst1'", Instructor.class).list();
            System.out.println("############ INSTRUCTOR : " + instructorList.get(0).toString());

            //get courses for the instructor
            System.out.println("######### COURSES : " + instructorList.get(0).getCourses().toString());

            s.getTransaction().commit();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            s.close();
        }
    }
}
