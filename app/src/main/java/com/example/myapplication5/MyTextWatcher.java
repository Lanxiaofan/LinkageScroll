package com.example.myapplication5;

import android.text.Editable;
import android.text.TextWatcher;

public class MyTextWatcher implements TextWatcher {
    private OnCallback callback;
    private int index;
    private int line;

    public MyTextWatcher(int index,int line,OnCallback callback){
        this.callback = callback;
        this.index = index;
        this.line = line;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String str = editable.toString().trim();
        callback.callback(index,line,str);
    }

    public interface OnCallback{
        void callback(int index,int line,String str);
    }
}
