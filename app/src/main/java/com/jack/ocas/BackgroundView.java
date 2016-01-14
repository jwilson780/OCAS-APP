package com.jack.ocas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;

public class BackgroundView extends View {
	private int width, height, fretSize, fretCount;
	Paint fretColor=new Paint();
	Thread thread = null;
	boolean CanDraw = false;
	Bitmap background;
	Canvas canvas;


	public BackgroundView(Context context, int frets) {
		super(context);

		//background = BitmapFactory.decodeResource(getResources(), R.drawable.keyboard);

		
		Log.d("BACKGROUNDVIEW","derp");

		fretColor.setARGB(255,255,255,0);

		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();

		Settings.System.putInt(context.getContentResolver(),
				"show_touches", 1);

		Point size=new Point();
		display.getSize(size);
		height=size.y;
		fretCount=frets;

		//the size of individual frets
		fretSize=height/frets;
		Log.d("BGINIT","width="+width);
		Log.d("BGINIT","height"+height);
		Log.d("BGINIT","fretCount"+fretCount);
	}

	protected void onDraw(Canvas canvas)
	{
		canvas.drawColor(Color.argb(255, 0, 0, 0));
		float width = canvas.getWidth();
		for (int y = fretCount; y>0; y--){
			canvas.drawLine(0f, (y)*fretSize, width, (y)*fretSize, fretColor);
//            canvas.drawLine(0f, (y+1)*fretSize, width, (y+1)*fretSize, fretColor);
		}
	}
	/*protected void onDraw(Canvas canvas)
	{
			Canvas g = canvas;
			g.drawBitmap(background, 0, 0, null);
	}*/

}
