package by.controller;

import by.dto.UserDTO;
import by.entity.Category;
import by.entity.User;
import by.manager.CategoryManager;
import by.manager.UserManager;
import by.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private CategoryManager categoryManager;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/login")
    public String userLogin(ModelMap map, UserDTO userDTO) {
        map.put("userDTO", new UserDTO());
        return "login";
    }

    @GetMapping("/registration")
    public String userRegistration(ModelMap map) {
        map.put("userDTO", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String userRegistration(@ModelAttribute @Valid UserDTO userDTO, BindingResult bindingResult, ModelMap map) {
        userValidator.validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            map.put("error", bindingResult);
            return "registration";
        }
        userManager.save(userManager.toUser(userDTO));
        log.info("Пользователь " + userDTO.getNickname() + " зарегестрировался");
        return "redirect:/login";
    }


    @GetMapping("/home")
    public String welcomeUser(Principal principal, ModelMap map) {
            User user = userManager.findByLogin(principal.getName());
        map.put("user",user);
        if (user.getRole().equals("ADMIN")){
            return "admin";
        }else {
            return "main";
        }
    }





}
