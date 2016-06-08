package com.danjiang.bitmapdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
/**
 *
 *	Author: ZhangDanJiang
 *
 *  Date:2016年6月8日  Time: 下午5:42:36
 *
 *  Function: Bitmap 在内存中加载
 *  
 *  
 *  图片的存在的不同形式
 *  ①：文件形式，即以二进制形式存在于硬盘上，file.length()
 *  ②：流的形式，即以二进制形式存在于内存中，将文件读取到流中时，流的大小和文件在磁盘中显示的大小是一样的
 *  ③：Bitmap形式，即以RGBA(默认)形式存在于内存中
 *  
 *  在Android3.0之前，Bitmap的内存分配分为两部分，一部分是分配在Dalvik的VM堆中，而像素数据的内存是分配在Native堆中，
 *  而到了Android3.0之后，Bitmap的内存则已经全部分配在VM堆上，这两种分配方式的区别在于，
 *  Native堆的内存不受Dalvik虚拟机的管理，我们想要释放Bitmap的内存，必须手动调用Recycle方法，
 *  而到了Android 3.0之后的平台，我们就可以将Bitmap的内存完全放心的交给虚拟机管理了，
 *  我们只需要保证Bitmap对象遵守虚拟机的GC Root Tracing的回收规则即可。OK，基础知识科普到此。
 *  
 *  Bitmap图片占用内存计算：
 *  Bitmap图片在加载到内存的时候是按照下面的计算公式
 *  计算公式：占用内存大小= Bitmap 宽度 * 高度 * 每个像素占用的内存 = 像素总数 * 每个像素占用的内存
 *  你可以把图片看成是由width行、height列的矩阵组成，每一个矩阵元素代表一个像素点，
 *  每一个像素点都是1byte整数倍的数据，这个数据越大，表示的色彩就越丰富,图片的显示质量就越高。
 *  
 *  Bitmap有四种像素类型：
 *  ARGB_8888、     4 字节
 *  ARGB_4444、     4 字节
 *  ARGB_565、       2 字节
 *  ALPHA_8，          1 字节。
 *  一个1000*1000的ARGB_8888类型的Bitmap占用的内存为1000*1000*4 byte= 4000000byte = 4000kb = 4MB。
 *  
 *  
 *  
 *  Bitmap 在文件中的大小 和 Bitmap在内存的大小 没有任何关系
 *  Bitmap 在内存中的大小主要是宽 高 和 分别率 有直接关系
 */
@SuppressLint("NewApi")
public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	
	private TextView mTextLoadMemory;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextLoadMemory = (TextView) findViewById(R.id.tv_load_memory);
		
		setOnClickListener();
	}

	
	private void setOnClickListener() {
		mTextLoadMemory.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), BitmapLoadMemoryActivity.class);
				startActivity(intent);
			}
		});
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
