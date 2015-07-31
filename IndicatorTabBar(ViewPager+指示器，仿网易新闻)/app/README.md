# IndicatorTabBar for Android

## How to use 

If you want use this view, the operation is as follows:

Because the IndicatorTabBar has custom attributes, if you want use them, you must add your own namespace in your xml file in the first component:



##attrs.xml
<code>

	<?xml version="1.0" encoding="utf-8"?>
	<resources>

	    <!-- IndicatorTabBar Attribute -->
	    <declare-styleable name="IndicatorTabBar">
	        <attr name="tab_text_size" format="dimension" />
	        <attr name="tab_text_color" format="color" />
	        <attr name="tab_text_selected_color" format="color" />
	        <attr name="tab_underline_color" format="color" />
	        <attr name="tab_underline_height" format="dimension" />
	        <attr name="tab_max_column" format="integer" />
	    </declare-styleable>

	</resources>

</code>


##main.xml
<code>


		<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:bob="http://schemas.android.com/apk/res-auto"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent">

    <com.my.indicatortabbar.IndicatorTabBar
        android:id="@+id/indicatorTabBar"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:background="@color/bg_color"
        bob:tab_text_color="@color/tab_text_color"
        bob:tab_text_selected_color="@color/tab_text_selected_color"
        bob:tab_text_size="@dimen/tab_text_size"
        ></com.my.indicatortabbar.IndicatorTabBar>



    <android.support.v4.view.ViewPager
        android:id="@+id/viewpager"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />



	</LinearLayout>
	
</code>

##MainAcivity

<code>

	/**<p>项目名：IndicatorTabBar</p>
	 * <p>包名：	com.my.indicatortabbar</p>
	 * <p>文件名：MainAcivity.java</p>
	 * <p>版本信息： 2.1.0</p>
	 * <p>日期： 2015/5/27/9:13.</p>
	 * Copyright (c) 2015帮你公司-版权所有
	 */
	package com.my.indicatortabbar;
	
	import android.app.Activity;
	import android.os.Bundle;
	import android.support.v4.app.Fragment;
	import android.support.v4.app.FragmentActivity;
	import android.support.v4.app.FragmentManager;
	import android.support.v4.app.FragmentPagerAdapter;
	import android.support.v4.view.ViewPager;
	
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;

	/**
	 * <p>名称：com.my.indicatortabbar.MainAcivity</p>
	 * <p>描述：</p>
	 * <pre>
	 *
	 * </pre>
	 *
	 * @author 鲍建明
	 * @version 2.1.0
	 * @date 2015/5/27/9:13
	 */
	public class MainAcivity extends FragmentActivity {


	    private ViewPager mViewPager;
	    private IndicatorTabBar mIndicatorTabBar;
	    private List<String> tableNames = Arrays.asList("上海", "北京", "广州", "深圳", "沈阳", "南京", "石家庄", "丽江");
	    private List<Fragment> fragmentList;
	
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        mViewPager = (ViewPager) findViewById(R.id.viewpager);
	        mIndicatorTabBar = (IndicatorTabBar) findViewById(R.id.indicatorTabBar);
	
	        intFragmentList();
	
	        mViewPager.setAdapter(  new MyViewPager(getSupportFragmentManager(), fragmentList) );
	        mIndicatorTabBar.initView(tableNames, mViewPager, 5);
	    }
	
	    /**
	     * 初始化Fragment
	     */
	    private void intFragmentList(){
	        fragmentList = new ArrayList<>();
	        for ( int i = 0; i < tableNames.size(); i++ ){
	            FragmentFactory fragment = FragmentFactory.newInstance(tableNames.get(i));
	            fragmentList.add(fragment);
	        }
	    }
	
	
	
	    /**
	     * <p>名称：com.my.indicatortabbar.MainAcivity。MyViewPager</p>
	     * <p>描述：</p>
	     * <pre>
	     *
	     * </pre>
	     *
	     * @author 鲍建明
	     * @version 2.1.0
	     * @date 2015/5/27/9:13
	     */
	    class MyViewPager extends FragmentPagerAdapter{
	
	        private List<Fragment> fragmentList;
	
	        public MyViewPager(FragmentManager fm, List<Fragment> fragmentList) {
	            super(fm);
	            this.fragmentList = fragmentList;
	        }
	
	        @Override
	        public Fragment getItem(int i) {
	            return fragmentList.get(i);
	        }
	
	        @Override
	        public int getCount() {
	            return fragmentList.size();
	        }
	    }
	}

</code>

##Demo
![image]()
![image]()
![image]()

