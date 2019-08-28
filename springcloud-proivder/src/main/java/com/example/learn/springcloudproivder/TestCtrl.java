package com.example.learn.springcloudproivder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCtrl {

    @Autowired
    private GoodsManagementFeign goodsManagementFeign;

    @GetMapping("getGoods")
    public String getGoods() {
        String result = goodsManagementFeign.getGoodsByCode();
        System.out.println(result);
        return result;
    }
}
