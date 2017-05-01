package com.example.mag.cs321app;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by eunicewang on 4/30/17.
 */

@RunWith(AndroidJUnit4.class)
public class CreateAccountTest {

    @Rule
    public final ActivityTestRule<CreateAccountActivity> rule =
            new ActivityTestRule<>(CreateAccountActivity.class);

    @Test
    public void enterInfo1() {
        Intent i = new Intent();

        rule.launchActivity(i);

        String email = "jsmith23@gmail.com";
        String password = "cs321";
        String confirmedPassword = "cs321";
        String firstname = "John";
        String lastname = "Smith";
        onView(withId(R.id.emailField)).perform(typeText(email), closeSoftKeyboard());
        onView(withId(R.id.passwordField)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.confirmPasswordField)).perform(typeText(confirmedPassword), closeSoftKeyboard());
        onView(withId(R.id.firstnameField)).perform(typeText(firstname), closeSoftKeyboard());
        onView(withId(R.id.lastnameField)).perform(typeText(lastname), closeSoftKeyboard());

        onView(withId(R.id.submitBtn)).perform(click());


    }
}
