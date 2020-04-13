package com.netintech.automation.mapper;

import com.netintech.automation.bean.logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LogsRepository extends JpaRepository<logs, Long>, JpaSpecificationExecutor<logs> {
}
