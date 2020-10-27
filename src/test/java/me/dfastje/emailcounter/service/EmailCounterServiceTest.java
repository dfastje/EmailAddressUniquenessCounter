package me.dfastje.emailcounter.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class EmailCounterServiceTest {

    @Autowired
    private EmailCounterService emailCounterService;

    static class EmailCounterServiceProvider{
        @Bean
        public EmailCounterService emailCounterServiceProvider(){
            return new EmailCounterService();
        }
    }

    @Test
    void countUniqueEmails_PlusPeriodsAndCapsTest() {
        List<String> emailList = new LinkedList<>();
        emailList.add("DFastjeWork@gmail.com");
        emailList.add("DFastje@gmail.com");
        emailList.add("d.fastje@gmail.com");
        emailList.add(".DFastje@gmail.com");
        emailList.add("D..Fastje@gmail.com");
        emailList.add("DFastje+@gmail.com");
        emailList.add("DFastje++@gmail.com");
        emailList.add("DFastje+abcd@gmail.com");
        int expectedEmailCount = 2;

        int emailCount = emailCounterService.countUniqueEmails(emailList);
        Assertions.assertEquals( expectedEmailCount, emailCount );
    }

    @Test
    void countUniqueEmails_HappyPathTest() {
        List<String> emailList = new LinkedList<>();
        emailList.add("DFastjeWork@gmail.com");
        emailList.add("DFastje@gmail.com");
        int expectedEmailCount = 2;

        int emailCount = emailCounterService.countUniqueEmails(emailList);
        Assertions.assertEquals( expectedEmailCount, emailCount );
    }

    @Test
    void countUniqueEmails_EmptyListTest() {
        List<String> emailList = new LinkedList<>();
        int expectedEmailCount = 0;

        int emailCount = emailCounterService.countUniqueEmails(emailList);
        Assertions.assertEquals( expectedEmailCount, emailCount );
    }

}
