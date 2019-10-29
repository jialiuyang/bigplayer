package org.bigplayer.skysoil.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bigplayer.skysoil.common.dto.DoubleVo;
import org.bigplayer.skysoil.common.dto.ThreeVo;
import org.bigplayer.skysoil.mapper.SkySoilMapper;
import org.bigplayer.skysoil.service.SkySoilService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SkySoilServiceImpl  implements SkySoilService {

    @Autowired
    private SkySoilMapper skySoilMapper;


    @Override
    public void getDoubleData() {
        List<DoubleVo> doubleVos=new ArrayList<>();
        Document document = null;
        int cont=0;
        try {
            document = Jsoup.connect("https://chart.cp.360.cn/kaijiang/ssq?spanType=2&span=2003-01-11_2019-10-27").get();
//            log.info("获取结果"+document);
            Element element =  document.getElementById("data-tab");
            Elements trs= element.getElementsByTag("tr");
            log.info(String.valueOf(trs.size()));
            for(Element r:trs){
                Elements tds= r.getElementsByTag("td");
                DoubleVo doubleVo= new DoubleVo();
                if(tds.size()>0){
                    log.info("时间："+tds.get(1).text().substring(0,10));
                }
                doubleVo.setDoubleday(tds.get(1).text().substring(0,10));
                Elements red= r.getElementsByClass("ball_5");
                for(Element e:red){
                    switch (red.indexOf(e)){
                        case 0:
                            doubleVo.setRed01(Integer.parseInt(e.text()));
                            break;
                        case 1:
                            doubleVo.setRed02(Integer.parseInt(e.text()));
                            break;
                        case 2:
                            doubleVo.setRed03(Integer.parseInt(e.text()));
                            break;
                        case 3:
                            doubleVo.setRed04(Integer.parseInt(e.text()));
                            break;
                        case 4:
                            doubleVo.setRed05(Integer.parseInt(e.text()));
                            break;
                        case 5:
                            doubleVo.setRed06(Integer.parseInt(e.text()));
                            break;
                    }
                }
                Elements blue= r.getElementsByClass("ball_1");
                for(Element b:blue){
                    doubleVo.setBlue(Integer.parseInt(b.text()));
                }
                cont++;
                log.info("第："+cont);
                doubleVos.add(doubleVo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("保存："+cont);
        int c= skySoilMapper.insertBlackBatch(doubleVos);
        log.info("保存end："+c);
    }


    @Override
    public void getThreeData() {
        List<ThreeVo>  threeVos=new ArrayList<>();
        Document document = null;
        int cont=0;
        try {
            document = Jsoup.connect("https://chart.cp.360.cn/kaijiang/sd/?spanType=2&span=2001-01-01_2019-04-16").get();
            Element element =  document.getElementById("data-tab");
            Elements trs= element.getElementsByTag("tr");
            log.info(String.valueOf(trs.size()));
            for(Element r:trs){
                Elements tds= r.getElementsByTag("td");
                ThreeVo  threeVo= new ThreeVo();
                if(tds.size()>0){
                    log.info("时间："+tds.get(1).text().substring(0,10));
                }
                threeVo.setDoubleday(tds.get(1).text().substring(0,10));
                Elements red= r.getElementsByClass("ball_5");
                for(Element e:red){
                    switch (red.indexOf(e)){
                        case 0:
                            threeVo.setDatanoe(Integer.parseInt(e.text()));
                            break;
                        case 1:
                            threeVo.setDatatwo(Integer.parseInt(e.text()));
                            break;
                        case 2:
                            threeVo.setDatathree(Integer.parseInt(e.text()));
                            break;
                    }
                }
                cont++;
                log.info("第："+cont);
                threeVos.add(threeVo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("保存："+cont);
        int c= skySoilMapper.insertThreeBlackBatch(threeVos);
        log.info("保存end："+c);
    }

    @Override
    public void getDryData() {
        List<DoubleVo> doubleVos=new ArrayList<>();
        Document document = null;
        int cont=0;
        List<DoubleVo> vos= skySoilMapper.selectSome();
        for (DoubleVo doubleVo :vos) {
            String doubleday=doubleVo.getDoubleday();
            String s=doubleday.replace("-0","-");
            try {
                String url="http://www.laohuangli.net/"+doubleday.substring(0,4)+"/"+s+  ".html";
                System.out.println(url);
                document = Jsoup.connect(url).get();
//                log.info("获取结果"+document);
                Elements trs =  document.getElementsByTag("table");
                Element element=trs.get(6);
                Elements fonts=  element.getElementsByTag("font");
                String mn=element.getElementsByTag("div").get(1).text();
                String five= mn.substring(mn.length()-1,mn.length());
                String day=fonts.get(2).text();
                String dry= day.substring(0,1);
                String branch=day.substring(1,2);
                System.out.println("five"+five+"dry"+dry+"branch"+branch);
                doubleVo.setFive(five);
                doubleVo.setDry(dry);
                doubleVo.setBranch(branch);
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("保存："+cont);
            Integer i= skySoilMapper.updateById(doubleVo);
            cont=cont+i;
        }
        log.info("更新end："+cont);
    }
}


