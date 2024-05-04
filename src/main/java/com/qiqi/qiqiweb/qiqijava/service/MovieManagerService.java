package com.qiqi.qiqiweb.qiqijava.movieManager.service;

import com.github.pagehelper.PageInfo;
import com.qiqi.qiqiweb.qiqijava.movieManager.controller.request.MovieManagerRequest;
import com.qiqi.qiqiweb.qiqijava.movieManager.entity.MovieManager;

import java.util.List;

public interface MovieManagerService {

    List<MovieManager> list();

    PageInfo<MovieManager> page(MovieManagerRequest baseRequest);

    void save(MovieManager obj);

    MovieManager getById(Integer m_id);

    void update(MovieManager obj);

    void deleteById(String tconst);

    PageInfo<MovieManager> getBysIdMovieManager(Integer id);

    PageInfo<MovieManager> getBysv(Integer pNum,Integer id);
}
