package cn.edu.pku.yuxi.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pku.yuxi.app.MyApplication;
import cn.edu.pku.yuxi.bean.City;
import cn.edu.pku.yuxi.adapter.MyAdapter;

/**
 * Created by yuxi on 17/10/18.
 */

public class SelectCity extends Activity implements View.OnClickListener{
    private static final String TAG1 ="MyTag";
    private ImageView mBackBtn;
    private ListView mListView;
    private List<City> mCityList = new ArrayList<>();
    private List<City> cityList;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//调用父类的onCreate构造函数
        Log.d(TAG1,"oncreate");
        setContentView(R.layout.select_city);
        initCity();
        MyAdapter myAdapter = new MyAdapter(SelectCity.this,R.layout.city_item,mCityList);

        ListView listView = (ListView)findViewById(R.id.city_list);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long ld) {
                City city = cityList.get(position);

                //Toast.makeText(SelectCity.this,city.getCity(),Toast.LENGTH_SHORT).show();
                String choosenCity = city.getCity();
                Intent intent1 = new Intent();
                intent1.putExtra("city_name",choosenCity);
                intent1.setClass(SelectCity.this,MainActivity.class);

                startActivity(intent1);
            }
        });
        mBackBtn = (ImageView)findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
            default:
                break;
        }
    }
    private String[] data={"第1组","第2组","第3组","第4组","第5组","第6组",
            "第7组","第8组","第9组","第10组","第11组","第12组","第13组",
            "第14组","第15组","第16组","第17组","第18组","第19组","第20组",
            "第21组","第22组"};
    private void initCity(){
        MyApplication myApplication = (MyApplication)getApplication();
        cityList = myApplication.getCityList();
        Log.e(TAG1,String.valueOf(cityList.size()));
        for (City city : cityList) {
            mCityList.add(city);
        }
    }
}
