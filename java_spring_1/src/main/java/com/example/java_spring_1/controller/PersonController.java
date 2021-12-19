package com.example.java_spring_1.controller;


import com.example.java_spring_1.forms.PersonForm;
import com.example.java_spring_1.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping
public class PersonController {
    private static List<Person> persons = new ArrayList<Person>();
    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(PersonController.class);
    static {
        persons.add(new Person("Jemmy", "Heringhton"));
        persons.add(new Person("Maxim", "Dobryi"));
    }

    //Вводится (inject) из application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", message);
        log.info("/index was called");
        return modelAndView;
    }

    @RequestMapping(value = {"/allpersons"}, method = RequestMethod.GET)
    public ModelAndView personList(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("personlist");
        model.addAttribute("persons", persons);
        return modelAndView;
    }

    @RequestMapping(value = {"/addperson"}, method = RequestMethod.GET)
    public ModelAndView showAddPersonPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("addperson");
        PersonForm personForm = new PersonForm();
        model.addAttribute("personform", personForm);
        return modelAndView;
    }
    //@PostMapping("/addbook")
    //GetMapping("/")
    @RequestMapping(value = {"/addperson"}, method = RequestMethod.POST)
    public ModelAndView savePerson(Model model, //
                                   @ModelAttribute("personform") PersonForm personForm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("personlist");
        String name = personForm.getName();
        String surname = personForm.getSurname();
        if (name != null && name.length() > 0 //
                && name != null && name.length() > 0) {
            Person newPerson = new Person(name, surname);
            persons.add(newPerson);
            model.addAttribute("persons",persons);
            return modelAndView;
        }
        model.addAttribute("errorMessage", errorMessage);
        modelAndView.setViewName("addperson");
        return modelAndView;
    }
    //Edit
    @GetMapping(value = {"/editperson/{id}"})
    public ModelAndView showEditPersonPage(Model model, @PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("editperson");
        Person person = persons.get(id);
        PersonForm personForm = new PersonForm(person.getName(), person.getSurname());
        model.addAttribute("personform", personForm);

        return  modelAndView;
    }

    @PostMapping(value = {"/editperson/{id}"})
    public ModelAndView EditPerson(Model model, @PathVariable(value = "id") int id, @ModelAttribute("personform") PersonForm personForm) {
        ModelAndView modelAndView = new ModelAndView("personlist");
        Person person = persons.get(id);
        person.setName(personForm.getName());
        person.setSurname(personForm.getSurname());
        model.addAttribute("persons", persons);

        return  modelAndView;
    }
    //delete
    @PostMapping(value = {"/deleteperson/{id}"})
    public ModelAndView deletePerson(Model model, @PathVariable(value = "id") int id){
        ModelAndView modelAndView = new ModelAndView("personlist");
        Person person = persons.remove(id);
        model.addAttribute("persons", persons);

        return  modelAndView;
    }
}