package com.codegym.model;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class Email implements Validator {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Email.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Email email = (Email) target;
        String e = email.getEmail();
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");

        if (!e.matches("(^[A-Za-z0-9+_.-]+@(.+)$)")){
            errors.rejectValue("email", "email.matches");
        }
    }
}