package com.kermitlin.lighttherapypat.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.kermitlin.lighttherapypat.R;
import com.kermitlin.lighttherapypat.ui.therapyLists.MainActivity;
import com.kermitlin.lighttherapypat.utils.Constants;

public class TherapyGo extends BaseActivity {

    private ImageView mImageView;
    private int mPhaseCount;
    private String[] mProcessColor;
    private int[] mProcessHz, mProcessTime;
    private int processTimeCounter = 0, processCounter = 0;
    private AnimationDrawable frameAnimation = null;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_therapy_go);

        /* Get the push ID from the extra passed by ShoppingListFragment */
        Intent intent = this.getIntent();
        mPhaseCount = Integer.parseInt(intent.getStringExtra(Constants.KEY_LIST_COUNT));
        mProcessColor = intent.getStringArrayExtra(Constants.KEY_ARRAY_COLOR);
        mProcessHz = intent.getIntArrayExtra(Constants.KEY_ARRAY_HZ);
        mProcessTime = intent.getIntArrayExtra(Constants.KEY_ARRAY_TIME);

        processCounter = Integer.parseInt(intent.getStringExtra(Constants.KEY_PROCESS_COUNTER));

        initializeScreen();

        mHandler.postDelayed(processCountRunnable, 0);
    }

    private void initializeScreen() {
        mImageView = (ImageView) findViewById(R.id.animation_iv);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
            startAnimation();
    }

    protected void startAnimation() {
        frameAnimation = new AnimationDrawable();
        int randomNum = (int)(Math.random()* 97 + 1);
        //mImageView.setBackgroundResource(R.drawable.frame_animation);
        //frameAnimation = (AnimationDrawable)mImageView.getBackground();

        if ("red".equals(mProcessColor[processCounter])) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_red);
            Drawable frame = new BitmapDrawable(getResources(), bmp);
            frameAnimation.addFrame(frame, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
            Drawable frame2 = new BitmapDrawable(getResources(), bmp2);
            frameAnimation.addFrame(frame2, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            mImageView.setBackgroundDrawable(frameAnimation);
        } else if ("orange".equals(mProcessColor[processCounter])) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_orange);
            Drawable frame = new BitmapDrawable(getResources(), bmp);
            frameAnimation.addFrame(frame, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
            Drawable frame2 = new BitmapDrawable(getResources(), bmp2);
            frameAnimation.addFrame(frame2, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            mImageView.setBackgroundDrawable(frameAnimation);
        } else if ("yellow".equals(mProcessColor[processCounter])) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_yellow);
            Drawable frame = new BitmapDrawable(getResources(), bmp);
            frameAnimation.addFrame(frame, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
            Drawable frame2 = new BitmapDrawable(getResources(), bmp2);
            frameAnimation.addFrame(frame2, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            mImageView.setBackgroundDrawable(frameAnimation);
        } else if ("green".equals(mProcessColor[processCounter])) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_green);
            Drawable frame = new BitmapDrawable(getResources(), bmp);
            frameAnimation.addFrame(frame, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
            Drawable frame2 = new BitmapDrawable(getResources(), bmp2);
            frameAnimation.addFrame(frame2, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            mImageView.setBackgroundDrawable(frameAnimation);
        } else if ("blue".equals(mProcessColor[processCounter])) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_blue);
            Drawable frame = new BitmapDrawable(getResources(), bmp);
            frameAnimation.addFrame(frame, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
            Drawable frame2 = new BitmapDrawable(getResources(), bmp2);
            frameAnimation.addFrame(frame2, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            mImageView.setBackgroundDrawable(frameAnimation);
        } else if ("purple".equals(mProcessColor[processCounter])) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_purple);
            Drawable frame = new BitmapDrawable(getResources(), bmp);
            frameAnimation.addFrame(frame, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
            Drawable frame2 = new BitmapDrawable(getResources(), bmp2);
            frameAnimation.addFrame(frame2, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            mImageView.setBackgroundDrawable(frameAnimation);
        } else if ("black".equals(mProcessColor[processCounter])) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
            Drawable frame = new BitmapDrawable(getResources(), bmp);
            frameAnimation.addFrame(frame, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
            Drawable frame2 = new BitmapDrawable(getResources(), bmp2);
            frameAnimation.addFrame(frame2, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            mImageView.setBackgroundDrawable(frameAnimation);
        } else if ("white".equals(mProcessColor[processCounter])) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_white);
            Drawable frame = new BitmapDrawable(getResources(), bmp);
            frameAnimation.addFrame(frame, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
            Drawable frame2 = new BitmapDrawable(getResources(), bmp2);
            frameAnimation.addFrame(frame2, (int) (1000.0 / (mProcessHz[processCounter] * 2.0)));

            mImageView.setBackgroundDrawable(frameAnimation);
        } else if ("random".equals(mProcessColor[processCounter])) {

            Bitmap bmp, bmp2;
            Drawable frame, frame2;

            switch (randomNum%10){
                case 0:
                    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_red);
                    frame = new BitmapDrawable(getResources(), bmp);
                    frameAnimation.addFrame(frame, (int) (1000.0 / (randomNum * 2.0)));

                    bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
                    frame2 = new BitmapDrawable(getResources(), bmp2);
                    frameAnimation.addFrame(frame2, (int) (1000.0 / (randomNum * 2.0)));

                    mImageView.setBackgroundDrawable(frameAnimation);
                    break;

                case 1:
                    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_orange);
                    frame = new BitmapDrawable(getResources(), bmp);
                    frameAnimation.addFrame(frame, (int) (1000.0 / (randomNum * 2.0)));

                    bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
                    frame2 = new BitmapDrawable(getResources(), bmp2);
                    frameAnimation.addFrame(frame2, (int) (1000.0 / (randomNum * 2.0)));

                    mImageView.setBackgroundDrawable(frameAnimation);
                    break;

                case 2:
                    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_yellow);
                    frame = new BitmapDrawable(getResources(), bmp);
                    frameAnimation.addFrame(frame, (int) (1000.0 / (randomNum * 2.0)));

                    bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
                    frame2 = new BitmapDrawable(getResources(), bmp2);
                    frameAnimation.addFrame(frame2, (int) (1000.0 / (randomNum * 2.0)));

                    mImageView.setBackgroundDrawable(frameAnimation);
                    break;

                case 3:
                    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_green);
                    frame = new BitmapDrawable(getResources(), bmp);
                    frameAnimation.addFrame(frame, (int) (1000.0 / (randomNum * 2.0)));

                    bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
                    frame2 = new BitmapDrawable(getResources(), bmp2);
                    frameAnimation.addFrame(frame2, (int) (1000.0 / (randomNum * 2.0)));

                    mImageView.setBackgroundDrawable(frameAnimation);
                    break;

                case 4:
                    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_blue);
                    frame = new BitmapDrawable(getResources(), bmp);
                    frameAnimation.addFrame(frame, (int) (1000.0 / (randomNum * 2.0)));

                    bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
                    frame2 = new BitmapDrawable(getResources(), bmp2);
                    frameAnimation.addFrame(frame2, (int) (1000.0 / (randomNum * 2.0)));

                    mImageView.setBackgroundDrawable(frameAnimation);
                    break;

                case 5:
                    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_purple);
                    frame = new BitmapDrawable(getResources(), bmp);
                    frameAnimation.addFrame(frame, (int) (1000.0 / (randomNum * 2.0)));

                    bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
                    frame2 = new BitmapDrawable(getResources(), bmp2);
                    frameAnimation.addFrame(frame2, (int) (1000.0 / (randomNum * 2.0)));

                    mImageView.setBackgroundDrawable(frameAnimation);
                    break;

                case 6:
                    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
                    frame = new BitmapDrawable(getResources(), bmp);
                    frameAnimation.addFrame(frame, (int) (1000.0 / (randomNum * 2.0)));

                    bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
                    frame2 = new BitmapDrawable(getResources(), bmp2);
                    frameAnimation.addFrame(frame2, (int) (1000.0 / (randomNum * 2.0)));

                    mImageView.setBackgroundDrawable(frameAnimation);
                    break;

                case 7:
                    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color_white);
                    frame = new BitmapDrawable(getResources(), bmp);
                    frameAnimation.addFrame(frame, (int) (1000.0 / (randomNum * 2.0)));

                    bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.color_black);
                    frame2 = new BitmapDrawable(getResources(), bmp2);
                    frameAnimation.addFrame(frame2, (int) (1000.0 / (randomNum * 2.0)));

                    mImageView.setBackgroundDrawable(frameAnimation);
                    break;

                default:
                    break;
            }
        }

        frameAnimation.setOneShot(false);
        frameAnimation.start();
    }

    private Runnable processCountRunnable = new Runnable() {
        public void run() {
            mHandler.postDelayed(this, 1000);

            processTimeCounter = processTimeCounter + 1;

            if (processTimeCounter == mProcessTime[processCounter] + 1) {

                Log.v("XDDDDDDDDDD",String.valueOf(processCounter));
                Log.v("XDDDDDDDDDD",String.valueOf(mPhaseCount));
                //check phaseCount
                if (processCounter < mPhaseCount - 1) {
                    processCounter = processCounter + 1;

                    Intent intent = new Intent();
                    intent.setClass(TherapyGo.this, TherapyGo.class);
                    intent.putExtra(Constants.KEY_LIST_COUNT, String.valueOf(mPhaseCount));
                    intent.putExtra(Constants.KEY_ARRAY_COLOR, mProcessColor);
                    intent.putExtra(Constants.KEY_ARRAY_HZ, mProcessHz);
                    intent.putExtra(Constants.KEY_ARRAY_TIME, mProcessTime);
                    intent.putExtra(Constants.KEY_PROCESS_COUNTER, String.valueOf(processCounter));
                    startActivity(intent);
                    mHandler.removeCallbacks(this);
                    finish();

                } else if (processCounter == mPhaseCount - 1) {
                    Intent intent = new Intent();
                    intent.setClass(TherapyGo.this, MainActivity.class);
                    startActivity(intent);
                    mHandler.removeCallbacks(this);
                    finish();
                }
            }
        }
    };
}
