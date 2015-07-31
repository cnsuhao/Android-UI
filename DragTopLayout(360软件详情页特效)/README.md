##仿360软件详情页特效##
###使用：
布局：

```xml
	 <com.bob.library.DragTopLayout
	     android:layout_width="match_parent"
	     android:layout_height="match_parent">
	
	     <!--top view-->
	     <LinearLayout
	         android:layout_width="match_parent"
	         android:layout_height="wrap_content"
	         android:gravity="center"
	         android:orientation="vertical">
	         ...
	     </LinearLayout>
	
	     <!--content view-->
	     <LinearLayout
	         android:orientation="vertical"
	         android:layout_width="match_parent"
	         android:layout_height="match_parent">
	         ...
	     </LinearLayout>
	
	 </com.bob.library.DragTopLayout>
```

###其他说明：
sample:是使用纯原生实现  

app:使用了比较多的第三方jar (这2个都可以独立打成一个apk)

library:jar包

###效果图：

![]('dragtop_1.1.0.gif')