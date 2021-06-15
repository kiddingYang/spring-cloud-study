package com.studyCloud.hystrix.dao;

import com.study.springCloud.commons.bean.LogInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogInfoDao {

    int createLoginfo(LogInfo logInfo);

}
