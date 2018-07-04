package jianqiang.com.core.engine;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BaseActivity extends Activity {

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if(intent.getComponent() == null) {
            super.startActivityForResult(intent, requestCode);
            return;
        }

        String packageName = intent.getComponent().getPackageName();
        String className = intent.getComponent().getClassName();
        String shortClassName = className.substring(className.lastIndexOf('.') + 1);

        //找不到就走正常逻辑
        String newClassName = ProductConfigManager.findMap(shortClassName);
        if(newClassName == null) {
            super.startActivityForResult(intent, requestCode);
            return;
        }

        ComponentName componentName = new ComponentName(packageName, newClassName);

        Intent newIntent = new Intent();
        newIntent.setComponent(componentName);

        super.startActivityForResult(newIntent, requestCode);
    }
}