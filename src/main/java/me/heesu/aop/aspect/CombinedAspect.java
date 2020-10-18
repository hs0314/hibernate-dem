package me.heesu.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class CombinedAspect {

    //exp0. aop패키지 내부의 전체 메서드
    @Pointcut("execution(* me.heesu.aop.*.*(..))")
    private void exp0(){}

    //exp1. aop패키지 내의 모든 메서드 중에서 getter
    @Pointcut("execution(* me.heesu.aop.*.get*(..))")
    private void exp1(){}

    //exp2. aop패키지 내의 모든 메서드 중에서 add
    @Pointcut("execution(* me.heesu.aop.*.add*(..))")
    private void exp2(){}

    //exp3. combined pointcut
    @Pointcut("exp0() && !(exp1() || exp2())")
    private void exp3(){}

    @Before("exp3()")
    public void wholeAopPackageExceptGetterAdder(){
        System.out.println("########### wholeAopPackageExceptGetterAdder");
    }
}
