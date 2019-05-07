package com.darekbojanek.com.darekbojanek.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.darekbojanek.com.darekbojanek.dao.*.*(..))")
    private void forDao() {}

    @Pointcut("execution(* com.darekbojanek.com.darekbojanek.service.*.*(..))")
    private void forService() {}

    @Pointcut("execution(* com.darekbojanek.springdemo.controller.*.*(..))")
    private void forController() {}

    @Pointcut("forController() || forService() || forDao()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Logger info @before: ");
        logger.info(joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();
        for(Object o : args) {
            logger.info("------> argument: " + o);
        }
    }

    @AfterReturning(pointcut="forAppFlow()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        logger.info("Logger info @after returning: ");
        logger.info(joinPoint.getSignature().toShortString());

        logger.info(result.toString());
    }
}
