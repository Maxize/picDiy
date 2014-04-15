package com.amnon.picdiy.entity;

import java.io.InputStream;

import com.amnon.picdiy.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MapView extends SurfaceView implements Callback, Runnable{
    public static Context m_context;
    
    public boolean isExit = false;
    
    Bitmap m_bitmap = null;
    
    Resources m_resources = null;
    
    private SurfaceHolder m_sfh;
    
    private Thread m_mainThread;
    
    private Canvas m_canvas;
    
    private Paint m_paint;
    
    private int m_screenW, m_screenH;
    
    private int[][] m_linker_a = {
                              {8, 780},
                              {33, 780},
                              {58, 780},
    };
    
    private int[][] m_buttonPos_a = { 
                                  {8, 780},
                                  {73, 780},
                                  {138, 780},
                                  {193, 780},
                                  {258, 780},
                                  {313, 780},
    };
    

    public MapView(Context context, AttributeSet attrs) {
        super(context);
        this.m_context = context;
        m_sfh = this.getHolder();
        m_sfh.addCallback(this);
        
        m_paint = new Paint();
        
        this.setKeepScreenOn(true);
        
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        m_screenW = this.getWidth();
        m_screenH = this.getHeight();
        m_bitmap = ReadBitMap(m_context, R.drawable.button_level02);
        m_mainThread = new Thread(this);
        m_mainThread.start();
        
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        isExit = true;
        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            long prevTime, restTime;
            // TODO 设置测试用
            while (!isExit) {
                prevTime = System.currentTimeMillis();
                synchronized (m_sfh) {
                    m_canvas = m_sfh.lockCanvas();
                    draw();
                    /** 绘制结束后解锁显示在屏幕上 **/
                    m_sfh.unlockCanvasAndPost(m_canvas);
                }
                
                restTime = (prevTime + 80) - System.currentTimeMillis();
                if (0 < restTime) {
                    if (80 < restTime) {
                        restTime = 80;
                    }
                    Thread.sleep(restTime);
                }
            }
        } catch (Exception e) {
            System.out.println("error!!!!!!!!!" + e);
        }
    }
    
    
    /**
     *  
     */
    public void draw(){
        
        drawMap(m_canvas, m_paint, m_bitmap);
        
    }
    
    
    /**
     * 
     */
    private void drawMap(Canvas canvas, Paint paint, Bitmap bitmap) {
        
        for (int i = 0; i < m_buttonPos_a.length; i++) {
            drawImage(canvas, paint, bitmap, m_buttonPos_a[i][0], m_buttonPos_a[i][1]);
        }
    }
    
    private void drawImage(Canvas canvas, Paint paint, Bitmap bitmap, int x, int y) {
        canvas.save();
//        canvas.clipRect(x, y, x + src_xp, y + src_yp);
        canvas.drawBitmap(bitmap, x, y, paint);
//        canvas.drawBitmap();
        canvas.restore();
    }
    
    /**
     * 读取本地资源的图片
     * 
     * @param context
     * @param resId
     * @return
     */
    public Bitmap ReadBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        // 获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
    
    public static int dip2px(float dipValue){ 
        final float scale = m_context.getResources().getDisplayMetrics().density; 
        return (int)(dipValue * scale + 0.5f); 
    } 

    public static int px2dip(float pxValue){ 
            final float scale = m_context.getResources().getDisplayMetrics().density; 
            return (int)(pxValue / scale + 0.5f); 
    }
    

}
