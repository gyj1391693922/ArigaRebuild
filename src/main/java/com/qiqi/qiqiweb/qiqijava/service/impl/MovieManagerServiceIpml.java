package com.qiqi.qiqiweb.qiqijava.movieManager.service.impl;

import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiqi.qiqiweb.qiqijava.movieManager.controller.request.MovieManagerRequest;
import com.qiqi.qiqiweb.qiqijava.movieManager.entity.MovieManager;
import com.qiqi.qiqiweb.qiqijava.movieManager.mapper.MovieManagerMapper;
import com.qiqi.qiqiweb.qiqijava.movieManager.service.MovieManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Slf4j
@Service
@Transactional
public class MovieManagerServiceIpml implements MovieManagerService {

    @Autowired
    MovieManagerMapper movieManagerMapper;

    List<MovieManager> temporary ;

    @Override
    public List<MovieManager> list() {
        return movieManagerMapper.list();
    }

    @Override
    public PageInfo<MovieManager> page(MovieManagerRequest baseRequest){
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<MovieManager> portfolioList = movieManagerMapper.listByCondition(baseRequest);
        return new PageInfo<>(portfolioList);
    }


    @Override
    public void save(MovieManager obj) {
        movieManagerMapper.save(obj);
    }


    @Override
    public MovieManager getById(Integer d_id) {
        return movieManagerMapper.getById(d_id);
    }

    @Override
    public void update(MovieManager obj) {
        movieManagerMapper.updateById(obj);
    }

    /**
     * 删除判断
     * @param tconst
     */

    @Override
    public void deleteById(String tconst) {
        if (checkDataExists(tconst)) {
            movieManagerMapper.deleteById(tconst);
        } else {
            throw new IllegalArgumentException("该剧下还有剧集存在，请删除剧集后再对该剧进行操作");
        }
    }

    //===============================
    private boolean checkDataExists(String tconst) {
        try {
            URL url = new URL("http://localhost:9091/akas/akaslists/" + tconst);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 读取返回的JSON数据并处理
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                String jsonResponse = response.toString();
                // 解析JSON对象，并获取data字段下的total值
                JSONObject jsonObject = new JSONObject(jsonResponse);
                int total = jsonObject.getJSONObject("data").getInt("total");
                if (total < 0){
                    return true;
                }
                return false;
            }
        } catch (IOException e) {
            // 请求异常，无数据
            return false;
        }
        return false;
    }


    /**
     * 删除判断结束
     * @param tconst
     * @return
     */

    @Override
    public PageInfo<MovieManager> getBysIdMovieManager(Integer id) {
        List<MovieManager> portfolioList = movieManagerMapper.listBysConditionMovieManager(id);
        return new PageInfo<>(portfolioList);
    }

    @Override
    public PageInfo<MovieManager> getBysv(Integer pNum,Integer id) {
        List<MovieManager> portfolioList = movieManagerMapper.listv(pNum,id);
        return new PageInfo<>(portfolioList);
    }

}
