package com.example.kk070.testproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends Activity {
    private MainView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new MainView(this);
        setContentView(view);
    }

    @Override
    protected void onPause(){ super.onPause();    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onDestroy(){ super.onDestroy();  }

    public void dialogSimple(){
        final Activity activity = this;
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setMessage("게임을 다시 시작하시겠습니까?").setCancelable(false).setPositiveButton("네",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                view = new MainView(activity);
                view.setBackgroundResource(R.drawable.background);
                setContentView(view);
                onResume();
            }
        }).setNegativeButton("프로그램 종료", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Action for 'NO' Button
                dialog.cancel();
                moveTaskToBack(true);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        AlertDialog alert = alt_bld.create();
        // Icon for AlertDialog
        alert.show();
        view.setCollision(true);
    }
}
