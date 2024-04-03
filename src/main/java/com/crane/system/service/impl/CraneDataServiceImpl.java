package com.crane.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crane.system.dto.QueryCraneData;
import com.crane.system.entity.CraneData;
import com.crane.system.mapper.CraneDataMapper;
import com.crane.system.service.CraneDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :zlq
 * @date : 2024/3/24
 */

@Service
public class CraneDataServiceImpl extends ServiceImpl<CraneDataMapper, CraneData> implements CraneDataService{

    @Override
    public PageInfo<CraneData> listPage(QueryCraneData dto) {
        PageInfo<CraneData> pageInfo = new PageInfo<>();
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        QueryWrapper<CraneData> wrapper = new QueryWrapper<>();
        if (dto.getDeviceId() != null) {
            wrapper.eq("id", dto.getDeviceId());
        }
        wrapper.orderByDesc("gmt_create");
        List<CraneData> craneData = baseMapper.selectList(wrapper);
        Integer count = baseMapper.selectCount(wrapper);
        if (CollectionUtils.isEmpty(craneData)) {
            return pageInfo;
        }
        pageInfo.setList(craneData);
        pageInfo.setTotal(count);
        return pageInfo;
    }
}
