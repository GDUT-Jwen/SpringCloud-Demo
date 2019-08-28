package com.example.learn.springcloud.goodscenter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsCtrl {

    @GetMapping("/getMsg")
    public String returnGoodsName() {
        return "this is an apple!";
    }

}
