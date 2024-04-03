package com.crane.system.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :zlq
 * @date : 2024/3/24
 */
@Data
public class QueryCraneInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 塔吊名称
     */
    private String craneName;

    private Integer pageNum=1;

    private Integer pageSize=20;


}
