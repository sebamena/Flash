package cl.sebastian.flash.views.chat;

import cl.sebastian.flash.data.CurrentUser;
import cl.sebastian.flash.data.Nodes;
import cl.sebastian.flash.models.Chat;
import cl.sebastian.flash.models.Message;

/**
 * Created by Sebastián Mena on 14-09-2017.
 */

public class SendMessage {

    public void validateMessage(String message, Chat chat){

        if (message.trim().length() >0){

            String email = new CurrentUser().email();
            Message msg = new Message();
            msg.setContent(message);
            msg.setOwner(email);

            String key = chat.getKey();
            new Nodes().messages(key).push().setValue(msg);
            new Nodes().userChat(chat.getUid()).child(key).child("notification").setValue(true);
        }
    }

}
