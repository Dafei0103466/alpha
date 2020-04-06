package com.pingan.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value="构造接口请求参数模板",description="参数模板类")
public class ApiDocDTO implements Serializable {
//    private  Integer id;
    @NotEmpty(message = "apiName不能为空")
    @NotBlank(message = "apiName不能为空哟")
    @ApiModelProperty(example="createExam",required = true)
    private String apiName;
    @NotEmpty(message = "接口项目Id不能为空")
    @NotBlank(message = "接口项目Id不能为空")
    @ApiModelProperty(example="xjl-app",required = true)
    private String projectId;
    @NotNull
    @ApiModelProperty(example="接口描述-创建考试接口参数模板",required = false)
    private String apiDesc;
    @NotEmpty(message = "接口所在模块不能为空")
    @NotBlank(message = "接口所在模块不能为空")
    @ApiModelProperty(example="studyWork",required = true)
    private String module;
    @NotNull
    @ApiModelProperty(example="{\"examId\":22,\"examdesc\":\"考试号\"}",required = true)
    private String apiRequestBody;
    @JsonProperty("otherInfo") //  当前端属性otherInfo后台接收对象的属性名不同时可以用@JsonProperty来保持一致
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
