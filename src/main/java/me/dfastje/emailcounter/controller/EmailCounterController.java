package me.dfastje.emailcounter.controller;

import me.dfastje.emailcounter.service.EmailCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmailCounterController {

    EmailCounterService emailCounterService;

    @Autowired
    EmailCounterController(EmailCounterService emailCounterService){
        this.emailCounterService = emailCounterService;
    }

    @PostMapping(value = "/countUniqueEmails")
    public int countUniqueEmails(@RequestBody List<String> emailList ){
        int numUniqueEmails = emailCounterService.countUniqueEmails( emailList );
        return numUniqueEmails;
    }

}
