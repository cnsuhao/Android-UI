/**<p>项目名：ViewPagerAnimator</p>
 * <p>包名：	com.bob.viewpageranimator.transFormer</p>
 * <p>文件名：ObliquePageTransFormer.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/6/15:16.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.viewpageranimator.transFormer;

import android.view.View;

import com.bob.viewpageranimator.widget.ViewPager;
import com.nineoldandroids.view.ViewHelper;

/**
 * <p>名称：com.bob.viewpageranimator.transFormer.ObliquePageTransFormer</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/6/15:16
 */

public class ObliquePageTransFormer implements ViewPager.PageTransformer {

    private static final float OBLIQUE = 20.0f;
    private float mRot;

    @Override
    public void transformPage(View view, float position) {

        //A切换到B 可见度(position) A页从1-0 B页0-1
        if (position < -1) { // [-Infinity,-1)
            ViewHelper.setRotation(view, 0f);
        } else if (position <= 1) { // [-1,1]


            if (position < 0)
            {

                mRot = (OBLIQUE * position);
                ViewHelper.setPivotX(view, view.getMeasuredWidth() * 0.5f);
                ViewHelper.setPivotY(view, view.getMeasuredHeight());
                ViewHelper.setRotation(view, mRot);
            } else
            {

                mRot = (OBLIQUE * position);
                ViewHelper.setPivotX(view, view.getMeasuredWidth() * 0.5f);
                ViewHelper.setPivotY(view, view.getMeasuredHeight());
                ViewHelper.setRotation(view, mRot);
            }



        } else {
            ViewHelper.setRotation(view, 0f);
        }
    }
}
