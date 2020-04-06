package com.pingan.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ResponseVO {

    private String res;
    @NotNull
    @ApiModelProperty(value = "接口创建成功",example="接口创建成功")
    private String msg;
    @NotNull
    @ApiModelProperty(example="0000",required = true)
    private String code;


}