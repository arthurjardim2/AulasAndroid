package com.android.josias.layouts.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.android.josias.layouts.R;

public class ImageViewActivity extends ActionBarActivity {

    private ImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        ivImg = (ImageView)findViewById(R.id.ivImg);
    }

    public void showImg(View v){
        ivImg.setVisibility(View.VISIBLE);
    }

    public void hideImg(View v){
        ivImg.setVisibility(View.GONE);
    }

    public void imgFitXY(View v){
        ivImg.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public void imgFitStart(View v){
        ivImg.setScaleType(ImageView.ScaleType.FIT_START);
    }

    public void imgFitEnd(View v){
        ivImg.setScaleType(ImageView.ScaleType.FIT_END);
    }

    public void imgCenterInside(View v){
        ivImg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void imgCenter(View v){
        ivImg.setScaleType(ImageView.ScaleType.CENTER);
    }

    public void imgCenterCrop(View v){
        ivImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

}
