package jp.co.trustsystem.portfoliomanagementapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomTabPage2 extends Fragment {

    public BottomTabPage2() { }

    public static BottomTabPage2 newInstance() {
        BottomTabPage2 fragment = new BottomTabPage2();
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
        return inflater.inflate(R.layout.fragment_bottomtab_page2, container, false);
    }

}