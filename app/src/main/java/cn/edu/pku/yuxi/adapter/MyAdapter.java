
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

/**
自定义适配器，重写父类的一组构造函数，用于将上下文、Listviw子项布局的id和数据都传进来
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
        City city = getItem(position);//得到当前项的实例
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        } else {
            view = convertView;
        }
        //covertview用于将之前加载好的布局进行缓存，为空用缓存，不为空则加载
        TextView cityName =(TextView)view.findViewById(R.id.city_name);
        TextView cityCode =(TextView)view.findViewById(R.id.city_code);
        cityName.setText(city.getCity());
        cityCode.setText(city.getNumber());

        return view;
    }

}