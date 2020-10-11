package me.heesu.aop;

import me.heesu.config.AopConfig;
import me.heesu.entity.Course;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class aopTest {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        TargetObject obj1 = context.getBean("targetObject", TargetObject.class);
        CourseDao dao = context.getBean("courseDao", CourseDao.class);

        /* basic test
        obj1.doSomething();
        obj1.doA("TEST!!");
        obj1.doB();
        System.out.println();

        Course c = new Course("title");
        dao.addCourse(c,true);
        dao.testMethod();

         */

        //combined test
        Course c = new Course("title");
        dao.addCourse(c,true);
        dao.testMethod();
        dao.getCourse();


        context.close();
    }
}
