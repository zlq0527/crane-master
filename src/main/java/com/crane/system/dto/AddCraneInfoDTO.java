package com.crane.system.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @author :zlq
 * @date : 2024/3/24
 */
@Data
public class AddCraneInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long equipmentId;

    private String imgUid;

}
