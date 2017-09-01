package cl.sebastian.flash.views.main.drawer;

import android.content.Context;

import cl.sebastian.flash.data.PhotoPreference;

/**
 * Created by Sebastián Mena on 01-09-2017.
 */

public class PhotoValidation {

    private Context context;
    private PhotoCallback callback;


    public PhotoValidation(Context context, PhotoCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void validate(){

        String url = new PhotoPreference(context).getPhoto();
        if (url !=null){

            callback.photoAvailable(url);

        }else{

            callback.emptyPhoto();
        }

    }


}
