package com.crane.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.crane.system.dto.AddCraneInfoDTO;
import com.crane.system.dto.CraneInfoDTO;
import com.crane.system.dto.QueryCraneInfoDTO;
import com.crane.system.entity.CraneInfo;
import com.crane.system.mapper.CraneInfoMapper;
import com.crane.system.service.CraneInfoService;
import com.crane.system.utils.AppResponse;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* (crane.crane_info)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/crane/info")
public class CraneInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private CraneInfoService craneInfoService;

    @Autowired
    private CraneInfoMapper craneInfoMapper;


    @PostMapping("listPage")
    public AppResponse<PageInfo<CraneInfoDTO>> listPage(@RequestBody QueryCraneInfoDTO dto) {
        PageInfo<CraneInfoDTO> craneInfoPageInfo = craneInfoService.listPage(dto);
        if (CollectionUtils.isEmpty(craneInfoPageInfo.getList())) {
            return AppResponse.fail(null);
        }
        return AppResponse.ok(craneInfoPageInfo);
    }
    @PostMapping("/insert")
    public AppResponse<Boolean> insert(@RequestBody AddCraneInfoDTO dto) {
        if (dto == null) {
            return AppResponse.fail(false);
        }
        CraneInfo craneInfo = new CraneInfo();
        BeanUtils.copyProperties(dto, craneInfo);
        craneInfoService.insertCrane(craneInfo);
        return AppResponse.ok(true);
    }

    @PostMapping("/update")
    public AppResponse update(@RequestBody AddCraneInfoDTO dto) throws Exception {
        if (dto == null) {
            return AppResponse.ok(null);
        }
        CraneInfo craneInfo = new CraneInfo();
        BeanUtils.copyProperties(dto, craneInfo);
        LambdaQueryWrapper<CraneInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CraneInfo::getEquipmentId, dto.getEquipmentId());
        queryWrapper.ne(CraneInfo::getId, dto.getId());
        CraneInfo info = craneInfoMapper.selectOne(queryWrapper);
        if (info != null) {
            return new AppResponse(500, "关联设备信息重复!");

        }
        craneInfoMapper.updateById(craneInfo);
        return AppResponse.ok(Boolean.TRUE);
    }
    @GetMapping("/deleteById")
    public Boolean deleteById(@RequestParam("id") Long id) {
        return craneInfoMapper.deleteById(id) > 0;
    }

}
