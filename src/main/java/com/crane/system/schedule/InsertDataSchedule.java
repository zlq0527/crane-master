//package com.crane.system.schedule;
//
//import com.crane.system.entity.CraneData;
//import com.crane.system.mapper.CraneDataMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.Random;
//
///**
// * @author :zlq
// * @date : 2024/3/30
// */
//@EnableScheduling
//@Component
//public class InsertDataSchedule {
//    @Autowired
//    private CraneDataMapper craneDataMapper;
//
//    /**
//     * 模拟插入数据
//     */
//    @Scheduled(cron = "0/2 * * * * ?")
//    public void clearCraneData() {
//
//        Random random = new Random();
//        CraneData craneData = new CraneData();
//        craneData.setId((long) 2);
//        int tem = random.nextInt(30) + 20;
//        craneData.setTemporary(String.valueOf(tem));
//
//        int weight = random.nextInt(501) + 2300;
//        craneData.setWeight(weight);
//
//        int winSpeed = random.nextInt(15) + 5;
//        craneData.setWinSpeed(winSpeed);
//
//        int distance = random.nextInt(100) + 300;
//        craneData.setDistance(distance);
//        craneData.setAngle(12);
//
//        Date now = new Date();
//        craneData.setGmtCreate(now);
//        craneData.setGmtModify(now);
//        craneDataMapper.insert(craneData);
//    }
//
//}
