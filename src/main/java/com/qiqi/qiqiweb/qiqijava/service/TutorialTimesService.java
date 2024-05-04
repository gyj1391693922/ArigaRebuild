package com.example.service;

import com.example.controller.request.TutorialPageRequest;
import com.example.entity.tutorial;
import com.example.entity.tutorialtimes;
import com.github.pagehelper.PageInfo;

public interface ITutorialTimesService {
    void add(tutorialtimes obj);

    PageInfo<tutorialtimes> page(TutorialPageRequest tutorialPageRequest);

    PageInfo<tutorialtimes> getBysIdtutorialtimes(Integer id);

    PageInfo<tutorialtimes> getBysv(Integer pNum, Integer id);

    tutorialtimes getById(Integer id);

    void save(tutorialtimes obj);

    void update(tutorialtimes obj);

    void deleteById(String tconst);
}
