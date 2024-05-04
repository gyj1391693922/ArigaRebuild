package com.example.mapper;

import com.example.controller.request.TutorialRequest;
import com.example.entity.tutorial;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TutorialMapper {
    void add(tutorial obj);

    List<tutorial> listByCondition(TutorialRequest tutorialRequest);

    tutorial listBysConditionMov(Integer id);
}
