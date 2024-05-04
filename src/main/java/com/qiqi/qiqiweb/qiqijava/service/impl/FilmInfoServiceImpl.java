package com.qiqi.qiqiweb.qiqijava.service.impl;

import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiqi.qiqiweb.qiqijava.Mapper.FilmInfoMapper;
import com.qiqi.qiqiweb.qiqijava.controller.request.LimitRequest;
import com.qiqi.qiqiweb.qiqijava.entity.FilmDetail;
import com.qiqi.qiqiweb.qiqijava.entity.FilmInfo;
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
//service的作用就是聚合业务，将业务放到service里面写

@Slf4j
@Service
@Transactional
public class FilmInfoInfoServiceImpl implements FilmInfoServiceImpl {

    @Autowired
    FilmInfoMapper filmInfoMapper;

    List<FilmDetail> temporary ;

    @Override
    public List<FilmInfo> list() {
        return filmInfoMapper.list();
    }

    @Override
    public PageInfo<FilmInfo> page(LimitRequest baseRequest){
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<FilmInfo> basicsList = filmInfoMapper.listByCondition(baseRequest);
        return new PageInfo<>(basicsList);
    }


    @Override
    public void save(FilmInfo obj) {
        obj.setTconst("zk" +  obj.getTconst());
        filmInfoMapper.save(obj);
    }


    @Override
    public FilmInfo getById(Integer d_id) {
        return filmInfoMapper.getById(d_id);
    }

    @Override
    public void update(FilmInfo obj) {
        filmInfoMapper.updateById(obj);
    }

    /**
     * 删除判断
     * @param tconst
     */

    @Override
    public void deleteById(String tconst) {
        if (checkDataExists(tconst)) {
            filmInfoMapper.deleteById(tconst);
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
     *
     * @param tconst
     * @return
     */


    @Override
    public PageInfo<FilmDetail> getByIdFilmInfo(String tconst) {
        temporary = filmInfoMapper.listByConditionAkas(tconst);
        return new PageInfo<>(temporary);
    }

    @Override
    public FilmInfo getBysIdFilmInfo(Integer id) {
        return filmInfoMapper.listBysConditionFilmInfo(id);
    }


}

