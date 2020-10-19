package com.okten.JavaAdvanced.validator;

import com.okten.JavaAdvanced.dao.UserDao;
import com.okten.JavaAdvanced.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;

@Component
public class UniqueUserEmailValidator implements Validator {
   private final UserDao userDao;

   @Autowired
   public UniqueUserEmailValidator(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public boolean supports(Class<?> aClass) {
      return User.class.isAssignableFrom(aClass);
   }

   @Override
   public void validate(@Valid Object o, Errors errors) {
      User user = (User) o;
      if (user.getEmail() != null && user.getEmail().trim().length() > 0){
         if (userDao.existsByEmail(user.getEmail())){
            errors.rejectValue("name","user.email.unique", "Email must be unique!!!");
         }
      }
   }
}

