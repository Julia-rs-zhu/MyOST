package com.example.myost;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class tab04Fragment extends Fragment {
    private Button button;

    public tab04Fragment() {
        // Required empty public constructor
    }
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab04, container, false);
        button=view.findViewById(R.id.button2);
        context = this.getActivity();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, MainActivity4.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "zrs");
                intent1.putExtras(bundle);
                startActivityForResult(intent1, 1);
            }
        });
        return view;
    }

}










