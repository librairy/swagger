package es.upm.oeg.librairy.service.swagger;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index(@RequestHeader HttpHeaders headers) {
//        headers.entrySet().stream().forEach( entry -> System.out.println("Header: " + entry.getKey() +" => " + entry.getValue()));

        String host = "http://"+headers.getFirst("host");
        String path = host.endsWith("/")? host + "api.html" : host+"/api.html";
        //String action = "redirect:"+path;
        String action = "redirect:/api.html";
//        System.out.println(action);
        return action;
    }
}
