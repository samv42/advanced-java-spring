package platform.codingnomads.co.corespring.examples.beanscopes.prototype;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProtoTypeDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PrototypeDemoConfig.class);
        ctx.refresh();

        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean1.hashCode());

        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean2.hashCode());

        OtherBean otherBean1 = ctx.getBean(OtherBean.class);
        System.out.println("Hashcode: " + otherBean1.hashCode());

        OtherBean otherBean2 = ctx.getBean(OtherBean.class);
        System.out.println("Hashcode: " + otherBean2.hashCode());

        ctx.close();
    }
}
