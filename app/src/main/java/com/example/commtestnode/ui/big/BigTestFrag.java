package com.example.commtestnode.ui.big;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commtestnode.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BigTestFrag extends Fragment {

    private RecyclerView mRecyclerView;
    private ActionAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton fabAdd, fabRem;

    private BigTestViewModel mViewModel;
    //TODO need to be an actors fragment for a scene
    // actionItems obtained from list of actions OR omitted entirely
    //

    private ArrayList<ActionItem> actionItems;


    public static BigTestFrag newInstance(ArrayList<ActionItem> actions) {
        //this.scene = scene;

        BigTestFrag newFrag = new BigTestFrag();
        newFrag.setActionItems(actions);
        return newFrag;
    }


    public void setActionItems(ArrayList<ActionItem> actionItems) {
        this.actionItems = actionItems;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //getView().findViewById(R.id.big_text).setTooltipText("displaydata1");
        //return inflater.inflate(R.layout.big_test_fragment, container, false);

        View root = inflater.inflate(R.layout.big_test_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        ((TextView) root.findViewById(R.id.big_text)).setText(R.string.placeholder_string);
        populate();
        initRecycler(root);
        fabAdd = root.findViewById(R.id.add_button);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAction();
            }
        });
        fabRem = root.findViewById( R.id.rem_button );
        fabRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAction( actionItems.size()-1 );
            }
        });
        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BigTestViewModel.class);
        // TODO: Use the ViewModel


    }

    public void populate() {

        if(actionItems == null) {
            actionItems = new ArrayList<>();

            actionItems.add(new ActionItem());
            actionItems.add(new ActionItem("11", "12", "13"));
            actionItems.add(new ActionItem("21", "22", "23"));
            actionItems.add(new ActionItem("31", "32", "33"));
            actionItems.add(new ActionItem("41", "42", "43"));/*
        actionItems.add(new ActionItem("41", "42", "43"));
        actionItems.add(new ActionItem("41", "42", "43"));
        actionItems.add(new ActionItem("41", "42", "43"));
        actionItems.add(new ActionItem("41", "42", "43"));
        actionItems.add(new ActionItem("41", "42", "43"));
        actionItems.add(new ActionItem("41", "42", "43"));
        actionItems.add(new ActionItem("41", "42", "43"));
        actionItems.add(new ActionItem("41", "42", "43"));*/
        }
    }

    public void addEmptyAction(int pos) {
        actionItems.add(pos, new ActionItem("hablar","carita empapada"," moverse"));
        mAdapter.notifyItemInserted(pos);//mAdapter.notifyDataSetChanged(); >> refreshes all list
    }

    public void addAction(){
        actionItems.add(new ActionItem("talk","facey","move"));
        mAdapter.notifyItemInserted(actionItems.size()-1);
    }

    public void addAction(int pos, String text1, String text2, String text3 ) {
        actionItems.add(pos, new ActionItem( text1, text2, text3 ));
        mAdapter.notifyItemInserted(pos);
    }

    public void deleteAction(int pos) {
        if(pos <0) return;
        actionItems.remove(pos);
        mAdapter.notifyItemRemoved(pos);
    }


    public void initRecycler(View root) {
        //assigning stuff
        mRecyclerView = root.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ActionAdapter(actionItems);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setItemClickListener(new ActionAdapter.itemClickListener() {
            @Override
            public void onTalky(int position) {
                //TODO handle talk action || perhaps intentforresult + return string and set!
                String txt = "edit talk for item " + position;
                Toast.makeText( getActivity(), txt , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMovey(int position) {
                //TODO handle move action
                String txt = "edit move for item " + position;
                Toast.makeText( getActivity(), txt , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFacey(int position) {
                //TODO handle face action
                String txt = "edit face for item " + position;
                Toast.makeText( getActivity(), txt , Toast.LENGTH_LONG).show();
            }
        });
    }
}