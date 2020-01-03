package com.bonc.oa.wanda.service;

import com.bonc.oa.wanda.bean.*;
import com.bonc.oa.wanda.bean.dto.CustomerInfoDto;
import com.bonc.oa.wanda.bean.dto.ProfessionDto;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<CustomerTitle> getAllTitle();
    List<CustomerSource> getAllSource();
    List<CustomerIdea> getAllIdea();
    List<Profession> getAllProfession();
    List<Profession> getProfessionByTitleId(Integer titleId);
    List<Safe> getSafe();

    Map<String, Object> addCustomer(CustomerInfoDto customerInfoDto);

    Map<String, Object> getAllCustomerInfo(int pageNumber, int pageSize, Integer type, Integer titleId, Integer professionId, String provinces, String register, Integer manager, Integer ideaId, Integer sourceId, String updateDate, String phone, String call, Integer userId);

    int getPageSize();

    Map<String,Object> getAllUserInfo(int pageNumber, int pageSize, String name);

    int editDetail(CustomerInfo customerInfo);

    int editTitleAndProfessionById(Integer id, Integer oldProId, Integer titleId, Integer professionId);

    int editPhoneInfo(CustomerInfoDto customerInfo);

    int editCompanyInfo(CustomerInfoDto customerInfoDto);

    int editCustomerAddress(Integer id, String address);

    int editCustomerIdea(Integer id, Integer ideaId);

    int editCustomerSource(Integer id, Integer sourceId);

    int editRegister(Integer id, String register);

    int addRecord(Integer id, String record);

    int editRecord(Integer id, String record, Integer customerId);

    int changeUserToCustomer(Integer id, Integer userId);

    List<CustomerInfo> getCustomerInfo(Integer userId);

    List<ProfessionDto> setProfession();

    int addTitle(String title);

    int addIdea(String idea);

    int addSource(String source);

    int editIdea(Integer id, String idea);

    int editSource(Integer id, String source);

    int addProfession(Integer id, String profession);

    int editProfession(Integer id, String profession);

    int deleteCustomerInfo(List<CustomerInfoDto> customerInfoDto);
}
