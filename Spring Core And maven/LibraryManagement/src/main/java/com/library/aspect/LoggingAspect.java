package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Before Advice
    @Before("execution(* com.library.service.BookService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LoggingAspect] BEFORE: Executing method: " + joinPoint.getSignature().getName());
    }

    // After Advice
    @After("execution(* com.library.service.BookService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[LoggingAspect] AFTER: Finished executing method: " + joinPoint.getSignature().getName());
    }

    // Around Advice (tracks method execution time)
    @Around("execution(* com.library.service.BookService.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("[LoggingAspect] AROUND: Starting execution time tracking for: " + joinPoint.getSignature().getName());
        
        Object result = joinPoint.proceed();
        
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("[LoggingAspect] AROUND: Method " + joinPoint.getSignature().getName() + " executed in " + executionTime + " ms");
        
        return result;
    }
}
