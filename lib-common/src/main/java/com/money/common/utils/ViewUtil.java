package com.money.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ViewUtil {

	public static void clearImgMemory(View V){
		if(V instanceof ImageView){
			Drawable d=((ImageView)V).getDrawable();
			if(d!=null&&d instanceof BitmapDrawable){
				Bitmap bmp=((BitmapDrawable)d).getBitmap();
				bmp.recycle();
				bmp=null;
			}
			((ImageView)V).setImageBitmap(null);
			if(d!=null){
				d.setCallback(null);
			}
		}
	}
	 
	public static void setGridViewSelectorTransparency(GridView gridView) {
		gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
	}

	public static void setTextSize(TextView tv, float size) {
		tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
	}

	public static void setEditTextMultirow(EditText et) {
		et.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
		et.setGravity(Gravity.TOP);
		et.setSingleLine(false);
		et.setHorizontallyScrolling(false);
	}

	public static void setOverScrollMode(Context context, View v) {
		try {
			if (SystemUtil.getAndroidSDKVersion() >= 9) {
				v.setOverScrollMode(View.OVER_SCROLL_NEVER);
			} else {
				Method method;
				try {
					method = context.getClass().getMethod("setOverScrollMode",
							int.class);
					Field field = context.getClass().getField(
							"OVER_SCROLL_NEVER");
					if (method != null && field != null) {
						method.invoke(context, field.getInt(View.class));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getWidthOrHeight(Context context, int dimenId) {
		int i = (int) context.getResources().getDimension(dimenId);
		if (i % 2 != 0) {
			i = i + 1;
		}
		return i;
	}

	/**
	 * 设置ExpandableListView不可点击
	 * 
	 * @param lv
	 */
	public static void setExpandableListOnClickEnable(ExpandableListView lv) {
		lv.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
				return true;
			}
		});
	}

	public static void expandGroupAll(ExpandableListView lv, int size){
		for (int i = 0; i < size; i++) { 
			lv.expandGroup(i); 
		}
	}
	
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}

		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}

}
