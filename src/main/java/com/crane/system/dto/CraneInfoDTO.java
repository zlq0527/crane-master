package com.crane.system.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author :zlq
 * @date : 2024/3/29
 */
@Data
public class CraneInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 塔吊名称
     */
    private String craneName;

    /**
     * 位置信息
     */
    private String locationName;

    /**
     * 硬件id
     */
    private Long equipmentId;

    private String company;

    private String principalName;

    private String principalPhone;

    private String deviceName;

    private String imgUid;
}
