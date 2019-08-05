# Svb_log

Simple Custom Toast with image and text

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	 	implementation 'com.github.sharathvbhargav:Svb_log:0.0.2'
	}
	
To use Custom Toast in your project:

	SvbToast.showToast(
		Context: Application Context,
		String: Message to display,
		Drawable: Drawable Icon (null if icon is not needed),
		Int: Corner Radius for toast window,
		Int[]: Array of colors,
		Boolean: IsLongToast (true: Toast.LENGTH_LONG, false: Toast.LENGTH_SHORT) 
	);
		
	Example:
	
	SvbToast.showToast(
		MainActivity.this,
		"Am your custom toast",
		getResources().getDrawable(R.drawable.error),
		50,
		color,
		true);
		
	final int[] color = new int[] {
		Color.parseColor("#b5b6d2"),
		Color.parseColor("#112233"),
		Color.parseColor("#b5b6d2")};
