package cl.sebastian.flash.views.main.chats;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.sebastian.flash.R;
import cl.sebastian.flash.adapters.ChatsAdapter;
import cl.sebastian.flash.adapters.ChatsListener;
import cl.sebastian.flash.views.chat.ChatActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatsFragment extends Fragment implements ChatsListener {

    public static final String CHAT_KEY = "cl.sebastian.flash.views.main.chats.KEY.CHAT_KEY";
    public static final String CHAT_RECEIVER = "cl.sebastian.flash.views.main.chats.KEY.CHAT_RECEIVER";

    RecyclerView recyclerView;


    public ChatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chats, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = (RecyclerView) view.findViewById(R.id.chatsRv);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                LinearLayoutManager.HORIZONTAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setHasFixedSize(true);

        ChatsAdapter adapter = new ChatsAdapter(this);

        recyclerView.setAdapter(adapter);




    }

    @Override
    public void clicked(String key, String mail) {
        //Toast.makeText(getContext(),mail,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity(), ChatActivity.class);
        intent.putExtra(CHAT_KEY,key);
        intent.putExtra(CHAT_RECEIVER,mail);
        startActivity(intent);

    }
}
