package com.example.gpaplan_mainpage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

//백버튼 수정 전

public class SplashActivity extends Activity {

	int splashSceneNumber;



	LinearLayout splashLayout;
	Handler mHandler;


	boolean isClick;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		splashLayout=(LinearLayout)findViewById(R.id.splashLayout);
/*		View scaleView= getLayoutInflater().inflate(R.layout.activity_set_scale,null);

		scaleView.findViewById(R.id.buttScale43).setOnClickListener(this);
*/		

		
		splashSceneNumber=0;
		
		isClick=true;
		
		mHandler=new Handler(){
			
			@Override
			public void handleMessage(Message msg){
				switch(splashSceneNumber){
				case 0:
					splashSceneNumber=1;
					mHandler.sendEmptyMessageDelayed(splashSceneNumber,2000);
					break;
					
				case 1:
					newOrnot();
//					SplashActivity.this.finish();
					break;
					
				case 2:
					if(isClick&&splashSceneNumber==0){
						splashSceneNumber=0;
						mHandler.sendEmptyMessageDelayed(splashSceneNumber,2000);
					}
					break;
				}
			}
		};
		mHandler.sendEmptyMessageAtTime(3,2000);
		

		
	}

	public void newOrnot(){
		SharedPreferences sharedPref=getSharedPreferences("pref",Context.MODE_PRIVATE);

		//원래는 defalutValue=0;으로 설정
		int defaultValue=1;
		int keepcheck=sharedPref.getInt(getString(R.string.savedSetting),defaultValue);
		if(keepcheck==defaultValue){ //아직 한번도 안써졌을때
			Intent intent=new Intent(this,SettingActivity_Scale.class);
			startActivity(intent);
			finish();
//			SplashActivity.this.finish();
		}
		else{
			Intent intent=new Intent(this,MainActivity.class);
			startActivity(intent);
			finish();
//			SplashActivity.this.finish();
		}
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}
*/




}
