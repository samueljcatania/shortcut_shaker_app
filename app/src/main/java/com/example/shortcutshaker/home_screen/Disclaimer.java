package com.example.shortcutshaker.home_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shortcutshaker.main.MainActivity;
import com.example.shortcutshaker.R;

public class Disclaimer extends AppCompatActivity implements View.OnClickListener {

    /**
     * Declares all cards within the activity xml file
     */
    private CardView back;

    /**
     * Declares all textViews within the activity xml file
     */
    private TextView disclaimer_backButton;

    //**********************************************************************************************

    /**
     * Executes when this class is called/created
     *
     * @param savedInstanceState A Bundle object containing the activity's previously saved state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);


        //Assign TextViews
        disclaimer_backButton = findViewById(R.id.disclaimer_backButton);

        //Assign Cards
        back = findViewById(R.id.back);

        //Add ClickListener to Cards
        back.setOnClickListener(this);

    }//End of onCreate

    @Override
    public void onBackPressed() {
    }

    /**
     * Controls the outcome of clicking the buttons
     *
     * @param v A View occupies a rectangular area on the screen and is responsible for drawing and event handling.
     */
    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {

            case R.id.back:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                back.setCardBackgroundColor(Color.WHITE);
                disclaimer_backButton.setTextColor(Color.BLACK);
                break;

            default:
                break;

        }


    }//End of onClick

}//End of Class Disclaimer