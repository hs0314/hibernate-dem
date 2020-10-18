package me.heesu.aop.aspect;

import me.heesu.entity.Course;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class OtherAdviceTypeAspect extends BaseExpression {

    @AfterReturning(pointcut = "forAopPackage()",
                    returning = "result")
    public void afterReturningAdvice(JoinPoint jp, List<Course> result){
        String method = jp.getSignature().toShortString();

        //get result of the method call
        System.out.println("####### afterReturningAdvice() RESULT : " + result);

        //post processing (첫번째 요소 삭제)
        if(result != null && result.size() >0){
            result.remove(0);
        }
    }

}
