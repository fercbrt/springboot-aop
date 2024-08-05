package es.fercbrt.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class OrderedAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("GreetingServicePointcut.greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        logger.info("Hello from OrderedAspect (before) on " + joinPoint.getSignature().getName());
    }
}
