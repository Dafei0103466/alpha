package com.pingan.service;
/*
 *created by dafei on 2020/4/6
 */

import com.pingan.domain.ApiDocDTO;
import com.pingan.entity.ApiDocDO;

public interface ApiDocService {

    public ApiDocDO findById(Integer id);
    void addApiDoc(ApiDocDTO apiDocDTO);
    //通过接口名称查询请求参数模板
    public ApiDocDO findByApiName(String apiName);
    Integer deleteApiDoc (Integer id);
}
