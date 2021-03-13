package com.babu.schoolmanagement.School_management.utils;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator phoneNumberValidator;

    @BeforeEach
    void setUp() {
        phoneNumberValidator = new PhoneNumberValidator();
    }


    @ParameterizedTest
    @CsvSource({
            "+61452555806,true",
            "+614525558061,false",
            "+51452555806,false"
    })
    void validatePhoneNumber(String phoneNumber, boolean expected) {
        //When
        boolean isValid = phoneNumberValidator.test(phoneNumber);
        //Then
        assertThat(isValid).isEqualTo(expected);
    }
}
