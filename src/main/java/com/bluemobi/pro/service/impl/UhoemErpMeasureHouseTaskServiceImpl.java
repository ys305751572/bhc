package com.bluemobi.pro.service.impl;

import com.bluemobi.sys.page.Page;
import com.bluemobi.sys.service.BaseService;
import com.bluemobi.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UhoemErpMeasureHouseTaskServiceImpl extends BaseService {
    public static String PREFIX = UhoemErpMeasureHouseTaskServiceImpl.class.getName();

    @Autowired
    private UhoemErpCoordinateServiceImpl uhoemErpCoordinateServiceImpl;

    @Autowired
    private UhoemErpMeasureHouseOrderServiceImpl uhoemErpMeasureHouseOrderServiceImpl;

    // 根据用户查询
    public Map<String, Object> findMyTask(Map<String, Object> params,String member) throws Exception {
        Map<String,Object> result = new HashMap<String,Object>();
        Map<String, Object> mytask = this.getBaseDao().get(PREFIX + ".findMyTask", params);

        // 一定会有一条
        List<Map<String,Object>> taskList = new ArrayList<>();
        {
            Map<String,Object> order = new HashMap<>();
            order.put("member",member);
            order = uhoemErpMeasureHouseOrderServiceImpl.findByMember(order);
            Map<String,Object> task = new HashMap<String,Object>();
            String msg = "您已预约成功，系统正在分配。";
            String friendlyDate = "";
            if(order!=null){
                friendlyDate = DateUtils.stringToFriendlyDate((String) order.get("create_date"));
                task.put("date", friendlyDate);
            }
            task.put("level",0);
            task.put("taskindex",0);
            task.put("msg",msg);
            task.put("date",friendlyDate);
            taskList.add(task);
        }

        // 还没有流程信息
        if(mytask == null || mytask.size() == 0){
            result.put("list",taskList);
            return result;
        }

        Integer status = Integer.parseInt((String) mytask.get("consultant_state"));
        String mobile = (String) mytask.get("Mobile");
        String realName = (String) mytask.get("RealName");
        String headImage = (String) mytask.get("UserAvatar");

        // 1已接单　2已电话确认　3已开始接车　4客户已上车　5量房结束
        if(status >= 1){
            Map<String,Object> task = new HashMap<String,Object>();
            String msg = "美家顾问"+realName+"联系方式："+mobile+" 正在为您服务这条信息";
            String friendlyDate = DateUtils.stringToFriendlyDate((String) mytask.get("consultant_confirm_date"));
            task.put("level",1);
            task.put("taskindex",1);
            task.put("realName",realName);
            task.put("headImage",headImage);
            task.put("msg",msg);
            task.put("date",friendlyDate);
            taskList.add(task);
        }
        if(status >= 2){
            Map<String,Object> task = new HashMap<String,Object>();
            String msg = "美家顾问"+realName+"已与您电话确认专车服务 ";
            String friendlyDate = DateUtils.stringToFriendlyDate((String) mytask.get("tel_confirm_date"));
            task.put("level",2);
            task.put("taskindex",2);
            task.put("realName",realName);
            task.put("headImage",headImage);
            task.put("msg",msg);
            task.put("date",friendlyDate);
            taskList.add(task);
        }
        if(status >= 3){
            // start_receive_taxi_coordinate!=0表示有接车
            String start_receive_taxi_coordinate = (String)mytask.get("start_receive_taxi_coordinate");
            Map<String,Object> task = new HashMap<String,Object>();
            if(StringUtils.isNotEmpty(start_receive_taxi_coordinate) && !"0".equals(start_receive_taxi_coordinate)){
                String msg = "美家顾问"+realName+"给您留言：我已经启程";
                Map<String,Object> coordinate = new HashMap<String,Object>();
                coordinate.put("id",start_receive_taxi_coordinate);
                coordinate = uhoemErpCoordinateServiceImpl.findOneById(coordinate);
                String friendlyDate = "";
                if(coordinate != null){
                    friendlyDate = DateUtils.stringToFriendlyDate((String) coordinate.get("now_date"));
                }
                task.put("level",3);
                task.put("taskindex",3);
                task.put("realName",realName);
                task.put("headImage",headImage);
                task.put("msg",msg);
                task.put("date",friendlyDate);
                taskList.add(task);
            }

        }
        if(status >= 4){
            // member_geton_taxi_coordinate!=0表示有接车
            String member_geton_taxi_coordinate = (String)mytask.get("member_geton_taxi_coordinate");
            Map<String,Object> task = new HashMap<String,Object>();
            if(StringUtils.isNotEmpty(member_geton_taxi_coordinate) && !"0".equals(member_geton_taxi_coordinate)){
                String msg = "已开始接车";
                Map<String,Object> coordinate = new HashMap<String,Object>();
                coordinate.put("id",member_geton_taxi_coordinate);
                coordinate = uhoemErpCoordinateServiceImpl.findOneById(coordinate);
                String friendlyDate = "";
                if(coordinate != null){
                    friendlyDate = DateUtils.stringToFriendlyDate((String) coordinate.get("now_date"));
                }
                task.put("level",4);
                task.put("taskindex",4);
                task.put("realName",realName);
                task.put("headImage",headImage);
                task.put("msg",msg);
                task.put("date",friendlyDate);
                taskList.add(task);
            }

        }
        if(status >= 5){
            Map<String,Object> task = new HashMap<String,Object>();
            String msg = "量房结束";
            String friendlyDate = DateUtils.stringToFriendlyDate((String) mytask.get("consultant_receipt_date"));
            task.put("level",5);
            task.put("taskindex",5);
            task.put("realName",realName);
            task.put("headImage",headImage);
            task.put("msg",msg);
            task.put("date",friendlyDate);
            taskList.add(task);
        }
        Collections.reverse(taskList);
        result.put("list",taskList);
        return result;
    }


}