package me.heesu.aop;

import me.heesu.config.AopConfig;
import me.heesu.entity.Course;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class aopOrderTest {
    public static void main(String[] args) {
        {
            //read spring config java class
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

            TargetObject obj1 = context.getBean("targetObject", TargetObject.class);
            CourseDao dao = context.getBean("courseDao", CourseDao.class);


            //aop order test
            Course c = new Course("course title here!");
            dao.addCourse(c,true); // add~메서드는 제외
            dao.testMethodForMethodSignature("string arg", c); // 실제 aop 작동 메서드

            context.close();
        }
    }
}
