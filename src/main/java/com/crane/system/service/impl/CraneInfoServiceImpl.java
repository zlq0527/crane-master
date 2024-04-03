package com.crane.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crane.system.dto.CraneInfoDTO;
import com.crane.system.dto.QueryCraneInfoDTO;
import com.crane.system.entity.CraneEquipment;
import com.crane.system.entity.CraneInfo;
import com.crane.system.mapper.CraneEquipmentMapper;
import com.crane.system.mapper.CraneInfoMapper;
import com.crane.system.service.CraneInfoService;
import com.crane.system.utils.GlobalExceptionHandler;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zlq
 * @date : 2024/3/24
 */

@Service
@Slf4j
public class CraneInfoServiceImpl extends ServiceImpl<CraneInfoMapper, CraneInfo> implements CraneInfoService{

    @Autowired
    private CraneEquipmentMapper craneEquipmentMapper;

    @Override
    public PageInfo<CraneInfoDTO> listPage(QueryCraneInfoDTO dto) {
        PageInfo<CraneInfoDTO> pageInfo = new PageInfo<>();
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        LambdaQueryWrapper<CraneInfo> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(dto.getCraneName())) {
            queryWrapper.like(CraneInfo::getCraneName, dto.getCraneName());
        }
        List<CraneInfo> craneInfos = baseMapper.selectList(queryWrapper);
        Integer count = baseMapper.selectCount(new QueryWrapper<>());
        if (CollectionUtils.isEmpty(craneInfos)) {
            return pageInfo;
        }
        List<CraneInfoDTO> craneInfoDTOList = new ArrayList<>();
        for (CraneInfo craneInfo : craneInfos) {
            CraneInfoDTO craneInfoDTO = new CraneInfoDTO();
            BeanUtils.copyProperties(craneInfo, craneInfoDTO);
            craneInfoDTO.setId(craneInfo.getId().toString());
            Long equipmentId = craneInfo.getEquipmentId();
            CraneEquipment equipment = craneEquipmentMapper.selectById(equipmentId);
            if (equipment != null) {
                craneInfoDTO.setDeviceName(equipment.getDeviceName());
            }
            craneInfoDTOList.add(craneInfoDTO);
        }
        pageInfo.setList(craneInfoDTOList);
        pageInfo.setTotal(count);
        return pageInfo;
    }

    @Override
    public Boolean insertCrane(CraneInfo dto) {
        LambdaQueryWrapper<CraneInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CraneInfo::getCraneName, dto.getCraneName());
        CraneInfo craneInfo = baseMapper.selectOne(queryWrapper);
        if (craneInfo != null) {
            throw new GlobalExceptionHandler("塔吊名称重复");
        }
        CraneInfo info = new CraneInfo();
        BeanUtils.copyProperties(dto, info);
        int res = baseMapper.insert(info);
        if (res < 0) {
            throw new GlobalExceptionHandler("插入异常");
        }
        return Boolean.TRUE;
    }

}
