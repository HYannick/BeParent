package com.example.yhous.beparent;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yhous on 22/11/2017.
 */

public class TestingConvert extends AppCompatActivity {
    Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Typeface titleTypeFace = Typeface.createFromAsset(mContext.getAssets(), "fonts/JosefinSans-Bold.ttf");
    }
}
