package platform.codingnomads.co.corespring.examples.propertysourceannoation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PropertySourceAnnotationConfig.class);
        ctx.refresh();
        final App app = ctx.getBean(App.class);
        System.out.println("Values from myapp.properties: " +
                "App Name: " + app.getAppName() + ", App Version: " + app.getAppVersion() +
                "OtherApp Name: " + app.getOtherName() + ", OtherApp Version: " + app.getOtherVersion());
        ctx.close();
    }
}
