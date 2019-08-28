package com.example.learn.springcloudproivder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "goodscenter")
public interface GoodsManagementFeign {
    @GetMapping(value = ( "/getMsg"))
    public String getGoodsByCode();
}
