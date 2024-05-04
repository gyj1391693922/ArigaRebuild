package com.example.Mapper;

import com.example.Entity.Comments;
import com.example.Entity.NewComments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comments> pageByPostId(Integer commentsId);

    void save(NewComments obj);

    void del(Integer commentsId);
}
