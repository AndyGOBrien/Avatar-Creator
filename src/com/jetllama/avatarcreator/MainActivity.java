package com.jetllama.avatarcreator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.larswerkman.colorpicker.ColorPicker;
import com.larswerkman.colorpicker.ColorPicker.OnColorChangedListener;
import com.larswerkman.colorpicker.SaturationBar;

public class MainActivity extends Activity implements OnColorChangedListener, OnClickListener{
	
	private ColorPicker colorPicker;
	private AvatarArtist artist;
	private SaturationBar satBar;
	private ImageButton faceButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		colorPicker = (ColorPicker) findViewById(R.id.picker);
		artist = (AvatarArtist)findViewById(R.id.artist);
		satBar = (SaturationBar)findViewById(R.id.saturationbar);
		faceButton = (ImageButton) findViewById(R.id.faceButton);
		
		
		colorPicker.setOnColorChangedListener(this);
		colorPicker.addSaturationBar(satBar);
		
		faceButton.setOnClickListener(this);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void onColorChanged(int color){
		artist.setColor(color);
		colorPicker.setOldCenterColor(color);
	}
	
	public void onClick(View v){
		if(v.getId() == faceButton.getId()){
			artist.nextFace();
		}
		
	}
	

}
