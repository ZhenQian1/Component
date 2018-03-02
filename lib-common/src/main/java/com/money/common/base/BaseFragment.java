package com.money.common.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Money.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = BaseActivity.class.getSimpleName();
    public BaseActivity mContext;

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = (BaseActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (initLayoutId() != 0){
            View view = inflater.inflate(initLayoutId(), container,false);

            unbinder = ButterKnife.bind(this, view);
            overloadInitView(view);
            overloadSetOnClickListener();
            overloadSetValue();

            return  view;
        }

        Logger.d("layoutId is 0");

        return null;
    }

    public abstract void overloadInitView(View view);

    public abstract void overloadSetOnClickListener();

    public abstract void overloadSetValue();

    public abstract void overloadOnClickListener(View v, int id, Object tag);

    public abstract int initLayoutId();

    public abstract String getReqTag();

    @Override
    public void onClick(View v) {
        overloadOnClickListener(v,v.getId(), v.getTag());
    }


    private BaseBroadcastReceiver receiver;
    private IntentFilter infilter;

    private class BaseBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.e(TAG, "onReceive,action:"+action);
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
        mContext.registerReceiver(receiver, infilter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //解绑
        if (unbinder != null) {
            unbinder.unbind();
        }
        //注销广播
        if(receiver != null){
            receiver.getDebugUnregister();
        }
    }
}
