package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Colocviu1_13MainActivity extends AppCompatActivity {

    EditText text;
    int buttonsPressed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if ((savedInstanceState != null) && (savedInstanceState.getInt("buttons_pressed") != 0)) {
            buttonsPressed = savedInstanceState.getInt("buttons_pressed");
            Log.d("pressed", "onCreate received saved state with value = " + String.valueOf(buttonsPressed));
        } else {
            Log.d("pressed", "No buttons were pressed so far");
        }

        text = findViewById(R.id.textView8);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("buttons_pressed", buttonsPressed);
        Log.d("pressed", "Before saving nr = " + String.valueOf(buttonsPressed));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if ((savedInstanceState != null) && (savedInstanceState.getInt("buttons_pressed") != 0)) {
            buttonsPressed = savedInstanceState.getInt("buttons_pressed");
            Log.d("pressed", "onRestoreInstance received saved state with value = " + String.valueOf(buttonsPressed));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == 0)
            Toast.makeText(getApplication(), "Returned from Cancel", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplication(), "Returned from Register", Toast.LENGTH_LONG).show();
    }

    public void switchHandler(View v) {
        Intent intent = new Intent(getApplicationContext(), Colocviu1_13SecondaryActivity.class);
        startActivityForResult(intent, 1);
        text.setText("");
        buttonsPressed = 0;
        return;
    }

    public void northHandler(View v) {
        String s = text.getText().toString();
        text.setText(s.concat("North,"));
        text.setSelection(text.getText().length());
        buttonsPressed++;
        return;
    }

    public void westHandler(View v) {
        String s = text.getText().toString();
        text.setText(s.concat("West,"));
        text.setSelection(text.getText().length());
        buttonsPressed++;
        return;
    }

    public void eastHandler(View v) {
        String s = text.getText().toString();
        text.setText(s.concat("East,"));
        text.setSelection(text.getText().length());
        buttonsPressed++;
        return;
    }

    public void southHandler(View v) {
        String s = text.getText().toString();
        text.setText(s.concat("South,"));
        text.setSelection(text.getText().length());
        buttonsPressed++;
        return;
    }
}
