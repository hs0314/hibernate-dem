package me.heesu.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class BasicAspect {
    //logging관련된 advices를 모두 관리

    //@Before("execution(public void doSomething())") // pointcut expression
    //@Before("execution(public void me.heesu.aop.TargetObject.doSomething())")
    @Before("execution(public void do*(..))")
    public void beforeDoSomethingAdvice(){
        System.out.println("\n########### executing @Before advice on doSomething() ############");
    }

    //@Before("execution(* add*(me.heesu.aop.CourseDao, ..))")
    @Before("execution(* me.heesu.aop.*.*(..))")
    public void beforeAddCourseAdvice(){
        System.out.println("\n########### executing @Before advice!!!!!! ############");
    }

    /* 동일한 pointcut을 재사용하기 위해서는
     @PointCut 어노테이션을 통해서 특정 pointCut을 설정 + 메서드A를 정의하고
     이후에 advice 클래스에서 필요한 pointcut을 A메서드로 지정함으로써 처리
     위에서 pointcut exp로 표현했던 부분을 아래와같이 표현할 수 있음
     */
    @Pointcut("execution(* me.heesu.aop.*.*(..))")
    private void forAopPackage(){}

    @Before("forAopPackage()")
    public void beforeAddCourseAdvice2(){
        System.out.println("\n########### pointcut annotation test!! ############");
    }

    @Before("forAopPackage()")
    public void beforeAddCourseAdvice3(){
        System.out.println("\n########### REUSE pointcut annotation test!! ############");
    }
}
