package jp.co.trustsystem.portfoliomanagementapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class BottomTabPagerAdapter extends FragmentStateAdapter {

    public BottomTabPagerAdapter(MainActivity fragment) {
        super(fragment);
    }

    /**
     * 指定されたタブの位置(position) に対応するタブページ（Fragment）を作成する
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;

        if (position == 0) {
            fragment = new BottomTabPage1();
        } else if (position == 1) {
            fragment = new BottomTabPage2();
        } else if (position == 2) {
            fragment = new BottomTabPage3();
        }

        return fragment;
    }

    /**
     * タブの数を返す
     */
    @Override
    public int getItemCount() {
        return 3;
    }
}