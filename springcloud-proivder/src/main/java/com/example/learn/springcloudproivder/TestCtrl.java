package com.example.learn.springcloudproivder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableHystrix
@EnableHystrixDashboard
public class TestCtrl {

    @Autowired
    private GoodsManagementFeign goodsManagementFeign;

    @GetMapping("getGoods")
    @HystrixCommand(fallbackMethod = "hiError")
    public String getGoods() {
        String result = goodsManagementFeign.getGoodsByCode();
        System.out.println(result);
        return result;
    }


    @GetMapping("getJson")
    public String getJson() {
       return jsonObjectSample();
    }


    public String hiError() {
        return "sorry,error!";
    }


    public static String jsonObjectSample(){
        //通过JSONObject类构造出对象，该对象去调用JSONObject中的put方法去拼装出JSON格式数据
        JSONObject jsonObj = new JSONObject();
        Object nullObject = null;
        try {
            //put方法拼接JSON数据格式(key-value数据)
            jsonObj.put("name", "小明");
            jsonObj.put("age", 25.2);
            jsonObj.put("birthday", "1990-01-01");
            jsonObj.put("school", "新东方");
            jsonObj.put("major", new String[]{"理发","挖掘机"});
            jsonObj.put("has_friend", false);
            jsonObj.put("car", nullObject);
            jsonObj.put("hourse", nullObject);
            jsonObj.put("status", 0);
            System.out.println(jsonObj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj.toString();
    }
}
