package com.example.itvec.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.itvec.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;


public class homeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);


        setSliderViews();

        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmap();
            }
        });

        return view;
    }

    private void openmap() {
        Uri uri = Uri.parse("geo:0, 0?q=Velammal Engineering College Ambatur Chennai");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        for(int i = 0;i < 3;i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                case 0:
                  sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/vec-app-3d56e.appspot.com/o/cmp1.jpg?alt=media&token=6c637662-13b0-4694-b2e3-86b722559ede");
                  break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/vec-app-3d56e.appspot.com/o/cmp2.jpg?alt=media&token=7c54b7e3-4d5c-437e-a76c-7841a7e07ffb");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/vec-app-3d56e.appspot.com/o/cmp.jpg?alt=media&token=d2f92b00-9523-44aa-936e-ed219cfda437");
                    break;


            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

            sliderLayout.addSliderView(sliderView);
        }
    }
}