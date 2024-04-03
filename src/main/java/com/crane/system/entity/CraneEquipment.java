package com.crane.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :zlq
 * @date : 2024/3/26
 */

@Data
@TableName(value = "crane.crane_equipment")
public class CraneEquipment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 关联数据
     */
    @TableField(value = "crane_data_id")
    private Integer craneDataId;

    /**
     * 设备名称
     */
    @TableField(value = "device_name")
    private String deviceName;

    /**
     * 设备型号
     */
    @TableField(value = "device_type")
    private String deviceType;

    /**
     * 传感器列表
     */
    @TableField(value = "sensor")
    private String sensor;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modify",fill = FieldFill.INSERT_UPDATE)
    private Date gmtModify;

}
