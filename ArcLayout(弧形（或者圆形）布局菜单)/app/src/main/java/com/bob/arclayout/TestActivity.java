/**<p>项目名：ArcLayout</p>
 * <p>包名：	com.bob.arclayout</p>
 * <p>文件名：TestActivity.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/6/24/16:17.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.arclayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

import com.bob.library.ArcLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>名称：com.bob.arclayout.TestActivity</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/6/24/16:17
 */

public class TestActivity extends ActionBarActivity {

    private static final String KEY_DEMO = "demo";
    private Button mButton;
    private ArcLayout mArcLayout;
    private boolean isOpen = false;



    public static void startActivity(Context context, Demo demo){
        Intent intent = new Intent(context, TestActivity.class);
        intent.putExtra(KEY_DEMO, demo.name());
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        mButton = (Button) findViewById(R.id.text_fab);
        mArcLayout = (ArcLayout) findViewById(R.id.text_arc_layout);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    //mArcLayout.setVisibility(View.GONE);
                    hideMenu();
                    isOpen = false;
                }else{
                  //  mArcLayout.setVisibility(View.VISIBLE);
                    showMenu();
                    isOpen = true;
                }
            }
        });



    }

    private void showMenu() {
        mArcLayout.setVisibility(View.VISIBLE);

        List<Animator> animList = new ArrayList<>();

        for (int i = 0, len = mArcLayout.getChildCount(); i < len; i++) {
            animList.add(createShowItemAnimator(mArcLayout.getChildAt(i)));
        }

        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(400);
        animSet.setInterpolator(new OvershootInterpolator());
        animSet.playTogether(animList);
        animSet.start();
    }

    private void hideMenu() {

        List<Animator> animList = new ArrayList<>();

        for (int i = mArcLayout.getChildCount() - 1; i >= 0; i--) {
            animList.add(createHideItemAnimator(mArcLayout.getChildAt(i)));
        }

        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(400);
        animSet.setInterpolator(new AnticipateInterpolator());
        animSet.playTogether(animList);
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mArcLayout.setVisibility(View.GONE);
            }
        });
        animSet.start();

    }


    private Animator createHideItemAnimator(final View item) {
        float dx = mButton.getX() - item.getX();
        float dy = mButton.getY() - item.getY();

        Animator anim = ObjectAnimator.ofPropertyValuesHolder(
                item,
                AnimatorUtils.rotation(720f, 0f),
                AnimatorUtils.translationX(0f, dx),
                AnimatorUtils.translationY(0f, dy)
        );

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                item.setTranslationX(0f);
                item.setTranslationY(0f);
            }
        });

        return anim;
    }



    private Animator createShowItemAnimator(View item) {

        float dx = mButton.getX() - item.getX();
        float dy = mButton.getY() - item.getY();

        item.setRotation(0f);
        item.setTranslationX(dx);
        item.setTranslationY(dy);

        Animator anim = ObjectAnimator.ofPropertyValuesHolder(
                item,
                AnimatorUtils.rotation(0f, 720f),
                AnimatorUtils.translationX(dx, 0f),
                AnimatorUtils.translationY(dy, 0f)
        );

        return anim;
    }
}
