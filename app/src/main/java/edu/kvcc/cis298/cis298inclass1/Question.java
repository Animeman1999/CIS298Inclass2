package edu.kvcc.cis298.cis298inclass1;

/**
 * Created by jmartin5229 on 9/23/2015.
 */
public class Question {

    //Class level variable to hold the question text
    //In order to get a string from strings.xml, we need
    //and integer as the reference value.
    private int mTextResId;
    //Bool value for whether the question is true or false
    private boolean mAnswerTrue;

    // Constructor that accepts 2 parameters.  The string id,
    // and the bool answer
    public Question(int textResId, boolean answerTrue) {
        //Assign the passed in ones to the class level ones.
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    // Getter for mAnswerTrue
    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    //Seter for mAnswerTrue
    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;

    }

    // Getter for mTextResId
    public int getTextResId() {
        return mTextResId;
    }

    //Seter for mTextResid
    public void setTextResId(int textResId) {
        mTextResId = textResId;

    }
}
