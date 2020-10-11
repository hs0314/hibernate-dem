package me.heesu.aop;

import org.springframework.stereotype.Component;

@Component
public class TargetObject {

    public void doSomething(){
        System.out.println("##################### doSomething() executed in OBJ1 ###################");
    }

    public void doA(String param){
        System.out.println("#################### doA() : " + param);
        System.out.println("##################### doA() executed in OBJ1 ###################");
    }
    public void doB(){
        System.out.println("##################### doB() executed in OBJ1 ###################");
    }
}
