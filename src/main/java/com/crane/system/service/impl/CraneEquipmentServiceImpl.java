package com.crane.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crane.system.dto.AddEquipmentDTO;
import com.crane.system.dto.EquipmentDTO;
import com.crane.system.entity.CraneEquipment;
import com.crane.system.mapper.CraneEquipmentMapper;
import com.crane.system.service.CraneEquipmentService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :zlq
 * @date : 2024/3/26
 */

@Service
public class CraneEquipmentServiceImpl extends ServiceImpl<CraneEquipmentMapper, CraneEquipment> implements CraneEquipmentService{

    @Override
    public void insert(AddEquipmentDTO dto) {
        CraneEquipment equipment = new CraneEquipment();
        BeanUtils.copyProperties(dto, equipment);
        baseMapper.insert(equipment);
    }

    @Override
    public List<EquipmentDTO> listAllEquipment() {
        List<CraneEquipment> craneEquipments = baseMapper.selectList(new LambdaQueryWrapper<>());
        List<EquipmentDTO> collect = craneEquipments.stream().map(this::buidEquipmentDTO).collect(Collectors.toList());
        return CollectionUtils.isEmpty(collect) ? new ArrayList<>() : collect;
    }

    EquipmentDTO buidEquipmentDTO(CraneEquipment equipment) {
        EquipmentDTO dto = new EquipmentDTO();
        dto.setId(equipment.getId().toString());
        dto.setDeviceName(equipment.getDeviceName());
        return dto;
    }


}
