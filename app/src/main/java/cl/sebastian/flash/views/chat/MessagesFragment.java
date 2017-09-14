package cl.sebastian.flash.views.chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.sebastian.flash.R;
import cl.sebastian.flash.adapters.MessageAdapter;
import cl.sebastian.flash.adapters.MessagesCallback;
import cl.sebastian.flash.models.Chat;
import cl.sebastian.flash.views.main.chats.ChatsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment implements MessagesCallback {

    private MessageAdapter adapter;
    private RecyclerView recyclerView;

    public MessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Chat chat = (Chat) getActivity().getIntent().getSerializableExtra(ChatsFragment.CHAT);
        //String key = chat.getKey();

        recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        adapter = new MessageAdapter(chat.getKey(), this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void update() {

        recyclerView.scrollToPosition(adapter.getItemCount() -1);
    }


    @Override
    public void onStop() {
        super.onStop();
        adapter.cleanup();
    }
}
