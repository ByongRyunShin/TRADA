package com.koscomapp.trada.mainFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koscomapp.trada.R;
import com.koscomapp.trada.Sub;

public class TradeDiaryFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_trade_diary, container, false);
        //Type here
        LinearLayout linearLayout = (LinearLayout)root.findViewById(R.id.mydiary_linerLayout);

        Sub cardview = new Sub(getActivity().getApplicationContext());

        linearLayout.addView(cardview);

        Sub cardview2 = new Sub(getActivity().getApplicationContext());
        Sub cardview3 = new Sub(getActivity().getApplicationContext());
        Sub cardview4 = new Sub(getActivity().getApplicationContext());


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

        return root;
    }
}