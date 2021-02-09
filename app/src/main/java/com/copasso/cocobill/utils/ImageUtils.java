package com.copasso.cocobill.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import com.copasso.cocobill.MyApplication;
import com.copasso.cocobill.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhouas666 on 2017/12/26.
 */
public class ImageUtils {

    /**
     * Save image to the SD card
     *
     * @param photoBitmap
     * @param photoName
     * @param path
     */
    public static String savePhoto(Bitmap photoBitmap, String path,
                                   String photoName) {
        String localPath = null;
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File photoFile = new File(path+"/"+photoName);
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(photoFile);
                if (photoBitmap != null) {
                    if (photoBitmap.compress(Bitmap.CompressFormat.PNG, 100,
                            fileOutputStream)) { // 转换完成
                        localPath = photoFile.getPath();
                        fileOutputStream.flush();
                    }
                }
            } catch (FileNotFoundException e) {
                photoFile.delete();
                localPath = null;
                e.printStackTrace();
            } catch (IOException e) {
                photoFile.delete();
                localPath = null;
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        fileOutputStream = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return localPath;
    }

    /**
     * 转换图片成圆形
     *
     * @param bitmap 传入Bitmap对象
     * @return
     */
    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;
        float left,top,right,bottom,dst_left,dst_top,dst_right,dst_bottom;
        if (width <= height) {
            roundPx = width / 2;
            top = 0;
            bottom = width;
            left = 0;
            right = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        } else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }
        Bitmap output = Bitmap.createBitmap(width,
                height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect src = new Rect((int)left, (int)top, (int)right, (int)bottom);
        final Rect dst = new Rect((int)dst_left, (int)dst_top, (int)dst_right, (int)dst_bottom);
        final RectF rectF = new RectF(dst);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, src, dst, paint);
        return output;
    }

    /**
     * 根据图片url设置与之相对应的本地图片
     * @param imgUrl
     * @return
     */
    public static Drawable getDrawable(String imgUrl){
        Drawable drawable = null;
        if("sort_shouxufei.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_shouxufei);
        } else if("sort_huankuan.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_huankuan);
        } else if("sort_yongjin.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_yongjin);
        } else if("sort_lingqian.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_lingqian);
        } else if("sort_yiban.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_yiban);
        } else if("sort_lixi.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_lixi);
        } else if("sort_gouwu.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_gouwu);
        } else if("sort_weiyuejin.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_weiyuejin);
        } else if("sort_zhufang.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_zhufang);
        } else if("sort_bangong.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_bangong);
        } else if("sort_canyin.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_canyin);
        } else if("sort_yiliao.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_yiliao);
        } else if("sort_tongxun.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_tongxun);
        } else if("sort_yundong.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_yundong);
        } else if("sort_yule.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_yule);
        } else if("sort_jujia.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_jujia);
        } else if("sort_chongwu.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_chongwu);
        } else if("sort_shuma.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_shuma);
        } else if("sort_juanzeng.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_juanzeng);
        } else if("sort_lingshi.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_lingshi);
        } else if("sort_jiangjin.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_jiangjin);
        } else if("sort_haizi.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_haizi);
        } else if("sort_zhangbei.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_zhangbei);
        } else if("sort_liwu.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_liwu);
        } else if("sort_xuexi.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_xuexi);
        } else if("sort_shuiguo.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_shuiguo);
        } else if("sort_meirong.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_meirong);
        } else if("sort_weixiu.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_weixiu);
        } else if("sort_lvxing.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_lvxing);
        } else if("sort_jiaotong.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_jiaotong);
        } else if("sort_jiushui.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_jiushui);
        } else if("sort_lijin.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_lijin);
        } else if("sort_fanxian.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_fanxian);
        } else if("sort_jianzhi.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_jianzhi);
        } else if("sort_tianjiade.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_tianjiade);
        } else if("sort_tianjia.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.sort_tianjia);
        } else if("card_cash.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.card_cash);
        } else if("card_account.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.card_account);
        } else if("card_account.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.card_account);
        } else {
            drawable=null;
        }

        return drawable;
    }
}
