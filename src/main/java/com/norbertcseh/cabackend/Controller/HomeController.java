package com.norbertcseh.cabackend.Controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.norbertcseh.cabackend.Entity.User;
import com.norbertcseh.cabackend.Exception.NoUserException;
import com.norbertcseh.cabackend.Exception.UserNotFoundException;
import com.norbertcseh.cabackend.Service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController()
public class HomeController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    private MessageSource messageSource;

    @Autowired // Implementasiont kéne használni !!!!!!
    public void setUserServiceImp(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
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
        List<User> users = userServiceImpl.findAll();
        if (users.isEmpty()) {
            throw new NoUserException("There is no user on this site yet!");
        }

        return users;
    }

    @GetMapping("/users/{handle}")
    public Resource<User> userByHandle(@PathVariable(name = "handle") String handle) {
        User user = userServiceImpl.findByHandle(handle);
        if (user == null) {
            throw new UserNotFoundException("Handle: " + handle);
        }

        // Link to all Users
        Resource<User> resource = new Resource<User>(user);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).allUser());
        resource.add(linkTo.withRel("all-users"));

        // Filtering

        // MappingJacksonValue mapping = new MappingJacksonValue(resource);
        // SimpleBeanPropertyFilter filter =
        // SimpleBeanPropertyFilter.filterOutAllExcept("fullName", "email");
        // FilterProvider filterProvider = new
        // SimpleFilterProvider().addFilter("passwordFilter", filter);
        // mapping.setFilters(filterProvider);

        // return mapping;
        return resource;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Object> newUser(@Valid @RequestBody User user) {

        userServiceImpl.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{handle}")
    public User deleteByHandle(@RequestParam(name = "handle") String handle) {
        return userServiceImpl.deleteUserByHandle(handle);
    }

}