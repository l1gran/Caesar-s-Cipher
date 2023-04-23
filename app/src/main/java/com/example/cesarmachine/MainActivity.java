package com.example.cesarmachine;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNewActivity(View v){
        Intent intent = new Intent(this, activity_second.class);
        startActivity(intent);
    }

    int keey=0;

    public void EncrytCcBtn(View view) {
        EditText editText = findViewById(R.id.editText);
        Editable x = editText.getText();
        EditText editText2 = findViewById(R.id.editText2);
        editText2.setText(EncrytionCc(x));
    }

    public void DecrytCcBtn(View view) {
        EditText editText2 = findViewById(R.id.editText2);
        Editable y = editText2.getText();
        EditText editText = findViewById(R.id.editText);
        editText.setText(DecrytionCc(y));
    }

    public void KeyCcBtn(View view) {
        EditText editCode = findViewById(R.id.editCode);
        Editable z = editCode.getText();
        keey = Integer.parseInt(z.toString());
    }

    public void Clear(View view) {
        EditText editText2 = findViewById(R.id.editText2);
        editText2.setText("");
        EditText editText = findViewById(R.id.editText);
        editText.setText("");
    }

    String EncrytionCc(Editable plain){
        StringBuilder temp = new StringBuilder();
        for(int i = 0 ; i < plain.length() ; i++){

            if(plain.charAt(i)==' ')
            {
                temp.append(' ');
            }
            else if (plain.charAt(i)+keey >'z')
            {
                temp.append((char) (plain.charAt(i) - (26 - keey)));
            }
            else
                temp.append((char) (plain.charAt(i) + keey));
        }
        return temp.toString();
    }

    String DecrytionCc(Editable cipher){
        StringBuilder temp = new StringBuilder();
        for(int i = 0;i  < cipher.length(); i++){

            if(cipher.charAt(i) == ' ')
            {
                temp.append(' ');
            }
            else if (cipher.charAt(i)- keey < 'a')
            {
                temp.append((char) (cipher.charAt(i) - (keey - 26)));
            }
            else {
                temp.append((char) (cipher.charAt(i) - keey));
            }
        }
        return temp.toString();
    }


}
