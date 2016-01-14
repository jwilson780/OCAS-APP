package com.jack.ocas.instruments;

import android.os.Bundle;

import com.jack.ocas.R;

/**
 * Created by Jacob on 1/9/2016.
 */
public class Keyboard extends KeyboardFret{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String getSound(){return getResourceFileAsString(R.raw.keyboard);}
}
