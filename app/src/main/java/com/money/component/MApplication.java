package com.money.component;

import android.content.Context;
import android.util.TypedValue;

import com.alibaba.android.arouter.launcher.ARouter;
import com.money.common.base.BaseApplication;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender;

/**
 * Created by Administrator on 2018/2/24.
 */

@ReportsCrashes(
        reportType = HttpSender.Type.JSON,
        formUri = "http://192.168.4.23:8080/ssm/api/app/user/crash",
        mode = ReportingInteractionMode.TOAST,
        customReportContent = {
            ReportField.APP_VERSION_NAME,
            ReportField.APP_VERSION_CODE,
            ReportField.PHONE_MODEL,
            ReportField.CUSTOM_DATA
    },
    resToastText = R.string.crash_toast_text)
public class MApplication extends BaseApplication {

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate).setEnableLastTime(false)
                        .setTextSizeTitle(TypedValue.COMPLEX_UNIT_DIP, 14)
                        .setArrowResource(R.drawable.refresh_arrow_down);
//                        .setProgressResource(R.drawable.jiazai);//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate)
                        .setTextSizeTitle(TypedValue.COMPLEX_UNIT_DIP, 14)
                        .setArrowResource(R.drawable.refresh_arrow_down);
            }
        });
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ARouter
        ARouter.openLog();
        ARouter.openDebug();

        ARouter.init(this);

        initLogger();

        //初始化崩溃日志
//        ACRA.init(this);
    }
    private void initLogger(){
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(5)        // (Optional) Hides internal method calls up to offset. Default 5
                .showThreadInfo(true)
                .tag("ticket")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

    }
}
