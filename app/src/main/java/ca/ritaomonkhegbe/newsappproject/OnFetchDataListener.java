package ca.ritaomonkhegbe.newsappproject;


import java.util.List;

import ca.ritaomonkhegbe.newsappproject.Models.NewsHeadlines;

public interface OnFetchDataListener<NewApiResponse> {
    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String message);
}
