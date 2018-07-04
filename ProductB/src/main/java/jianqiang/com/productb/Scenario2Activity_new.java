package jianqiang.com.productb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jianqiang.com.core.L1Activity;
import jianqiang.com.core.Scenario2Activity;

public class Scenario2Activity_new extends Scenario2Activity {

    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        button2 = (Button) findViewById(jianqiang.com.core.R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Scenario2Activity_new.this, L1Activity.class));
            }
        });
    }
}