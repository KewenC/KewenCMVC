package com.kewenc.kewencmvc.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.kewenc.kewencmvc.R;

public class Model {
    private final Handler handler = new Handler();
    private OnStateChangeListener mListener;
    private Bitmap bitmap;
    private Context context;
    public interface OnStateChangeListener{
        void onStateChanged(Bitmap bitmap);
    }
    public Model(Context context){
        this.context = context;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
    }
    public void setOnStateChangedListener(OnStateChangeListener onStateChangedListener){
        mListener = onStateChangedListener;
    }
    public void loadImage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    bitmap = BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_app_name);
                    if (mListener != null){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                mListener.onStateChanged(bitmap);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
