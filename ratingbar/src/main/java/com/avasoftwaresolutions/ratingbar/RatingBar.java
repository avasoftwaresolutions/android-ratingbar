package com.avasoftwaresolutions.ratingbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RatingBar extends LinearLayout {

    private ImageView[] starArray;
    private Drawable filled;
    private Drawable unfilled;
    private int filledColor;
    private int unfilledColor;
    private int selected = 0;

    public RatingBar(Context context) {
        super(context);
        this.init(context, null);
    }

    public RatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context, attrs);
    }

    public RatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RatingBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.init(context, attrs);
    }

    public void setStarDrawable(Drawable drawable) {
        this.unfilled = drawable;
        recreate();
    }

    public void setStarDrawableFilled(Drawable drawable) {
        this.filled = drawable;
        recreate();
    }

    public void setFilledTint(int color) {
        this.filledColor = color;
        recreate();
    }

    public void setUnfilledTint(int color) {
        this.unfilledColor = color;
        recreate();
    }

    public void setOnClickListener(final OnClickListener listener) {
        int n = starArray.length;
        for(int i = 0; i < n; i++) {
            final int finalI = i;
            starArray[i].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    starClick(finalI);
                    listener.onClick(RatingBar.this);
                }
            });
        }
    }

    public int getStars() { return selected + 1; }

    private void init(Context context, AttributeSet attrs) {

        LayoutInflater.from(context).inflate(R.layout.layout_rating_bar, this, true);
        LinearLayout layout = findViewById(R.id.lrb);

        if(attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.RatingBar,
                    0, 0
            );

            int stars = a.getInt(R.styleable.RatingBar_max_stars, 5);
            filledColor = a.getColor(R.styleable.RatingBar_filled_tint, Color.YELLOW);
            unfilledColor = a.getColor(R.styleable.RatingBar_unfilled_tint, Color.YELLOW);

            if(a.getDrawable(R.styleable.RatingBar_star_drawable) != null) {
                unfilled = a.getDrawable(R.styleable.RatingBar_star_drawable);
            } else {
                unfilled = getResources().getDrawable(R.drawable.ic_star_unfilled);
            }

            if(a.getDrawable(R.styleable.RatingBar_star_drawable_filled) != null) {
                filled = a.getDrawable(R.styleable.RatingBar_star_drawable_filled);
            } else {
                filled = getResources().getDrawable(R.drawable.ic_star_filled);
            }

            starArray = new ImageView[stars];

            for(int i = 0; i < stars; i++) {
                createStar(
                        context,
                        layout,
                        unfilled,
                        unfilledColor,
                        i
                );
            }
        }
    }

    private void recreate() {
        for(int x = 0; x < starArray.length; x++) {
            if(x <=  selected) {
                starArray[x].setImageDrawable(filled);
                starArray[x].setColorFilter(filledColor);
            } else {
                starArray[x].setImageDrawable(unfilled);
                starArray[x].setColorFilter(unfilledColor);
            }
        }
    }

    private void createStar(Context context, LinearLayout parent, Drawable drawable, int tintColor, final int i) {

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT,
                1.0f
        );

        ImageView star = new ImageView(context);
        star.setLayoutParams(params);
        star.setImageDrawable(drawable);
        star.setColorFilter(tintColor);

        star.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                starClick(i);
            }
        });

        parent.addView(star);

        starArray[i] = star;
    }

    private void starClick(int i) {
        selected = i;
        recreate();
    }
}
