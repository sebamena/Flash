package cl.sebastian.flash.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

import cl.sebastian.flash.R;
import cl.sebastian.flash.data.CurrentUser;
import cl.sebastian.flash.data.Nodes;
import cl.sebastian.flash.models.Chat;

/**
 * Created by Sebastián Mena on 09/09/2017.
 */

public class ChatsAdapter extends FirebaseRecyclerAdapter<Chat,ChatsAdapter.ChatHolder>{

    private ChatsListener listener;

    public ChatsAdapter(ChatsListener listener) {
        super(Chat.class, R.layout.list_item_chat, ChatHolder.class, new Nodes().userChat(new CurrentUser().uid()));
        this.listener = listener;
    }

    @Override
    protected void populateViewHolder(final ChatHolder viewHolder, Chat model, int position) {

        Picasso.with(viewHolder.view.getContext()).load(model.getPhoto()).into(viewHolder.bubbleImageView);
        viewHolder.textView.setText(model.getReceiver());

        if (model.isNotification()){
            viewHolder.view.setVisibility(View.VISIBLE);
        }else{
            viewHolder.view.setVisibility(View.GONE);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chat auxChat = getItem(viewHolder.getAdapterPosition());
                listener.clicked(auxChat);
            }
        });

        //Log.d("TIMESTAMP",String.valueOf(model.getTimestamp()));

    }


    public static class ChatHolder extends RecyclerView.ViewHolder {
        private final ImageView bubbleImageView;
        private final TextView textView;
        private final View view;


        public ChatHolder(View itemView) {
            super(itemView);
            bubbleImageView = (ImageView) itemView.findViewById(R.id.photoBiv);
            textView = (TextView) itemView.findViewById(R.id.emailTv);
            view = itemView.findViewById(R.id.notificationV);
        }
    }

}
