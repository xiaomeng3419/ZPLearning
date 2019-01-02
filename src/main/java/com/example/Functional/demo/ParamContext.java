package com.example.Functional.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangpan on 2018/11/22.
 */
public class ParamContext {

    private Map<String, Object> datas = new HashMap<String, Object>();

    public ParamContext(Object... params) {
        if (params == null || params.length == 0) {
            return;
        }
        for (int i = 0; i < params.length; ) {
            datas.put((String) params[i], params[i + 1]);
            i += 2;
        }

    }
    @SuppressWarnings("unchecked")
    public <R> R get(String key){
        return (R)datas.get(key);
    }
}
