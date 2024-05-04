package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Comments {

    private Integer id;

    private Integer postId;

    private Integer commentsId;

    private Integer userId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    private String comments;

    private String username;
}
