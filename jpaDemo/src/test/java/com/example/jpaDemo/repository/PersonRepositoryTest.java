package com.example.jpaDemo.repository;

import com.example.jpaDemo.JpaDemoApplicationTests;
import com.example.jpaDemo.model.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Optional;

@WebAppConfiguration
public class PersonRepositoryTest extends JpaDemoApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public  void create(){
        Person p = new Person();
        p.setName("kim");
        p.setEmail("kim@nate.com");
        p.setCreateAt(LocalDateTime.now());
        p.setCreateBy("Test");

        System.out.println(p.toString());
        personRepository.save(p);
    }


    @Test
    public void read(){
        Optional<Person> person = personRepository.findById(1);

        Assertions.assertTrue(person.isPresent());

        //Person p;
        person.ifPresent(p ->{
            System.out.println(p);
        });

        System.out.println("종료~!");
    }

    @Test
    public void update(){
        Optional<Person> person = personRepository.findById(2);

        Assertions.assertTrue(person.isPresent());

        //Person p;
        person.ifPresent(p ->{
           p.setName("kkkkkk");
           personRepository.save(p);
        });


    }

    @Test
    public void delete(){
        Optional<Person>person= personRepository.findById(2);
        person.ifPresent(p ->{
            personRepository.delete(p);
        });

    }
}
