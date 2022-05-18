package platform.codingnomads.co.ioc.examples.dependencylookup;

public class HebrewGreetingProvider implements GreetingProvider {

    @Override
    public String getGreeting() {
        return "Shalom!";
    }
}
