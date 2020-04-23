package com.example.commtestnode.utils;

import com.android.volley.VolleyError;

import org.json.JSONObject;

//Result interface
public interface IResult {
    void notifySuccess(String requestType, String response);
    void notifySuccess(String requestType, JSONObject response);
    void notifyError(String requestType, VolleyError error);

}
