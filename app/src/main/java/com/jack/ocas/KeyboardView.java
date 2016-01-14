package com.jack.ocas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class KeyboardView extends View {
	private int width, height, fretSize, fretCount;
	Paint fretColor=new Paint();
	Thread thread = null;
	boolean CanDraw = false;
	Bitmap background;
	Canvas canvas;
	Paint mPaint;
	float mX;
	float mY;
	TextView mTVCoordinates;


	public KeyboardView(Context context, int frets) {
		super(context);

		background = BitmapFactory.decodeResource(getResources(), R.drawable.keyboard);

		Settings.System.putInt(context.getContentResolver(),
				"show_touches", 1);
		
		Log.d("BACKGROUNDVIEW","derp");

		fretColor.setARGB(255,255,255,0);

		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();

		Point size=new Point();
		display.getSize(size);
		height=size.y;
		fretCount=frets;

		//the size of individual frets
		fretSize = height / frets;
		Log.d("BGINIT","width=" + width);
		Log.d("BGINIT","height"+height);
		Log.d("BGINIT","fretCount"+fretCount);

		mPaint = new Paint();
		mX = mY = -100;
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Canvas g = canvas;

		g.drawBitmap(background, 0, 0, null);




	}




}
