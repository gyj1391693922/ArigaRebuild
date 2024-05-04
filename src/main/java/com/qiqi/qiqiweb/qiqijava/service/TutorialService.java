package com.example.service;

import com.example.controller.request.TutorialPageRequest;
import com.example.entity.tutorial;
import com.github.pagehelper.PageInfo;

public interface ITutorialService {
    void add(tutorial obj);

    PageInfo<tutorial> page(TutorialPageRequest tutorialPageRequest);

    tutorial getBysIdMov(Integer id);
//    PageInfo<User> page(BaseRequest baseRequest);
}
