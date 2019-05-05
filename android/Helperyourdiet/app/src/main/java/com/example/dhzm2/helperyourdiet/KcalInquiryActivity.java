package com.example.dhzm2.helperyourdiet;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KcalInquiryActivity extends AppCompatActivity {

    private LineChart lineChart;
    User member ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kcal_inquiry);


        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String getTime;
        getTime = sdf.format(date);

        member = User.getInstance();

        lineChart = (LineChart)findViewById(R.id.chart);

        List<Entry> entries = new ArrayList<>();
        try{
            CustomTask userFoodTask = new CustomTask("kcalInquiry.jsp");
            String ss = userFoodTask.execute("userID=" + member.getUserID() + "&date=" + getTime).get();
            userFoodTask.cancel(true);

            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
            String[] splitStr = ss.split("`");
            for(String temp : splitStr){
                String[] splitTemp = temp.split(",");
                String dday = splitTemp[0];
                String[] day = dday.split("-");
                String kcal = splitTemp[1];
                int intDay = Integer.parseInt(day[2]);
                if(!arrayList.contains(intDay)){
                    arrayList.add(intDay);
                    arrayList2.add(Integer.parseInt(kcal));
                }
                else {
                    int i = arrayList.indexOf(intDay);
                    int h = arrayList2.get(i);
                    h += Integer.parseInt(kcal);
                    arrayList2.set(i,h);
                }
            }
            for(int i = 0  ; i < arrayList.size() ; i++){

                entries.add(new Entry(arrayList.get(i),arrayList2.get(i)));
            }
        }catch (Exception e){

        }


        LineDataSet lineDataSet = new LineDataSet(entries, "섭취 칼로리");
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setCircleColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setCircleColorHole(Color.BLUE);
        lineDataSet.setColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(false);

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLACK);
        xAxis.enableGridDashedLine(8, 24, 0);

        YAxis yLAxis = lineChart.getAxisLeft();
        yLAxis.setTextColor(Color.BLACK);

        YAxis yRAxis = lineChart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(false);

        Description description = new Description();
        description.setText("");

        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setDescription(description);
        lineChart.animateY(2000, Easing.EasingOption.EaseInCubic);
        lineChart.invalidate();

        MyMarkerView marker = new MyMarkerView(this,R.layout.activity_my_marker_view);
        marker.setChartView(lineChart);
        lineChart.setMarker(marker);





    }
}
