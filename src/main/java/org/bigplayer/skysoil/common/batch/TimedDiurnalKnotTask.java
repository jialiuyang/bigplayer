package org.bigplayer.skysoil.common.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 每天的定时任务
 */
@RestController
@Component
@Slf4j
public class TimedDiurnalKnotTask {

    /**
     * 每天01:02
     */
    @Scheduled(cron = "0 02 01 * * ?")
    @Transactional
    public void autliftingmmount() {

    }

    public static void main(String[] args){
        List<String> dogs = new ArrayList<>();
        dogs.add("s");
        dogs.add("mm");
        String[] arr = new String[]{"s1","s2","s3"};



        System.out.print( Arrays.asList(dogs)+"..."+Arrays.asList(arr));

    }
}
