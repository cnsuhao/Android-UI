##  RecyclerView Demo ##

`` xml

		1.不关心Item是否显示在正确的位置，如何显示？	可以使用不同的布局LayoutManager来实现。
		LayoutManager:	
			1.LinearLayoutManager 线性布局		ListView
			2.GridLayoutManager GridView布局 //纵向GridView
			3.StaggeredGridLayoutManager HORIZONTAL 横向GridView
			4.StaggeredGridLayoutManager VERTICAL 瀑布流(动态改变Item布局的高度)
		2.不关心Item间如何分隔？  可以使用ItemDecoration
		3.不关注Item增加与删除的动画效果？	可以使用ItemAnimator
		4.仅仅关注如何回收与复用
	
	https://gist.github.com/alexfu/0f464fc3742f134ccd1e    
	DividerItemDecoration 
		
	
	https://github.com/gabrielemariotti/RecyclerViewItemAnimators

``



效果图：
![效果图]('shili.gif')