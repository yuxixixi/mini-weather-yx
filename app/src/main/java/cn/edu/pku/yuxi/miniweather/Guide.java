package cn.edu.pku.yuxi.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pku.yuxi.adapter.ViewPagerAdapter;
import cn.edu.pku.yuxi.miniweather.R;

public class Guide extends Activity{
    private ViewPagerAdapter vpAdatepter;
    private ViewPager vp;
    private List<View> views;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        initViews();
        btn = (Button)views.get(1).findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Guide.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    private void initViews(){
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.page1,null));
        views.add(inflater.inflate(R.layout.page2,null));
        vpAdatepter = new ViewPagerAdapter(views,this);
        vp = (ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(vpAdatepter);
    }
}
