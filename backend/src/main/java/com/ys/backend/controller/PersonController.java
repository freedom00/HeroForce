package com.ys.backend.controller;

import com.ys.backend.entity.Mail;
import com.ys.backend.entity.Person;
import com.ys.backend.service.PersonService;
import com.ys.backend.utilities.MailHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Person")
public class PersonController {
    @Autowired
    PersonService personService;

    @Value("${HeroForce.myEmailAccount}")
    private String myEmailAccount;
    @Value("${HeroForce.myEmailPassword}")
    private String myEmailPassword;
    @Value("${HeroForce.myEmailSmtpHost}")
    private String myEmailSmtpHost;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Person save(@RequestBody Person person) {
        System.out.println("------------------------------------------");
        System.out.println(person);
        System.out.println("------------------------------------------");

        if (person.getIsMessageOnBirthday()) {
            Mail mail = new Mail();
            mail.setFromPersonal("HERO FORCE");
            mail.setTo(person.getEmail());
            mail.setToPersonal(person.getFirstName());
            mail.setSubject("HERO FORCE SIGN UP");
            mail.setContent(person.toString());
            try {
                new MailHelper(myEmailAccount, myEmailPassword, myEmailSmtpHost).sendMail(mail);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return personService.create(person);
    }
}
