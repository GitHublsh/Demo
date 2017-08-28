package com.lsh.newedittext;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by liushihan on 2017/8/27.
 */

public class NewEditText extends EditText implements TextWatcher, View.OnFocusChangeListener {
    public NewEditText(Context context) {
        super(context);
        initListener();
    }

    public NewEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initListener();
    }

    public NewEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initListener();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NewEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initListener() {
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.e("beforeTextChanged", s.toString());
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.e("onTextChanged", s.toString());
        if (s.length() > 11) {
            this.setText("");
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.e("afterTextChanged", s.toString());
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            Log.e("hasFocus", this.getText().length() + "");
        } else {
            Log.e("lostFocus",this.getText().length() + "");
            if (!(this.getText().length() == 7 || this.getText().length() == 8 || this.getText().length() == 11 || this.getText().length() == 12)) {
                this.setText("");
                this.setHint("仅限输入7、8、11位电话");
            }
        }
    }
}
