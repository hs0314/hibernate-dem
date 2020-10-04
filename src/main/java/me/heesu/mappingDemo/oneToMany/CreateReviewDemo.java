package me.heesu.mappingDemo.oneToMany;

import me.heesu.config.BaseDemo;
import me.heesu.entity.Course;
import me.heesu.entity.Review;
import org.hibernate.Session;

public class CreateReviewDemo extends BaseDemo {

    public static void main(String[] args) {
        Session s = getSession();
        try{

            s.beginTransaction();
            Course c = new Course("course nm");

            c.addReview(new Review("review 1"));
            c.addReview(new Review("review 2"));

            //cascade type=all 로 review까지 저장됌
            s.save(c);

            s.getTransaction().commit();

        }catch(Exception e){

        }finally{
            s.close();
        }
    }
}
