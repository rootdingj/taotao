package com.dj.taotao.search.service;

import com.dj.taotao.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryStr, int page, int rows);

}
