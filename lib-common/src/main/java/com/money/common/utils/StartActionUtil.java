package com.money.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

public class StartActionUtil {

	public static void startActivity(Context context, Class cla, boolean finishStatus){
		startActivity(context, cla, finishStatus, -1, -1);
	}

	public static void startActivity(Context context, Class cla, boolean finishStatus, Bundle bundle){
		startActivity(context, cla, finishStatus, -1, -1, bundle);
	}

	public static void startActivity(Context context, Class cla, boolean finishStatus, String key, String value){
		startActivity(context, cla, finishStatus, -1, -1, key, value);
	}

	public static void startActivity(Context context, Class cla, boolean finishStatus, String key, Serializable value){
		startActivity(context, cla, finishStatus, -1, -1, key, value);
	}

	public static void startActivity(Context context, Class cla, boolean finishStatus, String key, int value){
		startActivity(context, cla, finishStatus, -1, -1, key, value);
	}

	public static void startActivity(Context context, Class cla, boolean finishStatus, String key, boolean value){
		startActivity(context, cla, finishStatus, -1, -1, key, value);
	}

	public static void startActivity(Context context, Class cla, boolean finishStatus, String key, double value){
		startActivity(context, cla, finishStatus, -1, -1, key, value);
	}

	public static void startActivity(Context context, Class cla, boolean finishStatus, String key, float value){
		startActivity(context, cla, finishStatus, -1, -1, key, value);
	}

	@SuppressWarnings("rawtypes")
	public static void startService(Context context, Class cla){
		Intent service = new Intent();
		service.setClass(context, cla);
		context.startService(service);
	}
	@SuppressWarnings("rawtypes")
	public static void stopService(Context context, Class cla){
		Intent service = new Intent();
		service.setClass(context, cla);
		context.stopService(service);
	}
	
	@SuppressWarnings("rawtypes")
	public static void startActivity(Context context, Class cla, boolean finishStatus, int enterAnim, int exitAnim){
		Intent intent = new Intent();
		intent.setClass(context, cla);
		if(enterAnim!=-1 && exitAnim!=-1){
			((Activity) context).overridePendingTransition(enterAnim, exitAnim);
		}
		if(finishStatus){
			context.startActivity(intent);
			((Activity)context).finish();
		}else{
			context.startActivity(intent);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void startActivity(Context context, Class cla, boolean finishStatus, int enterAnim, int exitAnim, Bundle bundle){
		Intent intent = new Intent();
		intent.setClass(context, cla);
		intent.putExtras(bundle);
		if(enterAnim!=-1 && exitAnim!=-1){
			((Activity) context).overridePendingTransition(enterAnim, exitAnim);
		}
		if(finishStatus){
			context.startActivity(intent);
			((Activity)context).finish();
		}else{
			context.startActivity(intent);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void startActivity(Context context, Class cla, boolean finishStatus, int enterAnim, int exitAnim, String extraName, String extraValue){
		Intent intent = new Intent();
		intent.setClass(context, cla);
		intent.putExtra(extraName,extraValue);
		if(enterAnim!=-1 && exitAnim!=-1){
			((Activity) context).overridePendingTransition(enterAnim, exitAnim);
		}
		if(finishStatus){
			context.startActivity(intent);
			((Activity)context).finish();
		}else{
			context.startActivity(intent);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void startActivity(Context context, Class cla, boolean finishStatus, int enterAnim, int exitAnim, String extraName, Serializable serializable){
		Intent intent = new Intent();
		intent.setClass(context, cla);
		intent.putExtra(extraName,serializable);
		if(enterAnim!=-1 && exitAnim!=-1){
			((Activity) context).overridePendingTransition(enterAnim, exitAnim);
		}
		if(finishStatus){
			context.startActivity(intent);
			((Activity)context).finish();
		}else{
			context.startActivity(intent);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void startActivity(Context context, Class cla, boolean finishStatus, int enterAnim, int exitAnim, String extraName, int extraValue){
		Intent intent = new Intent();
		intent.setClass(context, cla);
		intent.putExtra(extraName,extraValue);
		if(enterAnim!=-1 && exitAnim!=-1){
			((Activity) context).overridePendingTransition(enterAnim, exitAnim);
		}
		if(finishStatus){
			context.startActivity(intent);
			((Activity)context).finish();
		}else{
			context.startActivity(intent);
		}
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public static void startActivity(Context context, Class cla, boolean finishStatus, int enterAnim, int exitAnim, String extraName, double extraValue){
		Intent intent = new Intent();
		intent.setClass(context, cla);
		intent.putExtra(extraName,extraValue);
		if(enterAnim!=-1 && exitAnim!=-1){
			((Activity) context).overridePendingTransition(enterAnim, exitAnim);
		}
		if(finishStatus){
			context.startActivity(intent);
			((Activity)context).finish();
		}else{
			context.startActivity(intent);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void startActivity(Context context, Class cla, boolean finishStatus, int enterAnim, int exitAnim, String extraName, float extraValue){
		Intent intent = new Intent();
		intent.setClass(context, cla);
		intent.putExtra(extraName,extraValue);
		if(enterAnim!=-1 && exitAnim!=-1){
			((Activity) context).overridePendingTransition(enterAnim, exitAnim);
		}
		if(finishStatus){
			context.startActivity(intent);
			((Activity)context).finish();
		}else{
			context.startActivity(intent);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void startActivity(Context context, Class cla, boolean finishStatus, int enterAnim, int exitAnim, String extraName, boolean extraValue){
		Intent intent = new Intent();
		intent.setClass(context, cla);
		intent.putExtra(extraName,extraValue);
		if(enterAnim!=-1 && exitAnim!=-1){
			((Activity) context).overridePendingTransition(enterAnim, exitAnim);
		}
		if(finishStatus){
			context.startActivity(intent);
			((Activity)context).finish();
		}else{
			context.startActivity(intent);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void startActivity(Context context, Class cla, boolean finishStatus, int enterAnim, int exitAnim, String extraName, Bundle extraValue){
		Intent intent = new Intent();
		intent.setClass(context, cla);
		intent.putExtra(extraName,extraValue);
		if(enterAnim!=-1 && exitAnim!=-1){
			((Activity) context).overridePendingTransition(enterAnim, exitAnim);
		}
		if(finishStatus){
			context.startActivity(intent);
			((Activity)context).finish();
		}else{
			context.startActivity(intent);
		}
	}
	
}
