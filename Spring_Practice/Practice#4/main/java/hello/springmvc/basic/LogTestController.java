package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //RestController returns: return value itself as simple text not view name [test purpose]
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass()); //LOMBOOK DOES THIS

    @RequestMapping("/log-test")
    private  String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }

}