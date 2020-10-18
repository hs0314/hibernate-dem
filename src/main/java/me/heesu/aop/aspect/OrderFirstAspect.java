package me.heesu.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class OrderFirstAspect extends BaseExpression{

    @Before("forAopPackageExceptGetterAndAdd()")
    private void firstAspectProcesss(){
        System.out.println("####### FIRST firstAspectProcesss() executed #####");
    }
}
