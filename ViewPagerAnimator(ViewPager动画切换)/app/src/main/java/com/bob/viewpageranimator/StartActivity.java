/**<p>项目名：ViewPagerAnimator</p>
 * <p>包名：	com.bob.viewpageranimator</p>
 * <p>文件名：StartActivity.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/6/10:40.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.viewpageranimator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.bob.viewpageranimator.transFormer.MyPageTransFormer;
import com.bob.viewpageranimator.transFormer.ObliquePageTransFormer;

import java.util.Arrays;
import java.util.List;

/**
 * <p>名称：com.bob.viewpageranimator.StartActivity</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/6/10:40
 */

public class StartActivity extends Activity {

    private List<Integer> mImages = Arrays.asList(R.drawable.guide_image1, R.drawable.guide_image2, R.drawable.guide_image3);
    private ViewPager mViewPager;
    private com.bob.viewpageranimator.widget.ViewPager customViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.start);
        //initSystemViewPager();
        initCustomViewPager();
    }

    //初始化自定义的ViewPager动画，全兼容
    private void initCustomViewPager(){
        customViewPager = (com.bob.viewpageranimator.widget.ViewPager) findViewById(R.id.custom_view_pager);
        customViewPager.setAdapter(new MyPagerAdapter());
        customViewPager.setPageTransformer(true,  new ObliquePageTransFormer());
    }

    //初始化系统自带的ViewPager 动画只支持3.0以上
  /*  private void initSystemViewPager(){
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        //设置无标题
        mViewPager.setAdapter(new MyPagerAdapter());
        // mViewPager.setPageTransformer(true, new MyPageTransFormer());
        mViewPager.setPageTransformer(true, new MyPageTransFormer());
    }*/

    class MyPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return mImages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView mImageView = new ImageView(StartActivity.this);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);            //铺满屏幕
            mImageView.setImageResource(mImages.get(position));
            container.addView(mImageView);
            return mImageView;
        }
    }
}
