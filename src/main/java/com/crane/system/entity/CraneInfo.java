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
 * @date : 2024/3/24
 */

@Data
@TableName(value = "crane.crane_info")
public class CraneInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 塔吊名称
     */
    @TableField(value = "crane_name")
    private String craneName;

    /**
     * 位置信息
     */
    @TableField(value = "location_name")
    private String locationName;

    /**
     * 硬件id
     */
    @TableField(value = "equipment_id")
    private Long equipmentId;

    @TableField(value = "img_uid")
    private String imgUid;

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
