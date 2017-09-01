package cl.sebastian.flash.views.main.drawer;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import cl.sebastian.flash.data.CurrentUser;
import cl.sebastian.flash.data.Nodes;
import cl.sebastian.flash.data.PhotoPreference;
import cl.sebastian.flash.models.LocalUser;

/**
 * Created by Sebastián Mena on 01-09-2017.
 */

public class UploadPhoto {

    private Context context;

    public UploadPhoto(Context context) {
        this.context = context;
    }

    public void toFirebase(String path){

        final CurrentUser currentUser = new CurrentUser();
        String folder = currentUser.sanitizedEmail(currentUser.email()+"/");
        String photoName = "avatar.jpg";
        String baseUrl = "gs://flash-540d5.appspot.com/avatars/";
        String refUrl = baseUrl+folder+photoName;
        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(refUrl);
        storageReference.putFile(Uri.parse(path)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                @SuppressWarnings("VisibleForTests")
                String[] fullUrl = taskSnapshot.getDownloadUrl().toString().split("&token");
                String url = fullUrl[0];
                Log.e("URL",url);
                new PhotoPreference(context).photoSave(url);

                LocalUser user = new LocalUser();
                user.setEmail(currentUser.email());
                user.setName(currentUser.getCurrentuser().getDisplayName());
                user.setPhoto(url);
                user.setUid(currentUser.uid());
                String key = currentUser.sanitizedEmail(currentUser.email());
                new Nodes().user(key).setValue(user);


            }
        });


    }

}
