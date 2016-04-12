package com.sage.mydemotest.ui;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.sage.imagechooser.FragmentDiaChoose;
import com.sage.imagechooser.api.ChosenImage;
import com.sage.imagechooser.api.ChosenVideo;
import com.sage.mydemotest.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Sage on 2016/4/6.
 */
public class ActivitySetting extends ActivityPicBase implements FragmentDiaChoose.ChooseClickListener{

    @ViewInject(R.id.layout_pics)
    LinearLayout layout_pics;

    @ViewInject(R.id.iv_pic)
    ImageView iv_pic;
    @ViewInject(R.id.vv)
    VideoView vv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        x.view().inject(this);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Event({R.id.btn_pic_single,R.id.btn_pic_multi,R.id.btn_video})
    private void SettingClick(View view){
        switch (view.getId()){
            case R.id.btn_pic_single:
                FragmentDiaChoose.create(0,getResources().getStringArray(R.array.choose_pic))
                        .setmChooseListener(this)
                        .show(getSupportFragmentManager(),"pics");
                break;
            case R.id.btn_pic_multi:

                break;
            case R.id.btn_video:
                FragmentDiaChoose.create(1,getResources().getStringArray(R.array.choose_video))
                        .setmChooseListener(this)
                        .show(getSupportFragmentManager(),"pics");
                break;
        }






    }


    @Override
    public void click(int index, int tag) {
        switch (tag){
            case 0:
                switch (index){
                    case 0://拍照
                        takePicture();
                        break;
                    case 1://相册
                        chooseImage();
                        break;
                }
                break;
            case 1:
                switch (index){
                    case 0://录像
                        captureVideo();
                        break;
                    case 1://本地视频
                        pickVideo();
                        break;
                }
                break;
        }
    }

    @Override
    public void onImageChosen(ChosenImage image) {
        iv_pic.setVisibility(View.VISIBLE);
       iv_pic.setImageBitmap(BitmapFactory.decodeFile(image.getFileThumbnail()));
    }

    @Override
    public void onVideoChosen(ChosenVideo video) {

    }
}
