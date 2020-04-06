package com.pingan.web.apiDoc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pingan.domain.ApiDocDTO;
import com.pingan.entity.ApiDocDO;
import com.pingan.response.ResponseCodeEnum;
import com.pingan.service.ApiDocService;
import com.pingan.response.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Slf4j
@RestController
@RequestMapping("/interfaceDoc")
@Api(value = "接口请求参数模板管理")
public class ApiDocController {

//    @Value("${name}")
//    private String name;

    private ApiDocService apiDocService;

    public ApiDocService getApiDocService() {
        return apiDocService;
    }

    @Autowired
    public void setApiDocService(ApiDocService apiDocService) {
        this.apiDocService = apiDocService;
    }


    @ApiOperation(value="创建一个接口文档", notes="验证")
    @ApiImplicitParam( paramType = "query", name = "apiName", value = "获取接口参数模板", required = true, dataType = "long")
    @RequestMapping(value = "/getApiDoc/{apiName}",method = {RequestMethod.GET,RequestMethod.POST})
    public JSONObject getApiDoc(@PathParam(value = "apiName") String apiName){
        ApiDocDO result = apiDocService.findByApiName(apiName);
        if (result!=null){
            return JSON.parseObject(result.getApiRequestBody());
        }
        return null;
    }
// 使用@RequestBody @Valid 对JSON参数进行获取和校验。
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "apiName", value = "接口名称", required = true, dataType = "String",defaultValue = "/adminapi/examDetail.do"),
            @ApiImplicitParam(paramType="query", name = "projectId", value = "项目名称", required = true, dataType = "String",defaultValue = "xjl-app"),
            @ApiImplicitParam(paramType="body", name = "apiRequestBody", value = "接口请求参数模板", required = true, dataType = "String",defaultValue = "{\"examId\":22,\"examdesc\":\"考试号\"}"),
            @ApiImplicitParam(paramType="query", name = "module", value = "接口所属模块", required = true, dataType = "String",defaultValue = "exam"),
            @ApiImplicitParam(paramType="query", name = "apiDesc", value = "项目名称", required = true, dataType = "String",defaultValue = "备注接口用途"),
            @ApiImplicitParam(paramType="query", name = "otherInfo", value = "预留字段暂时无用", required = false, dataType = "String")
    })
//    @RequestBody @Valid ApiDocDTO apiDocDTO 后续带前端再增加
    @PostMapping(value = "/createApiDoc")
    public ResponseVO createApiDoc(@RequestBody String apiRequestBody,ApiDocDTO apiDocDTO){
        ResponseVO responseVO = new ResponseVO();
        try {
            apiDocDTO.setApiRequestBody(apiRequestBody);
            apiDocService.addApiDoc(apiDocDTO);
        }catch (Exception e){
            log.error(e.getMessage());
            responseVO.setCode(ResponseCodeEnum.FAIL.getCode());
            responseVO.setMsg(ResponseCodeEnum.FAIL.getName());
            return responseVO;
        }
        responseVO.setCode(ResponseCodeEnum.SUCCESS.getCode());
        responseVO.setMsg(ResponseCodeEnum.SUCCESS.getName());
        return  responseVO;
    }

    @ApiOperation(value="查询接口文档详细",notes = "")
    @ApiImplicitParam(paramType="path", name = "id", value = "接口模板ID", required = true, dataType = "Long")
    @GetMapping(value = "/getInfo/{id}")
    public ApiDocDO getApiInfo(@PathVariable(value = "id") Integer id){
        return apiDocService.findById(id);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path", name = "id", value = "接口模板ID", required = true, dataType = "Long"),
            @ApiImplicitParam( name = "apiDocDto", value = "接口参数模板详细信息", required = true, dataType = "ApiDocDTO")
    })
    @ApiOperation(value="更新接口模板参数",notes = "根据id更新")
    @PutMapping(value = "/updateApiInfo")
    public ResponseVO updateApiInfo(@PathParam(value = "id") Integer id, @RequestParam(value = "apiDocDto") ApiDocDTO apiDocDto){
        return  new ResponseVO();
    }

    @ApiImplicitParam(paramType="query", name = "id", value = "删除接口模板", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleteApiDoc/{id}")
    public Integer deleteApiDoc(@PathParam(value = "id") Integer id){
        return apiDocService.deleteApiDoc(id);
    }
}
