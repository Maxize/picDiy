package com.amnon.picdiy.util;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;

public class ImageUtil {
    
    /**
     * 读取本地资源的图片
     * 
     * @param context
     * @param resId
     * @return
     */
    public static Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        // 获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
    
    /**
     * 
     * 根据 宽高设置图片 的宽高
     * @param bitmap
     * @param width
     * @param height
     * @return
     */
    public static Bitmap setBitmapWithWH(Bitmap bitmap, int width, int height){
        Bitmap newBitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height);
        return newBitmap == null ? bitmap : newBitmap;
    }

}
