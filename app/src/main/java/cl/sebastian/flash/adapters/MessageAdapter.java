package cl.sebastian.flash.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import cl.sebastian.flash.R;
import cl.sebastian.flash.data.CurrentUser;
import cl.sebastian.flash.data.Nodes;
import cl.sebastian.flash.models.Message;

/**
 * Created by Sebastián Mena on 14-09-2017.
 */

public class MessageAdapter extends FirebaseRecyclerAdapter <Message, MessageAdapter.MessageHolder> {

    private static final String CURRENT_EMAIL = new CurrentUser().email();
    private MessagesCallback callback;

    public MessageAdapter(String chatId,MessagesCallback callback) {
        super(Message.class, R.layout.list_item_message, MessageHolder.class, new Nodes().messages(chatId));
        this.callback = callback;
    }

    @Override
    protected void populateViewHolder(MessageHolder viewHolder, Message model, int position) {

        TextView textView = (TextView) viewHolder.itemView;

        if(CURRENT_EMAIL.equals(model.getOwner())){
            textView.setGravity(Gravity.RIGHT);
        }else{
            textView.setGravity(Gravity.LEFT);
        }

        textView.setText(model.getContent());

    }

    @Override
    protected void onDataChanged() {
        super.onDataChanged();
        callback.update();
    }

    public static class MessageHolder extends RecyclerView.ViewHolder{


        public MessageHolder(View itemView) {
            super(itemView);
        }
    }

}
