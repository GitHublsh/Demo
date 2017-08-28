package com.lsh.newedittext;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    NewEditText newEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newEditText = (NewEditText)findViewById(R.id.new_edit);
    }
}
