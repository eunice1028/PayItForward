package com.example.mag.cs321app;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.action.ViewActions.*;


import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.mag.cs321app", appContext.getPackageName());
    }

    private String mStringToBetyped;



    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
    }

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.emailField))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.emailField)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.emailField)) .check(matches(withText(mStringToBetyped)));
    }



    }
