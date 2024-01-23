
package com.baidu.ai.aip;

import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.HttpUtil;
import com.google.gson.Gson;

import java.net.URLEncoder;

/**
 * 动物识别
 */
public class Animal {
    /**
     * 动物
     *
     * @return {@link String}
     */
    public static String animal() {
        //TODO:后面开发能接受2中参数  一种是在线图片链接的url  一种是图片的base64格式  文件上传在线链接可以用 阿里云oss对象存储
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
        try {
            // 本地文件路径
            String filePath = "E:\\cyStudy\\第一阶段\\javaSe\\day04\\src\\com\\baidu\\ai\\aip\\images\\logo.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;


            //在线图片路径
            // String param = "src=" + "https://lhwaimai.oss-cn-beijing.aliyuncs.com/logo/logo.jpg";
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            // String accessToken = "[24.cf937e5b26af488bbe432a0b261d82ea.2592000.1706410007.282335-45969874]";
            String accessToken = "24.cf937e5b26af488bbe432a0b261d82ea.2592000.1706410007.282335-45969874";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String animal = Animal.animal();
        // Gson gson = new Gson();
        // String animalJsonStr = gson.toJson(animal);
        // System.out.println("返回的json格式："+animalJsonStr);
    }
}