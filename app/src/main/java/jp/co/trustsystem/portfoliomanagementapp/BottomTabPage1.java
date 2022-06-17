package jp.co.trustsystem.portfoliomanagementapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomTabPage1 extends Fragment {

    public BottomTabPage1() { }

    public static BottomTabPage1 newInstance() {
        BottomTabPage1 fragment = new BottomTabPage1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottomtab_page1, container, false);
    }
}