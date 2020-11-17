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
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.koscomapp.trada.R;

import java.util.ArrayList;
import java.util.List;

public class StatFragment extends Fragment {

    private LineChart linechart;
    private PieChart pieChartType, pieChartCap, pieChartVal;
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

                scrollView.scrollTo(0, 0);
                chartProfit.animateY(1000, Easing.EaseInOutCubic); //애니메이션

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView.scrollTo(0, 1450);
                //execute Chart Animation
                pieChartType.animateY(1000, Easing.EaseInOutCubic);
                pieChartCap.animateY(1000, Easing.EaseInOutCubic);
                pieChartVal.animateY(1000, Easing.EaseInOutCubic);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView.scrollTo(0, 2900);

                linechart.animateXY(2000, 2000);
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

        final List<Data> data3 = new ArrayList<>();
        data3.add(new Data(6, 98, "12-29"));
        data3.add(new Data(7, -72, "12-30"));
        data3.add(new Data(8, 105, "12-31"));
        data3.add(new Data(9, 105, "01-01"));
        data3.add(new Data(10, 12, "01-02"));

        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return data3.get(Math.min(Math.max((int) value, 0), data3.size() - 1)).xAxisValue;
            }
        });

        setData(data3);

        //PieChart Type example
        pieChartType = (PieChart) root.findViewById(R.id.piechartType);

        pieChartType.setUsePercentValues(true);
        pieChartType.getDescription().setEnabled(false);
        pieChartType.setExtraOffsets(5, 10, 5, 5);
        pieChartType.setRotationAngle(40.f);
        pieChartType.setDragDecelerationFrictionCoef(0.95f);

        pieChartType.setDrawHoleEnabled(false);
        pieChartType.setHoleColor(Color.WHITE);
        pieChartType.setTransparentCircleRadius(61f);
        pieChartType.setDrawEntryLabels(false);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();
        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(getResources().getColor(R.color.themecolor1));
        colors.add(getResources().getColor(R.color.themecolor2));
        colors.add(getResources().getColor(R.color.themecolor3));
        colors.add(getResources().getColor(R.color.blue));
        colors.add(getResources().getColor(R.color.themecolor5));


        yValues.add(new PieEntry(58.2f, "바이오"));
        yValues.add(new PieEntry(14.5f, "통신"));
        yValues.add(new PieEntry(11.3f, "철강"));
        yValues.add(new PieEntry(9.9f, "IT"));
        yValues.add(new PieEntry(6.3f, "석유화학"));

        pieChartType.animateY(1000, Easing.EaseInOutCubic); //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setValueLinePart1Length(0.8f);
        dataSet.setValueLinePart2Length(.8f);
        dataSet.setValueLinePart1OffsetPercentage(1.f);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setColors(colors);

        Legend l = pieChartType.getLegend();
        l.setForm(Legend.LegendForm.CIRCLE);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setXEntrySpace(7);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        l.setYEntrySpace(5);


        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);

        pieChartType.getLegend().setEnabled(true);

        pieChartType.setData(data);


        //PieChart Captial example
        pieChartCap = (PieChart) root.findViewById(R.id.piechartCap);

        pieChartCap.setUsePercentValues(true);
        pieChartCap.getDescription().setEnabled(false);
        pieChartCap.setExtraOffsets(5, 10, 5, 5);
        pieChartCap.setRotationAngle(40.f);
        pieChartCap.setDragDecelerationFrictionCoef(0.95f);

        pieChartCap.setDrawHoleEnabled(false);
        pieChartCap.setHoleColor(Color.WHITE);
        pieChartCap.setTransparentCircleRadius(61f);
        pieChartCap.setDrawEntryLabels(false);

        ArrayList<PieEntry> yValues1 = new ArrayList<PieEntry>();
        ArrayList<Integer> colors1 = new ArrayList<>();

        colors1.add(getResources().getColor(R.color.themecolor1));
        colors1.add(getResources().getColor(R.color.themecolor2));
        colors1.add(getResources().getColor(R.color.themecolor3));
        colors1.add(getResources().getColor(R.color.blue));


        yValues1.add(new PieEntry(45.3f, "대형주"));
        yValues1.add(new PieEntry(30.1f, "중형주"));
        yValues1.add(new PieEntry(13.1f, "소형주"));
        yValues1.add(new PieEntry(11.5f, "기타"));

        pieChartCap.animateY(1000, Easing.EaseInOutCubic); //애니메이션

        PieDataSet dataSet1 = new PieDataSet(yValues1, "");
        dataSet1.setSliceSpace(3f);
        dataSet1.setSelectionShift(5f);
        dataSet1.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet1.setValueLinePart1Length(0.8f);
        dataSet1.setValueLinePart2Length(.8f);
        dataSet1.setValueLinePart1OffsetPercentage(1.f);
        dataSet1.setValueTextColor(Color.BLACK);
        dataSet1.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet1.setColors(colors);

        Legend l1 = pieChartCap.getLegend();
        l1.setForm(Legend.LegendForm.CIRCLE);
        l1.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l1.setXEntrySpace(7);
        l1.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l1.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l1.setYEntrySpace(5);


        PieData data1 = new PieData(dataSet1);
        data1.setValueTextSize(10f);
        data1.setValueTextColor(Color.BLACK);

        pieChartCap.getLegend().setEnabled(true);

        pieChartCap.setData(data1);


        //PieChart Value example
        pieChartVal = (PieChart) root.findViewById(R.id.piechartVal);

        pieChartVal.setUsePercentValues(true);
        pieChartVal.getDescription().setEnabled(false);
        pieChartVal.setExtraOffsets(5, 10, 5, 5);
        pieChartVal.setRotationAngle(40.f);
        pieChartVal.setDragDecelerationFrictionCoef(0.95f);

        pieChartVal.setDrawHoleEnabled(false);
        pieChartVal.setHoleColor(Color.WHITE);
        pieChartVal.setTransparentCircleRadius(61f);
        pieChartVal.setDrawEntryLabels(false);

        ArrayList<PieEntry> yValues2 = new ArrayList<PieEntry>();
        ArrayList<Integer> colors2 = new ArrayList<>();

        colors2.add(getResources().getColor(R.color.themecolor1));
        colors2.add(getResources().getColor(R.color.themecolor2));


        yValues2.add(new PieEntry(70.4f, "가치주"));
        yValues2.add(new PieEntry(29.6f, "성장주"));

        pieChartVal.animateY(1000, Easing.EaseInOutCubic); //애니메이션

        PieDataSet dataSet2 = new PieDataSet(yValues2, "");
        dataSet2.setSliceSpace(3f);
        dataSet2.setSelectionShift(5f);
        dataSet2.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet2.setValueLinePart1Length(0.8f);
        dataSet2.setValueLinePart2Length(.8f);
        dataSet1.setValueLinePart1OffsetPercentage(1.f);
        dataSet2.setValueTextColor(Color.BLACK);
        dataSet2.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet2.setColors(colors2);

        Legend l2 = pieChartVal.getLegend();
        l2.setForm(Legend.LegendForm.CIRCLE);
        l2.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l2.setXEntrySpace(7);
        l2.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l2.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l2.setYEntrySpace(5);


        PieData data2 = new PieData(dataSet2);
        data2.setValueTextSize(10f);
        data2.setValueTextColor(Color.BLACK);

        pieChartVal.getLegend().setEnabled(true);

        pieChartVal.setData(data2);


        //Line Chart
        linechart = root.findViewById(R.id.chartCubic);
        linechart.setViewPortOffsets(0, 0, 0, 0);
        linechart.setBackgroundColor(Color.rgb(187, 134, 252));

        // no description text
        linechart.getDescription().setEnabled(false);

        // enable touch gestures
        linechart.setTouchEnabled(true);

        // enable scaling and dragging
        linechart.setDragEnabled(true);
        linechart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        linechart.setPinchZoom(false);

        linechart.setDrawGridBackground(false);
        linechart.setMaxHighlightDistance(300);

        XAxis x = linechart.getXAxis();
        x.setEnabled(false);

        YAxis y = linechart.getAxisLeft();
        y.setLabelCount(6, false);
        y.setTextColor(Color.WHITE);
        y.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        y.setDrawGridLines(false);
        y.setAxisLineColor(Color.WHITE);

        linechart.getAxisRight().setEnabled(false);

        linechart.getLegend().setEnabled(false);

        linechart.animateXY(2000, 2000);

        // don't forget to refresh the drawing
        setDataLine(20, 100);

        // redraw
        linechart.invalidate();
        //
        return root;
    }

    private void setData(List<Data> dataList) {

        ArrayList<BarEntry> values = new ArrayList<>();
        List<Integer> colors = new ArrayList<>();

        int green = Color.rgb(110, 190, 102);
        int red = Color.rgb(211, 74, 88);

        for (int i = 0; i < dataList.size(); i++) {

            Data d = dataList.get(i);
            BarEntry entry = new BarEntry(d.xValue, d.yValue);
            values.add(entry);

            // specific colors
            if (d.yValue >= 0)
                colors.add(red);
            else
                colors.add(green);
        }

        BarDataSet set;

        if (chartProfit.getData() != null &&
                chartProfit.getData().getDataSetCount() > 0) {
            set = (BarDataSet) chartProfit.getData().getDataSetByIndex(0);
            set.setValues(values);
            chartProfit.getData().notifyDataChanged();
            chartProfit.notifyDataSetChanged();
        } else {
            set = new BarDataSet(values, "Values");
            set.setColors(colors);
            set.setValueTextColors(colors);

            BarData data = new BarData(set);
            data.setValueTextSize(13f);
            //data.setValueTypeface(tfRegular);
            data.setValueFormatter(new ValueFormatter() {

            });
            data.setBarWidth(0.8f);

            chartProfit.setData(data);
            chartProfit.invalidate();
        }

        chartProfit.animateY(1000, Easing.EaseInOutCubic); //애니메이션
    }

    private class Data {

        final String xAxisValue;
        final float yValue;
        final float xValue;

        Data(float xValue, float yValue, String xAxisValue) {
            this.xAxisValue = xAxisValue;
            this.yValue = yValue;
            this.xValue = xValue;
        }
    }

    private void setDataLine(int count, float range) {

        ArrayList<Entry> values = new ArrayList<>();


        values.add(new Entry(0, 30));
        values.add(new Entry(1, 35));
        values.add(new Entry(2, 33));
        values.add(new Entry(3, 41));
        values.add(new Entry(4, 42));
        values.add(new Entry(5, 41));
        values.add(new Entry(6, 46));
        values.add(new Entry(7, 48));
        values.add(new Entry(8, 50));
        values.add(new Entry(9, 51));
        values.add(new Entry(10, 51));
        values.add(new Entry(11, 53));
        values.add(new Entry(12, 58));
        values.add(new Entry(13, 53));
        values.add(new Entry(14, 50));
        values.add(new Entry(15, 47));
        values.add(new Entry(16, 43));
        values.add(new Entry(17, 42));
        values.add(new Entry(18, 41));
        values.add(new Entry(19, 45));

        LineDataSet set1;

        if (linechart.getData() != null &&
                linechart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) linechart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            linechart.getData().notifyDataChanged();
            linechart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "DataSet 1");

            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set1.setCubicIntensity(0.2f);
            set1.setDrawFilled(true);
            set1.setDrawCircles(false);
            set1.setLineWidth(1.8f);
            set1.setCircleRadius(4f);
            set1.setCircleColor(Color.WHITE);
            set1.setHighLightColor(Color.rgb(244, 117, 117));
            set1.setColor(Color.WHITE);
            set1.setFillColor(Color.WHITE);
            set1.setFillAlpha(100);
            set1.setDrawHorizontalHighlightIndicator(false);
            set1.setFillFormatter(new IFillFormatter() {
                @Override
                public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                    return linechart.getAxisLeft().getAxisMinimum();
                }
            });

            // create a data object with the data sets
            LineData data = new LineData(set1);
            data.setValueTextSize(9f);
            data.setDrawValues(false);

            // set data
            linechart.setData(data);
        }
    }
}