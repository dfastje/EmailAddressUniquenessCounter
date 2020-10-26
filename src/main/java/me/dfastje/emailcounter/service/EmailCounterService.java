package me.dfastje.emailcounter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class EmailCounterService {

    private static final Logger logger = LoggerFactory.getLogger(EmailCounterService.class);


    /**
     * Counts each unique email address
     * @param emailList
     * @return
     */
    public int countUniqueEmails(List<String> emailList ){
        Map<String, Integer> emailOccurrenceMap = new HashMap<>();

        for (String email: emailList) {
            String simplifiedEmail = emailSimplifier( email );

            if( emailOccurrenceMap.containsKey( simplifiedEmail ) ){
                emailOccurrenceMap.put( simplifiedEmail, emailOccurrenceMap.get(simplifiedEmail) + 1);
            } else {
                emailOccurrenceMap.put( simplifiedEmail, 1);
            }
        }

        int uniqueEmailCount = emailOccurrenceMap.size();
        return uniqueEmailCount;
    }

    /**
     * Return a list of emails. These are hard-coded and not backed by any DB
     *
     * @return
     */
    public List<String> getEmails(){
        List<String> emailList = new LinkedList<>();
        emailList.add("DFastjeWork@gmail.com");
        emailList.add("DFastje@gmail.com");
        emailList.add("D.Fastje@gmail.com");
        emailList.add(".DFastje@gmail.com");
        emailList.add("D..Fastje@gmail.com");
        emailList.add("DFastje+@gmail.com");
        emailList.add("DFastje++@gmail.com");
        emailList.add("DFastje+abcd@gmail.com");

        return emailList;
    }

    /**
     *  helper method used to simplify emails
     *      1) this will strip out '.' => test.email@gmail.com will convert into testemail@gmail.com
     *      2) this will strip out everything between the first '+' and a '@'
     *      3) this will remove case sensitivity
     * @param email
     * @return
     */
    private String emailSimplifier(String email){

        //1) Remove '.'
        email = email.replace(".", "");

        //2) Remove everything between first '+' and last '@'
        if ( email.contains("+") && email.contains("@") ){
            int locationOfPlus = email.indexOf("+");
            int locationOfAt = email.lastIndexOf("@");
            email = email.substring( 0, locationOfPlus ) + email.substring( locationOfAt, email.length() );
        }

        //3) remove case sensitivity
        email = email.toLowerCase();

        return email;
    }
}
