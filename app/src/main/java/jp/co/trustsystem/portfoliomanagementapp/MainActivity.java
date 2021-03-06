package jp.co.trustsystem.portfoliomanagementapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //PieChartクラス作成
        pieChart = findViewById(R.id.activity_main_piechart);
        setupPieChart();
        loadPieChartData();

        // ViewPagerをアダプタに関連付ける
        ViewPager2 pager = (ViewPager2)findViewById(R.id.pager);
        BottomTabPagerAdapter adapter = new BottomTabPagerAdapter(this);
        pager.setAdapter(adapter);

        // TabLayoutとViewPagerを関連付ける
        TabLayout tabs = (TabLayout)findViewById(R.id.tab_layout);
        String tabTitleArray[] = {"投資比率", "リターン", "リスク"};
        new TabLayoutMediator(tabs, pager,
                (tab, position) -> tab.setText(tabTitleArray[position])
        ).attach();

    }
    //PieChartのSet関数定義
    private void setupPieChart() {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("ポートフォリオ比率");
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(false);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }
    //PieChartのload関数定義
    private void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.2f, "Food & Dining"));
        entries.add(new PieEntry(0.15f, "Medical"));
        entries.add(new PieEntry(0.10f, "Entertainment"));
        entries.add(new PieEntry(0.25f, "Electricity and Gas"));
        entries.add(new PieEntry(0.3f, "Housing"));

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        for (int color: ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries, "Expense Category");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1400, Easing.EaseInOutQuad);
    }


    public void changeText1(View view) {
        //保有金額取得
        //1
        EditText edit1 = (EditText)findViewById(R.id.kingaku1);
        Editable getText1 = edit1.getText();
        int amount1 = Integer.parseInt(getText1.toString());
        //2
        EditText edit2 = (EditText)findViewById(R.id.kingaku2);
        Editable getText2 = edit2.getText();
        int amount2 = Integer.parseInt(getText2.toString());
        //3
        EditText edit3 = (EditText)findViewById(R.id.kingaku3);
        Editable getText3 = edit3.getText();
        int amount3 = Integer.parseInt(getText3.toString());

        int sum = amount1+amount2+amount3;

        //保有比率
        //1
        TextView txt1 = (TextView) findViewById(R.id.hiritsu1);
        int ratio1 = 100 * amount1 / sum;
        String text1 = String.valueOf(ratio1);
        txt1.setText(text1);
        //2
        TextView txt2 = (TextView) findViewById(R.id.hiritsu2);
        int ratio2 = 100 * amount2 / sum;
        String text2 = String.valueOf(ratio2);
        txt2.setText(text2);
        //3
        TextView txt3 = (TextView) findViewById(R.id.hiritsu3);
        int ratio3 = 100 * amount3 / sum;
        String text3 = String.valueOf(ratio3);
        txt3.setText(text3);

//        // inflate
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View view2 = inflater.inflate(R.layout.fragment_bottomtab_page2, null);
//        //1
//        TextView txt1_2 = view2.findViewById(R.id.hiritsu1);
//        txt1_2.setText("aaa");

        //xmlに移動し、文字を入力
        setContentView(R.layout.fragment_bottomtab_page2);
        TextView txt4 = (TextView) findViewById(R.id.hiritsu1);
        txt4.setText(text1);
        TextView txt5 = (TextView) findViewById(R.id.hiritsu2);
        txt5.setText(text2);
        TextView txt6 = (TextView) findViewById(R.id.hiritsu3);
        txt6.setText(text3);

//        setContentView(R.layout.activity_main);
//
//        // ViewPagerをアダプタに関連付ける
//        ViewPager2 pager = (ViewPager2)findViewById(R.id.pager);
//        BottomTabPagerAdapter adapter = new BottomTabPagerAdapter(this);
//        pager.setAdapter(adapter);
//
//        // TabLayoutとViewPagerを関連付ける
//        TabLayout tabs = (TabLayout)findViewById(R.id.tab_layout);
//        String tabTitleArray[] = {"投資比率", "リターン", "リスク"};
//        new TabLayoutMediator(tabs, pager,
//                (tab, position) -> tab.setText(tabTitleArray[position])
//        ).attach();

    }


    public void changeText2(View view) {
        //リターン取得
        //1
        EditText edit1 = (EditText)findViewById(R.id.return1);
        Editable getText1 = edit1.getText();
        int return1 = Integer.parseInt(getText1.toString());
        //2
        EditText edit2 = (EditText)findViewById(R.id.return2);
        Editable getText2 = edit2.getText();
        int return2 = Integer.parseInt(getText2.toString());
        //3
        EditText edit3 = (EditText)findViewById(R.id.return3);
        Editable getText3 = edit3.getText();
        int return3 = Integer.parseInt(getText3.toString());

        //保有比率取得
        //1
        TextView txt1 = (TextView) findViewById(R.id.hiritsu1);
        String text1 = txt1.getText().toString();
        double ratio1 = Double.valueOf(text1.toString()).doubleValue() / 100;
        //2
        TextView txt2 = (TextView) findViewById(R.id.hiritsu2);
        String text2 = txt2.getText().toString();
        double ratio2 = Double.valueOf(text2.toString()).doubleValue() / 100;
        //3
        TextView txt3 = (TextView) findViewById(R.id.hiritsu3);
        String text3 = txt3.getText().toString();
        double ratio3 = Double.valueOf(text3.toString()).doubleValue() / 100;
//
        //平均リターン算出
        double ave_return = return1*ratio1 + return2*ratio2 + return3*ratio3;
        TextView txt4 = (TextView) findViewById(R.id.ave_return);
        String text = String.format("%.3f", ave_return);
        txt4.setText(text);

    }

    public void changeText3(View view) {
        //リスク取得
        //1
        EditText edit1 = (EditText)findViewById(R.id.risk1);
        Editable getText1 = edit1.getText();
        int risk1 = Integer.parseInt(getText1.toString());
        //2
        EditText edit2 = (EditText)findViewById(R.id.risk2);
        Editable getText2 = edit2.getText();
        int risk2 = Integer.parseInt(getText2.toString());
        //3
        EditText edit3 = (EditText)findViewById(R.id.risk3);
        Editable getText3 = edit3.getText();
        int risk3 = Integer.parseInt(getText3.toString());

        //保有比率取得
        //1
        TextView txt1 = (TextView) findViewById(R.id.hiritsu1);
        String text1 = txt1.getText().toString();
        double ratio1 = Double.valueOf(text1.toString()).doubleValue() / 100;
        //2
        TextView txt2 = (TextView) findViewById(R.id.hiritsu2);
        String text2 = txt2.getText().toString();
        double ratio2 = Double.valueOf(text2.toString()).doubleValue() / 100;
        //3
        TextView txt3 = (TextView) findViewById(R.id.hiritsu3);
        String text3 = txt3.getText().toString();
        double ratio3 = Double.valueOf(text3.toString()).doubleValue() / 100;
//
        //平均リターン算出
        double total_risk = Math.sqrt(Math.pow(risk1, 2.0)*Math.pow(ratio1, 2.0) + Math.pow(risk2, 2.0)*Math.pow(ratio2, 2.0) + Math.pow(risk3, 2.0)*Math.pow(ratio3, 2.0));
        TextView txt4 = (TextView) findViewById(R.id.total_risk);
        String text = String.format("%.3f", total_risk);
        txt4.setText(text);

    }
}