package jianqiang.com.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jianqiang.com.core.engine.BaseActivity;
import jianqiang.com.core.engine.ProductConfigManager;

public class Scenario1Activity extends BaseActivity {
    private static final String TAG = "Scenario1Activity";

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario1);

        button1 = (Button) findViewById(R.id.button1);
        if(ProductConfigManager.findConfig(Scenario1Activity.TAG + "show_button1")) {
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Scenario1Activity.this, L1Activity.class));
                }
            });
        } else {
            button1.setVisibility(View.GONE);
        }
    }
}