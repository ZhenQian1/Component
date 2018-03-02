package com.money.common.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.money.common.R;
import com.money.common.http.manager.RxApiManager;
import com.money.common.utils.StatusBarUtil;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;

/**
 * Created by Money on 2017/11/16.
 */

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener{


    private Toast mToast;
    public boolean mAllowFullScreen = false;
    public int statusColor = R.color.white;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (initLayoutId() != 0){
            setContentView(initLayoutId());
            ButterKnife.bind(this);
            overloadInitView(savedInstanceState);
            overloadSetOnClickListener();
            overloadSetValue();

            if (mAllowFullScreen){
                StatusBarUtil.transparencyBar(this);
            }else{
                StatusBarUtil.StatusBarLightMode(this);
                StatusBarUtil.setStatusBarColor(this, statusColor);
            }
        }else{
            Logger.d("layoutId is 0");
        }
    }


    public abstract void overloadInitView(Bundle savedInstanceState);

    public abstract void overloadSetOnClickListener();

    public abstract void overloadSetValue();

    public abstract void overloadOnClickListener(View v, int id, Object tag);

    public abstract int initLayoutId();

    public abstract String getReqTag();

    @Override
    public void onClick(View v) {
        overloadOnClickListener(v,v.getId(), v.getTag());
    }

    public void showSignToast(final String content){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (mToast != null) {
                    mToast.cancel();
                }
                mToast = Toast.makeText(BaseActivity.this, content, Toast.LENGTH_SHORT);
                mToast.show();
            }
        });
    }

    public void showSignToast(int stringId){
        showSignToast(getResources().getString(stringId));
    }


    private BaseBroadcastReceiver receiver;
    private IntentFilter infilter;

    private class BaseBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Logger.d("onReceive,action:" + action);
            overloadOnReceive(action,intent);
        }
    };

    public abstract void overloadOnReceive(String action, Intent intent);

    public void addAction(String... action){
        if(infilter==null){
            infilter = new IntentFilter();
        }
        if(receiver==null){
            receiver = new BaseBroadcastReceiver();
        }
        if(action!=null){
            for(int i=0;i<action.length;i++){
                infilter.addAction(action[i]);
            }
        }
        registerReceiver(receiver, infilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        RxApiManager.getINSTANCE().cancel(getReqTag());
        if (receiver != null){
            unregisterReceiver(receiver);
        }
    }
}
