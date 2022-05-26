package platform.codingnomads.co.corespring.examples.profileannotation;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
//@PropertySource(value = "application-deploy.properties", ignoreResourceNotFound = true)
public class SecondaryDeveloper {
    /*@Value("${application-deploy.ready"})
    private String ready;

    public String getReady(){
        return ready;
        }*/
    public SecondaryDeveloper() {
        System.out.println("Secondary developer is ready!");}
    }
