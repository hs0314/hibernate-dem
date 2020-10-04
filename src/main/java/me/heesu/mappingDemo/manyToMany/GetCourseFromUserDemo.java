package me.heesu.mappingDemo.manyToMany;

import me.heesu.config.BaseDemo;
import me.heesu.entity.Course;
import me.heesu.entity.User;
import org.hibernate.Session;

import java.util.List;

public class GetCourseFromUserDemo extends BaseDemo {
    public static void main(String[] args) {
        Session s = getSession();

        try{
            s.beginTransaction();
            //userId = 9

            int targetId = 9;
            User tgtUser = s.get(User.class, targetId);

            System.out.println("################### COURSES : " + tgtUser.getCourses().toString());
            //tgtCourseId = 4 인 코스 삭제, User는 유지
            List<Course> courses = tgtUser.getCourses();

            if(courses != null && courses.size() > 0) {
                Course tgtCourse = courses.get(0);
                int tgtCourseId = tgtCourse.getId();
                s.delete(tgtCourse); // Course, joinTable에서 모두 삭
                System.out.println("################## COURSE DELETED : " + tgtCourseId + " ###############");
            }

            s.getTransaction().commit();

        }catch(Exception e){

        }finally {
            s.close();
        }
    }
}
