package pixel.academy.spring_core_ioc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pixel.academy.spring_core_ioc.common.Chef;

@RestController
public class DemoController {

    private Chef myChef;
    private Chef secondChef;

    //setter
    @Autowired
    public DemoController(@Qualifier("mexicanChef") Chef theChef,
                          @Qualifier("mexicanChef") Chef theSecondChef) {
        myChef = theChef;
        secondChef = theSecondChef;
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @GetMapping("/dailyrecipe")
    public String getDailyRecipe() {
        return myChef.getDailyRecipe();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myChef == secondChef, " + (myChef == secondChef);
    }

}
