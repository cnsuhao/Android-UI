package com.my.lib;


import com.my.lib.core.BaseEffects;
import com.my.lib.core.FadeIn;
import com.my.lib.core.Fall;
import com.my.lib.core.FlipH;
import com.my.lib.core.FlipV;
import com.my.lib.core.NewsPaper;
import com.my.lib.core.RotateBottom;
import com.my.lib.core.RotateLeft;
import com.my.lib.core.Shake;
import com.my.lib.core.SideFall;
import com.my.lib.core.SlideBottom;
import com.my.lib.core.SlideLeft;
import com.my.lib.core.SlideRight;
import com.my.lib.core.SlideTop;
import com.my.lib.core.Slit;

/**
 * Created by lee on 2014/7/30.
 */
public enum  Effectstype {

    FADEIN(FadeIn.class),
    SLIDELEFT(SlideLeft.class),
    SLIDETOP(SlideTop.class),
    SLIDEBOTTOM(SlideBottom.class),
    SLIDERIGHT(SlideRight.class),
    FALL(Fall.class),
    NEWSPAGER(NewsPaper.class),
    FLIPH(FlipH.class),
    FLIPV(FlipV.class),
    ROTATEBOTTOM(RotateBottom.class),
    ROTATELEFT(RotateLeft.class),
    SLIT(Slit.class),
    SHAKE(Shake.class),
    SIDEFILL(SideFall.class);
    private Class effectsClazz;

    private Effectstype(Class mclass) {
        effectsClazz = mclass;
    }

    public BaseEffects getAnimator() {
        try {
            return (BaseEffects) effectsClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
