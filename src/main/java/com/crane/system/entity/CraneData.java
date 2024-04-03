package com.crane.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :zlq
 * @date : 2024/3/24
 */

@Data
@TableName(value = "crane.crane_data")
public class CraneData implements Serializable {
    /**
     * 数据id
     */
    @TableField(value = "id")
    private Long id;

    /**
     * 塔吊温度
     */
    @TableField(value = "`temporary`")
    private String temporary;

    /**
     * 塔吊重量
     */
    @TableField(value = "weight")
    private Integer weight;

    /**
     * 风速
     */
    @TableField(value = "win_speed")
    private Integer winSpeed;

    /**
     * 距离
     */
    @TableField(value = "distance")
    private Integer distance;

    /**
     * 角度
     */
    @TableField(value = "angle")
    private Integer angle;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modify")
    private Date gmtModify;

    private static final long serialVersionUID = 1L;
}
