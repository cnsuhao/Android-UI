/**<p>项目名：ParallaxViewPager</p>
 * <p>包名：	com.bob.parallaxviewpager</p>
 * <p>文件名：MainActivity.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/6/23/13:46.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.parallaxviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bob.parallaxviewpager.weight.ParallaxViewPager;


/**
 * <p>名称：com.bob.parallaxviewpager.MainActivity</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/6/23/13:46
 */

public class MainActivity extends FragmentActivity {

    private ParallaxViewPager mParallaxViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       setContentView(R.layout.main);
        mParallaxViewPager = (ParallaxViewPager) findViewById(R.id.parallaxviewpager);
        mParallaxViewPager.setOverlapPercentage(0.99f).setAdapter(new MyAdapter(getSupportFragmentManager()));

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentTest.newInstance(position + "");
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

}
