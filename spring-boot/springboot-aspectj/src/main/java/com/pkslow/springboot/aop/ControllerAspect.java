package com.pkslow.springboot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
//@EnableAspectJAutoProxy
public class ControllerAspect {

    @Pointcut("execution(* com.pkslow.springboot.controller..*.*(..))")
    private void testControllerPointcut() {

    }

    @Before("testControllerPointcut()")
    public void doBefore(JoinPoint joinPoint){
        log.info("------pkslow aop doBefore start------");
        String method = joinPoint.getSignature().getName();
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        log.info("Method: {}.{}" ,declaringTypeName, method);
        log.info("------pkslow aop doBefore end------");
    }

    @Around("testControllerPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("------pkslow aop doAround start------");
        long start = System.nanoTime();
        Object obj = joinPoint.proceed();
        long end = System.nanoTime();
        log.info("Execution Time: " + (end - start) + " ns");
        log.info("------pkslow aop doAround end------");

        return obj;
    }
}
