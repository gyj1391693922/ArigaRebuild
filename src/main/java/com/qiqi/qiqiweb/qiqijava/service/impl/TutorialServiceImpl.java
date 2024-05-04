package com.example.service.impl;

import com.example.controller.request.TutorialPageRequest;
import com.example.entity.tutorial;
import com.example.mapper.TutorialMapper;
import com.example.service.ITutorialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialService implements ITutorialService {

    @Autowired
    TutorialMapper tutorialMapper;

    @Override
    public void add(tutorial obj) {
        tutorialMapper.add(obj);
    }

    @Override
    public PageInfo<tutorial> page(TutorialPageRequest tutorialRequest){
        PageHelper.startPage(tutorialRequest.getPageNum(),tutorialRequest.getPageSize());
        List<tutorial> basicsList = tutorialMapper.listByCondition(tutorialRequest);
        return new PageInfo<>(basicsList);
    }

    @Override
    public tutorial getBysIdMov(Integer id) {
        return tutorialMapper.listBysConditionMov(id);
    }
}
