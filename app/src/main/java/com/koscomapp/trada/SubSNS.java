package com.koscomapp.trada;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by user on 2016-12-23.
 */

public class SubSNS extends LinearLayout{

    public SubSNS(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public SubSNS(Context context) {
        super(context);

        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_sns_card,this,true);
    }
}