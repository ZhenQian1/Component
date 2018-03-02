package com.money.common.utils;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

/**
 * 广播工具类
 * @author Money
 *
 */
public class BroadcastUtil {

	public static final String TAG = BroadcastUtil.class.getName();
	
	public static void sendBroadcast(Context context, String action){
		Intent intent = new Intent();
		intent.setAction(action);
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcast(Context context, String action, String backAction){
		Intent intent = new Intent();
		intent.setAction(action);
		if(backAction!=null){
			intent.putExtra(action, backAction);
		}
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcast(Context context, String action, String extraName, Serializable value){
		Intent intent = new Intent();
		intent.setAction(action);
		if(extraName!=null && value!=null){
			intent.putExtra(extraName, value);
		}
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcast(Context context, String action, String backAction, String extraName, Serializable value){
		Intent intent = new Intent();
		intent.setAction(action);
		
		if(backAction!=null){
			intent.putExtra(action, backAction);
		}
		
		if(extraName!=null && value!=null){
			intent.putExtra(extraName, value);
		}
		context.sendBroadcast(intent);
	}

	
	public static void sendBroadcast(Context context, String action, String extraName, Boolean value){
		Intent intent = new Intent();
		intent.setAction(action);
		
		if(extraName!=null && value!=null){
			intent.putExtra(extraName, value);
		}
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcast(Context context, String action, Intent intent){
		intent.setAction(action);
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcast(Context context, String action, String backAction, String extraName, String value){
		Intent intent = new Intent();
		intent.setAction(action);
		
		if(backAction!=null){
			intent.putExtra(action, backAction);
		}
		
		if(extraName!=null && value!=null){
			intent.putExtra(extraName, value);
		}
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcast(Context context, String action, String backAction, String extraName, Boolean value){
		Intent intent = new Intent();
		intent.setAction(action);
		
		if(backAction!=null){
			intent.putExtra(action, backAction);
		}
		
		if(extraName!=null && value!=null){
			intent.putExtra(extraName, value);
		}
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcast(Context context, String action, String extraName, String value){
		Intent intent = new Intent();
		intent.setAction(action);
		if(extraName!=null && value!=null){
			intent.putExtra(extraName, value);
		}
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcast(Context context, String action, String extraName, Integer value){
		Intent intent = new Intent();
		intent.setAction(action);
		if(extraName!=null && value!=null){
			intent.putExtra(extraName, value);
		}
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcast(Context context, String action, String extraName, Long value){
		Intent intent = new Intent();
		intent.setAction(action);
		if(extraName!=null && value!=null){
			intent.putExtra(extraName, value);
		}
		context.sendBroadcast(intent);
	}
}
