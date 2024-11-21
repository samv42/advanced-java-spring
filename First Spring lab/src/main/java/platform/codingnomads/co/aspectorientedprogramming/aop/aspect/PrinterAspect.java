package platform.codingnomads.co.aspectorientedprogramming.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

@Aspect
@Component
public class PrinterAspect {

    @Before("@annotation(Printer)")
    public void around() {
        System.out.println("Printer custom annotation hit.");
        System.out.println("/////");
        System.out.println("/////");
    }
}
