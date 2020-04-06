package com.pingan.entity;

import com.alibaba.fastjson.JSONPObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class ApiDocDO implements Serializable {
    private  Integer id;
    private String apiName;

    private String projectId;

    private String apiDesc;

    private String module;

    private String apiRequestBody;

    private String otherInfo;

    @Override
    public String toString() {
        return "TestDemoDTO{" +
                "apiName='" + apiName + '\'' +
                ", projectId=" + projectId +
                ", apiDesc=" + apiDesc +
                ", module=" + module +
                ", apiRequestBody=" + apiRequestBody +
                ", otherInfo=" + otherInfo +
                '}';
    }
}
