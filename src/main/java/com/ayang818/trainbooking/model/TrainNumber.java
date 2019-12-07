package com.ayang818.trainbooking.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrainNumber {
    private Integer id;
    /**
     * 路线id
     */
    private Integer routeId;
    /**
     * 火车编号
     */
    private String trainId;
    /**
     * 出发时间
     */
    private LocalDateTime startTime;
    /**
     * 中止时间
     */
    private LocalDateTime endTime;
    /**
     * 车票总数
     */
    private Integer ticketNumber;

    /**
     * 路线具体 (数据库无关)
     */
    private String routeDetail;
}
