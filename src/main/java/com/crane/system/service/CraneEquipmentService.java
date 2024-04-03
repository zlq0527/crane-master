package com.crane.system.service;

import com.crane.system.dto.AddEquipmentDTO;
import com.crane.system.dto.EquipmentDTO;
import com.crane.system.entity.CraneEquipment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author :zlq
 * @date : 2024/3/26
 */

public interface CraneEquipmentService extends IService<CraneEquipment> {


    void insert(AddEquipmentDTO dto);

    List<EquipmentDTO> listAllEquipment();
}
