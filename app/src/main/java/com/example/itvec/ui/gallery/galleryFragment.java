package com.example.itvec.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itvec.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class galleryFragment extends Fragment {

    RecyclerView placementrecycler,studentrecyler,facultiesrecycler;
    GalleryAdapter adapter;

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("gallery");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        placementrecycler=view.findViewById(R.id.placementRecycler);
        studentrecyler=view.findViewById(R.id.studentRecycler);
        facultiesrecycler=view.findViewById(R.id.facultiesRecycler);


        getPlaceimage();
        
        getStudentimage();

        getFacultimage();
        
        return view;

    }

    private void getFacultimage() {
        reference.child("Faculties Acheivements").addValueEventListener(new ValueEventListener() {
            List<String> imageList =  new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                   String data = (String) snapshot.getValue();
                   Log.d("Data",data);
                   imageList.add(data);
               }

               adapter = new GalleryAdapter(getContext(),imageList);
               facultiesrecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
               facultiesrecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getStudentimage() {
        reference.child("Students Acheivements").addValueEventListener(new ValueEventListener() {
            List<String> imageList =  new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                studentrecyler.setLayoutManager(new GridLayoutManager(getContext(),3));
                studentrecyler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getPlaceimage() {
        reference.child("Placement Acheivements").addValueEventListener(new ValueEventListener() {
            List<String> imageList =  new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                placementrecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                placementrecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}