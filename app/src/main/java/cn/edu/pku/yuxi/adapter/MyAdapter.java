
package cn.edu.pku.yuxi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;
import java.lang.Object;

import cn.edu.pku.yuxi.bean.City;
import cn.edu.pku.yuxi.miniweather.R;


/**
 * Created by yuxi on 17/11/9.
 */

public class MyAdapter extends ArrayAdapter<City> {
    private Context context;
    private int resourceId;
//    public MyAdapter(Context context,List<City> data){
//        this.context=context;
//        this.data=data;
//    }
    public MyAdapter(Context context,int textViewResourceId,List<City> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        City city = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        } else {
            view = convertView;
        }
        TextView cityName =(TextView)view.findViewById(R.id.city_name);
        TextView cityCode =(TextView)view.findViewById(R.id.city_code);
        cityName.setText(city.getCity());
        cityCode.setText(city.getNumber());

        return view;
    }

}