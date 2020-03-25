package com.example.myquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {

    private RecyclerView recyclerView;

    private TextView tv;
    private HomeAdapter homeAdapter;
    private  RecyclerView.LayoutManager layoutManager;
    private List<HomeViewModel> homelist= new ArrayList<>();//without new it was giving null pointer exception

    public Home_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_home, container, false);
        tv = view.findViewById(R.id.tt);
        recyclerView = view.findViewById(R.id.rv);
        layoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setHasFixedSize(true);//
        recyclerView.setLayoutManager(layoutManager);
        homeAdapter = new HomeAdapter(getContext(),homelist);

        recyclerView.setAdapter(homeAdapter);
        prepareHomeData();
        return view;
    }

    private void prepareHomeData()
    {
        int[] images={R.drawable.download6,R.drawable.download2,R.drawable.download3,
                R.drawable.download4,R.drawable.download5
        };

       HomeViewModel a = new HomeViewModel(images[0],"Fact1");
       homelist.add(a);
       homelist.add(new HomeViewModel(images[1],"Fact2"));
        homelist.add(new HomeViewModel(images[2],"Fact3"));
        homelist.add(new HomeViewModel(images[3],"Fact4"));
        homelist.add(new HomeViewModel(images[4],"Fact5"));
    }
}



