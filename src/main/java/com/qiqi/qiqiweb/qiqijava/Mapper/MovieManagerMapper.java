package com.qiqi.qiqiweb.qiqijava.Mapper.MovieManager;

import com.qiqi.qiqiweb.qiqijava.controller.request.MovieManagerRequest;
import com.qiqi.qiqiweb.qiqijava.entity.MovieManager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieManagerMapper {

    List<MovieManager> list();

    List<MovieManager> listByCondition(MovieManagerRequest baseRequest);

    void save(MovieManager obj);

    MovieManager getById(Integer d_id);

    void updateById(MovieManager obj);

    void deleteById(String tconst);

    List<MovieManager> listBysConditionMovieManager(Integer pNum);

    List<MovieManager> listv(Integer pNum,Integer id);
}
