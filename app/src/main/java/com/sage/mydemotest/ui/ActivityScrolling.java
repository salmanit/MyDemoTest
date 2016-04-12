package com.sage.mydemotest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.sage.mydemotest.R;
import com.sage.mydemotest.adapter.AdapterRVanima;
import com.sage.mydemotest.widget.RecyclerViewAnima;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class ActivityScrolling extends ActivityBase {

    @ViewInject(R.id.rv)
    private RecyclerViewAnima rv;
    @ViewInject(R.id.fab)
    private FloatingActionButton fab;

    private AdapterRVanima adapter;

    @ViewInject(R.id.toolbar_layout)
    private CollapsingToolbarLayout collaLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        x.view().inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.include_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        adapter=new AdapterRVanima();
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_settings:
                startActivity(new Intent(this,ActivitySetting.class));
                return true;
            case R.id.action_web:
                startActivity(new Intent(this,ActivityWeb.class));
                return true;
            case R.id.action_html5:
                startActivity(new Intent(this,ActivityHTML5Web.class));
                return true;
            case R.id.action_1111:
                startActivity(new Intent(this,Activity1111.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
