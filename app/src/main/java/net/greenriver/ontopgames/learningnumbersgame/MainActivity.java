package net.greenriver.ontopgames.learningnumbersgame;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int value1 = 0;
    int value2 = 0;
    int score = 0;
    int max = 10;
    Random randInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        randInt = new Random();
        generateNumbers();
    }

    public void generateNumbers(){
        value1 = randInt.nextInt(max) + 1;
        value2 = randInt.nextInt(max) + 1;

        if(value1 == value2){

            if(value1 > max/2){
                value1 = randInt.nextInt(value1-1)+1;
            }else{
                value1 = randInt.nextInt(max - value1)+1 + value1;
            }
        }
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText(""+value1);


        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("" + value2);

        TextView scoreView = (TextView)findViewById(R.id.score);
        scoreView.setText("score: " + score);

    }

    public void compare1(View view){

        if(value1 >= value2){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            score += 1;
        }
        generateNumbers();
    }

    public void compare2(View view) {

        if(value2 >= value1){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            score += 1;
        }
        generateNumbers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
