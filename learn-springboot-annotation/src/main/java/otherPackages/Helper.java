package otherPackages;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component
public class Helper {
    public void pleaseHelp(){
        System.out.println("Doing ...yeah done :)");
    }
}
