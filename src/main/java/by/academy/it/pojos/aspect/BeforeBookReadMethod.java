package main.java.by.academy.it.pojos.aspect;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;


public class BeforeBookReadMethod implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before Method");
    }
}
