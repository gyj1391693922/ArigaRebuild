package com.example.qiqijava.qiqiweb.service.impl;

import com.example.qiqijava.qiqiweb.controller.request.MovRequest;
import com.example.qiqijava.qiqiweb.entity.Mov;
import com.example.qiqijava.qiqiweb.mapper.MovMapper;
import com.example.qiqijava.qiqiweb.service.IMovService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//service的作用就是聚合业务，将业务放到service里面写

@Slf4j
@Service
@Transactional
public class MovService implements IMovService {

    @Autowired
    MovMapper movMapper;

    List<Mov> temporary ;

    @Override
    public List<Mov> list() {
        return movMapper.list();
    }

    @Override
    public PageInfo<Mov> page(MovRequest baseRequest){
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Mov> movList = movMapper.listByCondition(baseRequest);
        return new PageInfo<>(movList);
    }


    @Override
    public void save(Mov obj) {
        movMapper.save(obj);
    }


    @Override
    public Mov getById(Integer d_id) {
        return movMapper.getById(d_id);
    }

    @Override
    public void update(Mov obj) {
        movMapper.updateById(obj);
    }


    @Override
    public void deleteById(Integer id) {

        movMapper.deleteById(id);
    }


    @Override
    public PageInfo<Mov> getByIdMov(Integer id) {
        temporary = movMapper.listByConditionMov(id);
        return new PageInfo<>(temporary);
    }

    @Override
//    @Cacheable(cacheNames = "mov",key = "#p0")//本地缓存,p0表示形参列表第一个
    public Mov getBysIdMov(Integer id) {
        return movMapper.listBysConditionMov(id);
    }


}

