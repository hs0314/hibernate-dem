package me.heesu.mappingDemo.manyToMany;

import me.heesu.config.BaseDemo;
import me.heesu.entity.Course;
import me.heesu.entity.User;
import org.hibernate.Session;

import java.util.List;

public class DeleteUserDemo extends BaseDemo {
    public static void main(String[] args) {
        Session s = getSession();

        try{
            s.beginTransaction();
            //userId = 9

            int targetId = 9;
            User tgtUser = s.get(User.class, targetId);


            System.out.println("################### COURSES : " + tgtUser.getCourses().toString());
            List<Course> courses = tgtUser.getCourses();

            s.delete(tgtUser); // User삭제해도 course는 그대로, joinTable은 삭제

            s.getTransaction().commit();

        }catch(Exception e){

        }finally {
            s.close();
        }
    }
}
