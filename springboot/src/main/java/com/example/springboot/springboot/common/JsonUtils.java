package com.example.springboot.springboot.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhangsongran
 * Date: 14-2-20
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public class JsonUtils {

    /**
     * 获取某个结点的值
     *
     * @param nodeName
     * @return
     */
    public static String getJsonNode(String json, String nodeName) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        return jsonObject.getJSONObject(nodeName).toJSONString();
    }

    /**
     * 将对象转成json串
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    /**
     * 将对象转成json串
     *
     * @param obj
     * @return
     * @throws IOException
     */
    public static String toJson(Object obj, String bundle) throws IOException {
        String v = JSONObject.toJSONString(obj);
        StringBuffer sb = new StringBuffer();
        sb.append("{\"");
        sb.append(bundle);
        sb.append("\":");
        sb.append(v);
        sb.append("}");
        return sb.toString();
    }

    /**
     * 对于可选字段的处理。
     *
     * @param obj
     * @param fields
     * @return
     * @throws IOException
     */
    public static String toJsonExcept(Object obj, String[] fields, Class clazz, String bundle) throws IOException {
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(clazz, fields);
        String vv = JSONObject.toJSONString(obj, filter);
        StringBuffer sb = new StringBuffer();
        sb.append("{\"");
        sb.append(bundle);
        sb.append("\":");
        sb.append(vv);
        sb.append("}");
        return sb.toString();
    }

    /**
     * json to clazz
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static Map<String, Object> jsonToMap(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        Map<String, Object> map = new HashMap<String, Object>();
        Set<String> sets = jsonObject.keySet();
        for (String key : sets) {
            map.put(key, jsonObject.get(key));
        }
        return map;
    }
}
