package com.lavalliere.daniel.aps;

import java.util.*;
import static org.junit.Assert.*;

import com.lavalliere.daniel.aps.PasswordValidator;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class PasswordValidatorTest {
    private PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    public void IsValid_GivenValidInputs_ThenRejectsNone() {
        List<String> validInputs = Arrays.asList("Abcd123$", "Aa1@#$%&$");
        List<String> rejectedInputs = retrievePasswordsWithExpectedResult(validInputs, false);

        assertThat(String.format("Valid password was not accepted: %s", rejectedInputs), rejectedInputs.size(), is(0));
    }

    @Test
    public void IsValid_GivenInvalidInputs_ThenAcceptsNone() {
        List<String> invalidInputs = Arrays.asList("Abcd12$ ", "Abcdefghjhfj", "abcd123$", "Abcd1234", "12345678");
        List<String> acceptedInputs = retrievePasswordsWithExpectedResult(invalidInputs, true);

        assertThat(String.format("Invalid password were accepted: %s", acceptedInputs), acceptedInputs.size(), is(0));
    }

    public List<String> retrievePasswordsWithExpectedResult(List<String> inputs, boolean expectedResult) {
        List<String> passwordsWithExpectedResult = new ArrayList<>();
        for (String cInput : inputs) {
            boolean success = passwordValidator.isValid(cInput);
            if (success == expectedResult) {
                passwordsWithExpectedResult.add(cInput);
            }
        }

        return passwordsWithExpectedResult;
    }

}
