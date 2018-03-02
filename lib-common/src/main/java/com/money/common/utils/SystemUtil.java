package com.money.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class SystemUtil {
	
	/**
	 * 获取sdk
	 * @return
	 */
	public static int getAndroidSDKVersion() {
		@SuppressWarnings("deprecation")
        String sdk = android.os.Build.VERSION.SDK;
		return Integer.valueOf(sdk);
	}
	
	/**
	 * 获取状态栏的高度
	 * @param context
	 * @return
	 */
	public static int getStatusHeight(Context context) {
	    int statusHeight = -1;
	    try {
	        Class<?> clazz = Class.forName("com.android.internal.R$dimen");
	        Object object = clazz.newInstance();
	        int height = Integer.parseInt(clazz.getField("status_bar_height")
	                .get(object).toString());
	        statusHeight = context.getResources().getDimensionPixelSize(height);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statusHeight;
	}
	
	/**
	 * 判断是否是wifi上网
	 * @param context
	 * @return
	 */
	public static boolean isWifi(Context context) {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager
                .getActiveNetworkInfo();  
        if(mNetworkInfo.isAvailable()){  
             int netWorkType =mNetworkInfo.getType();  
             if(netWorkType== ConnectivityManager.TYPE_WIFI){
                 return true;
             }else if(netWorkType== ConnectivityManager.TYPE_MOBILE){
                 return false;
             }else{  
                 return false;
             }  
        }else{  
        	return false;
        }  
    }  
}
