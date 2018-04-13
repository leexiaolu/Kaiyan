package com.example.leesnriud.kaiyan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OneFragment extends Fragment {
    private TextView textView;

    public OneFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        String title= (String) getArguments().get("title");
        textView = view.findViewById(R.id.txt_title);
        textView.setText(title);
    }
}
