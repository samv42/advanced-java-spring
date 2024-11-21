package platform.codingnomads.co.corespring.examples.scopeannotaion;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ScopeAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScopeAnnotationDemoConfig.class);
        ctx.refresh();
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);

        System.out.println("-----Hashcode of SingletonBean-----");
        System.out.println(singletonBean1.hashCode());
        System.out.println(singletonBean2.hashCode());

        final PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        final PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);

        System.out.println("-----Hashcode of PrototypeBean-----");
        System.out.println(prototypeBean1.hashCode());
        System.out.println(prototypeBean2.hashCode());
        System.out.println();

        HebrewBean hebrewBean1 = ctx.getBean(HebrewBean.class);
        HebrewBean hebrewBean2 = ctx.getBean(HebrewBean.class);
        System.out.println("-----Hashcode of HebrewBean-----");
        System.out.println(hebrewBean1.hashCode());
        System.out.println(hebrewBean2.hashCode());

        System.out.println("-----Hashcode of FrenchBean-----");
        FrenchBean frenchBean1 = ctx.getBean(FrenchBean.class);
        FrenchBean frenchBean2 = ctx.getBean(FrenchBean.class);
        System.out.println(frenchBean1.hashCode());
        System.out.println(frenchBean2.hashCode());
        ctx.close();
    }
}
