package me.heesu.mappingDemo.oneToMany;

import me.heesu.config.BaseDemo;
import me.heesu.entity.Course;
import org.hibernate.Session;

public class GetCourseReviewDemo extends BaseDemo {
    public static void main(String[] args) {
        Session s = getSession();

        try{
            s.beginTransaction();
            //id - 3
            int tgtId = 3;
            Course c = s.get(Course.class, tgtId);
            System.out.println("################## " + c.toString());

            //Lazy loading
            System.out.println("################## " + c.getReviews().toString());


            s.getTransaction().commit();

        }catch(Exception e){

        }finally{
            s.close();
        }
    }
}
