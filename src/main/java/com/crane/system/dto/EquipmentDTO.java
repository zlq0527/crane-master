package com.crane.system.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :zlq
 * @date : 2024/3/29
 */
@Data
public class EquipmentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String deviceName;

}
