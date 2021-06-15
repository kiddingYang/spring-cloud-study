package com.study.springCloud.commons.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    public Integer code;
    public String message;
    public T dataList;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }


}
