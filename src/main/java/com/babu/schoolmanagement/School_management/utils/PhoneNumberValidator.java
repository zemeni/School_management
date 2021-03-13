package com.babu.schoolmanagement.School_management.utils;

import java.util.function.Predicate;


public class PhoneNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String phoneNumber) {
        return (phoneNumber.length()==12) &&
                phoneNumber.startsWith("+61");
    }
}
