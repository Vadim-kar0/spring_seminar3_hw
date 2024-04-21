package ru.gb.seminar3_hw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.seminar3_hw.domain.User;
import ru.gb.seminar3_hw.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().findAll();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        return service.processRegistration(user.getName(),user.getAge(),user.getEmail());
    }

    @PostMapping("/param")
    @ResponseBody
    public String userAddFromParam(@RequestParam("name") String name
                                    ,@RequestParam("age") int age
                                    ,@RequestParam("email") String email){
        return service.processRegistration(name,age,email);
    }

}