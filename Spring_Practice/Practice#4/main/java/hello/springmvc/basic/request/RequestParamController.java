package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@Slf4j
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}", username);
        log.info("age={}", age);

        response.getWriter().write("ok");
    }

    @ResponseBody //Directly insert return string into http body not returning to viewname
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge) {

        log.info("username={}, age={}", memberName, memberAge);

        return "ok";
    }

    @ResponseBody //Directly insert return string into http body not returning to viewname
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age) {

        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody //Directly insert return string into http body not returning to view name
    @RequestMapping("/request-param-v4")
    //@RequestParam annotation can be skipped when name of request parameter is same as variable name
    //and when the variable is the fundamental data type(String, int, integer...)
    public String requestParamV4(String username, int age) {

        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody //Directly insert return string into http body not returning to view name
    @RequestMapping("/request-param-required")
    //@RequestParam annotation can be skipped when name of request parameter is same as variable name
    //and when the variable is the fundamental data type(String, int, integer...)
    public String requestParamRequired(@RequestParam(required = false) String username, @RequestParam(required = false)  Integer age) {

        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody //Directly insert return string into http body not returning to view name
    @RequestMapping("/request-param-default")
    //@RequestParam annotation can be skipped when name of request parameter is same as variable name
    //and when the variable is the fundamental data type(String, int, integer...)
    public String requestParamDefault(@RequestParam(required = false, defaultValue = "guest") String username,
                                      @RequestParam(required = false, defaultValue = "-1")  Integer age) {

        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody //Directly insert return string into http body not returning to view name
    @RequestMapping("/request-param-map")
    //@RequestParam annotation can be skipped when name of request parameter is same as variable name
    //and when the variable is the fundamental data type(String, int, integer...)
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
