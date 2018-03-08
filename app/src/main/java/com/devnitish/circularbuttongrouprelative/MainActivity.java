package com.devnitish.circularbuttongrouprelative;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
                implements View.OnClickListener
{

    private static final String TAG = "MainActivity";
    ImageView facebook,whatsapp,instagram,tinder,tumbler,
                blogger,hangout,slack,gmail;

    // arrays to store the initial position of each element.
    int[] pos_facebook,pos_whatsapp,pos_instagram,pos_tinder,
            pos_tumbler,pos_blogger,pos_hangout,pos_slack,pos_gmail;

    // boolean variable to control if imageview other than facebook
    // is visible or not...
    // it is initially visible............
    boolean isMenuOpen = true;

    // boolean variable to control user click,
    // i donot want user to interrupt in animation by clicking open/close button
    // it will just distort all the animation..
    // so invaliding user input untill animation is done..
    // By the way animation last for 0.8 sec..

    boolean isReadyForUserInput = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a reference of each image view..
        initWidget();

        // get initial position of each imageview..with a delay to let the screen rendered..
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getInitialPosition();
                isReadyForUserInput = true;

            }
        }, 2000);


        // attach listener to the center button, facebook
        setUpListener();

    }


    private void getInitialPosition(){
        pos_facebook = new int[2];
        pos_whatsapp = new int[2];
        pos_instagram = new int[2];
        pos_gmail = new int[2];
        pos_tinder = new int[2];
        pos_tumbler = new int[2];
        pos_blogger = new int[2];
        pos_hangout = new int[2];
        pos_slack = new int[2];




        // get the initial position of each component....
        facebook.getLocationOnScreen(pos_facebook);
        whatsapp.getLocationOnScreen(pos_whatsapp);
        instagram.getLocationOnScreen(pos_instagram);
        tinder.getLocationOnScreen(pos_tinder);
        tumbler.getLocationOnScreen(pos_tumbler);
        blogger.getLocationOnScreen(pos_blogger);
        hangout.getLocationOnScreen(pos_hangout);
        slack.getLocationOnScreen(pos_slack);
        gmail.getLocationOnScreen(pos_gmail);

        Log.e(TAG, "getInitialPosition: facebook "+pos_facebook[0]+"  "+pos_facebook[1] );
        Log.e(TAG, "getInitialPosition: whatsapp "+pos_whatsapp[0]+"  "+pos_whatsapp[1] );
        Log.e(TAG, "getInitialPosition: facebook "+pos_facebook[0]+"  "+pos_facebook[1] );
        Log.e(TAG, "getInitialPosition: facebook "+pos_facebook[0]+"  "+pos_facebook[1] );
        Log.e(TAG, "getInitialPosition: facebook "+pos_facebook[0]+"  "+pos_facebook[1] );
        Log.e(TAG, "getInitialPosition: facebook "+pos_facebook[0]+"  "+pos_facebook[1] );
        Log.e(TAG, "getInitialPosition: facebook "+pos_facebook[0]+"  "+pos_facebook[1] );
        Log.e(TAG, "getInitialPosition: facebook "+pos_facebook[0]+"  "+pos_facebook[1] );
        Log.e(TAG, "getInitialPosition: facebook "+pos_facebook[0]+"  "+pos_facebook[1] );

    }


    private void initWidget(){
        facebook = findViewById(R.id.facebook);
        whatsapp = findViewById(R.id.whatsapp);
        instagram = findViewById(R.id.instagram);
        tinder = findViewById(R.id.tinder);
        tumbler = findViewById(R.id.tumbler);
        blogger = findViewById(R.id.blogger);
        hangout = findViewById(R.id.hangout);
        slack = findViewById(R.id.slack);
        gmail = findViewById(R.id.gmail);
    }

    private void setUpListener(){

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // if we are ready for receiving user input than only proceed.
                if (isReadyForUserInput) {

                    if (isMenuOpen)
                        closeMenu();

                    else
                        openMenu();
                }
            }
        });

        whatsapp.setOnClickListener(this);
        instagram.setOnClickListener(this);
        tinder.setOnClickListener(this);
        blogger.setOnClickListener(this);
        hangout.setOnClickListener(this);
        slack.setOnClickListener(this);
        gmail.setOnClickListener(this);
        tumbler.setOnClickListener(this);
    }


    private void closeMenu(){
        isMenuOpen = false;
        isReadyForUserInput = false;
        Log.e(TAG, "closeMenu: " );
        whatsapp.animate()
                .translationXBy((pos_facebook[0]-pos_whatsapp[0]))
                .translationYBy((pos_facebook[1]-pos_whatsapp[1]))
                .setDuration(500)
                .alpha(0)
                .rotationBy(360)
                .start();

        instagram.animate()
                .translationXBy((pos_facebook[0]-pos_instagram[0]))
                .translationYBy((pos_facebook[1]-pos_instagram[1]))
                .setDuration(500)
                .alpha(0)
                .rotationBy(360)
                .start();

        tinder.animate()
                .translationXBy((pos_facebook[0]-pos_tinder[0]))
                .alpha(0)
                .translationYBy((pos_facebook[1]-pos_tinder[1]))
                .setDuration(500)
               .start();


        tumbler.animate()
                .translationXBy((pos_facebook[0]-pos_tumbler[0]))
                .alpha(0)
                .translationYBy((pos_facebook[1]-pos_tumbler[1]))
                .setDuration(500)
                .start();


        blogger.animate()
                .translationXBy((pos_facebook[0]-pos_blogger[0]))
                .translationYBy((pos_facebook[1]-pos_blogger[1]))
                .alpha(0)
                .setDuration(500)
                .start();


        hangout.animate()
                .translationXBy((pos_facebook[0]-pos_hangout[0]))
                .translationYBy((pos_facebook[1]-pos_hangout[1]))
                .alpha(0)
                .setDuration(500)
                .start();


        slack.animate()
                .translationXBy((pos_facebook[0]-pos_slack[0]))
                .translationYBy((pos_facebook[1]-pos_slack[1]))
                .alpha(0)
                .setDuration(500)
                .rotationBy(360)
                .start();


        gmail.animate()
                .translationXBy((pos_facebook[0]-pos_gmail[0]))
                .translationYBy((pos_facebook[1]-pos_gmail[1]))
                .setDuration(500)
                .alpha(0)
                .rotationBy(360)
                .start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isReadyForUserInput = true;
            }
        },1000);

    }

    private void openMenu(){

        isReadyForUserInput = false;

        isMenuOpen = true;
        Log.e(TAG, "openMenu: " );
//        isReadyForUserInput = false;

        whatsapp.animate()
                .translationXBy(pos_whatsapp[0]-pos_facebook[0])
                .translationYBy(pos_whatsapp[1]-pos_facebook[1])
                .setDuration(500)
                .rotationBy(360)
                .alpha(1)
                .start();

        instagram.animate()
                .translationXBy(pos_instagram[0]-pos_facebook[0])
                .translationYBy(pos_instagram[1]-pos_facebook[1])
                .setDuration(500)
                .alpha(1)
                .rotationBy(360)
                .start();

        tinder.animate()
                .translationXBy(pos_tinder[0]-pos_facebook[0])
                .translationYBy(pos_tinder[1]-pos_facebook[1])
                .setDuration(500)
                .rotationBy(360)
                .alpha(1)
                .start();

        tumbler.animate()
                .translationXBy(pos_tumbler[0]-pos_facebook[0])
                .translationYBy(pos_tumbler[1]-pos_facebook[1])
                .setDuration(500)
                .rotationBy(360)
                .alpha(1)
                .start();

        blogger.animate()
                .translationXBy(pos_blogger[0]-pos_facebook[0])
                .translationYBy(pos_blogger[1]-pos_facebook[1])
                .setDuration(500)
                .rotationBy(360)
                .alpha(1)
                .start();

        hangout.animate()
                .translationXBy(pos_hangout[0]-pos_facebook[0])
                .translationYBy(pos_hangout[1]-pos_facebook[1])
                .setDuration(500)
                .rotationBy(360)
                .alpha(1)
                .start();

        slack.animate()
                .translationXBy(pos_slack[0]-pos_facebook[0])
                .translationYBy(pos_slack[1]-pos_facebook[1])
                .setDuration(500)
                .rotationBy(360)
                .alpha(1)
                .start();

        gmail.animate()
                .translationXBy(pos_gmail[0]-pos_facebook[0])
                .translationYBy(pos_gmail[1]-pos_facebook[1])
                .setDuration(500)
                .rotationBy(360)
                .alpha(1)
                .start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isReadyForUserInput = true;
            }
        },1000);


    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id){

            case R.id.whatsapp :
                Toast.makeText(this,"whatsapp",Toast.LENGTH_SHORT).show();
                break;


            case R.id.instagram :
                Toast.makeText(this,"instagram",Toast.LENGTH_SHORT).show();
                break;


            case R.id.tinder :
                Toast.makeText(this,"tinder",Toast.LENGTH_SHORT).show();
                break;


            case R.id.tumbler :
                Toast.makeText(this,"tumbler",Toast.LENGTH_SHORT).show();
                break;


            case R.id.blogger :
                Toast.makeText(this,"blogger",Toast.LENGTH_SHORT).show();
                break;


            case R.id.hangout :
                Toast.makeText(this,"hangout",Toast.LENGTH_SHORT).show();
                break;


            case R.id.slack :
                Toast.makeText(this,"slack",Toast.LENGTH_SHORT).show();
                break;


            case R.id.gmail :
                Toast.makeText(this,"gmail",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
