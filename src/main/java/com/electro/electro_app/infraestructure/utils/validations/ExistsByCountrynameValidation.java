package com.electro.electro_app.infraestructure.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;

import com.electro.electro_app.application.service.ICountryService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistsByCountrynameValidation implements ConstraintValidator<ExistsByCountryname, String> {
    
    @Autowired
    private ICountryService countryService;

    @Override
    public boolean isValid(String countryname, ConstraintValidatorContext context) {
        if(countryService == null){
            return true;
        }

        return !countryService.existsByCountryname(countryname);
    }


}
