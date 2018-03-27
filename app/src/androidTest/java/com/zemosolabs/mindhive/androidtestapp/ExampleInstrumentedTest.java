package com.zemosolabs.mindhive.androidtestapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Instrumented test, which will execute on an Android device.
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.zemosolabs.mindhive.androidtestapp", appContext.getPackageName());
    }

    @Test
    public void testMainActivityComponents() throws Exception {
        MainActivity mainActivity = mainActivityTestRule.getActivity();

        //checking the views
        View welcomeViewRaw  = mainActivity.findViewById(R.id.welcome_content);
        assertThat(welcomeViewRaw, notNullValue());
        assertThat(welcomeViewRaw, instanceOf(TextView.class));
        TextView welcomeView = (TextView) welcomeViewRaw;

        //checking the strings
        String text = mainActivity.getResources().getString(R.string.large_text);
        assertEquals("Checking the content", welcomeView.getText().toString(), text);
    }
}
