package com.netintech.automation.mapper;

import com.netintech.automation.bean.logs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogsMapper {

    List<logs> getLogsAll();
}
