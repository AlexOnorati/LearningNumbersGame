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

    LearningNumbersModal modal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        modal = new LearningNumbersModal();
        modal.generateNumbers();
        updateDisplay();
    }

    public void updateDisplay(){

        Button buttonLeft = (Button) findViewById(R.id.buttonleft);
        buttonLeft.setText(""+modal.getLeftNumber());


        Button buttonRight = (Button) findViewById(R.id.buttonright);
        buttonRight.setText(""+modal.getRightNumber());

        TextView wonView = (TextView)findViewById(R.id.gameswon);
        wonView.setText("Correct: " + modal.getGamesWon());

        TextView gameCountView = (TextView)findViewById(R.id.gamesplayed);
        gameCountView.setText("Total Games: " + modal.getGamesPlayed());

    }

    public void checkLeft(View view){
        if(modal.play(LearningNumbersModal.LEFT_SIDE)){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        updateDisplay();
    }

    public void checkRight(View view){
        if(modal.play(LearningNumbersModal.RIGHT_SIDE)){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        updateDisplay();
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
