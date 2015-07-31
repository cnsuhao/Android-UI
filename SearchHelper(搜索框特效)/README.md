## 搜索框特效 ##
####使用说明
<code>

	maven {
        url "https://oss.sonatype.org/content/repositories/snapshots"
    }
	compile 'com.quinny898.library.persistentsearch:library:1.0.0-SNAPSHOT'

</code>

#####布局文件：
<code>

	 <com.quinny898.library.persistentsearch.SearchBox
        android:layout_width="wrap_content"
        android:id="@+id/searchbox"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_alignParentTop="true" />

</code>


#####Acivity.java
<code>

	search = (SearchBox) findViewById(R.id.searchbox);
    search.enableVoiceRecognition(this);//启用语音识别
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

</code>


#####效果图：
![GIF of its use](https://raw.githubusercontent.com/Quinny898/PersistentSearch/master/resources/search.gif)
