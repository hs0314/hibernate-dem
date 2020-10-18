package me.heesu.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class BaseExpression {
    // aop 패키지 전체
    @Pointcut("execution(* me.heesu.aop.*.*(..))")
    public void forAopPackage(){}


    //exp0. aop패키지 내부의 전체 메서드
    @Pointcut("execution(* me.heesu.aop.*.*(..))")
    private void exp0(){}

    //exp1. aop패키지 내의 모든 메서드 중에서 getter
    @Pointcut("execution(* me.heesu.aop.*.get*(..))")
    private void exp1(){}

    //exp2. aop패키지 내의 모든 메서드 중에서 add
    @Pointcut("execution(* me.heesu.aop.*.add*(..))")
    private void exp2(){}

    //exp3. combined pointcut(aop패키지 내에서 add~, get~ 메서드 제외)
    @Pointcut("exp0() && !(exp1() || exp2())")
    public void forAopPackageExceptGetterAndAdd(){}
}
