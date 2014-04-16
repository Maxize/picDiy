package com.amnon.picdiy.entity;

import java.io.InputStream;

import com.amnon.picdiy.R;
import com.amnon.picdiy.common.DiyApplication;
import com.amnon.picdiy.common.GameConfig;
import com.amnon.picdiy.data.DataDefine;
import com.amnon.picdiy.util.ImageUtil;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MapView extends SurfaceView implements Callback, Runnable{
    public static Context m_context;
    public DiyApplication m_application;
    
    public boolean isExit = false;
    
    Bitmap m_bitmap = null;
    Bitmap m_btn_bitmap = null;
    Bitmap m_linker_bitmap = null;
    
    
    Resources m_resources = null;
    
    private SurfaceHolder m_sfh;
    
    private Thread m_mainThread;
    
    private Canvas m_canvas;
    
    private Paint m_paint;
    
    private int m_screenW, m_screenH;
    
    private int[][] m_linker_a = new int[100][3];
    
    private int[][] m_buttonPos_a = new int[100][5];;
    

    public MapView(Context context, AttributeSet attrs) {
        super(context);
        MapView.m_context = context;
        this.m_application = (DiyApplication)MapView.m_context.getApplicationContext();
        m_sfh = this.getHolder();
        m_sfh.addCallback(this);
        
        m_paint = new Paint();
        initData();
        this.setKeepScreenOn(true);
        
    }

    private void initData() {
        // TODO Auto-generated method stub
//        System.out.println(" DataDefine.m_linker_a -------------> ");
        for (int i = 0; i < DataDefine.m_linker_a.length; i++) {
//            System.out.println(" DataDefine.m_linker_a -------> " + i);
            for (int j = 0; j < DataDefine.m_linker_a[i].length; j++) {
                if (j == 0){
                    m_linker_a[i][j] = (int) Math.floor(DataDefine.m_linker_a[i][j] * GameConfig.getWeightsX() + 0.5f);
                }else if(j == 1){
                    m_linker_a[i][j] = (int) Math.floor(DataDefine.m_linker_a[i][j] * GameConfig.getWeightsY() + 0.5f);
                }else{
                    m_linker_a[i][j] = DataDefine.m_linker_a[i][j];
                }
//                System.out.println(" -------------> "+m_linker_a[i][j]);
            }
        }
        
        
//        System.out.println(" DataDefine.m_buttonPos_a -------------> ");
        for (int i = 0; i < DataDefine.m_buttonPos_a.length; i++) {
//            System.out.println(" DataDefine.m_buttonPos_a -------> " + i);
            for (int j = 0; j < DataDefine.m_buttonPos_a[i].length; j++) {
                if (j == 0){
                    m_buttonPos_a[i][j] = (int) Math.floor(DataDefine.m_buttonPos_a[i][j] * GameConfig.getWeightsX() + 0.5f);
                }else if(j == 1){
                    m_buttonPos_a[i][j] = (int) Math.floor(DataDefine.m_buttonPos_a[i][j] * GameConfig.getWeightsY() + 0.5f);
                }else{
                    m_buttonPos_a[i][j] = DataDefine.m_buttonPos_a[i][j];
                }
//                System.out.println(" -------------> "+m_buttonPos_a[i][j]);
            }
        }
        System.out.println(GameConfig.getRatio() + "===========================         ");
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        m_screenW = this.getWidth();
        m_screenH = this.getHeight();
        m_btn_bitmap = ImageUtil.readBitMap(m_context, R.drawable.button_level02);
//        m_btn_bitmap = ImageUtil.setBitmapWithWH(m_btn_bitmap, (int)Math.floor(m_btn_bitmap.getWidth()*GameConfig.getRatio()+ 0.5f), (int)Math.floor(m_btn_bitmap.getHeight()*GameConfig.getRatio()+ 0.5f));
        m_linker_bitmap = ImageUtil.readBitMap(m_context, R.drawable.button_linker01);
//        m_linker_bitmap = ImageUtil.setBitmapWithWH(m_linker_bitmap, (int)Math.floor(m_linker_bitmap.getWidth()*GameConfig.getRatio()+ 0.5f), (int)Math.floor(m_linker_bitmap.getHeight()*GameConfig.getRatio()+ 0.5f));
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
        drawLinker(m_canvas, m_paint, m_linker_bitmap);
        drawButton(m_canvas, m_paint, m_btn_bitmap);
//        drawMap(m_canvas, m_paint, m_btn_bitmap);
        
    }
    
    
    /**
     * 
     */
    private void drawButton(Canvas canvas, Paint paint, Bitmap bitmap) {
        
        for (int i = 0; i < DataDefine.m_buttonPos_a.length; i++) {
            drawImage(canvas, paint, bitmap, m_buttonPos_a[i][0], m_buttonPos_a[i][1], DataDefine.BUTTON_WIDTH, DataDefine.BUTTON_HEIGHT);
        }
    }
    
    private void drawLinker(Canvas canvas, Paint paint, Bitmap bitmap) {
        
        for (int i = 0; i < DataDefine.m_linker_a.length; i++) {
            drawImage(canvas, paint, bitmap, m_linker_a[i][0], m_linker_a[i][1], DataDefine.BUTTON_WIDTH, DataDefine.BUTTON_HEIGHT);
        }
    }
    
    private void drawImage(Canvas canvas, Paint paint, Bitmap bitmap, int x, int y, int width, int height) {
        canvas.save();
//        canvas.clipRect(x, y, x, y);
//        Bitmap afterBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
//        float wDegress = bitmap.getWidth() / w;
//        float hDegress = bitmap.getHeight() / h;
//        Matrix matrix = new Matrix();
//        matrix.setScale(wDegress, hDegress);
        canvas.drawBitmap(bitmap, x, y, paint);
//        canvas.drawBitmap();
        canvas.restore();
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
