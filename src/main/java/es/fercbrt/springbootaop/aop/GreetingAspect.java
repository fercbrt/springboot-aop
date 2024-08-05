package es.fercbrt.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* es.fercbrt.springbootaop.services.impl.GreetingServiceImpl.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        logger.info("Hello "+ Arrays.toString(joinPoint.getArgs()) +" from GreetingAspect (before) on " + joinPoint.getSignature().getName());
    }

    @After("execution(* es.fercbrt.springbootaop.services.impl.GreetingServiceImpl.sayHello(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        logger.info("Goodbye "+ Arrays.toString(joinPoint.getArgs()) +" from GreetingAspect (after) on " + joinPoint.getSignature().getName());
    }
}
