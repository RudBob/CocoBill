package com.copasso.cocobill.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.copasso.cocobill.MyApplication;
import com.copasso.cocobill.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;

/**
 * 记账本饼状图
 */

public class PieChartUtils {

    /**
     * 初始化饼状图
     *
     * @param mChart
     */
    public static void initPieChart(PieChart mChart) {
        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        //设置饼图右下角的文字描述
//        Description description = new Description();
//        description.setText("饼状图");
//        mChart.setDescription(description);
        //设置圆盘是否转动，默认转动
        mChart.setRotationEnabled(true);
        mChart.setExtraOffsets(5, 10, 5, 5);
        mChart.setDragDecelerationFrictionCoef(0.95f);
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);
        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);
        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);
        mChart.setDrawCenterText(true);
        mChart.setHighlightPerTapEnabled(true);
        Legend l = mChart.getLegend();
        l.setEnabled(false);
    }


    /**
     * 设置饼状图数据
     *
     * @param mChart
     * @param entries
     * @param colors
     */
    public static void setPieChartData(PieChart mChart, ArrayList<PieEntry> entries, ArrayList<Integer> colors) {

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");

        dataSet.setDrawIcons(true);
        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 1));
        dataSet.setSelectionShift(5f);

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.TRANSPARENT);
//        data.setValueTypeface(mTfLight);
        mChart.setData(data);
        // undo all highlights
        mChart.highlightValues(null);


        setStartAngle(mChart);
        setAnimate(mChart);
    }


    /**
     * 设置初始角度
     *
     * @param mChart
     */
    public static void setStartAngle(PieChart mChart) {
        //--------------设置初始角度----------------------
        float[] mDrawAngles = mChart.getDrawAngles();
        float offset = mDrawAngles[0] / 2;
        mChart.setRotationAngle(90 - offset);
    }


    /**
     * 设置初始旋转动画
     *
     * @param mChart
     */
    public static void setAnimate(PieChart mChart) {
        //--------------设置动画----------------------
        mChart.animateY(1000, Easing.EasingOption.EaseInOutQuad);
        mChart.invalidate();
    }


    /**
     * 设置点击相应区域旋转角度
     *
     * @param mChart
     * @param entryIndex
     */
    public static void setRotationAngle(PieChart mChart, int entryIndex) {

        float[] mDrawAngles = mChart.getDrawAngles();

        //--------------初始角度----------------------
        float inAngle = 90 - mDrawAngles[0] / 2;

        switch (entryIndex) {
            case 0:
                mChart.setRotationAngle(inAngle);
                break;
            case 1:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] / 2));
                break;
            case 2:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] / 2));
                break;
            case 3:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] / 2));
                break;
            case 4:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] / 2));
                break;
            case 5:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] / 2));
                break;
            case 6:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] + mDrawAngles[6] / 2));
                break;
            case 7:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] + mDrawAngles[6] + mDrawAngles[7] / 2));
                break;
            case 8:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] + mDrawAngles[6] + mDrawAngles[7] + mDrawAngles[8] / 2));
                break;
            case 9:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] + mDrawAngles[6] + mDrawAngles[7] + mDrawAngles[8] + mDrawAngles[9] / 2));
                break;
            case 10:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] + mDrawAngles[6] + mDrawAngles[7] + mDrawAngles[8] + mDrawAngles[9] + mDrawAngles[10] / 2));
                break;
            case 11:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] + mDrawAngles[6] + mDrawAngles[7] + mDrawAngles[8] + mDrawAngles[9] + mDrawAngles[10] + mDrawAngles[11] / 2));
                break;
            case 12:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] + mDrawAngles[6] + mDrawAngles[7] + mDrawAngles[8] + mDrawAngles[9] + mDrawAngles[10] + mDrawAngles[11] + mDrawAngles[12] / 2));
                break;
            case 13:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] + mDrawAngles[6] + mDrawAngles[7] + mDrawAngles[8] + mDrawAngles[9] + mDrawAngles[10] + mDrawAngles[11] + mDrawAngles[12] + mDrawAngles[13] / 2));
                break;
            case 14:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] + mDrawAngles[6] + mDrawAngles[7] + mDrawAngles[8] + mDrawAngles[9] + mDrawAngles[10] + mDrawAngles[11] + mDrawAngles[12] + mDrawAngles[13] + mDrawAngles[14] / 2));
                break;
            case 15:
                mChart.setRotationAngle(inAngle - (mDrawAngles[0] / 2 + mDrawAngles[1] + mDrawAngles[2] + mDrawAngles[3] + mDrawAngles[4] + mDrawAngles[5] + mDrawAngles[6] + mDrawAngles[7] + mDrawAngles[8] + mDrawAngles[9] + mDrawAngles[10] + mDrawAngles[11] + mDrawAngles[12] + mDrawAngles[13] + mDrawAngles[14] + mDrawAngles[15] / 2));
                break;
            default:
                break;
        }

        mChart.invalidate();
    }


    /**
     * 根据图片url设置与之相对应的本地图片
     *
     * @param imgUrl
     * @return
     */
    public static Drawable getDrawable(String imgUrl) {
        Drawable drawable = null;
        if ("sort_shouxufei.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_shouxufei);
        } else if ("sort_huankuan.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_changhuanfeiyong);
        } else if ("sort_yongjin.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_yongjinjiangli);
        } else if ("sort_lingqian.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_ewaishouyi);
        } else if ("sort_yiban.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_zijinbuchang);
        } else if ("sort_lixi.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_lixi);
        } else if ("sort_gouwu.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_shangchengxiaofei);
        } else if ("sort_weiyuejin.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_weiyuejin);
        } else if ("sort_zhufang.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_zhufang);
        } else if ("sort_bangong.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_bangong);
        } else if ("sort_canyin.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_canyin);
        } else if ("sort_yiliao.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_yiliao);
        } else if ("sort_tongxun.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_tongxun);
        } else if ("sort_yundong.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_yundong);
        } else if ("sort_yule.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_yule);
        } else if ("sort_jujia.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_jujia);
        } else if ("sort_chongwu.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_chongwu);
        } else if ("sort_shuma.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_shuma);
        } else if ("sort_juanzeng.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_juanzeng);
        } else if ("sort_lingshi.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_lingshi);
        } else if ("sort_haizi.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_haizi);
        } else if ("sort_zhangbei.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_zhangbei);
        } else if ("sort_liwu.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_liwu);
        } else if ("sort_xuexi.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_xuexi);
        } else if ("sort_shuiguo.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_shuiguo);
        } else if ("sort_meirong.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_meirong);
        } else if ("sort_weixiu.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_weixiu);
        } else if ("sort_type_lvxing.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_lvxing);
        } else if ("sort_jiaotong.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_jiaotong);
        } else if ("sort_jiushui.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_jiushuiyinliao);
        } else if ("sort_lijin.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_lijin);
        } else if ("sort_jiangjin.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_jiaxi);
        } else if ("sort_fanxian.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_fanxian);
        } else if ("sort_jianzhi.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_jianzhi);
        } else if ("sort_tianjiade.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_qita);
        } else if ("sort_tianjia.png".equals(imgUrl)) {
            drawable = MyApplication.application.getResources().getDrawable(R.mipmap.type_tianjiade);
        } else {
            drawable = null;
        }

        return drawable;
    }


}
