package com.koscomapp.trada;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyDiaryActivity extends AppCompatActivity {

/*

    String [] name= {"SK텔레콤","현대차","네이버"};
    String [] percent= {"(+2.2%)","(+9.4%)","(+3.5%)"};
    String [] returns= {"12,560","98,720","54,100"};
    String [] memo= {"매도한 종목이 그 이후로도 계속 오르는 중. 향후에는 보유기간을 늘리도록. ",
            "장기 투자 목적. \n" +
                    "내년 2분기 실적 발표 후 매도할 것.",
            "배당 기대로 인한 상승. 배당락일 전에 매도할 것."};
    String [] curprice= {"229,500","177,500","284,000"};
    String [] price= {"매수가: 214,000","매수가: 150,500","매수가: 261,200"};
    String [] date= {"20/11/04","20/11/03","20/11/03"};
    String [] code= {"017670 KOSPI","005380 KOSPI","018120 KOSPI"};

*/

    String[][] datastr= {{"SK텔레콤","현대차","네이버"},
        {"(+2.2%)","(+9.4%)","(+3.5%)"},
        {"12,560","98,720","54,100"},
        {"블라블라블발 ",
                "블발블아 \n" +
                        "블라블라",
                "블라라어앙"},
        {"229,500","177,500","284,000"},
        {"매수가: 214,000","매수가: 150,500","매수가: 261,200"},
        {"20/11/04","20/11/03","20/11/03"},
        {"017670 KOSPI","005380 KOSPI","018120 KOSPI"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydiary);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.mydiary_linerLayout);

        Sub cardview = new Sub(getApplicationContext());
       // name.setText(datastr[0][0]);
        linearLayout.addView(cardview);

        Sub cardview2 = new Sub(getApplicationContext());
        Sub cardview3 = new Sub(getApplicationContext());
        Sub cardview4 = new Sub(getApplicationContext());


        Sub[] cardviewset = {cardview2,cardview3,cardview4};



        for(int i=0;i<3;i++) {

                ((TextView) cardviewset[i].findViewById(R.id.custom_tv_name)).setText(datastr[0][i]);
                ((TextView) cardviewset[i].findViewById(R.id.custom_tv_percent)).setText(datastr[1][i]);
                ((TextView) cardviewset[i].findViewById(R.id.custom_tv_return)).setText(datastr[2][i]);
                 ((TextView) cardviewset[i].findViewById(R.id.custom_tv_memo)).setText(datastr[3][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_curprice)).setText(datastr[4][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_price)).setText(datastr[5][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_date)).setText(datastr[6][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_code)).setText(datastr[7][i]);

        }


        linearLayout.addView(cardview2);
        linearLayout.addView(cardview3);
        linearLayout.addView(cardview4);


    }
}

