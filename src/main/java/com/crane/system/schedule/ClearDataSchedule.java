package com.crane.system.schedule;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crane.system.entity.CraneData;
import com.crane.system.mapper.CraneDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author :zlq
 * @date : 2024/3/30
 */
@EnableScheduling
@Component
public class ClearDataSchedule {
    @Autowired
    private CraneDataMapper craneDataMapper;

    /**
     * 定时任务定期清除数据,可以设置时间间隔
     * 如一天清理一次/12小时清理一次
     * 每次清理12小时前的数据/6小时前的数据
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void clearCraneData() {
        LocalDateTime sixHoursAgo = LocalDateTime.now().minusHours(6);
        Date sixHoursAgoDate = java.sql.Timestamp.valueOf(sixHoursAgo);
        QueryWrapper<CraneData> wrapper = new QueryWrapper<>();
        wrapper.le("gmt_create", sixHoursAgoDate);
        List<CraneData> craneData = craneDataMapper.selectList(wrapper);
//        craneDataMapper.delete(wrapper);
    }

}
