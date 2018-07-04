package jianqiang.com.productb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jianqiang.com.core.L1Activity;
import jianqiang.com.core.engine.BaseActivity;
import jianqiang.com.core.engine.ProductConfigManager;

public class Scenario2Activity2 extends BaseActivity {
    private static final String TAG = "Scenario2Activity";

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(jianqiang.com.core.R.layout.activity_scenario2);

        if(ProductConfigManager.findConfig(Scenario2Activity2.TAG + "show_button")) {
            button1 = (Button) findViewById(jianqiang.com.core.R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Scenario2Activity2.this, L1Activity.class));
                }
            });
        }

        button2 = (Button) findViewById(jianqiang.com.core.R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Scenario2Activity2.this, L1Activity.class));
            }
        });
    }
}