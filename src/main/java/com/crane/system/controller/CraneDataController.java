package com.crane.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crane.system.dto.QueryCraneData;
import com.crane.system.entity.CraneData;
import com.crane.system.entity.CraneEquipment;
import com.crane.system.entity.CraneInfo;
import com.crane.system.service.CraneDataService;
import com.crane.system.service.CraneEquipmentService;
import com.crane.system.service.CraneInfoService;
import com.crane.system.utils.AppResponse;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (crane.crane_data)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/crane/data")
public class CraneDataController {

    @Autowired
    private CraneDataService craneDataService;
    @Autowired
    private CraneInfoService craneInfoService;
    @Autowired
    private CraneEquipmentService craneEquipmentService;


    @PostMapping("/listPage")
    public AppResponse<PageInfo<CraneData>> listPage(@RequestBody QueryCraneData dto) {
        PageInfo<CraneData> page =  craneDataService.listPage(dto);
        return AppResponse.ok(page);
    }

    @GetMapping("/getById")
    public AppResponse<CraneData> getById(@RequestParam("id") Long id) {
        CraneInfo craneInfo = craneInfoService.getById(id);
        if (craneInfo == null) {
            return AppResponse.ok(null);
        }
        Long equipmentId = craneInfo.getEquipmentId();
        CraneEquipment equipment = craneEquipmentService.getById(equipmentId);
        Integer dataId = equipment.getCraneDataId();
        QueryWrapper<CraneData> wrapper = new QueryWrapper<>();
        wrapper.eq("id", dataId);
        wrapper.orderByDesc("gmt_create");
        List<CraneData> list = craneDataService.list(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            return AppResponse.ok(null);
        }
        return AppResponse.ok(list.get(0));
    }


}
