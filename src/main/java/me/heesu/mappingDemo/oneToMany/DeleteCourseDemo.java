package me.heesu.mappingDemo.oneToMany;

import me.heesu.config.BaseDemo;
import me.heesu.entity.Course;
import org.hibernate.Session;

public class DeleteCourseDemo extends BaseDemo {

    public static void main(String[] args) {
        Session s = getSession();

        try{
            s.beginTransaction();
            int tgtId = 1;
            Course course = s.get(Course.class, tgtId);

            s.delete(course);

            s.getTransaction().commit();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            s.close();
        }
    }
}
