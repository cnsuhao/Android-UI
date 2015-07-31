##	ViewPager动画(开场动画等)##

 - ViewPager.setPageTransformer实现切换动画(默认为3.0API)
	http://developer.android.com/training/animation/screen-slide.html(官方提供的几种切换动画)
 - 修改ViewPager内部代码(setPageTransformer这个方法)+使用nineoldandroids代替属性动画实现向下兼容
 - 这里我们使用第三方动画库ninooldandroids来兼容3.0一下版本
 - 也可以使用第三方切换库(JazzyViewPager)


###效果图
![效果图]('shili.gif')