package com.example.movierecord.controller;

import com.example.movierecord.domain.User;
import com.example.movierecord.domain.UserRepository;
import com.example.movierecord.form.UserForm;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    /**
     * get the registration page
     * @param model
     * @return
     */
    @GetMapping("/register")
    public String login(Model model){
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    /**
     * submit one registration request
     * @param userForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult bindingResult){
        if(!userForm.confirmPassword()){
            bindingResult.rejectValue("confirmPassword", "confirmError", "The password is not match");
        }
        if(bindingResult.hasErrors()){
            return "register";
        }
        User user = convertToUser(userForm);
        userRepository.save(user);
        return "redirect:/login";
    }

    /**
     * get the login page
     * @return
     */
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    /**
     * submit the login request, if success, redirect to the movies page
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String loginAccount(@RequestParam String username, @RequestParam String password){
        User user = userRepository.findUserByUsername(username);
        if(user == null){
            return "redirect:/login";
        }
        if(!user.getPassword().equals(password)){
            return "redirect:/login";
        }
        return "redirect:/movies";
    }

    /**
     * convert the UserForm object to the User object
     * @param userForm
     * @return
     */
    private User convertToUser(UserForm userForm){
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return user;
    }
}
