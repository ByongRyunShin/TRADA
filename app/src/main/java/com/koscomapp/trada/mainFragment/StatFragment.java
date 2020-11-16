package com.koscomapp.trada.mainFragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.koscomapp.trada.R;

import java.util.ArrayList;

public class StatFragment extends Fragment {

    PieChart pieChartType;
    private BarChart chartProfit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_stat, container, false);

        // Inflate the layout for this fragment
        ScrollView scrollView = (ScrollView) root.findViewById(R.id.scrollView);
        Button button1 = (Button) root.findViewById(R.id.btn_stat1);
        Button button2 = (Button) root.findViewById(R.id.btn_stat2);
        Button button3 = (Button) root.findViewById(R.id.btn_stat3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView.scrollTo(0,0);


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView.scrollTo(0,1450);
                //execute Chart Animation
                pieChartType.animateY(1000, Easing.EaseInOutCubic);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView.scrollTo(0,2900);


            }
        });

        //barchart Negative Positive Example
        chartProfit = root.findViewById(R.id.barChartNP);
        chartProfit.setBackgroundColor(Color.WHITE);
        chartProfit.setExtraTopOffset(-30f);
        chartProfit.setExtraBottomOffset(10f);
        chartProfit.setExtraLeftOffset(70f);
        chartProfit.setExtraRightOffset(70f);

        chartProfit.setDrawBarShadow(false);
        chartProfit.setDrawValueAboveBar(true);

        chartProfit.getDescription().setEnabled(false);

        // scaling can now only be done on x- and y-axis separately
        chartProfit.setPinchZoom(false);

        chartProfit.setDrawGridBackground(false);

        XAxis xAxis = chartProfit.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //xAxis.setTypeface(tfRegular);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setTextColor(Color.LTGRAY);
        xAxis.setTextSize(13f);
        xAxis.setLabelCount(5);
        xAxis.setCenterAxisLabels(true);
        xAxis.setGranularity(1f);

        YAxis left = chartProfit.getAxisLeft();
        left.setDrawLabels(false);
        left.setSpaceTop(25f);
        left.setSpaceBottom(25f);
        left.setDrawAxisLine(false);
        left.setDrawGridLines(false);
        left.setDrawZeroLine(true); // draw a zero line
        left.setZeroLineColor(Color.GRAY);
        left.setZeroLineWidth(0.7f);
        chartProfit.getAxisRight().setEnabled(false);
        chartProfit.getLegend().setEnabled(false);
/*
        final List<Data> data = new ArrayList<>();
        data.add(new Data(0f, -224.1f, "12-29"));
        data.add(new Data(1f, 238.5f, "12-30"));
        data.add(new Data(2f, 1280.1f, "12-31"));
        data.add(new Data(3f, -442.3f, "01-01"));
        data.add(new Data(4f, -2280.1f, "01-02"));

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return data.get(Math.min(Math.max((int) value, 0), data.size()-1)).xAxisValue;
            }
        });

        setData(data);
*/


        //PieChart example
        pieChartType = (PieChart)root.findViewById(R.id.piechartType);

        pieChartType.setUsePercentValues(true);
        pieChartType.getDescription().setEnabled(false);
        pieChartType.setExtraOffsets(5,10,5,5);

        pieChartType.setDragDecelerationFrictionCoef(0.95f);

        pieChartType.setDrawHoleEnabled(false);
        pieChartType.setHoleColor(Color.WHITE);
        pieChartType.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(34f,"Japen"));
        yValues.add(new PieEntry(23f,"USA"));
        yValues.add(new PieEntry(14f,"UK"));
        yValues.add(new PieEntry(35f,"India"));
        yValues.add(new PieEntry(40f,"Russia"));
        yValues.add(new PieEntry(40f,"Korea"));

        //우측 레이블
        Description description = new Description();
        description.setText("세계 국가"); //라벨
        description.setTextSize(15);
//        pieChartType.setDescription(description);

        pieChartType.animateY(1000, Easing.EaseInOutCubic); //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues,"Countries");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChartType.getLegend().setEnabled(false);

        pieChartType.setData(data);

        //
        return root;
    }
}