package com.pingan.mapper;

import com.pingan.domain.ApiDocDTO;
import com.pingan.entity.ApiDocDO;
import org.mapstruct.Mapper;

/**
 * Created by dafei on 2020/4/05
 */
@Mapper
public interface ApiDocMapper {

    public ApiDocDO findById(Integer id);

    void addApiDoc(ApiDocDTO apiDocDTO);
    //通过接口名称查询请求参数模板
    public ApiDocDO findByApiName(String apiName);

    Integer deleteApiDoc (Integer id);

}