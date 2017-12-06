package cn.edu.pku.yuxi.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;



public class ViewPagerAdapter extends PagerAdapter {
    private List<View> views;
    private Context context;

    public ViewPagerAdapter(List<View> views,Context context){
        this.views = views;
        this.context = context;
    }
    @Override
    public int getCount() {
        return views.size();
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View layout = views.get(position);
        container.addView(layout);
        return layout;
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View layout = views.get(position);
        container.removeView(layout);
    }
}
