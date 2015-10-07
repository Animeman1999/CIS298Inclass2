package edu.kvcc.cis298.cis298inclass1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    // This is a string that will be used as he key for key/vaule pair that
    // is passed in the extras part of the intent. the key will be this string
    //The value will be the value that is passed ino the method below called
    // newInent
    private static final String EXTRA_ANSWER_IS_TRUE =
            "edu.kvcc.cis298.cis298inclass1.answer_is_ture";

    //The key for the return result intent
    private static final String EXTRA_ANSWER_SHOWN =
            "edu.kvcc.cis298.cis298inclass2.answer_shown";

    // A bool to hold the answer to the question that we get from
    //pressing cheat on the quiz activity and coming here.
    private boolean mAnswerIsTrue;

    // variables for the controls we need to work with.
    private TextView mAnswerTextView;
    private Button mShowAnswer;

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

    //A static method to dermine if the user clicked on the cheat button
    // of this activity It is static so that it can be called on this class
    //from the Activity that started this activity.
    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        //Get the view that will display the answer
        mAnswerTextView = (TextView) findViewById(R.id.anwer_text_view);

        mShowAnswer = (Button) findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If the answer is rue, se the view text to true
                if (mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }else{//else test is false
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResults(true);
            }
        });
    }

    private void setAnswerShownResults(boolean isAnswerShown)
    {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
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
