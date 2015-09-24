package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
// Create a class level widet variables so that we will
    // have access to stuff from the view.
    //No value yet. Just declard the variable
    private Button mTrueButton;
    private Button mFalseButton;

    // Variable for the nest button
    private Button mNextButton;

    // Variable for the question string
    private TextView mQuestionTextView;

    // The question that will be used. It is an array of type
    // Question, that contains 5 Questions. I is a hardcoded
    // array. In most apps, you would want your data to come from
    // somewhere else. (databes, internet) Not be hard coded.
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_america, true),
            new Question(R.string.question_asia, true)
    };

    private int mCurrentIndex = 0;


    // Private methods that will be used inside he OnCreat
    private  void  updateQuestion() {
        //Get the Question instance stored at the mCurrentIndex of the
        //QuestionBank array. Then call the getTextResId method (property)
        // o return the inteer value that points to he string
        // resource in strins.xml that we want to use.
        int question = mQuestionBank[mCurrentIndex].getTextResId();

        //Assign he inteer for the string resource to the
        //textview so that the question text will display.
        mQuestionTextView.setText(question);

    }

    private void checkAnswer(boolean userPressedTrue){

        //Create a bolean to represent he actual answe of
        // the current question we are on.
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        //declar an integer that will be a pointer to the string
        // rsource that will be used for the toast message

        int messageResId = 0;
        //Compare the actual answer to the answer that was passed
        //into this method. If they match, the message is correct.
        //else it is incorrect. Assign the R in value to the
        // messageResId.

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;

        }  else
        {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    // I didn;t write this method. It was given to me by google.
    // It is the 'setup' method for the app.
    // It will be called when the ap launches.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Begin code I write*******************

        // Get a 'handle' to the textview in the layout
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);



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
                checkAnswer(true);
            }
        });

        //  See the notes from the TrueBuon It is he same.
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // call he checkAnser method that is declared at the top
                // of this class. It will take in the bool value that they
                //selected, and do the work of determining if the answer
                // is correct, Eiher way it will toast the message to the
                //screen.
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                // this method is declared at the top of the class. It
                // habndles updating the question text.
                updateQuestion();
            }
        });

        // This is delcared up above. It does the work of changing
        // to the next question in the array
        updateQuestion();
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
