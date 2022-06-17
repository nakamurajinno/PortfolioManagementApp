package jp.co.trustsystem.portfoliomanagementapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}