package com.crane.system.service.impl;

import com.crane.system.entity.CraneData;
import com.crane.system.service.CraneDataService;
import com.crane.system.service.CraneInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author :zlq
 * @date : 2024/3/30
 */
@SpringBootTest
class CraneInfoServiceImplTest {

    @Autowired
    CraneInfoService craneInfoService;
    @Autowired
    CraneDataService craneDataService;
    @Test
    public void test() {
        for (int i = 0; i < 1000; i++) {
            Date now = new Date();
            CraneData craneData = new CraneData();
            craneData.setId((long) 2);
            craneData.setTemporary(String.valueOf(i));
            craneData.setWeight(i);
            craneData.setWinSpeed(i);
            craneData.setDistance(i);
            craneData.setAngle(i);
            craneData.setGmtCreate(now);
            craneData.setGmtModify(now);
            craneDataService.save(craneData);
        }
    }

}
