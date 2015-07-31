/**<p>项目名：ViewPagerAnimator</p>
 * <p>包名：	com.bob.viewpageranimator</p>
 * <p>文件名：MyPageTransFormer.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/6/13:43.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.viewpageranimator.transFormer;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * <p>名称：com.bob.viewpageranimator.transFormer.MyPageTransFormer</p>
 * <p>描述：</p>
 * <pre>
 *  兼容动画3.0一下版本
 *  但是在ViewPage的setPageTransformer方法中还是在判断是否小于3.0版本。
 *  因此我们需要自定义一个ViewPager，重写该方法
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/6/13:43
 */

public class MyPageTransFormer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;
    private static final String TAG = MyPageTransFormer.class.getSimpleName();

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        //A切换到B 可见度(position) A页从1-0 B页0-1
        Log.e(TAG, "view-->" + view +  ",position-->" + position);

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            //这页是向左的屏幕。
            ViewHelper.setAlpha(view, 0f);
            //view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]



            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                ViewHelper.setTranslationX(view, (horzMargin - vertMargin / 2));
               // view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                ViewHelper.setTranslationX(view, (-horzMargin + vertMargin / 2));
               // view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between MIN_SCALE and 1)
            ViewHelper.setScaleX(view, scaleFactor);
            ViewHelper.setScaleY(view, scaleFactor);
          //  view.setScaleX(scaleFactor);
           // view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            ViewHelper.setAlpha(view, (MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA)));
           /* view.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));*/

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            ViewHelper.setAlpha(view, 0);
            //view.setAlpha(0);
        }
    }
}
