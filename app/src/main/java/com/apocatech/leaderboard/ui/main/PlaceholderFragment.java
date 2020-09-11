package com.apocatech.leaderboard.ui.main;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.apocatech.leaderboard.Constants;
import com.apocatech.leaderboard.R;
import com.apocatech.leaderboard.Result;
import com.apocatech.leaderboard.ResultRecycleAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    private ResultRecycleAdapter adapter;
    private RecyclerView recyclerView;

    String urlAppend = "";
    List<Result> results;

    AsyncTask<?, ?, ?> runningTask;


    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
                View root = inflater.inflate(R.layout.fragment_main, container, false);
                recyclerView = root.findViewById(R.id.lst_results);
                //final TextView textView = root.findViewById(R.id.section_label);
                pageViewModel.getText().observe(this, new Observer<String>() {
                @Override
                public void onChanged(@Nullable String tab) {
                    //textView.setText(s);
                    //textView.setText(fetchData(s));
                    fetchData(tab);
                }
            });
        return root;
    }

    private void fetchData(final String tab)
    {
        urlAppend = (tab.equals("1")) ? "/api/hours": "/api/skilliq";

        StringRequest stringRequest = new StringRequest(Constants.URL+urlAppend, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                results = Arrays.asList(gson.fromJson(response, Result[].class));

                ResultRecycleAdapter adapter = new ResultRecycleAdapter(getActivity(), results, tab);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MainActivity.class", "onErrorResponse: " + error.getMessage());
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }






}