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

    /**
     * Counts each unique email address
     *
     * Notes:
     *      1) this method will strip out '.' => test.email@gmail.com will convert into testemail@gmail.com
     *      2) this method will strip out everything between the first '+' and a '@'
     *      3) this method will remove case sensitivity
     *      4) this method will NOT validate that an email address is properly formatted
     *
     * @param emailList - EX: ["dfastje@gmail.com","dfastje.work@gmail.com"]
     * @return integer representing the number of unique email addresses input into the endpoint
     */
    @PostMapping(value = "/countUniqueEmails")
    public int countUniqueEmails(@RequestBody List<String> emailList ){
        int numUniqueEmails = emailCounterService.countUniqueEmails( emailList );
        return numUniqueEmails;
    }

}
