package me.heesu.aop.aspect;

import me.heesu.entity.Course;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class OtherAdviceTypeAspect extends BaseExpression {

    /**
     * @AfterReturning
     * 메서드의 결과값에 대한 후처리 가능
     */
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

    /**
     * @AfterThrowing
     */
    @AfterThrowing(pointcut = "forAopPackage()",
                    throwing = "e")
    public void afterThrowingAdvice(JoinPoint jp, Throwable e){
        String method = jp.getSignature().toShortString();
        System.out.println("####### method : " + method);

        //exception handling
        //ex. log exception
        System.out.println("######## afterThrowingAdvice() log exception : " + e.getMessage());

    }

    /**
     * @After
     * 타겟 메서드의 성공/실패 상관없이 호출됌 (Throwable 객체를 불러올 수 없음)
     */
    @After("forAopPackage()")
    public void afterAdvice(JoinPoint jp){
        System.out.println("#### After advice!! ######");
    }

}
