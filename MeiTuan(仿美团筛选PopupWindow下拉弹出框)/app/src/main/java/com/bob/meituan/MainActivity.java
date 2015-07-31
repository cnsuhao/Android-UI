package com.bob.meituan;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.PopupWindow.OnDismissListener;
import android.app.Activity;
import android.graphics.drawable.PaintDrawable;

public class MainActivity extends Activity implements OnClickListener,
		OnDismissListener {
	private LinearLayout ll_all, ll_location, ll_price;
	private ListView lv1, lv2;
	private ImageView icon1, icon2, icon3;
	private int screenWidth;
	private int screenHeight;
	private MyAdapter adapter;
	private MyToAdapter mToadapter;
	private int idx;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initScreenWidth();
		findViews();
	}

	private void findViews() {
		ll_all = (LinearLayout) findViewById(R.id.ll_all);
		ll_location = (LinearLayout) findViewById(R.id.ll_location);
		ll_price = (LinearLayout) findViewById(R.id.ll_price);
		icon1 = (ImageView) findViewById(R.id.icon1);
		icon2 = (ImageView) findViewById(R.id.icon2);
		icon3 = (ImageView) findViewById(R.id.icon3);
		ll_all.setOnClickListener(this);
		ll_location.setOnClickListener(this);
		ll_price.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_all:
			idx = 1;
			icon1.setImageResource(R.drawable.icon_43343434);
			showPopupWindow(findViewById(R.id.ll_layout), 1);
			break;
		case R.id.ll_location:
			idx = 2;
			icon2.setImageResource(R.drawable.icon_43343434);
			showPopupWindow(findViewById(R.id.ll_layout), 2);
			break;
		case R.id.ll_price:
			idx = 3;
			icon3.setImageResource(R.drawable.icon_43343434);
			showPopupWindow(findViewById(R.id.ll_layout), 3);
			break;
		}
	}

	/**
	 * 
	 * @Title: showPopupWindow
	 * @Description: PopupWindow
	 * @author luck
	 * @return void 返回类型
	 */
	public void showPopupWindow(View anchor, int flag) {
		final PopupWindow popupWindow = new PopupWindow(MainActivity.this);
		View contentView = LayoutInflater.from(MainActivity.this).inflate(
				R.layout.windows_popupwindow, null);
		lv1 = (ListView) contentView.findViewById(R.id.lv1);
		lv2 = (ListView) contentView.findViewById(R.id.lv2);
		switch (flag) {
		case 1:
			adapter = new MyAdapter(MainActivity.this, initLv1Data());
			break;
		case 2:
			adapter = new MyAdapter(MainActivity.this, initLv2Data());
			break;
		case 3:
			adapter = new MyAdapter(MainActivity.this, initLv3Data());
			break;
		}
		lv1.setAdapter(adapter);
		lv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (parent.getAdapter() instanceof MyAdapter) {
					if (lv2.getVisibility() == View.INVISIBLE) {
						lv2.setVisibility(View.VISIBLE);
						switch (idx) {
						case 1:
							mToadapter = new MyToAdapter(MainActivity.this,
									initLv1Data());
							break;
						case 2:
							mToadapter = new MyToAdapter(MainActivity.this,
									initLv2Data());
							break;
						case 3:
							mToadapter = new MyToAdapter(MainActivity.this,
									initLv3Data());
							break;
						}
						lv2.setAdapter(mToadapter);
						lv2.setOnItemClickListener(new OnItemClickListener() {

							@Override
							public void onItemClick(AdapterView<?> parent,
									View view, int position, long id) {
								String name = (String) parent.getAdapter()
										.getItem(position);
								Toast.makeText(MainActivity.this, name,
										Toast.LENGTH_SHORT).show();
								popupWindow.dismiss();
							}
						});
					}
				}
			}
		});
		popupWindow.setOnDismissListener(this);
		popupWindow.setWidth(screenWidth);
		popupWindow.setHeight(screenHeight);
		popupWindow.setContentView(contentView);
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setBackgroundDrawable(new PaintDrawable());
		popupWindow.showAsDropDown(anchor);

	}

	/**
	 * @Title: initScreenWidth
	 * @Description: 查看自身的宽高
	 * @author lmw
	 * @return void 返回类型
	 */
	private void initScreenWidth() {
		DisplayMetrics dm = new DisplayMetrics();
		dm = getResources().getDisplayMetrics();
		screenHeight = dm.heightPixels;
		screenWidth = dm.widthPixels;
		Log.v("屏幕宽高", "宽度" + screenWidth + "高度" + screenHeight);
	}

	private List<String> initLv1Data() {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			switch (i) {
			case 0:
				l.add("综合排序");
				break;
			case 1:
				l.add("销量最高");
				break;
			case 2:
				l.add("速度最快");
				break;
			case 3:
				l.add("评分最高");
				break;
			case 4:
				l.add("起价最低");
				break;
			}
		}
		return l;
	}

	private List<String> initLv2Data() {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			switch (i) {
			case 0:
				l.add("距离排序");
				break;
			case 1:
				l.add("距离最高");
				break;
			case 2:
				l.add("距离最快");
				break;
			case 3:
				l.add("距离最高");
				break;
			case 4:
				l.add("距离最低");
				break;
			}
		}
		return l;
	}

	private List<String> initLv3Data() {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			switch (i) {
			case 0:
				l.add("价格排序");
				break;
			case 1:
				l.add("价格最高");
				break;
			case 2:
				l.add("价格最快");
				break;
			case 3:
				l.add("价格最高");
				break;
			case 4:
				l.add("价格最低");
				break;
			}
		}
		return l;
	}

	
	@Override
	public void onDismiss() {
		icon1.setImageResource(R.drawable.icon_435);
		icon2.setImageResource(R.drawable.icon_435);
		icon3.setImageResource(R.drawable.icon_435);
	}
}
