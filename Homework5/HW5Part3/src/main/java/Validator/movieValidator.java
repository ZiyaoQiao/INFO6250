package Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class movieValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(POJO.Movie.class);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.title", "Title Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "error.invalid.actor", "actor Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "error.invalid.actress", "actress Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "error.invalid.genre", "genre Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "error.invalid.year", "year Required");
    }
}
