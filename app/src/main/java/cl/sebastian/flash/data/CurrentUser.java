package cl.sebastian.flash.data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Sebastián Mena on 24-08-2017.
 */

public class CurrentUser {

    private FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();

    public FirebaseUser getCurrentuser() {
        return currentuser;
    }

    public String email(){ return getCurrentuser().getEmail(); }

    public String uid(){ return getCurrentuser().getUid(); }



}
