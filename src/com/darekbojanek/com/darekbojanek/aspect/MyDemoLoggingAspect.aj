package com.darekbojanek.com.darekbojanek.aspect;

import com.darekbojanek.com.darekbojanek.service.AccountService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.darekbojanek.com.darekbojanek.*.*(..))")
    private void forDarekBojanekDarekBojanekPackage() {}

    @Pointcut("execution(* com.darekbojanek.com.darekbojanek.dao.*.*(..))")
    private void forDarekBojanekDarekBojanekDaoPackage() {}

    @Pointcut("execution(* com.darekbojanek.com.darekbojanek.service.*.*(..))")
    private void forDarekBojanekDarekBojanekServicePackage() {}

    @Pointcut("execution(* com.darekbojanek.com.darekbojanek.service.*.get*(..))")
    private void forDarekBojanekDarekBojanekServicePackageGet() {}

    @Pointcut("execution(* com.darekbojanek.com.darekbojanek.service.*.set*(..))")
    private void forDarekBojanekDarekBojanekServicePackageSet() {}

    @Pointcut("forDarekBojanekDarekBojanekServicePackage() && !(forDarekBojanekDarekBojanekServicePackageGet() || forDarekBojanekDarekBojanekServicePackageSet())")
    private void serviceWithoutGetSet() {}

    @Before("serviceWithoutGetSet()")
    public void beforeAddAccountAdvice() {
        System.out.println("****** Doing some stuff @Before adding Account");
    }

    @Before("serviceWithoutGetSet()")
    public void beforeAddingAccountWithJoinPoint(JoinPoint joinPoint) {
        System.out.println("@beforeAddingAccountWithJoinPoint");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(methodSignature);

        Object[] args = joinPoint.getArgs();
        for(Object arg : args) {
            System.out.println(arg);

            if(arg instanceof AccountService) {
                ((AccountService) arg).printMe();
            }
        }
    }

    @AfterReturning(pointcut = "serviceWithoutGetSet()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, String result){
        System.out.println("call from method: " + joinPoint.getSignature().toShortString());
        System.out.println("Result was: " + result);
    }
}
