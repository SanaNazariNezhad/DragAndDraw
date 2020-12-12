package org.maktab.draganddraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BoxDrawingView extends View {

    private static final String TAG = "BoxDrawingView";

    private List<Box> mBoxes = new ArrayList<>();
    private Box mBoxCurrent;

    private int mColorSemiTransparentRed = 0x22ff0000;
    private int mColorOffWhite = 0xfff8efe0;

    private Paint mPaintBackground;
    private Paint mPaintBox;

    //Usage: In java code
    public BoxDrawingView(Context context) {
        super(context);

        initPaints();
    }

    //Usage: In XML
    public BoxDrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initPaints();
    }

    private void initPaints() {
        mPaintBackground = new Paint();
        mPaintBackground.setColor(mColorOffWhite);

        mPaintBox = new Paint();
        mPaintBox.setColor(mColorSemiTransparentRed);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        String action = "";
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                mBoxCurrent = new Box(current);
                mBoxes.add(mBoxCurrent);
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                if (mBoxCurrent != null) {
                    mBoxCurrent.setCurrent(current);
                    //draw
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                mBoxCurrent = null;
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                mBoxCurrent = null;
                break;
            default:
                return super.onTouchEvent(event);
        }
        Log.d(TAG, action + " at x = " + current.x + " , y = " + current.y);
        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawPaint(mPaintBackground);
        for (Box box: mBoxes) {
            float left = Math.min(box.getCurrent().x, box.getOrigin().x);
            float right = Math.max(box.getCurrent().x, box.getOrigin().x);
            float top = Math.min(box.getCurrent().y, box.getOrigin().y);
            float bottom = Math.max(box.getCurrent().y, box.getOrigin().y);
            canvas.drawRect(left, top, right, bottom, mPaintBox);
        }
    }
}
