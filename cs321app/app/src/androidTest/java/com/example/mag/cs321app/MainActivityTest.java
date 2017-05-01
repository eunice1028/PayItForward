package com.example.mag.cs321app;


import android.content.Context;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import static android.support.test.espresso.intent.Intents.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.*;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;



import static org.junit.Assert.*;

/**
 *
 * Created by Maggie Li on 4/27/2017
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    public String mStringToBetyped;
    private static final String MESSAGE = "This is a test";
    private static final String PACKAGE_NAME = "com.example.mag.cs321app";


    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    public IntentsTestRule<MainActivity> mIntentsRule =
            new IntentsTestRule<>(MainActivity.class);


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.mag.cs321app", appContext.getPackageName());
    }


    @Test
    public void changeText_emailField() {
        // Type text and then press the button.
        onView(withId(R.id.emailField))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.emailField)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.emailField)).check(matches(withText(mStringToBetyped)));
    }

    @Test
    public void changeText_passwordField() {
        // Type text and then press the button.
        onView(withId(R.id.passwordField))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.passwordField)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.passwordField)).check(matches(withText(mStringToBetyped)));
    }

    @Test
    //verifies the text entered
    public void validateEmail() {
        onView(withId(R.id.emailField)).perform(typeText("abc@gmu.edu")).check(matches(withText("abc@gmu.edu")));
    }

    @Test
    public void validateEmailEmpty() {
        onView(withId(R.id.emailField)).perform(typeText("")).check(matches(withText("")));
    }

    @Test
    public void validatePassword() {
        onView(withId(R.id.passwordField)).perform(typeText("123456")).check(matches(withText("123456")));
    }

    @Test
    public void validatePasswordEmpty() {
        onView(withId(R.id.passwordField)).perform(typeText("")).check(matches(withText("")));
    }

    @Test
    public void buttonShouldNotUpdateText1(){
        onView(withId(R.id.emailField)).perform(click());
        onView(withId(R.id.emailField)).check(matches(withText("")));
    }

    @Test
    public void buttonShouldNotUpdateText2(){
        onView(withId(R.id.passwordField)).perform(click());
        onView(withId(R.id.passwordField)).check(matches(withText("")));
    }

    @Test
    public void clicksignUpBtn1() throws Exception{
        onView(withId(R.id.emailField)).perform(click());
        onView((withId(R.id.signUpBtn))).check(matches(isDisplayed()));
    }

    @Test
    public void clicksignUpBtn2() throws Exception{
        onView(withId(R.id.passwordField)).perform(click());
        onView((withId(R.id.signUpBtn))).check(matches(isDisplayed()));
    }

    @Test
    public void clicklogInBtn1() throws Exception{
        onView(withId(R.id.emailField)).perform(click());
        onView((withId(R.id.loginBtn))).check(matches(isDisplayed()));
    }

    @Test
    public void clicklogInBtn2() throws Exception{
        onView(withId(R.id.passwordField)).perform(click());
        onView((withId(R.id.loginBtn))).check(matches(isDisplayed()));
    }
}
