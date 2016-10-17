package org.seckill.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saplmm on 2016/10/17.
 */

@Controller
public class HelloController {

    @RequestMapping(value = "hello")
    public String hello() {
        return "hello";
    }
}
