package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintableAspect {
    @Pointcut(value = "@annotation(Printable)")
    public void print() {}
    @Before("print()")
    public void printBefore(){
        System.out.println("/////");
        System.out.println("Printable custom annotation hit.");
        System.out.println("/////");
    }
}
