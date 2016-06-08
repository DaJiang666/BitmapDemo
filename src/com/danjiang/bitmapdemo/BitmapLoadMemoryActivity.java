package com.danjiang.bitmapdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

@SuppressLint("NewApi")
public class BitmapLoadMemoryActivity extends Activity {
	private static final String TAG = "BitmapLoadMemoryActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_load_memory);
		
		Config config = Bitmap.Config.ARGB_8888;
		String string = "ARGB_8888";
		// 分别打印不同配置下创建Bitmap的大小
		printBitmapCount(config, string);
		printBitmapCount(Config.ARGB_4444, "ARGB_4444");
		printBitmapCount(Config.RGB_565, "RGB_565");
		printBitmapCount(Config.ALPHA_8, "ALPHA_8");
	}

	/**
	 * 创建一个1000 * 1000 的分辨率的Bitmap 配置不同的config
	 * @param config Bitmap.Config参数
	 * @param string 名字
	 */
	private void printBitmapCount(Config config, String string) {
		
		Bitmap bitmap = Bitmap.createBitmap(1000, 1000, config); // 创建一个1000 * 1000 的分辨率的Bitmap
		int byteCount = bitmap.getByteCount();            // 获取大小 字节总数
		int  kbCount = byteCount / 1000;                  // 转化为KB
		int  mbCount = kbCount / 1000; 	                  // 转化为MB
		logD( string + " kbCount ==" + kbCount + "KB");
//		logD( string + " mbCount ==" + mbCount + "MB");
	}
	/**
	 * 打印日志
	 * @param string 输出内容
	 */
	public void logD(String string){
		Log.d(TAG, string);
	}
	
	
	public void toast(String string){
		Toast.makeText(this, string, 0).show();
	}
}
