package com.example.commtestnode.ui.notifications;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.VolleyError;
import com.example.commtestnode.R;

import com.example.commtestnode.utils.IResult;
import com.example.commtestnode.utils.VolleyService;

import org.json.JSONObject;


public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    private TextView
            responseView;
    private EditText
            svURL,
            message;
    private Button
            get,
            post;
    IResult mResultCallback;
    VolleyService mVolleyService;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);

        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        svURL = root.findViewById(R.id.svurl);
        message = root.findViewById(R.id.message);
        responseView = root.findViewById(R.id.text_notifications);
        get = root.findViewById(R.id.get_req);
        post = root.findViewById(R.id.post_req);

        //String ip = "";
        //wifiHelper = new WifiHelper( getActivity().getApplicationContext() , ip);

        initVolleyCallback();
        mVolleyService = new VolleyService(mResultCallback, getActivity().getApplicationContext());


        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVolleyService.getDataVolley("GETCALL", "https://postman-echo.com/get?foo1=bar1&foo2=bar2" );//"http://192.168.1.150/datatest/get/data");

            }
        });

        return root;
    }

    void initVolleyCallback() {
        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Toast.makeText(getContext(), "this shouldn't be here..", Toast.LENGTH_SHORT).show();
            }

            String TAG = getContext().getClass().getSimpleName();

            @Override
            public void notifySuccess(String requestType, String response) {
                Log.d(TAG, "Volley requester " + requestType);
                Log.d(TAG, "Volley JSON post" + response);
                responseView.setText( response );
            }

            @Override
            public void notifyError(String requestType, VolleyError error) {
                Log.d(TAG, "Volley requester " + requestType);
                Log.d(TAG, "Volley JSON post" + "That didn't work!");
            }
        };
    }
}
