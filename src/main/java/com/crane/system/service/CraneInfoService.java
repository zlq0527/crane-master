package com.crane.system.service;

import com.crane.system.dto.CraneInfoDTO;
import com.crane.system.dto.QueryCraneInfoDTO;
import com.crane.system.entity.CraneInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * @author :zlq
 * @date : 2024/3/24
 */

public interface CraneInfoService extends IService<CraneInfo>{


    PageInfo<CraneInfoDTO> listPage(QueryCraneInfoDTO dto);

    Boolean insertCrane(CraneInfo dto);
}
