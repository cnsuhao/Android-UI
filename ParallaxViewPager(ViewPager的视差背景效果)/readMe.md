## ParallaxViewPager : ViewPager的视差背景效果 ##


布局：
<xml>

	<?xml version="1.0" encoding="utf-8"?>
	<com.bob.parallaxviewpager.weight.ParallaxViewPager
	xmlns:android="http://schemas.android.com/apk/res/android"
	android:id="@+id/parallaxviewpager"
	android:layout_width="match_parent"
	android:background="@drawable/background"
	android:layout_height="match_parent" />
</xml>

MainAcitivity.java
<code>
    
 		setContentView(R.layout.main);
        mParallaxViewPager = (ParallaxViewPager) findViewById(R.id.parallaxviewpager);
        mParallaxViewPager.setOverlapPercentage(0.99f).setAdapter(new MyAdapter(getSupportFragmentManager()));
</code>

效果图：

![效果图]("shili.gif")
