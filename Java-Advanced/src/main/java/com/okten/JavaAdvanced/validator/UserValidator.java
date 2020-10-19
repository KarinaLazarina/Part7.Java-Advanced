package com.okten.JavaAdvanced.validator;

import com.okten.JavaAdvanced.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(@Valid Object o, Errors errors) {
        User user = (User) o;
        if (user.getName() != null && user.getName().trim().length() > 0){
            if (user.getName().charAt(0) < 65 || user.getName().charAt(0) > 90){
                errors.rejectValue("name","user.name.capital-letter", "Name must start with capital letter!!!");
            }
        }
    }
}
