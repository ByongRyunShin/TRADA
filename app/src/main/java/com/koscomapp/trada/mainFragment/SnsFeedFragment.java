package com.koscomapp.trada.mainFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.koscomapp.trada.R;
import com.koscomapp.trada.SNSDetailActivity;
import com.koscomapp.trada.SubSNS;
import com.koscomapp.trada.http.APIClient;
import com.koscomapp.trada.http.APIInterface;
import com.koscomapp.trada.http.ResultStockPrice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SnsFeedFragment extends Fragment {
    Handler m;
    ArrayList<String> tarr;
    ArrayList<String> tarr2;
    SubSNS cardview2;
    SubSNS cardview3;
    SubSNS cardview4;
    SubSNS[] cardviewset;
    TextView temp;

    String[][] datastr= {{"삼성전자","신풍제약", "에코프로비엠"},
            {"005930","352820", "068270"},
            {"KOSPI","KOSPI", "코스닥"},
            {"▲","▲","▲"},
            {"10.6","12.3","0.0"},
            {"59,400","105,000","144,800"},
            {"20","100","25"},
            {"매도가","현재가","현재가"},
            {"65,700","126,000","144,800"},
            {
             "매도한 종목이 그 이후로도 계속 오르는 중. \n향후에는 보유기간을 늘리도록. ", 
                "코로나 재료 유효. \n거래량 급등. 볼린저밴드 상단 돌파",
                "장기 투자 목적. \n" + "내년 2분기 실적 발표 후 매도할 것."},
            {"GoGoGo", "HanRiver","JuRinYi"},
            {"20/11/04","20/11/03","20/11/03"},
            {"#우량주 #성장주 #기업분석","#차트분석 #단타 #급등주","#코스닥 #장기투자"}
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sns_feed, container, false);
        // Inflate the layout for this fragment
        LinearLayout linearLayout = (LinearLayout) root.findViewById(R.id.SNS_LinearLayout);

        m= new Handler();
        cardview2 = new SubSNS(getActivity().getApplicationContext());
        cardview3 = new SubSNS(getActivity().getApplicationContext());
        cardview4 = new SubSNS(getActivity().getApplicationContext());

        cardviewset = new SubSNS[4];
        cardviewset[0]=cardview2;
        cardviewset[1]=cardview3;
        cardviewset[2]=cardview4;

        APIInterface api = APIClient.getListApiService();

        SubSNS cardview = new SubSNS(getActivity().getApplicationContext());
        // name.setText(datastr[0][0]);
        linearLayout.addView(cardview);
        tarr=new ArrayList<String>();
        tarr2=new ArrayList<String>();

        for(int i=0; i<3; i++){
            Call<ResultStockPrice> call2 = api.getStockConclusionPrice("kospi", datastr[1][i], "l7xxf5913ee4b7714c5eb5b18224a2e5e23e");

            call2.enqueue(new Callback<ResultStockPrice>() {
                @Override
                public void onResponse(Call<ResultStockPrice> call, Response<ResultStockPrice> response) {

                    if(response.isSuccessful()) {
                        ResultStockPrice result = response.body();
                        tarr.add(result.getStockDetail().getTrdPrc());
                        tarr2.add(result.getStockDetail().getIsuSrtCd());
                        //Toast.makeText(getContext(),result.getStockDetail().getTrdPrc(), Toast.LENGTH_LONG ).show();
                    } else {
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<ResultStockPrice> call, Throwable t) {
                    Toast.makeText(getContext(),"onFailure",Toast.LENGTH_SHORT).show();
                }
            });
        }

        for(int i=0;i<3;i++) {

            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_name)).setText(datastr[0][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_code)).setText(datastr[1][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_market)).setText(datastr[2][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_icon)).setText(datastr[3][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_return_num)).setText(datastr[4][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_buy_price_num)).setText(datastr[5][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_buy_count_num)).setText(datastr[6][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_now_price)).setText(datastr[7][i]);



            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_comment)).setText(datastr[9][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_user_name)).setText(datastr[10][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_ago_time)).setText(datastr[11][i]);
            ((TextView) cardviewset[i].findViewById(R.id.cs_tv_hash)).setText(datastr[12][i]);

        }
        linearLayout.addView(cardview2);



        linearLayout.addView(cardview3);
        linearLayout.addView(cardview4);

        ((ImageView) cardview.findViewById(R.id.cs_iv_user_face)).setBackgroundResource(R.drawable.profile3);
        ((ImageView) cardview2.findViewById(R.id.cs_iv_user_face)).setBackgroundResource(R.drawable.profile4);
        ((ImageView) cardview3.findViewById(R.id.cs_iv_user_face)).setBackgroundResource(R.drawable.profile5);
        ((ImageView) cardview4.findViewById(R.id.cs_iv_user_face)).setBackgroundResource(R.drawable.profile6);

        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(getActivity().getBaseContext(), SNSDetailActivity.class);
                startActivity(intent);
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1500);
                m.post(new Runnable() {
                    public void run() {
                        for(int i=0; i<3; i++) {
                            for(int j=0; j<3; j++){
                                if(!tarr2.get(j).equals(datastr[1][i])){
                                    ((TextView) cardviewset[i].findViewById(R.id.cs_tv_now_price_num)).setText(tarr.get(j));
                                }
                            }
                        }
                    }
                });
            }
        }).start();
        return root;
    }
}