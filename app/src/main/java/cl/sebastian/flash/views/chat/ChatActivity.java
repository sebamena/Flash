package cl.sebastian.flash.views.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.ServerValue;

import cl.sebastian.flash.R;
import cl.sebastian.flash.data.CurrentUser;
import cl.sebastian.flash.data.Nodes;
import cl.sebastian.flash.models.Chat;
import cl.sebastian.flash.views.main.chats.ChatsFragment;

public class ChatActivity extends AppCompatActivity {

    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Chat chat = (Chat) getIntent().getSerializableExtra(ChatsFragment.CHAT);
        key = chat.getKey();
        new Nodes().userChat(new CurrentUser().uid()).child(key).child("timestamp").setValue(ServerValue.TIMESTAMP);
        //String email = getIntent().getStringExtra(ChatsFragment.CHAT);

        getSupportActionBar().setTitle(chat.getReceiver());

    }

    @Override
    protected void onPause() {
        super.onPause();
        new Nodes().userChat(new CurrentUser().uid()).child(key).child("notification").setValue(false);
    }
}
