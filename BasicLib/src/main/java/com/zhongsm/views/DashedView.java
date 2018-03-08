package com.zhongsm.views;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ThinkPad S5-WangJ on 2018/3/8.
 */

public class DashedView extends View {

    private int dashed;
    private int dashGap;
    private int dashedColor;



    public DashedView(Context context) {
        super(context);
    }

    public DashedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
