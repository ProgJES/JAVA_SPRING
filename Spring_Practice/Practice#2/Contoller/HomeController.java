package practice2.Practice2.Contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Localhost:8080
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
