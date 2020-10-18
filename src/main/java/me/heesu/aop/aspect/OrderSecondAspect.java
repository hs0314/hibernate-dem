package me.heesu.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class OrderSecondAspect extends BaseExpression{
    @Before("forAopPackageExceptGetterAndAdd()")
    private void secondAspectProcesss(){
        System.out.println("####### SECOND secondAspectProcesss() executed #####");
    }
}
