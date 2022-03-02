package com.mobiquity.neel.customerservice.validator.annotation;


import com.mobiquity.neel.customerservice.validator.CustomerValidator;
import openapi.model.PatchCustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PatchCustomerRequestDtoValidation.ValidationConstraints.class})
public @interface PatchCustomerRequestDtoValidation {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "String is not in valid form.";

    @Component
    class ValidationConstraints implements ConstraintValidator<PatchCustomerRequestDtoValidation, PatchCustomerRequestDto> {

        @Autowired
        CustomerValidator customerValidator;

        @Override
        public void initialize(PatchCustomerRequestDtoValidation constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(PatchCustomerRequestDto patchCustomerRequestDto, ConstraintValidatorContext constraintValidatorContext) {
            customerValidator.validatePatchCustomerRequestDto(patchCustomerRequestDto);
            return true;
        }
    }
}
