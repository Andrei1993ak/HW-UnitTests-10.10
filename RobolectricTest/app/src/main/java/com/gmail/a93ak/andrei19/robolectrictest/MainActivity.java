package com.gmail.a93ak.andrei19.robolectrictest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button button;
    public SetterButtonVisibility visibilitySetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        visibilitySetter = new SetterButtonVisibility();
    }

    public void setButtonVisibility() {
        if(visibilitySetter.isButtonVisible())
            button.setVisibility(View.VISIBLE);
        else
            button.setVisibility(View.INVISIBLE);
    }

    public class SetterButtonVisibility {
        public boolean isButtonVisible(){
            return Calendar.getInstance().get(Calendar.SECOND) >= 30;
        }
    }

}
