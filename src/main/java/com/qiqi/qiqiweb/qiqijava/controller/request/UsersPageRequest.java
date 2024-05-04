package com.example.controller.request;

import lombok.Data;

@Data
public class UsersPageRequest extends BaseRequest{
    private String tconst;
    private String primaryTitle;

}
