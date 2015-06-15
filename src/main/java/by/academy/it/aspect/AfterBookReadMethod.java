package by.academy.it.aspect;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by sam on 13.06.2015.
 */
public class AfterBookReadMethod implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After Method");
    }
}
