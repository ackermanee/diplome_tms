package by.validator;

import by.dto.UserDTO;
import by.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserManager userManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;

        if (userManager.findByLogin(user.getLogin())!=null){
            errors.rejectValue("login", "DUPLICATE","Логин уже занят");
        }
        if (userManager.findByEmail(user.getEmail())!=null){
            errors.rejectValue("email","DUPLICATE","Такая почта уже используется");
        }
        if (!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmPassword","DIFFERENT","Пароли не совпадают");
        }
    }
}
