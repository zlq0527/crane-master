package com.crane.system.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :zlq
 * @date : 2024/3/24
 */

@Data
public class QueryCraneData implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pageNum = 1;

    private Integer pageSize = 20;

    private Integer deviceId;
}
