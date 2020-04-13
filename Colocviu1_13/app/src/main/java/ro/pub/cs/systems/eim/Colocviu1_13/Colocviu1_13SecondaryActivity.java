package ro.pub.cs.systems.eim.Colocviu1_13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Colocviu1_13SecondaryActivity extends Activity {
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Intent intent = getIntent();

        text = findViewById(R.id.textView9);
    }

    public void registerHandler(View v) {
        setResult(1, null);
        finish();
        return;
    }

    public void cancelHandler(View v) {
        setResult(0, null);
        finish();
        return;
    }

}
