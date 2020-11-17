package com.koscomapp.trada.mainFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koscomapp.trada.R;
import com.koscomapp.trada.Sub;

public class TradeDiaryFragment extends Fragment {

    String[][] datastr= {{"삼성전자","SK텔레콤","현대차","네이버"},
            {"(+3.4%)","(-2.2%)","(+9.4%)","(+3.5%)"},
            {"+3,860","-12,560","98,720","54,100"},
            {"다음에는 조급증을 버리고 매수 타이밍을 더 신중하게 잡을 것 ",
                    "매도한 종목이 그 이후로도 계속 오르는 중. 향후에는 보유기간을 늘리도록.",
                    "장기 투자 목적. 내년 2분기 실적 발표 후 매도할 것.",
                    "배당 기대로 인한 상승. 배당락일 전에 매도할 것."
            },
            {"63,100","209,500","177,500","284,000"},
            {"매수가: 59,240","매수가: 214,000","매수가: 150,500","매수가: 261,200"},
            {"20/11/05","20/11/04","20/11/03","20/11/03"},
            {"035420 KOSPI","017670 KOSPI","005380 KOSPI","018120 KOSPI"}
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_trade_diary, container, false);
        //Type here
        LinearLayout linearLayout = (LinearLayout)root.findViewById(R.id.mydiary_linerLayout);

        Sub cardview = new Sub(getActivity().getApplicationContext());
        Sub cardview2 = new Sub(getActivity().getApplicationContext());
        Sub cardview3 = new Sub(getActivity().getApplicationContext());
        Sub cardview4 = new Sub(getActivity().getApplicationContext());


        Sub[] cardviewset = {cardview, cardview2,cardview3,cardview4};


        for(int i=0;i<4;i++) {

            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_name)).setText(datastr[0][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_percent)).setText(datastr[1][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_return)).setText(datastr[2][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_memo)).setText(datastr[3][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_curprice)).setText(datastr[4][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_price)).setText(datastr[5][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_date)).setText(datastr[6][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_code)).setText(datastr[7][i]);

            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_percent)).setTextColor(getResources().getColor(R.color.red));
            ((ImageView) cardviewset[i].findViewById(R.id.custom_iv)).setBackgroundResource(R.drawable.icon_buy);
            ((ImageView) cardviewset[i].findViewById(R.id.custom_iv_arrow)).setBackgroundResource(R.drawable.up);

        }

        ((TextView) cardview2.findViewById(R.id.custom_tv_percent)).setTextColor(getResources().getColor(R.color.blue));
        ((ImageView) cardview2.findViewById(R.id.custom_iv)).setBackgroundResource(R.drawable.icon_sell);
        ((ImageView) cardview2.findViewById(R.id.custom_iv_arrow)).setBackgroundResource(R.drawable.down);

        linearLayout.addView(cardview);
        linearLayout.addView(cardview2);
        linearLayout.addView(cardview3);
        linearLayout.addView(cardview4);

        return root;
    }
}