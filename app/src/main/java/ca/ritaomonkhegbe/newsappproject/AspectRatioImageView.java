package ca.ritaomonkhegbe.newsappproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class AspectRatioImageView extends AppCompatImageView {
    private float aspectRatio = 1f; // default aspect ratio
    private boolean isCircle = false; // default shape is rectangle

    public AspectRatioImageView(Context context) {
        super(context);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
        requestLayout();
    }

    public void setShape(boolean isCircle) {
        this.isCircle = isCircle;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = (int) (width / aspectRatio);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (isCircle) {
            Path clipPath = new Path();
            clipPath.addCircle(
                    getWidth() / 2f,
                    getHeight() / 2f,
                    Math.min(getWidth(), getHeight()) / 2f,
                    Path.Direction.CW);
            canvas.clipPath(clipPath);
        }
        super.onDraw(canvas);
    }
}
