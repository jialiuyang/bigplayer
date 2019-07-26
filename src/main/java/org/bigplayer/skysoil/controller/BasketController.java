package org.bigplayer.skysoil.controller;

import lombok.extern.slf4j.Slf4j;
import org.bigplayer.skysoil.common.dto.DoubleVo;
import org.bigplayer.skysoil.service.impl.SkySoilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangjingffei
 * @description 购物车controller
 */

@Slf4j
@RestController
@RefreshScope
@RequestMapping("/double")
@SuppressWarnings("all")
public class BasketController {
    @Autowired
    SkySoilServiceImpl skySoilService;

    @PostMapping("/getData")
    public void getData() {
        skySoilService.getDoubleData();
    }


    @PostMapping("/getThreeData")
    public void getThreeData() {
        skySoilService.getThreeData();
    }
}