package com.meng.TaiHunDanmaku.helpers;

import android.app.*;
import android.content.*;
import com.meng.TaiHunDanmaku.ui.*;

public class ErrDialog {
    public static void show(String title, String message) {
        new AlertDialog.Builder(MainActivity.instance)
			.setTitle(title)
			.setMessage(message)
			.setIcon(android.R.drawable.stat_sys_warning)
			.setPositiveButton("Dismiss", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
				}
			}).show();
    }
}
