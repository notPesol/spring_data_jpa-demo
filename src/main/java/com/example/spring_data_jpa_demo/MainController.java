package com.example.spring_data_jpa_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PersonRepository repository;

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/showAllPerson'>Show All Person</a></li>";
        html += " <li><a href='/searchPerson'>Search Person Name = 'Baby'</a></li>";
        html += " <li><a href='/insertPerson'>Insert Person Name = 'Kim Jisoo'</a></li>";
        html += " <li><a href='/deletePerson'>Delete Person Name = 'Zara Obama'</a></li>";
        html += "</ul>";
        return html;
    }

    @ResponseBody
    @RequestMapping("/showAllPerson")
    public String showAllPerson() {
        Iterable<Person> person = repository.findAll();

        StringBuilder html = new StringBuilder();

        for (Person emp : person) {
            html.append(emp).append("<br>");
        }

        html.append("<br><a href='/'>Back To Home Page</a>");

        return html.toString();
    }

    @ResponseBody
    @RequestMapping("/searchPerson")
    public String searchPerson() {
        StringBuilder html = new StringBuilder("Test Search Person Name = 'David'<br>");
        List<Person> person = repository.findByFirstNameOrLastName("Baby", "Baby");

        if (person != null) {
            for (Person emp : person) {
                html.append(emp).append("<br>");
            }
        }

        html.append("<br><a href='/'>Back To Home Page</a>");
        return html.toString();
    }

    @ResponseBody
    @RequestMapping("/insertPerson")
    public String insertPerson() {
        String html = "Test Insert Person Name = 'Kim Jisoo'<br>";
        Person person = new Person("Kim", "Jisoo");
        repository.save(person);
        html += "Inserted: " + person + "<br><br><a href='/'>Back To Home Page</a>";
        return html;
    }

    @ResponseBody
    @RequestMapping("/deletePerson")
    public String deletePerson() {
        String html = "Test delete Person Name = 'Zara Obama'<br>";
        List<Person> person = this.repository.findByFirstNameAndLastName("Zara", "Obama");
        if (person != null && !person.isEmpty()) {
            //this.personRepository.deleteById(person.get(0).getId());
            this.repository.delete(person.get(0));
        }
        html += "Deleted: 'Zara Obama' <br><br><a href='/'>Back To Home Page</a> <br><br>";
        return html;
    }
}
