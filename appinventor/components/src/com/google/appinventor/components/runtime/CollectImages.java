package com.google.appinventor.components.runtime;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;

public class CollectImages {
	static ArrayList<Drawable> listImages;
	
	public CollectImages(){
		listImages=new ArrayList<Drawable>();
	}
	
	public static void add(Drawable d){
		listImages.add(d);
	}
	
	public static ArrayList<Drawable> getList(){
		return listImages;
	}
	
	

}
