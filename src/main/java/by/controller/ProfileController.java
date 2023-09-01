package by.controller;

import by.dto.UserDTO;
import by.entity.User;
import by.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping
public class ProfileController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserManager userManager;

    @GetMapping("/profile")
    public String getProfile(Principal principal, ModelMap map, @RequestParam(value = "error", required = false) String error) {
        User user = userManager.findByLogin(principal.getName());
        map.put("user", user);
        return "profile";
    }

    @GetMapping("/profile/edit")
    public String editProfilePage(Principal principal, ModelMap map) {
        User user = userManager.findByLogin(principal.getName());
        map.put("userDTO", user);
        return "editProfile";
    }

    @PostMapping("/profile/edit")
    public String editProfile(@ModelAttribute UserDTO userDTO,ModelMap map, Principal principal) {
        User user = userManager.findByLogin(principal.getName());
        user.setId(user.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setNickname(userDTO.getNickname());
        user.setCountry(userDTO.getCountry());
        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(hashedPassword);
        user.setEmail(userDTO.getEmail());
        userManager.editUser(user);
        map.put("user", user);
        map.put("userDTO", new UserDTO());
        log.info("Пользователь " + userDTO.getName() + " изменил свои данные");
        return "redirect:/profile";
    }
}

