
package com.jetllama.avatarcreator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class AvatarArtist extends View {
	
	private int backgroundColor;
	
	
	private Drawable faces[] = new Drawable[6];
	private Drawable eyes[] = new Drawable[1];
	private Drawable mouths[] = new Drawable[1];
	private Drawable ears[] = new Drawable[1];
	
	private int currentFace;
	private int currentEyes;
	private int currentMouth;
	private int currentEars;
	



	public AvatarArtist(Context context) {
		super(context);
		initialize(context);
	}


	public AvatarArtist(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
	}


	public AvatarArtist(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);	
		initialize(context);
	}
	
	
	private void initialize(Context context){
		backgroundColor = Color.RED;
		currentFace = 0;
		currentEyes = 0;
		currentMouth = 0;
		currentEars = 0;
		
		faces[0] = context.getResources().getDrawable(R.drawable.face0);
		faces[1] = context.getResources().getDrawable(R.drawable.face1);
		faces[2] = context.getResources().getDrawable(R.drawable.face2);
		faces[3] = context.getResources().getDrawable(R.drawable.face3);
		faces[4] = context.getResources().getDrawable(R.drawable.face4);
		faces[5] = context.getResources().getDrawable(R.drawable.face5);
		
		eyes[0] = context.getResources().getDrawable(R.drawable.eyes0);
		mouths[0] = context.getResources().getDrawable(R.drawable.mouth0);
		
		ears[0] = context.getResources().getDrawable(R.drawable.ears0);
		
	}
	
	public void setColor(int color){
		backgroundColor = color;
		invalidate();
	}
	
	public void nextFace(){
		currentFace = currentFace >= 5 ? 0 : currentFace + 1;
		invalidate();
	}


	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		int height = getMeasuredHeight();
		int width = getMeasuredWidth();
		
		Paint p = new Paint();
		p.setColor(backgroundColor);
		
		//draw face
		canvas.drawRect(0, 0,width,height, p);
		
		//draw face
		faces[currentFace].setBounds(canvas.getClipBounds());
		faces[currentFace].draw(canvas);
		//eyes
		eyes[currentEyes].setBounds(canvas.getClipBounds());
		eyes[currentEyes].draw(canvas);
		//mouth
		mouths[currentMouth].setBounds(canvas.getClipBounds());
		mouths[currentMouth].draw(canvas);
		//ears
		ears[currentEars].setBounds(canvas.getClipBounds());
		ears[currentEars].draw(canvas);
		
	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(512, 512);
		
	}

}
