package com.example.service.impl;

import com.example.controller.request.TutorialPageRequest;
import com.example.entity.tutorialtimes;
import com.example.mapper.TutorialTimesMapper;
import com.example.service.ITutorialTimesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialTimesService implements ITutorialTimesService {

    @Autowired
    TutorialTimesMapper tutorialTimesMapper;

    @Override
    public void add(tutorialtimes obj) {
        tutorialTimesMapper.add(obj);
    }

    @Override
    public PageInfo<tutorialtimes> page(TutorialPageRequest tutorialtimesPageRequest) {
        PageHelper.startPage(tutorialtimesPageRequest.getPageNum(),tutorialtimesPageRequest.getPageSize());
        List<tutorialtimes> basicsList = tutorialTimesMapper.listByCondition(tutorialtimesPageRequest);
        return new PageInfo<>(basicsList);
    }

    @Override
    public PageInfo<tutorialtimes> getBysIdtutorialtimes(Integer id) {
        List<tutorialtimes> tutorialtimesList = tutorialTimesMapper.listByConditiontutorialtimes(id);
        return new PageInfo<>(tutorialtimesList);
    }

    @Override
    public PageInfo<tutorialtimes> getBysv(Integer pId, Integer id) {
        List<tutorialtimes> tutorialtimesList = tutorialTimesMapper.listv(pId,id);
        return new PageInfo<>(tutorialtimesList);
    }

    @Override
    public tutorialtimes getById(Integer id) {
        return tutorialTimesMapper.getById(id);
    }

    @Override
    public void save(tutorialtimes obj) {
        tutorialTimesMapper.save(obj);
    }

    @Override
    public void update(tutorialtimes obj) {
        tutorialTimesMapper.updateById(obj);
    }

    @Override
    public void deleteById(String tconst) {

    }
}
