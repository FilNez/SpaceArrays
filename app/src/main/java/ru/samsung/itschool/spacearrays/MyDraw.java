package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyDraw extends View {

	Rocket[] rocket = new Rocket[5];


	public MyDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		makeSky();

		int Width = 1000;
		int Height = 1000;

		for (int i = 0; i < rocket.length; i++)
			rocket[i] = new Rocket(
					(float) (Math.random() * Width),
					(float) (Math.random() * Height),
					(float) (Math.random() * 6 - 3),
					(float) (Math.random() * 6 - 3),
					rocketImage);
	}



	Paint paint = new Paint();
	Bitmap rocketImage = BitmapFactory.decodeResource(getResources(), R.drawable.rocket);

	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		for (int i = 0; i < numStars; i++)
			stars[i].draw(canvas);

		for (int i = 0; i < rocket.length; i++) {
			rocket[i].draw(canvas, paint);
			rocket[i].move();
		}

		invalidate();
	}
	
	final int numStars = 1000;
	
	Star[] stars = new Star[numStars];
	
	void makeSky()
	{
		int maxX = 2000;
		int maxY = 2000;

		for (int i = 0; i < numStars; i++)
		{	
		   stars[i] = new Star(
		   		(int)(Math.random() * maxX),
				   (int)(Math.random() * maxY),
			   	(int)(Math.random() * 256));
		}   
	}
}
