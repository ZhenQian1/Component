package com.money.common.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

public class DeviceUtil {
	
	public static String getMacAddress(Context context){
		WifiManager wifiMgr = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);  
		WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());  
		if (null != info) {  
		    return info.getMacAddress();  
		}else{
			return null;
		}
	}
	
	public static String getIMEI(Context context){
		return ((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE))
				.getDeviceId();
	}
	public static String getMacAddress2IMEI(Context context){
		WifiManager wifiMgr = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);  
		WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());  
		String macAddress = "";
		if (null != info) {  
			macAddress = info.getMacAddress();  
		}
		return macAddress+((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE))
				.getDeviceId();
	}
	
	public static String getMacAddress2IMEIMD5(Context context){
		WifiManager wifiMgr = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);  
		WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());  
		String macAddress = "";
		if (null != info) {  
			macAddress = info.getMacAddress();  
		}
		return Md5Util.Md5(macAddress+((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE))
				.getDeviceId());
	}
}
