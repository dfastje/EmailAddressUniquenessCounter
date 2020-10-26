package me.dfastje.emailcounter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class TempController {

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public @ResponseBody String getHelloWorld(){
        String helloWorld = "HelloWorld";
        return helloWorld;
    }
}
