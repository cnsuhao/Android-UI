# ViewPagerIndicator for Android

## How to use 

If you want use this view, the operation is as follows:

Because the ViewPagerIndicator has custom attributes, if you want use them, you must add your own namespace in your xml file in the first component:


##attrs.xml
<code>

	<?xml version="1.0" encoding="utf-8"?>
	<resources>
	
	    <attr name="item_count" format="integer"></attr>
	
	    <declare-styleable name="ViewPagerIndicator">
	        <attr name="item_count" />
	    </declare-styleable>
	
	</resources>

</code>

##vp_indicator.xml
<code>


		<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    xmlns:zhy="http://schemas.android.com/apk/res-auto"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:background="#ffffffff"
	    android:orientation="vertical" >
	
	    <com.my.viewpagerindicator.ViewPagerIndicator
	        android:id="@+id/id_indicator"
	        android:layout_width="match_parent"
	        android:layout_height="45dp"
	        android:background="@drawable/title_bar_bg_one_row"
	        android:orientation="horizontal"
	        zhy:item_count="4" >
	
	        <TextView
	            android:layout_width="0dp"
	            android:layout_height="fill_parent"
	            android:layout_weight="1"
	            android:gravity="center"
	            android:text="短信1"
	            android:textColor="#CCFFFFFF"
	            android:textSize="16sp" />
	
	        <TextView
	            android:layout_width="0dp"
	            android:layout_height="fill_parent"
	            android:layout_weight="1"
	            android:gravity="center"
	            android:text="收藏2"
	            android:textColor="#CCFFFFFF"
	            android:textSize="16sp" />
	
	        <TextView
	            android:layout_width="0dp"
	            android:layout_height="fill_parent"
	            android:layout_weight="1"
	            android:gravity="center"
	            android:text="推荐3"
	            android:textColor="#CCFFFFFF"
	            android:textSize="16sp" />
	
	        <TextView
	            android:layout_width="0dp"
	            android:layout_height="fill_parent"
	            android:layout_weight="1"
	            android:gravity="center"
	            android:text="推荐4"
	            android:textColor="#CCFFFFFF"
	            android:textSize="16sp" />
	
	        <TextView
	            android:layout_width="0dp"
	            android:layout_height="fill_parent"
	            android:layout_weight="1"
	            android:gravity="center"
	            android:text="推荐5"
	            android:textColor="#CCFFFFFF"
	            android:textSize="16sp" />
	
	        <TextView
	            android:layout_width="0dp"
	            android:layout_height="fill_parent"
	            android:layout_weight="1"
	            android:gravity="center"
	            android:text="推荐6"
	            android:textColor="#CCFFFFFF"
	            android:textSize="16sp" />
	
	        <TextView
	            android:layout_width="0dp"
	            android:layout_height="fill_parent"
	            android:layout_weight="1"
	            android:gravity="center"
	            android:text="推荐7"
	            android:textColor="#CCFFFFFF"
	            android:textSize="16sp" />
	    </com.my.viewpagerindicator.ViewPagerIndicator>
	
	    <android.support.v4.view.ViewPager
	        android:id="@+id/id_vp"
	        android:layout_width="match_parent"
	        android:layout_height="0dp"
	        android:layout_weight="1" >
	    </android.support.v4.view.ViewPager>
	
	</LinearLayout>
	
</code>

##main.xml
<code>

	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:paddingBottom="@dimen/activity_vertical_margin"
	    android:paddingLeft="@dimen/activity_horizontal_margin"
	    android:paddingRight="@dimen/activity_horizontal_margin"
	    android:paddingTop="@dimen/activity_vertical_margin"
	    tools:context=".MainActivity" >
	
	    <TextView
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:text="hello World" />
	
	</RelativeLayout>


</code>

##MainAcivity

<code>

	package com.my.viewpagerindicator;

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	
	import android.os.Bundle;
	import android.support.v4.app.Fragment;
	import android.support.v4.app.FragmentActivity;
	import android.support.v4.app.FragmentPagerAdapter;
	import android.support.v4.view.ViewPager;
	import android.view.Window;
	
	public class MainActivity extends FragmentActivity
	{
		private List<Fragment> mTabContents = new ArrayList<Fragment>();
		private FragmentPagerAdapter mAdapter;
		private ViewPager mViewPager;
		private List<String> mDatas = Arrays.asList("示例1", "示例2", "示例3", "示例4",
				"示例5", "示例6", "示例7", "示例8", "示例9");
	//	private List<String> mDatas = Arrays.asList("示例", "收藏", "推荐");
	
		private ViewPagerIndicator mIndicator;
	
		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.vp_indicator);
	
			initView();
			initDatas();
			//设置Tab上的标题
			mIndicator.setTabItemTitles(mDatas);
			mViewPager.setAdapter(mAdapter);
			//设置关联的ViewPager
			mIndicator.setViewPager(mViewPager,0);
	
		}
	
		private void initDatas()
		{
	
			for (String data : mDatas)
			{
				VpSimpleFragment fragment = VpSimpleFragment.newInstance(data);
				mTabContents.add(fragment);
			}
	
			mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
			{
				@Override
				public int getCount()
				{
					return mTabContents.size();
				}
	
				@Override
				public Fragment getItem(int position)
				{
					return mTabContents.get(position);
				}
			};
		}
	
		private void initView()
		{
			mViewPager = (ViewPager) findViewById(R.id.id_vp);
			mIndicator = (ViewPagerIndicator) findViewById(R.id.id_indicator);
		}
	
	
	}


</code>

##Demo
![image]()
![image]()
![image]()

