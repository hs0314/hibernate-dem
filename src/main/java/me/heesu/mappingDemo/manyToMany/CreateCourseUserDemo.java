package me.heesu.mappingDemo.manyToMany;

import me.heesu.config.BaseDemo;
import me.heesu.entity.Course;
import me.heesu.entity.User;
import org.hibernate.Session;

public class CreateCourseUserDemo extends BaseDemo {
    public static void main(String[] args) {
        Session s = getSession();

        try{
            s.beginTransaction();

            Course c = new Course("course for many to many test");
            s.save(c);

            User u1 = new User("u1", "u1", "aa@1.1");
            User u2 = new User("u2", "u2", "aa@2.2");
            c.addUser(u1);
            c.addUser(u2);

            s.save(u1);
            s.save(u2);

            s.getTransaction().commit();

        }catch(Exception e){

        }finally {
            s.close();
        }
    }
}
