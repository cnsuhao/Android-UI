package com.bob.searchhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Toast;

import com.quinny898.library.persistentsearch.SearchBox;
import com.quinny898.library.persistentsearch.SearchBox.MenuListener;
import com.quinny898.library.persistentsearch.SearchBox.SearchListener;
import com.quinny898.library.persistentsearch.SearchResult;

import java.util.ArrayList;

public class MainActivity extends Activity {
	Boolean isSearch;
	private SearchBox search;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		search = (SearchBox) findViewById(R.id.searchbox);
        search.enableVoiceRecognition(this);    //启用语音识别功能
		for(int x = 0; x < 10; x++){        //添加历史记录
			SearchResult option = new SearchResult("Result " + Integer.toString(x), getResources().getDrawable(R.drawable.ic_history));
			search.addSearchable(option);
		}		
		search.setMenuListener(new MenuListener(){           //更多的菜单被点击

			@Override
			public void onMenuClick() {
				//Hamburger has been clicked 更多的菜单被点击
				Toast.makeText(MainActivity.this, "Menu click", Toast.LENGTH_LONG).show();				
			}
			
		});
		search.setSearchListener(new SearchListener(){              //搜索框相关事情触发

			@Override
			public void onSearchOpened() {                  //打开时
				//Use this to tint the screen
			}

			@Override
			public void onSearchClosed() {              //关闭时
				//Use this to un-tint the screen
			}

			@Override
			public void onSearchTermChanged() {         //单个被选中时
				//React to the search term changing
				//Called after it has updated results
			}

			@Override
			public void onSearch(String searchTerm) {           //选中完毕时
				Toast.makeText(MainActivity.this, searchTerm +" Searched", Toast.LENGTH_LONG).show();
				
			}

			@Override
			public void onSearchCleared() {                 //数据清空时
				//Called when the clear button is clicked
				
			}
			
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1234 && resultCode == RESULT_OK) {
			ArrayList<String> matches = data
					.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			search.populateEditText(matches);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	public void reveal(View v){
		startActivity(new Intent(this, RevealActivity.class));
	}

	
}
