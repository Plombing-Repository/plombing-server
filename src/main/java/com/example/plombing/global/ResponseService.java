package com.example.plombing.global;

import com.example.plombing.global.result.CommonResult;
import com.example.plombing.global.result.ListResult;
import com.example.plombing.global.result.SingleResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResponseService{
    @AllArgsConstructor
    @Getter
    private enum CommonResponse {
        SUCCESS(200, "성공하였습니다.");

        int code;
        String message;
    }

    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<T>();
        result.setData(data);
        this.setSuccessResult(result);
        return result;
    }

    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<T>();
        result.setList(list);
        this.setSuccessResult(result);
        return result;
    }
    public CommonResult getSuccessfulResult() {
        CommonResult result = new CommonResult();
        this.setSuccessResult(result);
        return result;
    }

    public CommonResult getFailResult(int code, String message) {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMessage(CommonResponse.SUCCESS.getMessage());
    }
}