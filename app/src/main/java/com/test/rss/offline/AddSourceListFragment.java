package com.test.rss.offline;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.rss.fragments.MainFragment;
import com.test.rss.model.FeedSourceModel;

import java.util.ArrayList;

public class AddSourceListFragment extends ListFragment {

    public static interface Listener {
        void sourceClicked(long id);
    }

    private Listener listener;

    public AddSourceListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SQLiteHelper sQLiteHelper;
        ArrayList<FeedSourceModel> feedSourceModel;
        Bundle arg = getArguments();
        String category;
        if (arg != null) {
            category = arg.getString("category");
        } else {
            category = "";
        }
        sQLiteHelper = new SQLiteHelper(getLayoutInflater().getContext());
        feedSourceModel = sQLiteHelper.getAllRecords(category);
        String[] name = new String[feedSourceModel.size()];
        String[] link = new String[feedSourceModel.size()];
        for (int i = 0; i < feedSourceModel.size(); i++) {
            name[i] = feedSourceModel.get(i).getName();
            link[i] = feedSourceModel.get(i).getUrl();
        }

        MainFragment.urls = link;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getLayoutInflater().getContext(), android.R.layout.simple_list_item_1, name);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        if (listener != null)
            listener.sourceClicked(id);
    }


}
