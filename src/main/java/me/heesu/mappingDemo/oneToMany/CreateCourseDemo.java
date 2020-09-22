package me.heesu.mappingDemo.oneToMany;

import me.heesu.config.BaseDemo;
import me.heesu.entity.Course;
import me.heesu.entity.Instructor;
import me.heesu.entity.InstructorDtl;
import me.heesu.entity.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CreateCourseDemo extends BaseDemo {

    public static void main(String[] args) {
        Session s = getSession();

        try{
            List<Instructor> instructorList = new ArrayList<>();

            s.beginTransaction();
            instructorList = s.createQuery("from Instructor where name='inst1'", Instructor.class).list();

            //create courses
            Course c1 = new Course("course1");
            Course c2 = new Course("course2");

            instructorList.get(0).add(c1);
            instructorList.get(0).add(c2);


            s.save(c1);
            s.save(c2);
            s.getTransaction().commit();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            s.close();
        }
    }
}
