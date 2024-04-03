package com.crane.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crane.system.dto.AddEquipmentDTO;
import com.crane.system.dto.EquipmentDTO;
import com.crane.system.entity.CraneEquipment;
import com.crane.system.mapper.CraneEquipmentMapper;
import com.crane.system.service.CraneEquipmentService;
import com.crane.system.utils.AppResponse;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (crane.crane_equipment)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/crane/equipment")
public class CraneEquipmentController {
    /**
     * 服务对象
     */
    @Autowired
    private CraneEquipmentMapper craneEquipmentMapper;
    @Autowired
    private CraneEquipmentService equipmentService;

    @GetMapping("/listPage")
    public AppResponse<Page<CraneEquipment>> listPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        Page<CraneEquipment> page = new Page<>(pageNum, pageSize);
        Page<CraneEquipment> res = equipmentService.page(page);
        if (CollectionUtils.isEmpty(res.getRecords())) {
            return AppResponse.ok(null);
        }
        res.setTotal(res.getRecords().size());
        return AppResponse.ok(res);
    }

    @GetMapping("deleteById")
    public AppResponse<Boolean> deleteById(@RequestParam("id") Long id) {
        equipmentService.removeById(id);
        return AppResponse.ok(Boolean.TRUE);
    }

    @PostMapping("insert")
    public AppResponse<Boolean> insert(@RequestBody AddEquipmentDTO dto) {
        CraneEquipment equipment = new CraneEquipment();
        BeanUtils.copyProperties(dto, equipment);
        equipmentService.insert(dto);
        return AppResponse.ok(Boolean.TRUE);
    }

    @PostMapping("update")
    public AppResponse<Boolean> update(@RequestBody AddEquipmentDTO dto) {
        CraneEquipment equipment = new CraneEquipment();
        BeanUtils.copyProperties(dto,equipment);
        QueryWrapper<CraneEquipment> wrapper = new QueryWrapper<>();
        wrapper.eq("crane_data_id", dto.getCraneDataId());
        CraneEquipment craneEquipment = equipmentService.getOne(wrapper);
        if (craneEquipment != null) {
            return new AppResponse<>(500, "关联数据重复");
        }
        equipmentService.updateById(equipment);
        return AppResponse.ok(Boolean.TRUE);
    }
    @GetMapping("/listAllEquipment")
    public AppResponse<List<EquipmentDTO>> listAllEquipment() {
        List<EquipmentDTO> list = equipmentService.listAllEquipment();
        return AppResponse.ok(list);
    }
}
