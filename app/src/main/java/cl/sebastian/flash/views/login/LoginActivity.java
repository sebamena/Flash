package cl.sebastian.flash.views.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ResultCodes;

import java.util.Arrays;

import cl.sebastian.flash.R;
import cl.sebastian.flash.views.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginInterface{

    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        new LoginPresenter(LoginActivity.this).validateSession();


//        if(new CurrentUser().getCurrentuser() != null){
//
//            logged();
//
//
//        }else{
//
//            signUp();
//
//        }




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(RC_SIGN_IN == requestCode){

            if(ResultCodes.OK == resultCode){

                logged();

            }

        }


    }

    @Override
    public void logged() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void signUp() {

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setProviders(
                                Arrays.asList(
                                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                        new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                        new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build()
                                )
                        )
                        .setTheme(R.style.LoginTheme)
                        .setLogo(R.mipmap.logo)
                        .build(),
                RC_SIGN_IN);
    }

//    public void signUp(){
//        startActivityForResult(
//                AuthUI.getInstance()
//                        .createSignInIntentBuilder()
//                        .setProviders(
//                                Arrays.asList(
//                                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
//                                        new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
//                                        new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build()
//                                )
//
//
//
//                        )
//                        .setTheme(R.style.LoginTheme)
//                        .setLogo(R.mipmap.logo)
//                        .build(),
//                RC_SIGN_IN);
//    }
//
//    public void logged(){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
//    }

}
