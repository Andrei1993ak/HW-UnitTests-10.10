package com.gmail.a93ak.andrei19.robolectrictest;

import android.widget.Button;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ButtonVisibilityTest {

    private MainActivity activity;
    private Button button;

    @Before
    public void init() {
        activity = Robolectric.setupActivity(MainActivity.class);
        activity.visibilitySetter = Mockito.mock(MainActivity.SetterButtonVisibility.class);
        button = (Button) activity.findViewById(R.id.button);
    }

    @Test
    public void checkForButtonVisible() {
        Mockito.when(activity.visibilitySetter.isButtonVisible()).thenReturn(true);
        activity.setButtonVisible();
        assertEquals(Button.VISIBLE, button.getVisibility());
    }

    @Test
    public void checkForButtonInvisible() {
        Mockito.when(activity.visibilitySetter.isButtonVisible()).thenReturn(false);
        activity.setButtonVisible();
        assertEquals(Button.INVISIBLE, button.getVisibility());
    }
}