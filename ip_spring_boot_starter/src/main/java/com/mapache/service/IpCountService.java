package com.mapache.service;

import com.mapache.properties.IpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class IpCountService {

    private Map<String, Integer> ipCountMap = new HashMap<>();

    /**
     * 当前的request对象的注入工作由使用当前starter的工程提供自动装配
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    public void count() {
        //每次调用当前操作，就记录当前访问的ip,然后累加访问的次数
        //1. 获取当前操作的ip地址
        String ip = httpServletRequest.getRemoteAddr();

        System.out.println("------------------------------" + ip);

        //2. 根据ip地址从map中取值，并递增
        Integer count = ipCountMap.get(ip);
        if (count == null) {
            ipCountMap.put(ip, 1);
        } else {
            ipCountMap.put(ip, count + 1);
        }
    }

    /*@Scheduled(cron = "0/5 * * * * ?")//每5秒
    public void print() {
        System.out.println("        IP访问监控");
        System.out.println("+-----ip-address-----+--num--+");
        for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("|%18s  |%5d  |", key, value);
        }
        System.out.println("+--------------------+-------+");
    }*/

    @Autowired
    private IpProperties ipProperties;

//    @Scheduled(cron = "0/5 * * * * ?")
//    @Scheduled(cron = "0/${tools.ip.cycle:5} * * * * ?")
//    @Scheduled(cron = "0/#{tools.ip-com.mapache.properties.IpProperties.cycle} * * * * ?") // EL1008E: Property or field 'tools' cannot be found on object of type 'org.springframework.beans.factory.config.BeanExpressionContext' - maybe not public or not valid?
    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    public void print() {

        if(ipProperties.getModel().equals(IpProperties.LogModel.DETAIL.getValue())) {
            System.out.println("        IP访问监控");
            System.out.println("+-----ip-address-----+--num--+");
            for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.printf("|%18s  |%5d  |\n", key, value);
            }
            System.out.println("+--------------------+-------+");
        } else if (ipProperties.getModel().equals(IpProperties.LogModel.SIMPLE.getValue())) {
            System.out.println("     IP访问监控");
            System.out.println("+-----ip-address-----+");
            for (String key : ipCountMap.keySet()) {
                System.out.printf("|%18s  |\n", key);
            }
            System.out.println("+--------------------+");
        }

       if (ipProperties.getCycleReset()) {
           ipCountMap.clear();
       }
    }
}
