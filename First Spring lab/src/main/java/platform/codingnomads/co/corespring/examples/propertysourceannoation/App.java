package platform.codingnomads.co.corespring.examples.propertysourceannoation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class App {
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${OtherApp.name}")
    private String otherName;

    @Value("${OtherApp.version}")
    private String otherVersion;

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getOtherName() { return otherName; }

    public String getOtherVersion() { return otherVersion; }
}


