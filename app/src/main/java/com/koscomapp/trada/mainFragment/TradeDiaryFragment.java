package com.koscomapp.trada.mainFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.koscomapp.trada.DiaryDetailActivity;
import com.koscomapp.trada.R;
import com.koscomapp.trada.SNSDetailActivity;
import com.koscomapp.trada.Sub;
import com.koscomapp.trada.http.APIClient;
import com.koscomapp.trada.http.APIInterface;
import com.koscomapp.trada.http.OpenAPIManager;
import com.koscomapp.trada.http.ResultMarketIndex;
import com.koscomapp.trada.http.ResultStockPrice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TradeDiaryFragment extends Fragment {
    ArrayList<String> arr;
    TextView temp;
    OpenAPIManager apiManager = new OpenAPIManager();

    String[][] datastr= {{"삼성전자","SK텔레콤","현대차","네이버","신풍제약","에코프로비엠", "빅히트"},
            {"(+3.4%)","(-2.2%)","(+9.4%)","(+3.5%)","(+1.2%)","(+3.4%)","(+4.7%)"},
            {"+3,860","-12,560","98,720","54,100","28,720","8,500","940"},
            {"다음에는 조급증을 버리고 매수 타이밍을 더 신중하게 잡을 것 ",
                    "매도한 종목이 그 이후로도 계속 오르는 중. 향후에는 보유기간을 늘리도록.",
                    "장기 투자 목적. 내년 2분기 실적 발표 후 매도할 것.",
                    "배당 기대로 인한 상승. 배당락일 전에 매도할 것.",
                    "매도한 종목이 그 이후로도 계속 오르는 중. 향후에는 보유기간을 늘리도록.",
                    "장기 투자 목적. 내년 2분기 실적 발표 후 매도할 것.",
                    "배당 기대로 인한 상승. 배당락일 전에 매도할 것."
            },
            {"63,100","209,500","177,500","284,000","123,400","333,000","112,335"},
            {"매수가: 59,240","매수가: 214,000","매수가: 150,500","매수가: 261,200","매수가: 233,400","매수가: 444,000","매수가: 222,000"},
            {"20/11/05","20/11/04","20/11/03","20/11/03","20/11/03","20/11/02","20/11/01"},
            {"005930","017670","005380","035420","019170","068270","352820"}
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_trade_diary, container, false);
        //Type here
        LinearLayout linearLayout = (LinearLayout)root.findViewById(R.id.mydiary_linerLayout);

        TextView kospitv = (TextView) root.findViewById(R.id.textView20);
        TextView kosdaqtv = (TextView) root.findViewById(R.id.textView22);

        APIInterface api = APIClient.getListApiService();

        Call<ResultMarketIndex> call = api.getMarketIndex("kospi", "l7xxf5913ee4b7714c5eb5b18224a2e5e23e");

        call.enqueue(new Callback<ResultMarketIndex>() {
            @Override
            public void onResponse(Call<ResultMarketIndex> call, Response<ResultMarketIndex> response) {

                if(response.isSuccessful()) {
                    ResultMarketIndex result = response.body();
                    kospitv.setText(result.getMarketDetail().getTrdPrc());
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResultMarketIndex> call, Throwable t) {
                Toast.makeText(getContext(),"onFailure",Toast.LENGTH_SHORT).show();
            }
        });

        call = api.getMarketIndex("kosdaq", "l7xxf5913ee4b7714c5eb5b18224a2e5e23e");

        call.enqueue(new Callback<ResultMarketIndex>() {
            @Override
            public void onResponse(Call<ResultMarketIndex> call, Response<ResultMarketIndex> response) {

                if(response.isSuccessful()) {
                    ResultMarketIndex result = response.body();
                    kosdaqtv.setText(result.getMarketDetail().getTrdPrc());
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResultMarketIndex> call, Throwable t) {
                Toast.makeText(getContext(),"onFailure",Toast.LENGTH_SHORT).show();
            }
        });

        Sub cardview = new Sub(getActivity().getApplicationContext());
        Sub cardview2 = new Sub(getActivity().getApplicationContext());
        Sub cardview3 = new Sub(getActivity().getApplicationContext());
        Sub cardview4 = new Sub(getActivity().getApplicationContext());
        Sub cardview5 = new Sub(getActivity().getApplicationContext());
        Sub cardview6 = new Sub(getActivity().getApplicationContext());
        Sub cardview7 = new Sub(getActivity().getApplicationContext());

        Sub[] cardviewset = {cardview, cardview2,cardview3,cardview4,cardview5,cardview6,cardview7};
        arr=new ArrayList<String>();
        for(int i=0; i<7; i++){
            Call<ResultStockPrice> call2 = api.getStockConclusionPrice("kospi", datastr[7][i], "l7xxf5913ee4b7714c5eb5b18224a2e5e23e");

            call2.enqueue(new Callback<ResultStockPrice>() {
                @Override
                public void onResponse(Call<ResultStockPrice> call, Response<ResultStockPrice> response) {

                    if(response.isSuccessful()) {
                        ResultStockPrice result = response.body();
                        arr.add(result.getStockDetail().getTrdPrc());
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

        for(int i=0;i<7;i++) {

            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_name)).setText(datastr[0][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_percent)).setText(datastr[1][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_return)).setText(datastr[2][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_memo)).setText(datastr[3][i]);




            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_price)).setText(datastr[5][i]);
            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_date)).setText(datastr[6][i]);


            ((TextView) cardviewset[i].findViewById(R.id.custom_tv_percent)).setTextColor(getResources().getColor(R.color.red));
            ((ImageView) cardviewset[i].findViewById(R.id.custom_iv)).setBackgroundResource(R.drawable.icon_buy);
            ((ImageView) cardviewset[i].findViewById(R.id.custom_iv_arrow)).setBackgroundResource(R.drawable.up);

        }

        ((TextView) cardview2.findViewById(R.id.custom_tv_percent)).setTextColor(getResources().getColor(R.color.blue));
        ((ImageView) cardview2.findViewById(R.id.custom_iv)).setBackgroundResource(R.drawable.icon_sell);
        ((ImageView) cardview2.findViewById(R.id.custom_iv_arrow)).setBackgroundResource(R.drawable.down);

        ((TextView) cardview5.findViewById(R.id.custom_tv_percent)).setTextColor(getResources().getColor(R.color.blue));
        ((ImageView) cardview5.findViewById(R.id.custom_iv)).setBackgroundResource(R.drawable.icon_sell);
        ((ImageView) cardview5.findViewById(R.id.custom_iv_arrow)).setBackgroundResource(R.drawable.down);


        linearLayout.addView(cardview);
        linearLayout.addView(cardview2);
        linearLayout.addView(cardview3);
        linearLayout.addView(cardview4);
        linearLayout.addView(cardview5);
        linearLayout.addView(cardview6);
        linearLayout.addView(cardview7);


        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(getActivity().getBaseContext(), DiaryDetailActivity.class);
                startActivity(intent);
            }
        });

        getActivity().runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(500);
                            for(int i=0; i<7; i++) {
                                ((TextView) cardviewset[i].findViewById(R.id.custom_tv_curprice)).setText(datastr[4][i]);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        return root;
    }


}