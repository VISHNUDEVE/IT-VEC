package com.example.itvec.ui.notice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.itvec.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class noticeFragment extends Fragment {

    private RecyclerView Deletenoticerecycler;
    private ProgressBar progressBar;
    private ArrayList<noticeData> list;
    private noticeadapter Adapter;

    private DatabaseReference reference;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        Deletenoticerecycler = view.findViewById(R.id.deletenoticerecycler);
        progressBar = view.findViewById(R.id.progessBar);

        reference = FirebaseDatabase.getInstance().getReference().child("Notice");

        Deletenoticerecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        Deletenoticerecycler.setHasFixedSize(true);

        getNotice();

        return view;
    }

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 : datasnapshot.getChildren()){
                    noticeData data = snapshot1.getValue(noticeData.class);
                    list.add(data);

                }

                Adapter = new noticeadapter(getContext(),list);
                Adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                Deletenoticerecycler.setAdapter(Adapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}