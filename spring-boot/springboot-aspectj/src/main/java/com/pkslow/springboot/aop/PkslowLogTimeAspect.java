package com.pkslow.springboot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class PkslowLogTimeAspect {
    @Around("@annotation(com.pkslow.springboot.aop.PkslowLogTime) && execution(* *(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("------PkslowLogTime doAround start------");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        // Measure method execution time
        StopWatch stopWatch = new StopWatch(className + "->" + methodName);
        stopWatch.start(methodName);
        Object result = joinPoint.proceed();
        stopWatch.stop();
        // Log method execution time
        log.info(stopWatch.prettyPrint());
        log.info("------PkslowLogTime doAround end------");
        return result;
    }
}
