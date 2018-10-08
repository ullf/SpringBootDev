package ru.marksblog.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {

    @Pointcut("execution(* ru.marksblog.controller.CompanyController..*(..))")
    public void printMethodName(){

    }

    @Before("printMethodName()")
    public void logBefore(JoinPoint point){
        System.out.println(point);
    }
}
