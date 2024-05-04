package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class NewComments {

    private Integer postId;

    private Integer userId;

    private String comments;

}
