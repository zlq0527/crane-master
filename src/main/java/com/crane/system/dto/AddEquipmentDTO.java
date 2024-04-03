package com.crane.system.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :zlq
 * @date : 2024/3/24
 */
@Data
public class AddEquipmentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer craneDataId;

    private String deviceName;

    private String deviceType;

    private String sensor;

}
