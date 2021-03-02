package com.example.mohamed.newsappstage1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<Newsnetwork>> {

    private static String REQUEST_URL =
            "http://content.guardianapis.com/search?show-tags=contributor&api-key=test";

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Newsnetwork> loadInBackground() {
        if (REQUEST_URL == null) {
            return null;
        }

        List<Newsnetwork> newsList = QueryUtils.fetchNewsData(REQUEST_URL);
        return newsList;
    }
}