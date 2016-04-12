package com.sage.mydemotest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import org.xutils.x;

/**
 * Created by Sage on 2016/4/1.
 */
public class ActivityBase extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    Toast toast;
    public void showToast(String msg){
        if(toast!=null){
            toast.cancel();
            toast=null;
        }else{
            toast=Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        }
        toast.show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
