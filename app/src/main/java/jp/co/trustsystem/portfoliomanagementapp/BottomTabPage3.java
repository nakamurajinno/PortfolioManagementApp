package jp.co.trustsystem.portfoliomanagementapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomTabPage3 extends Fragment {

    public BottomTabPage3() { }

    public static BottomTabPage3 newInstance() {
        BottomTabPage3 fragment = new BottomTabPage3();
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
        return inflater.inflate(R.layout.fragment_bottomtab_page3, container, false);
    }
}