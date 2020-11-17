package com.koscomapp.trada.mainFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koscomapp.trada.MainActivity;
import com.koscomapp.trada.R;
import com.koscomapp.trada.SNSDetailActivity;
import com.koscomapp.trada.SubSNS;

public class SnsFeedFragment extends Fragment {

    String[][] datastr= {{"삼성전자","신풍제약","에코프로비엠", "빅히트"},
            {"005930","019170","247540", "352820"},
            {"KOSPI","KOSPI","KOSPI", "KOSPI"},
            {"▲","▲","▲"},
            {"33.2","12.3","14.5"},
            {"123,400","333,000","112,335"},
            {"20","100","25"},
            {"233,400","444,000","222,000"},
            {"매도한 종목이 그 이후로도 계속 오르는 중. 향후에는 보유기간을 늘리도록. ",
                    "장기 투자 목적. \n" +
                            "내년 2분기 실적 발표 후 매도할 것.",
                    "배당 기대로 인한 상승. 배당락일 전에 매도할 것."},
            {"GoGoGo", "HanRiver","JuRinYi"},
            {"20/11/04","20/11/03","20/11/03"},
            {"#우량주 #성장주 #기업분석","#KOSPI #장기투자","#차트분석 #단타 #급등주"}
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sns_feed, container, false);
        // Inflate the layout for this fragment
        LinearLayout linearLayout = (LinearLayout) root.findViewById(R.id.SNS_LinearLayout);

        SubSNS cardview = new SubSNS(getActivity().getApplicationContext());
        // name.setText(datastr[0][0]);
        linearLayout.addView(cardview);

        SubSNS cardview2 = new SubSNS(getActivity().getApplicationContext());
        SubSNS cardview3 = new SubSNS(getActivity().getApplicationContext());
        SubSNS cardview4 = new SubSNS(getActivity().getApplicationContext());

        SubSNS[] cardviewset = {cardview2,cardview3,cardview4};

        for(int i=0;i<3;i++) {

            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_1)).setText(datastr[0][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_2)).setText(datastr[1][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_3)).setText(datastr[2][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_4)).setText(datastr[3][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_5)).setText(datastr[4][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_8)).setText(datastr[5][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_10)).setText(datastr[6][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_12)).setText(datastr[7][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_13)).setText(datastr[8][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_14)).setText(datastr[9][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_15)).setText(datastr[10][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_16)).setText(datastr[11][i]);

        }
        linearLayout.addView(cardview2);
        linearLayout.addView(cardview3);
        linearLayout.addView(cardview4);

        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(getActivity().getBaseContext(), SNSDetailActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}