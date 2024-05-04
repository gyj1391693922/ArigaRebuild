package com.example.mapper;

import com.example.controller.request.TutorialPageRequest;
import com.example.entity.tutorial;
import com.example.entity.tutorialtimes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TutorialTimesMapper {
    void add(tutorialtimes obj);

    List<tutorialtimes> listByCondition(TutorialPageRequest tutorialPageRequest);

    void save(tutorialtimes obj);

    void updateById(tutorialtimes obj);

    List<tutorialtimes> listByConditiontutorialtimes(Integer id);

    List<tutorialtimes> listv(Integer pId, Integer id);

    tutorialtimes getById(Integer id);
}

