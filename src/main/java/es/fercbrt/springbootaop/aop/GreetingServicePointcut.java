package es.fercbrt.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcut {
    @Pointcut("execution(* es.fercbrt.springbootaop.services.impl.GreetingServiceImpl.*(..))")
    public void greetingLoggerPointCut() {

    }
}
