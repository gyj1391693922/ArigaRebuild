package com.example.qiqijava.qiqiweb.mapper;

import com.example.qiqijava.qiqiweb.controller.request.MovRequest;
import com.example.qiqijava.qiqiweb.entity.Mov;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovMapper {

    List<Mov> list();

    List<Mov> listByCondition(MovRequest baseRequest);

    List<Mov> listByConditionMov(Integer id);

    void save(Mov obj);

    Mov getById(Integer id);

    void updateById(Mov obj);

    void deleteById(Integer id);

    List<Mov> getByIdMov(Integer id);

    Mov listBysConditionMov(Integer id);
}
