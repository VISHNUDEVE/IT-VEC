package com.example.itvec.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.itvec.R;

import java.util.ArrayList;
import java.util.List;


public class aboutFragment extends Fragment {

    private ViewPager viewPager;
    private branchadapter adapter;
    private List<branchmodel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new branchmodel(R.drawable.ic_computer_,"Information Technology", "Information Technology is one of the best departments in Velammal Engineering College"));
        list.add(new branchmodel(R.drawable.ic_mech,"Mechanical Engineering", "Mechanical Engineering was started at 2014 ,Where more than 200 students placed in core companies"));

        adapter=new branchadapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

       Glide.with(getContext())
               .load("https://firebasestorage.googleapis.com/v0/b/vec-app-3d56e.appspot.com/o/home.jpg?alt=media&token=1e03ab0c-e112-4646-a3d8-b2078359f7bb")
               .into(imageView);


        return view;
    }
}