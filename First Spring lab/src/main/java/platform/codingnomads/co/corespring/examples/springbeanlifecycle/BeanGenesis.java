package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import lombok.NonNull;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BeanGenesis implements BeanNameAware {
    @Override
    public void setBeanName(@NonNull String name){
        System.out.println("Barashit bara elohim ett ha'aretz ve ett hasshamime.");
    }
}
