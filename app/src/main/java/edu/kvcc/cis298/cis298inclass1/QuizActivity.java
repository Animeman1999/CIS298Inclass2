package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
// Create a class level widet variables so that we will
    // have access to stuff from the view.
    //No value yet. Just declard the variable
    private RadioGroup mQuestionGroup;

    private RadioButton mChoice1;
    private RadioButton mChoice2;
    private RadioButton mChoice3;
    private RadioButton mChoice4;

    private Button mSubmitButton;

    // Variable for the nest button
    private Button mNextButton;

    // Variable for the question string
    private TextView mQuestionTextView;

    // The question that will be used. It is an array of type
    // Question, that contains 2 Questions. It is a hardcoded
    // array. In most apps, you would want your data to come from
    // somewhere else. (databes, internet) Not be hard coded.
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_1_multiple,R.id.multple_choice_3,
                    new int[]{R.string.question_1_choice1, R.string.question_1_choice2,
                            R.string.question_1_choice3,R.string.question_1_choice4}),

            new Question(R.string.question_2_multiple,R.id.multple_choice_2,
                    new int[]{R.string.question_2_choice1, R.string.question_2_choice2,
                            R.string.question_2_choice3,R.string.question_2_choice4})
    };

    private int mCurrentIndex = 0;


    // Private methods that will be used inside he OnCreat
    private  void  updateQuestion() {
        //Get the Question instance stored at the mCurrentIndex of the
        //QuestionBank array. Then call the getTextResId method (property)
        // to return the integer value that points to he string
        // resource in strings.xml that we want to use.
        int question = mQuestionBank[mCurrentIndex].getTextResId();

        //Assign he inteer for the string resource to the
        //textview so that the question text will display.
        mQuestionTextView.setText(question);

        //Fetch the question choice strings from the question object
        int[] choices = mQuestionBank[mCurrentIndex].getChoiceResIds();

        //Assign each question choice text o the text property of the
        //radio button.
        mChoice1.setText(choices[0]);
        mChoice2.setText(choices[1]);
        mChoice3.setText(choices[2]);
        mChoice4.setText(choices[3]);

    }

    private void checkAnswer(int selectedRadioButtonId){

        //Create a int to represent he actual answer of
        // the current question we are on.
        int correctAnswer = mQuestionBank[mCurrentIndex].getCorrectAnswerResId();


        //declar an integer that will be a pointer to the string
        // rsource that will be used for the toast message

        int messageResId = 0;
        // Does the radio buon id of the answe they submited
        // match the radio buton id of correct answer.
        // If so, they got it right, else, wrong
        if (selectedRadioButtonId == correctAnswer) {
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

        mQuestionGroup = (RadioGroup) findViewById(R.id.multiple_group);

        mChoice1 = (RadioButton) findViewById(R.id.multple_choice_1);
        mChoice2 = (RadioButton) findViewById(R.id.multple_choice_2);
        mChoice3 = (RadioButton) findViewById(R.id.multple_choice_3);
        mChoice4 = (RadioButton) findViewById(R.id.multple_choice_4);

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Query the radio button group to find out which radio button
                // was selected. Store the id of the selected one in the
                // variable selectedAnswerId.
                int selectedAnswer = mQuestionGroup.getCheckedRadioButtonId();
                // pass the id of th selected radio button into the checkAnswer
                //method. The checkAnswer handles toasting whether it is correct
                // or not.
                checkAnswer(selectedAnswer);
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

        //Check to see if there is a bundle and that is is not null
        //If so, fetch out the KEY_INDEX, which will be the index of
        //the question that we were on before we did a rotate.
        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
                    }

        // This is delcared up above. It does the work of changing
        // to the next question in the array
        updateQuestion();
        //End code I write********************************************
    }


// Static string to use for the override methods
    private static final String TAG = "QuizActivity";


    //static strin to be used as the key in the key /vaulu
    //bundle for onSaveInstance
    private static final String KEY_INDEX = "index";


    //Overridden method to save any information about
    // our activity that we will need to restore form
    // either a rotate, ora change in activity.
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        // Log that onSaveInstanceState was called
        Log.i(TAG, "onSaveInstaneState");

        //
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }


    // Below are the main activity methods that can be
    // overriden to do 'work' with out application
    //the app will call all of these in sequence as it
    // loads, and as it is closed.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
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
