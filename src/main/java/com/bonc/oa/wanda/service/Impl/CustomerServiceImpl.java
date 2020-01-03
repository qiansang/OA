package com.bonc.oa.wanda.service.Impl;

import com.bonc.oa.login.bean.UserExample;
import com.bonc.oa.login.dao.UserMapper;
import com.bonc.oa.utils.CacheUtil;
import com.bonc.oa.utils.DtoUtil;
import com.bonc.oa.utils.SortUtil;
import com.bonc.oa.wanda.bean.*;
import com.bonc.oa.wanda.bean.dto.CustomerInfoDto;
import com.bonc.oa.wanda.bean.dto.ProfessionDto;
import com.bonc.oa.wanda.dao.*;
import com.bonc.oa.wanda.service.CustomerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final static Logger logger = LoggerFactory.getLogger("oa");
    @Autowired
    private CustomerTitleMapper customerTitleMapper;
    @Autowired
    private CustomerIdeaMapper customerIdeaMapper;
    @Autowired
    private CustomerSourceMapper customerSourceMapper;
    @Autowired
    private ProfessionMapper professionMapper;
    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private SafeMapper safeMapper;


    @Override
    public List<CustomerTitle> getAllTitle() {
        return customerTitleMapper.selectAll();
    }

    @Override
    public List<CustomerSource> getAllSource() {
        return customerSourceMapper.selectAll();
    }

    @Override
    public List<CustomerIdea> getAllIdea() {
        return customerIdeaMapper.selectAll();
    }

    @Override
    public List<Profession> getProfessionByTitleId(Integer titleId) {
        return professionMapper.selectByTitleId(titleId);
    }

    @Override
    public List<Safe> getSafe() {
        return safeMapper.selectAll();
    }

    @Override
    public List<Profession> getAllProfession() {
        return professionMapper.selectAll();
    }

    @Override
    public Map<String, Object> addCustomer(CustomerInfoDto customerInfoDto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer id = (Integer) CacheUtil.getCache().get("id");
            if(id != null){
                id = id + 1;
                CacheUtil.getCache().put("id", id);
            }else{
                id = customerInfoMapper.selectMaxId();
                if (id == null){
                    id=0;
                }
                CacheUtil.getCache().put("id", id + 1);
                id = id + 1;
            }
            customerInfoDto.setId(id);
            customerInfoMapper.insert(DtoUtil.getCustomerInfo(customerInfoDto));
            Record record = new Record();
            record.setContent(customerInfoDto.getDetail());
            record.setCustomerId(customerInfoDto.getId());
            Date date = new Date();
            record.setDate(date);
            recordMapper.insert(record);
            String bookPro = customerInfoDto.getBookPro();
            professionMapper.addNumById(Integer.parseInt(bookPro));
            map.put("result", true);
        }catch(Exception e){
            map.put("result", false);
            map.put("msg", e.getMessage());
            logger.error("[CustomerServiceImpl] addCustomer error:" + e.getMessage());
        }
        return map;
    }

    @Override
    public Map<String, Object> getAllCustomerInfo(int pageNumber, int pageSize, Integer type, Integer titleId, Integer professionId, String provinces, String register, Integer manager, Integer ideaId, Integer sourceId, String updateDate, String phone, String call, Integer userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd");
        CustomerInfoExample example = new CustomerInfoExample();
        CustomerInfoExample.Criteria criteria = example.createCriteria();
        if(type != null && type > 0){
            criteria.andTypeEqualTo(type);
        }
        if (titleId != null && titleId > 0){
            criteria.andTitleIdEqualTo(titleId);
        }
        if(professionId != null && professionId > 0){
            criteria.andProfessionIdEqualTo(professionId);
        }
        if(provinces != null && provinces.trim().length() > 0 && !provinces.equals("不限")){
            criteria.andAddressEqualTo(provinces);
        }
        if(register != null && register.trim().length() > 0 && !register.equals("不限")){
            criteria.andRegisterEqualTo(register);
        }
        if(manager != null && manager > 0){
            criteria.andUserIdEqualTo(manager);
        }
        if(ideaId != null && ideaId > 0){
            criteria.andIdeaIdEqualTo(ideaId);
        }
        if(sourceId != null && sourceId > 0){
            criteria.andSourceIdEqualTo(sourceId);
        }
        if(updateDate != null && updateDate.trim().length() > 0){
            String updateDate1 = updateDate.split("~")[0].trim();
            String updateDate2 = updateDate.split("~")[1].trim();
            try {
                criteria.andUpdateDateBetween(sdf0.parse(updateDate1), sdf0.parse(updateDate2));
            } catch (ParseException e) {
//                e.printStackTrace();
            }
        }
        if(phone != null && phone.trim().length() > 0){
            criteria.andCustomerPhoneLike("%" + phone + "%");
        }
        if(call != null && call.trim().length() > 0){
            criteria.andCustomerCalLike("%" + call + "%");
        }
        if(userId > 0){
            criteria.andUserIdEqualTo(userId);
        }
        example.setOrderByClause("update_date desc");
        PageHelper.startPage(pageNumber, pageSize);
        Page page = (Page)customerInfoMapper.selectByExample(example);
        map.put("count", page.getTotal());
        List<CustomerInfo> customerInfos = page.getResult();
        List<CustomerInfoDto> list = new ArrayList<CustomerInfoDto>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < customerInfos.size(); i++) {
            CustomerInfoDto customerInfoDto = new CustomerInfoDto();
            customerInfoDto.setId(customerInfos.get(i).getId());
            customerInfoDto.setType(customerInfos.get(i).getType());
            customerInfoDto.setDetail(customerInfos.get(i).getDetail());
            customerInfoDto.setUpdate(sdf.format(customerInfos.get(i).getUpdateDate()));
            customerInfoDto.setIdeaId(customerInfos.get(i).getIdeaId());
            customerInfoDto.setContact(customerInfos.get(i).getCustomerName());
            customerInfoDto.setProfessionId(customerInfos.get(i).getProfessionId());
            customerInfoDto.setTitleId(customerInfos.get(i).getTitleId());
            customerInfoDto.setRegister(customerInfos.get(i).getRegister());
            customerInfoDto.setProvinces(customerInfos.get(i).getAddress());
            customerInfoDto.setSourceId(customerInfos.get(i).getSourceId());
            customerInfoDto.setUserId(customerInfos.get(i).getUserId());
            customerInfoDto.setUser(userMapper.selectUsernameById(customerInfos.get(i).getUserId()));
            List<Record> records = recordMapper.selectByCustomerId(customerInfos.get(i).getId());
            customerInfoDto.setRemark(SortUtil.getSortRecords(records));
            if(customerInfos.get(i).getCustomerPhone().contains(",")){
                String []split = customerInfos.get(i).getCustomerPhone().split(",");
                for (int j = 0; j < split.length; j++) {
                    if(j==0){
                        customerInfoDto.setPhone(split[j]);
                    }
                    if (j==1){
                        customerInfoDto.setPhone1(split[j]);
                    }
                    if (j==2){
                        customerInfoDto.setPhone2(split[j]);
                    }
                }
            }else{
                customerInfoDto.setPhone(customerInfos.get(i).getCustomerPhone());
            }
            customerInfoDto.setCall(customerInfos.get(i).getCustomerCal());
            customerInfoDto.setQq(customerInfos.get(i).getCustomerQq());
            customerInfoDto.setEmail(customerInfos.get(i).getCustomerEmail());
            customerInfoDto.setCompanyName(customerInfos.get(i).getCompanyName());
            customerInfoDto.setCompanyLegal(customerInfos.get(i).getCompanyLegal());
            customerInfoDto.setCompanyMoney(customerInfos.get(i).getCompanyMoney());
            customerInfoDto.setCompanyAddress(customerInfos.get(i).getCompanyAddress());
            customerInfoDto.setCompanyRegistAddress(customerInfos.get(i).getCompanyRegistAddress());
            customerInfoDto.setCompanyDate(customerInfos.get(i).getCompanyDate());
            customerInfoDto.setCompanySignday(customerInfos.get(i).getCompanySignday());
            customerInfoDto.setSafeId(customerInfos.get(i).getSafeId());
            list.add(customerInfoDto);
        }
        map.put("rows", list);
        return map;
    }

    @Override
    public int getPageSize() {
        return customerInfoMapper.selectSum();
    }

    @Override
    public Map<String, Object> getAllUserInfo(int pageNumber, int pageSize, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(name != null && name.trim().length() > 0){
            criteria.andNameLike("%" + name + "%");
        }
        example.or(criteria);
        PageHelper.startPage(pageNumber, pageSize);
        Page page = (Page)userMapper.selectByExample(example);
        map.put("count", page.getTotal());
        map.put("rows", page.getResult());
        return map;
    }

    @Override
    public int editDetail(CustomerInfo customerInfo) {
        Date date = new Date();
        return customerInfoMapper.updateDetailById(customerInfo.getId(), customerInfo.getDetail(), date);
    }

    @Override
    public int editTitleAndProfessionById(Integer id, Integer oldProId, Integer titleId, Integer professionId) {
        Date date = new Date();
        professionMapper.cutNumById(oldProId);
        professionMapper.addNumById(professionId);
        return customerInfoMapper.updateProfessionById(id, titleId, professionId, date);
    }

    @Override
    public int editPhoneInfo(CustomerInfoDto customerInfoDto) {
        Date date = new Date();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(customerInfoDto.getId());
        customerInfo.setCustomerName(customerInfoDto.getContact().trim());
        String phone = customerInfoDto.getPhone();
        if(!customerInfoDto.getPhone1().trim().equals("")){
            phone += "," + customerInfoDto.getPhone1();
        }
        if(!customerInfoDto.getPhone2().trim().equals("")){
            phone += "," + customerInfoDto.getPhone2();
        }
        customerInfo.setCustomerPhone(phone);
        customerInfo.setCustomerCal(customerInfoDto.getCall());
        customerInfo.setCustomerQq(customerInfoDto.getQq());
        customerInfo.setCustomerEmail(customerInfoDto.getEmail());
        customerInfo.setUpdateDate(date);
        return customerInfoMapper.updatePhoneInfo(customerInfo);
    }

    @Override
    public int editCompanyInfo(CustomerInfoDto customerInfoDto) {
        Date date = new Date();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(customerInfoDto.getId());
        customerInfo.setCompanyName(customerInfoDto.getCompanyName());
        customerInfo.setCompanyMoney(customerInfoDto.getCompanyMoney());
        customerInfo.setCompanyAddress(customerInfoDto.getCompanyAddress());
        customerInfo.setCompanyRegistAddress(customerInfoDto.getCompanyRegistAddress());
        customerInfo.setSafeId(customerInfoDto.getSafeId());
        customerInfo.setCompanyDate(customerInfoDto.getCompanyDate());
        customerInfo.setCompanyLegal(customerInfoDto.getCompanyLegal());
        customerInfo.setCompanySignday(customerInfoDto.getCompanySignday());
        customerInfo.setUpdateDate(date);
        return customerInfoMapper.updateCompanyInfo(customerInfo);
    }

    @Override
    public int editCustomerAddress(Integer id, String address) {
        Date date = new Date();
        return customerInfoMapper.updateAddress(id, address, date);
    }

    @Override
    public int editCustomerIdea(Integer id, Integer ideaId) {
        Date date = new Date();
        return customerInfoMapper.updateCustomerIdea(id, ideaId, date);
    }

    @Override
    public int editCustomerSource(Integer id, Integer sourceId) {
        Date date = new Date();
        return customerInfoMapper.updateCustomerSource(id, sourceId, date);
    }

    @Override
    public int editRegister(Integer id, String register) {
        Date date = new Date();
        return customerInfoMapper.updateCustomerRegister(id, register, date);
    }

    @Override
    public int addRecord(Integer id, String record) {
        Date date = new Date();
        customerInfoMapper.updateUpdateDate(id, date);
        Record r = new Record();
        r.setContent(record);
        r.setCustomerId(id);
        r.setDate(date);
        return recordMapper.insert(r);
    }

    @Override
    public int editRecord(Integer id, String record, Integer customerId) {
        Date date = new Date();
        customerInfoMapper.updateUpdateDate(customerId, date);
        Record r = new Record();
        r.setContent(record);
        r.setId(id);
        return recordMapper.updateByPrimaryKey(r);
    }

    @Override
    public int changeUserToCustomer(Integer id, Integer userId) {
        Date date = new Date();
        return customerInfoMapper.changeUserToCustomer(id, userId, date);
    }

    @Override
    public List<CustomerInfo> getCustomerInfo(Integer userId) {
        return customerInfoMapper.selectAllByUserId(userId);
    }

    @Override
    public List<ProfessionDto> setProfession() {
        List<ProfessionDto> professionDtos = new ArrayList<>();
        List<CustomerTitle> customerTitles = customerTitleMapper.selectAll();
        List<Profession> professions = professionMapper.selectAll();
        for (int i = 0; i < customerTitles.size(); i++) {
            ProfessionDto professionDto = new ProfessionDto();
            List<Profession> list = new ArrayList<Profession>();
            professionDto.setId(customerTitles.get(i).getId());
            professionDto.setTitle(customerTitles.get(i).getName());
            for (int j = 0; j < professions.size(); j++) {
                if(professions.get(j).getTitleId() == customerTitles.get(i).getId()){
                    Profession profession = new Profession();
                    profession.setId(professions.get(j).getId());
                    profession.setName(professions.get(j).getName());
                    list.add(profession);
                }
            }
            professionDto.setProfessionList(list);
            professionDtos.add(professionDto);
        }
        return professionDtos;
    }

    @Override
    public int addTitle(String title) {
        CustomerTitle customerTitle = new CustomerTitle();
        customerTitle.setName(title);
        return customerTitleMapper.insert(customerTitle);
    }

    @Override
    public int addIdea(String idea) {
        CustomerIdea customerIdea = new CustomerIdea();
        customerIdea.setName(idea);
        return customerIdeaMapper.insert(customerIdea);
    }

    @Override
    public int addSource(String source) {
        CustomerSource customerSource = new CustomerSource();
        customerSource.setName(source);
        return customerSourceMapper.insert(customerSource);
    }

    @Override
    public int editIdea(Integer id, String idea) {
        if(idea != null && idea.trim().length() > 0){
            CustomerIdea customerIdea = new CustomerIdea();
            customerIdea.setId(id);
            customerIdea.setName(idea);
            return customerIdeaMapper.updateByPrimaryKey(customerIdea);
        }else{
            return customerIdeaMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int editSource(Integer id, String source) {
        if(source != null && source.trim().length() > 0){
            CustomerSource customerSource = new CustomerSource();
            customerSource.setId(id);
            customerSource.setName(source);
            return customerSourceMapper.updateByPrimaryKey(customerSource);
        }else{
            return customerSourceMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int addProfession(Integer id, String profession) {
        Profession pro = new Profession();
        pro.setTitleId(id);
        pro.setName(profession);
        pro.setNum(0);
        return  professionMapper.insert(pro);
    }

    @Override
    public int editProfession(Integer id, String profession) {
        if(profession != null && profession.trim().length() > 0){
            Profession pro = new Profession();
            pro.setName(profession);
            pro.setId(id);
            return  professionMapper.updateById(pro);
        }else{
            return  professionMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int deleteCustomerInfo(List<CustomerInfoDto> customerInfoDto) {
        for (int i = 0; i < customerInfoDto.size(); i++) {
            recordMapper.deleteByCustomerId(customerInfoDto.get(i).getId());
            professionMapper.cutNumByIdList(customerInfoDto.get(i).getProfessionId());
            customerInfoMapper.deleteByIdList(customerInfoDto.get(i).getId());
        }
        return 0;
    }
}
