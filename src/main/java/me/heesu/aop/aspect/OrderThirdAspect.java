package me.heesu.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class OrderThirdAspect extends BaseExpression{
    @Before("forAopPackageExceptGetterAndAdd()")
    private void thirdAspectProcesss(){
        System.out.println("####### THIRD thirdAspectProcesss() executed #####");
    }
}
