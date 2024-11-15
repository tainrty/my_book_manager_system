package com.example.my_book_manager_system.comment.request;

import lombok.Data;

@Data
public class BaseRequest {
    private Integer pagemun=1;
    private Integer pagesize=10;
}
