package com.bonc.oa.utils;

import com.bonc.oa.wanda.bean.CustomerInfo;
import com.bonc.oa.wanda.bean.dto.CustomerInfoDto;

import java.util.Date;

public class DtoUtil {
    public static CustomerInfo getCustomerInfo(CustomerInfoDto customerInfoDto){
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setType(customerInfoDto.getType());
        customerInfo.setId(customerInfoDto.getId());
        customerInfo.setIdeaId(Integer.parseInt(customerInfoDto.getIdea()));
        customerInfo.setSourceId(Integer.parseInt(customerInfoDto.getSource()));
        customerInfo.setTitleId(Integer.parseInt(customerInfoDto.getBookType()));
        customerInfo.setProfessionId(Integer.parseInt(customerInfoDto.getBookPro()));
        customerInfo.setRegister(customerInfoDto.getRegister());
        customerInfo.setAddress(customerInfoDto.getProvinces());
        customerInfo.setCustomerName(customerInfoDto.getContact());
        customerInfo.setUserId(customerInfoDto.getUserId());
        String phone = customerInfoDto.getPhone();
        if(!customerInfoDto.getPhone1().equals("")){
            phone += "," + customerInfoDto.getPhone1();
        }
        if(!customerInfoDto.getPhone2().equals("")){
            phone += "," + customerInfoDto.getPhone2();
        }
        customerInfo.setCustomerPhone(phone);
        customerInfo.setCompanyName(customerInfoDto.getCompanyName());
        customerInfo.setCustomerCal(customerInfoDto.getCall());
        customerInfo.setCustomerQq(customerInfoDto.getQq());
        customerInfo.setCustomerEmail(customerInfoDto.getEmail());
        Date date = new Date();
        customerInfo.setUpdateDate(date);
        return customerInfo;
    }

    public static void insertCache() {
        if(CacheUtil.getCache().containsKey("title_")){

        }
    }
}
