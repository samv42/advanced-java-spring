package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import platform.codingnomads.co.aspectorientedprogramming.aop.aspect.ServiceAspect;

import java.util.Arrays;

@Aspect
@Component
public class GreetingServiceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);

    @Before("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void logBeforeGreeting(JoinPoint joinPoint){
        LOGGER.info("Before Greeting : " + joinPoint.getSignature());
    }
    @AfterReturning("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void logAfterGreeting(JoinPoint joinPoint) {
        LOGGER.info("After Greeting : " + joinPoint.getSignature());
    }
    @Pointcut(value = "execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.*(..))")
    private void logGreetingSalutation(){}

    @Before("logGreetingSalutation()")
    public void logBeforeSalutation(JoinPoint joinPoint){
        LOGGER.info("Before Greeting : "+ joinPoint.getSignature());
        LOGGER.info("Before Greeting : "+ Arrays.toString(joinPoint.getArgs()));
        LOGGER.info("Before Greeting : "+ joinPoint.getKind());
    }
}
