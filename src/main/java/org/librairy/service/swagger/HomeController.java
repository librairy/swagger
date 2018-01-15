package org.librairy.service.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        return "redirect:api.html";
    }
}
