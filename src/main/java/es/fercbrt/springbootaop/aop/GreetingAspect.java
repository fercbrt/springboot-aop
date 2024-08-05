package es.fercbrt.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(2)
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* es.fercbrt.springbootaop.services.impl.GreetingServiceImpl.*(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        logger.info("Hello "+ Arrays.toString(joinPoint.getArgs()) +" from GreetingAspect (before) on " + joinPoint.getSignature().getName());
    }

    @After("execution(* es.fercbrt.springbootaop.services.impl.GreetingServiceImpl.*(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        logger.info("Goodbye "+ Arrays.toString(joinPoint.getArgs()) +" from GreetingAspect (after) on " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* es.fercbrt.springbootaop.services.impl.GreetingServiceImpl.*(..))")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        logger.info("Goodbye "+ Arrays.toString(joinPoint.getArgs()) +" from GreetingAspect (afterReturning) on " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* es.fercbrt.springbootaop.services.impl.GreetingServiceImpl.*(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        logger.info("Goodbye "+ Arrays.toString(joinPoint.getArgs()) +" from GreetingAspect (afterThrowing) on " + joinPoint.getSignature().getName());
    }

    @Around("execution(* es.fercbrt.springbootaop.services.impl.GreetingServiceImpl.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint){
        logger.info("Hello "+ Arrays.toString(joinPoint.getArgs()) +" from GreetingAspect (around) on " + joinPoint.getSignature().getName());
        try {
            Object result = joinPoint.proceed();
            logger.info("Goodbye "+ Arrays.toString(joinPoint.getArgs()) +" from GreetingAspect (around) on " + joinPoint.getSignature().getName());
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
