package com.pingan.service;/*
 *created by Administrator on 2020/4/6
 */

import com.pingan.domain.ApiDocDTO;
import com.pingan.entity.ApiDocDO;
import com.pingan.mapper.ApiDocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ApiDocService")
public class ApiDocServiceImp implements ApiDocService{
    @Autowired
    private ApiDocMapper apiDocMapper;
    @Override
    public ApiDocDO findById(Integer id) {
        return apiDocMapper.findById(id);
    }

    @Override
    public void addApiDoc(ApiDocDTO apiDocDTO) {
        apiDocMapper.addApiDoc(apiDocDTO);
    }

    @Override
    public ApiDocDO findByApiName(String apiName) {
        return apiDocMapper.findByApiName(apiName);
    }

    @Override
    public Integer deleteApiDoc(Integer id) {
        return apiDocMapper.deleteApiDoc(id);
    }
}
