package com.norbertcseh.cabackend.Controller;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.norbertcseh.cabackend.Entity.User;
import com.norbertcseh.cabackend.Exception.*;
import com.norbertcseh.cabackend.Service.UserService;
import com.norbertcseh.cabackend.Service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
public class HomeController {

    private UserServiceImpl userService;

    @Autowired
    private MessageSource messageSource;

    @Autowired // Implementasiont kéne használni !!!!!!
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    // @GetMapping("/")
    // public String landingPage(@RequestHeader(name = "Accept-Language", required =
    // false) Locale locale) {
    // return messageSource.getMessage("welcome", null, locale);
    // }

    // @GetMapping("/")
    // public String landingPage() {
    // return "Welcome";
    // }

    @GetMapping("/users")
    public List<User> allUser() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            throw new NoUserException("There is no user on this site yet!");
        }
        return users;
    }

    @GetMapping("/users/{handle}")
    public Resource<User> userByHandle(@PathVariable(name = "handle") String handle) {
        User user = userService.findByHandle(handle);
        if (user == null) {
            throw new UserNotFoundException("Handle: " + handle);
        }

        // Link to all Users
        Resource<User> resource = new Resource<User>(user);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).allUser());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Object> newUser(@Valid @RequestBody User user) {

        userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{handle}")
    public void deleteByHandle(String handle) {
    }

}