package by.controller;


import by.entity.User;
import by.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/profile")
public class ProfileController {



    @Autowired
    private UserManager userManager;


    @GetMapping
    public String getStorage(Principal principal, ModelMap map,
        @RequestParam(value = "error", required = false) String error) {
        User user = userManager.findByLogin(principal.getName());
        map.put("user", user);
        return "profile";
    }


}

