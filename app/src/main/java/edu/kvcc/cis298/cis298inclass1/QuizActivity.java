package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
// Create a class level widet variables so that we will
    // have access to stuff from the view.
    //No value yet. Just declard the variable
    private Button mTrueButton;
    private Button mFalseButton;


    // I didn;t wrie this method. It was given to me by google.
    // It is the 'setup' method for the app.
    // It will be called when the ap launches.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Begin code I write*******************

        // Fetch the widget control from the view, and then
        //cast and assign it to the class variable we setup
        mTrueButton = (Button) findViewById(R.id.true_button);

        //Now that I have a 'andle' to the view widget, I can
        //Setup an OnClickListener for the widget
        //This OnClickListner uses an anonymous inner class.
        //We are passing what we want to have happen onClick.
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Use the Toast class to print a message to the
                // screen that will fade out after the duration
                // listed as LENGTH_SHORT
                // This method requires 3 parameters.
                // The conext, which will usually be Activity.this,
                // The Message wich will usuall be a string from strings.xml
                //TheLength, which will be one of the predefined constants.
                Toast.makeText(QuizActivity.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
            }
        });

        //  See the notes from the TrueBuon It is he same.
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });
        //End code I write********************************************
    }

        // These are methods we did not wrie, but google provided.
        // If we ge to using menus, we will need hem. They can be ignored for now

    // Begin unneeded google methods*****************************************************
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
    //End unneeded google methods**********************************************************
}
