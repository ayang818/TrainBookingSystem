package com.ayang818.trainbooking.dto;

import lombok.Data;

/**
 * @ClassName SearchDto
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/8 20:34
 **/
@Data
public class SearchDto {
    private Integer startStation;
    private Integer endStation;
    private String startTime;
}
