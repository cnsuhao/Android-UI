/**<p>项目名：PopupWindowViewPager</p>
 * <p>包名：	com.my.popupwindowviewpager</p>
 * <p>文件名：AppStart.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/5/23/13:55.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.my.popupwindowviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>名称：com.my.popupwindowviewpager.AppStart</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/5/23/13:55
 */
public class AppStart extends Activity {

    private ViewPager mViewPager;
    private LinearLayout mLinearLayout;             //圆点的布局
    private PopupWindow mPopupWindow;
    private List<ImageView> pointList;              //圆点的Item
    private List<View> data;                        //数据



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appstart);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);


        mLinearLayout = (LinearLayout) findViewById(R.id.nav_point);
        mPopupWindow = new PopupWindow(getCurrentFocus(), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        data = initData();
        initPoint(data);
        AppStartViewPager mAppStartViewPager = new AppStartViewPager(data);
        mViewPager.setAdapter(mAppStartViewPager);
        mViewPager.setOnPageChangeListener(mAppStartViewPager);
    }



    /**
     * 初始化引导页数据
     * @return
     */
    private List<View> initData(){
        View view1 = LayoutInflater.from(this).inflate(R.layout.appstart_item, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.appstart_item, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.appstart_item, null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.appstart_item, null);
        view1.findViewById(R.id.item_image).setBackgroundResource(R.drawable.view1);
        view2.findViewById(R.id.item_image).setBackgroundResource(R.drawable.view2);
        view3.findViewById(R.id.item_image).setBackgroundResource(R.drawable.view3);
        view4.findViewById(R.id.item_image).setBackgroundResource(R.drawable.view4);
        return Arrays.asList(view1, view2, view3, view4);
    }

    /**
     * 初始化圆点的数据
     * @param data
     */
    private void initPoint(List<View> data){
        pointList = new ArrayList<>();
        //加入小圆点
        for (int i = 0; i < data.size(); i++) {
            ImageView indicator = new ImageView(this);
            if (i == 0) {
                indicator.setImageResource(R.drawable.page_indicator_foucesed);
            }else {
                indicator.setImageResource(R.drawable.page_indicator);
            }
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(5,0,5,0);
            indicator.setLayoutParams(lp);
            mLinearLayout.addView(indicator);
            //把小圆点图片存入集合,好让切换图案片的时候动态改变小圆点背景
            pointList.add(indicator);
        }

    }


    /**
     *
     */
    class AppStartViewPager extends PagerAdapter implements ViewPager.OnPageChangeListener{


        private List<View> data;

        public AppStartViewPager(List<View> data){
            this.data = data;
        }


        // 获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
        @Override
        public int getCount() {
            return data.size();
        }

        // 来判断显示的是否是同一张图片，这里我们将两个参数相比较返回即可
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view ==o;
        }

        // PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(data.get(position));
        }

        // 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(data.get(position));
            return data.get(position);
        }

        @Override
        public void onPageScrolled(int i, float v, int i2) {

        }

        @Override
        public void onPageSelected(int i) {
            for (int k = 0; k < pointList.size(); k++){
                pointList.get(k).setImageResource(R.drawable.page_indicator);
            }
            pointList.get(i).setImageResource(R.drawable.page_indicator_foucesed);
        }

        @Override
        public void onPageScrollStateChanged(int i) {
        }
    }

}
