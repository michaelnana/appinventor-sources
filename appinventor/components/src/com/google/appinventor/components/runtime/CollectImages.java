package com.google.appinventor.components.runtime;

import java.util.ArrayList;
import java.io.Serializable;

import android.graphics.drawable.Drawable;

public class CollectImages implements Serializable {
	static ArrayList<Drawable> listImages;
	
	public CollectImages(){
		listImages=new ArrayList<Drawable>();
	}

	public CollectImages collect(){
		return this;
	}
	
	public static void add(Drawable d){
		listImages.add(d);
	}
	
	public static ArrayList<Drawable> getList(){
		return listImages;
	}
	
	

}
