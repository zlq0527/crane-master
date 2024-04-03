package com.crane.system.service;

import com.crane.system.dto.QueryCraneData;
import com.crane.system.entity.CraneData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * @author :zlq
 * @date : 2024/3/24
 */

public interface CraneDataService extends IService<CraneData> {


    PageInfo<CraneData> listPage(QueryCraneData dto);

}
