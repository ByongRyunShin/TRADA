package com.koscomapp.trada;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by user on 2016-12-23.
 */

public class Sub extends LinearLayout{

    public Sub(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }
    public Sub(Context context) {
        super(context);

        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_cardview,this,true);
    }
}