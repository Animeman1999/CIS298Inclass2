package edu.kvcc.cis298.cis298inclass1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CheatActivity extends AppCompatActivity {
    // This is a string that will be used as he key for key/vaule pair that
    // is passed in the extras part of the intent. the key will be this string
    //The value will be the value that is passed ino the method below called
    // newInent
    private static final String EXTRA_ANSWER_IS_TRUE =
            "edu.kvcc.cis298.cis298inclass1.answer_is_ture";


    // This method is being declared on this class so that ANY class that wants
    // to start this intent can call this static method to get a properly
    //formatted intent. The intent could be created in the calling class, but
    //then the calling class would have to know what this activity is expecting.
    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        //Creat new intent
        Intent i = new Intent(packageContext, CheatActivity.class);
        // put the extra using the string key defined above, and the passed in value
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        //return the intent to whoever called this method. In this case
        // it will be quizactivity.
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cheat, menu);
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