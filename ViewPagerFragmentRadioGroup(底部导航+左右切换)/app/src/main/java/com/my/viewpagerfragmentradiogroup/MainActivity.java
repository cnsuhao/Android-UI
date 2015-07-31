/**<p>项目名：ViewPagerFragmentRadioGroup</p>
 * <p>包名：	com.my.viewpagerfragmentradiogroup</p>
 * <p>文件名：MainActivity.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/5/14/13:00.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.my.viewpagerfragmentradiogroup;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>名称：com.my.viewpagerfragmentradiogroup.MainActivity</p>
 * <p>描述：</p>
 * <pre>
 *    ViewPager + Fragment + RadioGroup
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/5/14/13:00
 */
public class MainActivity extends FragmentActivity {


    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mRadioGroup = (RadioGroup) findViewById(R.id.group);

        List<Fragment> mFragments = initFragment();
        mViewPager.setAdapter( new MyPageAdapter(getSupportFragmentManager(), mFragments) );

        mRadioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());

        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());


    }

    /**
     * 初始化Fragment数据
     */
    private List<Fragment> initFragment(){
        FirstFragment f1 = new FirstFragment();
        FourFragment f4 = new FourFragment();
        SecondFragment f2 = new SecondFragment();
        ThreeFragment f3 = new ThreeFragment();
        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(f1);
        mFragments.add(f2);
        mFragments.add(f3);
        mFragments.add(f4);
        return mFragments;
    }


    /**
     * FragmentPagerAdapter:
     * FragmentPagerAdapter 继承自 PagerAdapter。
     * 相比通用的 PagerAdapter，该类更专注于每一页均为 Fragment 的情况。
     * 如文档所述，该类内的每一个生成的 Fragment 都将保存在内存之中，因此适用于那些相对静态的页，数量也比较少的那种；如果需要处理有很多页，并且数据动态性较大、占用内存较多的情况，
     * 应该使用FragmentStatePagerAdapter。
     *
     *
     * FragmentStatePagerAdapter:
     * FragmentStatePagerAdapter 和前面的 FragmentPagerAdapter 一样，是继承子 PagerAdapter。
     * 但是，和 FragmentPagerAdapter 不一样的是，正如其类名中的 'State' 所表明的含义一样，该 PagerAdapter 的实现将只保留当前页面，当页面离开视线后，就会被消除，
     * 释放其资源；而在页面需要显示时，生成新的页面(就像 ListView 的实现一样)。这么实现的好处就是当拥有大量的页面时，不必在内存中占用大量的内存。
     *
     */
    class MyPageAdapter extends FragmentStatePagerAdapter {


        private List<Fragment> mFragments;

        public MyPageAdapter(FragmentManager fm, List<Fragment> mFragments) {
            super(fm);
            this.mFragments = mFragments;
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }


    /**
     * 底部按钮选择的事件处理
     */
    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int currentIndex = 0;
            switch (checkedId){
                case R.id.one :
                    currentIndex = 0;
                    break;
                case R.id.two :
                    currentIndex = 1;
                    break;
                case R.id.three :
                    currentIndex = 2;
                    break;
                case R.id.four :
                    currentIndex = 3;
                    break;
            }
            if( mViewPager.getCurrentItem() != currentIndex ){
                mViewPager.setCurrentItem(currentIndex);
            }
        }
    }

    /**
     * Fragment 选择事件
     */
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{


        @Override
        public void onPageScrolled(int i, float v, int i2) {

        }

        @Override
        public void onPageSelected(int i) {
            int currentIndex = mViewPager.getCurrentItem();
            switch (currentIndex){
                case 0 :
                    mRadioGroup.check(R.id.one);
                    break;
                case 1 :
                    mRadioGroup.check(R.id.two);
                    break;
                case 2 :
                    mRadioGroup.check(R.id.three);
                    break;
                case 3 :
                    mRadioGroup.check(R.id.four);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }

}
