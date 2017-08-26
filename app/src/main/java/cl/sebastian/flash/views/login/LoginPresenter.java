package cl.sebastian.flash.views.login;

import cl.sebastian.flash.data.CurrentUser;

/**
 * Created by Sebastián Mena on 26/08/2017.
 */

public class LoginPresenter {

    private LoginInterface callback;

    public LoginPresenter(LoginInterface callback){
        this.callback = callback;
    }

    public void validateSession(){

        if(new CurrentUser().getCurrentuser() != null){

            callback.logged();

        }else{

            callback.signUp();

        }

    }


}
