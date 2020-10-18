package me.heesu.aop.aspect;

import me.heesu.entity.Course;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JoinPointAspect extends BaseExpression{

    @Before("forAopPackageExceptGetterAndAdd()")
    public void getArgsFromJoinPoint(JoinPoint joinPoint){
        System.out.println("####### JoinPoint getArgsFromJoinPoint() executed #####");

        //display method signature
        MethodSignature s = (MethodSignature) joinPoint.getSignature();
        System.out.println("###### METHOD SIGNATURE : " + s);

        //display args passed
        Object[] args = joinPoint.getArgs();
        for(Object obj : args){
            if(obj instanceof Course){
                Course tmpCourese = (Course)obj;
                System.out.println("########### ARG COURSE TITLE : " + tmpCourese.getTitle());
            }
        }

    }
}
