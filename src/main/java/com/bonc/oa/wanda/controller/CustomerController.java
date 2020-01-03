package com.bonc.oa.wanda.controller;

import com.bonc.oa.login.bean.User;
import com.bonc.oa.login.service.UserService;
import com.bonc.oa.utils.ResultResponse;
import com.bonc.oa.wanda.bean.CustomerInfo;
import com.bonc.oa.wanda.bean.dto.CustomerInfoDto;
import com.bonc.oa.wanda.service.CustomerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    private final static Logger logger = LoggerFactory.getLogger("oa");

    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;

    @RequestMapping("/company")
    public String company(){
        return "home/company";
    }

    @RequestMapping("/person")
    public String person(){
        return "home/person";
    }

    @RequestMapping("/addbook")
    public String addbook(){
        return "home/addbook";
    }

    @RequestMapping("/toSetCustomer")
    public String toSetCustomer(){
        return "home/SetSelectTag";
    }

    @RequestMapping("/toUser")
    public String toUser(){
        return "home/user";
    }

    @RequestMapping("/toCustomer")
    public String toCustomer(){
        Subject subject = SecurityUtils.getSubject();
        User user = userService.findByUsername(subject.getPrincipals() + "");
        if(user.getRoleId() == 1){
            return "home/customer_admin";
        }
        return "home/customer";
    }

    @RequestMapping("/getTitle")
    @ResponseBody
    public ResultResponse getTitle(){
        try {
            return new ResultResponse(200, "", customerService.getAllTitle());
        }catch (Exception e){
            logger.error("[CustomerController] getTitle error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/getProfessionByTitleId")
    @ResponseBody
    public ResultResponse getProfessionByTitleId(Integer titleId){
        try {
            return new ResultResponse(200, "", customerService.getProfessionByTitleId(titleId));
        }catch (Exception e){
            logger.error("[CustomerController] getProfessionByTitleId error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/getAllProfession")
    @ResponseBody
    public ResultResponse getAllProfession(){
        try {
            return new ResultResponse(200, "", customerService.getAllProfession());
        }catch (Exception e){
            logger.error("[CustomerController] getAllProfession error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/getIdea")
    @ResponseBody
    public ResultResponse getIdea(){
        try {
            return new ResultResponse(200, "", customerService.getAllIdea());
        }catch (Exception e){
            logger.error("[CustomerController] getIdea error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }

    }

    @RequestMapping("/getSource")
    @ResponseBody
    public ResultResponse getSource(){
        try {
            return new ResultResponse(200, "", customerService.getAllSource());
        }catch (Exception e){
            logger.error("[CustomerController] getSource error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/getCustomerInfo")
    @ResponseBody
    public Map<String, Object> getCompanyInfo(int pageNumber, int pageSize, Integer type, Integer titleId, Integer professionId, String provinces, String register, Integer manager,
                                              Integer ideaId, Integer sourceId, String updateDate, String phone, String call){
        Subject subject = SecurityUtils.getSubject();
        User user = userService.findByUsername(subject.getPrincipals() + "");
        Integer userId = user.getId();
        if(user.getRoleId() == 1){
            userId = 0;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Map<String, Object> allCustomerInfo = customerService.getAllCustomerInfo(pageNumber, pageSize, type, titleId, professionId, provinces, register, manager, ideaId, sourceId, updateDate, phone, call, userId);
            map.put("rows", allCustomerInfo.get("rows"));
            map.put("count", allCustomerInfo.get("count"));
            map.put("code", 0);
        }catch (Exception e){
            logger.error("[CustomerController] getCompanyInfo error: " + e.getMessage());
            map.put("msg", e.getMessage());
            map.put("code", 1);
        }
        return map;
    }

    @RequestMapping("/deleteCustomerInfo")
    @ResponseBody
    public ResultResponse deleteCustomerInfo(@RequestBody List<CustomerInfoDto> customerInfoDto){
        Subject subject = SecurityUtils.getSubject();
        User user = userService.findByUsername(subject.getPrincipals() + "");
        try {
            customerService.deleteCustomerInfo(customerInfoDto);
            logger.info("[用户：" + user.getName() + "] 删除客户信息成功！" + customerInfoDto.toString());
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.error("[用户：" + user.getName() + "] 删除客户id失败！" + customerInfoDto.toString());
            logger.error("fail reason:", e);
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/addCustomer")
    @ResponseBody
    public ResultResponse addCustomer(@RequestBody CustomerInfoDto customerInfo){
        Subject subject = SecurityUtils.getSubject();
        User user = userService.findByUsername(subject.getPrincipals() + "");
        customerInfo.setUserId(user.getId());
        Map<String, Object> map = customerService.addCustomer(customerInfo);
        if((boolean)map.get("result")){
            logger.info("[用户：" + user.getName() + "] 添加客户信息：" + customerInfo.toString() + " 成功！");
            return new ResultResponse(200, "", null);
        }else{
            logger.info("[用户：" + user.getName() + "] 添加客户信息：" + customerInfo.toString() + " 失败！");
            return new ResultResponse(400, map.get("msg").toString(), null);
        }
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Map<String, Object> getUserInfo(int pageNumber, int pageSize, String name){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Map<String, Object> allCustomerInfo = customerService.getAllUserInfo(pageNumber, pageSize, name);
            map.put("rows", allCustomerInfo.get("rows"));
            map.put("count", allCustomerInfo.get("count"));
            map.put("code", 0);
        }catch (Exception e){
            logger.error("[CustomerController] getUserInfo error: " + e.getMessage());
            map.put("msg", e.getMessage());
            map.put("code", 1);
        }
        return map;
    }

    @RequestMapping("/getRole")
    @ResponseBody
    public ResultResponse getRole(){
        try {
            return new ResultResponse(200, "", userService.getRole());
        }catch (Exception e){
            logger.error("[CustomerController] getUser error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/getSafe")
    @ResponseBody
    public ResultResponse getSafe(){
        try {
            return new ResultResponse(200, "", customerService.getSafe());
        }catch (Exception e){
            logger.error("[CustomerController] getSafe error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public ResultResponse addUser(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            if(user1.getRoleId() != 1){
                return new ResultResponse(400, "您没有权限添加用户！", null);
            }
            if(userService.IsOrNotExist(user)){
                return new ResultResponse(400, "该用户名或姓名已被注册！", null);
            }
            user.setPassword("e10adc3949ba59abbe56e057f20f883e");
            user.setLogin(0);
            userService.addUser(user);
            logger.info("[管理员:" + user1.getName() + "] 添加用户：" + user.getName() +" 成功！");
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[管理员:" + user1.getName() + "] 添加用户：" + user.getName() +" 失败！");
            logger.error("[CustomerController] addUser error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/reSetPwd")
    @ResponseBody
    public ResultResponse reSetPwd(Integer id){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            if(!user1.getUsername().equals("admin")){
                return new ResultResponse(400, "您没有权限重置密码！", null);
            }
            userService.editPwd(id);
            logger.info("[管理员:" + user1.getName() + "] 重置用户密码成功！该用户编号为：" + id);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.error("[管理员:" + user1.getName() + "] 重置用户密码成功！该用户编号为：" + id);
            logger.error("[CustomerController] reSetPwd error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public ResultResponse deleteUser(Integer id){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(!user1.getUsername().equals("admin")){
            return new ResultResponse(400, "您没有删除用户的权限，请联系管理员！", null);
        }
        if(userService.findUserLockById(id).getUsername().equals("admin")){
            return new ResultResponse(400, "此用户无法删除！", null);
        }
        try {
            List<CustomerInfo>list = customerService.getCustomerInfo(id);
            if(list.size() > 0){
                return new ResultResponse(400, "请先将此用户下的客户信息分配给其他员工！", null);
            }
            userService.deleteUser(id);
            logger.info("[管理员:" + user1.getName() + "] 删除用户成功！该用户编号为：" + id);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[管理员:" + user1.getName() + "] 删除用户失败！该用户编号为：" + id);
            logger.error("[CustomerController] deleteUser error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/lockUser")
    @ResponseBody
    public ResultResponse lockUser(Integer id, Integer login){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(!user1.getUsername().equals("admin")){
            return new ResultResponse(400, "您没有锁定用户的权限，请联系超级管理员！", null);
        }
        if(userService.findUserLockById(id).getUsername().equals("admin")){
            return new ResultResponse(400, "此用户无法锁定！", null);
        }
        try {
            userService.setUserLock(id, login);
            logger.info("[管理员:" + user1.getName() + "] 修改用户状态成功！该用户编号为：" + id + "状态修改为:" + login);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[管理员:" + user1.getName() + "] 修改用户状态失败！该用户编号为：" + id);
            logger.error("[CustomerController] lockUser error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editUser")
    @ResponseBody
    public ResultResponse editUser(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(!user1.getUsername().equals("admin")){
            return new ResultResponse(400, "您没有编辑用户的权限，请联系超级管理员！", null);
        }
        if(userService.findUserLockById(user.getId()).getUsername().equals("admin")){
            return new ResultResponse(400, "此用户无法修改！", null);
        }
        try {
            userService.editUser(user);
            logger.info("[管理员:" + user1.getName() + "] 编辑用户成功！该用户信息改为：" + user.toString());
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[管理员:" + user1.getName() + "] 编辑用户失败！该用户信息未被改为：" + user.toString());
            logger.error("[CustomerController] editUser error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editDetail")
    @ResponseBody
    public ResultResponse editDetail(@RequestBody CustomerInfo customerInfo){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            customerService.editDetail(customerInfo);
            logger.info("[用户:" + user1.getName() + "] 编辑现有人员详细成功！该客户:["+customerInfo.getCompanyName()+"]现有人员信息改为：" + customerInfo.getDetail());
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑现有人员详细失败！该客户:["+customerInfo.getCompanyName()+"]现有人员信息未被改为：" + customerInfo.getDetail());
            logger.error("[CustomerController] editDetail error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editTitleAndProfessionById")
    @ResponseBody
    public ResultResponse editTitleAndProfessionById(Integer id, String bookId){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            String []str = bookId.split("_");
            customerService.editTitleAndProfessionById(id, Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
            logger.info("[用户:" + user1.getName() + "] 编辑客户证书专业成功！该客户编号为:["+id+"]，证书编号改为：" + str[1] + "专业编号改为：" +str[2]);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑客户证书专业失败！该客户编号为:["+id+"]");
            logger.error("[CustomerController] editTitleAndProfessionById error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editPhoneInfo")
    @ResponseBody
    public ResultResponse editPhoneInfo(@RequestBody CustomerInfoDto customerInfoDto){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            customerService.editPhoneInfo(customerInfoDto);
            logger.info("[用户:" + user1.getName() + "] 编辑客户联系信息成功！该客户编号为:["+customerInfoDto.getId()+"]，联系信息改为：" + customerInfoDto.getPhone() + "," + customerInfoDto.getPhone1()
                    + "," + customerInfoDto.getPhone2() + ",cal: " + customerInfoDto.getCall()  + ", QQ: " + customerInfoDto.getQq() + ",email: " + customerInfoDto.getEmail());
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑客户联系信息失败！该客户编号为:["+customerInfoDto.getId()+"]，联系信息未被改为：" + customerInfoDto.getPhone() + "," + customerInfoDto.getPhone1()
                    + "," + customerInfoDto.getPhone2() + ",cal: " + customerInfoDto.getCall()  + ", QQ: " + customerInfoDto.getQq() + ",email: " + customerInfoDto.getEmail());
            logger.error("[CustomerController] editPhoneInfo error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editCompanyInfo")
    @ResponseBody
    public ResultResponse editCompanyInfo(@RequestBody CustomerInfoDto customerInfoDto){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            customerService.editCompanyInfo(customerInfoDto);
            logger.info("[用户:" + user1.getName() + "] 编辑客户公司信息成功！该客户编号为:["+customerInfoDto.getId()+"]，企业信息被改为： 公司名 " + customerInfoDto.getCompanyName()
                    +", 地址：" + customerInfoDto.getCompanyAddress()+", 法人：" + customerInfoDto.getCompanyLegal()+", 资金：" + customerInfoDto.getCompanyMoney()
                    +", 注册地址：" + customerInfoDto.getCompanyRegistAddress() +", 成立日期：" + customerInfoDto.getCompanyDate()+", -：" + customerInfoDto.getCompanySignday()
            );
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑客户公司信息失败！该客户编号为:["+customerInfoDto.getId()+"]，企业信息未被改为： 公司名 " + customerInfoDto.getCompanyName()
                    +", 地址：" + customerInfoDto.getCompanyAddress()+", 法人：" + customerInfoDto.getCompanyLegal()+", 资金：" + customerInfoDto.getCompanyMoney()
                    +", 注册地址：" + customerInfoDto.getCompanyRegistAddress() +", 成立日期：" + customerInfoDto.getCompanyDate()+", -：" + customerInfoDto.getCompanySignday()
            );
            logger.error("[CustomerController] editCompanyInfo error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editAddress")
    @ResponseBody
    public ResultResponse editAddress(Integer id, String address){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            customerService.editCustomerAddress(id, address);
            logger.info("[用户:" + user1.getName() + "] 编辑客户地区成功！该客户编号:["+id+"] 地区信息改为：" +address);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑客户地区失败！该客户编号:["+id+"] 地区信息未被改为：" +address);
            logger.error("[CustomerController] editAddress error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editCustomerIdea")
    @ResponseBody
    public ResultResponse editCustomerIdea(Integer id, Integer ideaId){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            customerService.editCustomerIdea(id, ideaId);
            logger.info("[用户:" + user1.getName() + "] 编辑客户意愿成功！该客户编号:["+id+"] 意愿编号改为：" +ideaId);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑客户意愿失败！该客户编号:["+id+"] 意愿编号未被改为：" +ideaId);
            logger.error("[CustomerController] editCustomerIdea error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editCustomerSource")
    @ResponseBody
    public ResultResponse editCustomerSource(Integer id, Integer sourceId){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            customerService.editCustomerSource(id, sourceId);
            logger.info("[用户:" + user1.getName() + "] 编辑客户来源成功！该客户编号:["+id+"] 来源编号改为：" +sourceId);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑客户来源失败！该客户编号:["+id+"] 来源编号未被改为：" +sourceId);
            logger.error("[CustomerController] editCustomerSource error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editRegister")
    @ResponseBody
    public ResultResponse editRegister(Integer id, String register){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            customerService.editRegister(id, register);
            logger.info("[用户:" + user1.getName() + "] 编辑客户注册类型成功！该客户编号:["+id+"] 注册类型改为：" +register);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑客户注册类型失败！该客户编号:["+id+"] 注册类型未被改为：" +register);
            logger.error("[CustomerController] editRegister error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/addRecord")
    @ResponseBody
    public ResultResponse addRecord(Integer id, String record){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            customerService.addRecord(id, record);
            logger.info("[用户:" + user1.getName() + "] 添加客户备注成功！该客户编号:["+id+"] 添加备注：" +record);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 添加客户备注失败！该客户编号:["+id+"] 添加备注：" +record +" 失败！");
            logger.error("[CustomerController] addRecord error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editRecord")
    @ResponseBody
    public ResultResponse editRecord(Integer id, String record, Integer customerId){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        try {
            customerService.editRecord(id, record, customerId);
            logger.info("[用户:" + user1.getName() + "] 修改客户备注成功！该客户编号:["+customerId+"] 修改备注为：" +record);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 修改客户备注失败！该客户编号:["+customerId+"] 修改备注失败：" +record);
            logger.error("[CustomerController] editRecord error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    public ResultResponse getAllUser(){
        try {
            return new ResultResponse(200, "", userService.getAllUser());
        }catch (Exception e){
            logger.error("[CustomerController] getAllUser error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/changeUserToCustomer")
    @ResponseBody
    public ResultResponse changeUserToCustomer(Integer id, Integer userId){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(user1.getRoleId() != 1){
            return new ResultResponse(400, "您没有权限分配此客户给该用户!", null);
        }
        try {
            customerService.changeUserToCustomer(id, userId);
            logger.info("[用户:" + user1.getName() + "] 分配客户给用户成功！该客户编号:["+id+"] 分配给的用户编号为：" +userId);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 分配客户给用户失败！该客户编号:["+id+"] 未分配给的用户编号为：" +userId);
            logger.error("[CustomerController] changeUserToCustomer error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/setProfession")
    @ResponseBody
    public Map<String, Object> setProfession(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("rows",  customerService.setProfession());
            map.put("code", 0);
        }catch (Exception e){
            logger.error("[CustomerController] setProfession error: " + e.getMessage());
            map.put("msg", e.getMessage());
            map.put("code", 1);
        }
        return map;
    }

    @RequestMapping("/setIdea")
    @ResponseBody
    public Map<String, Object> setIdea(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("rows",  customerService.getAllIdea());
            map.put("code", 0);
        }catch (Exception e){
            logger.error("[CustomerController] setIdea error: " + e.getMessage());
            map.put("msg", e.getMessage());
            map.put("code", 1);
        }
        return map;
    }

    @RequestMapping("/setSource")
    @ResponseBody
    public Map<String, Object> setSource(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("rows",   customerService.getAllSource());
            map.put("code", 0);
        }catch (Exception e){
            logger.error("[CustomerController] setSource error: " + e.getMessage());
            map.put("msg", e.getMessage());
            map.put("code", 1);
        }
        return map;
    }

    @RequestMapping("/addTitle")
    @ResponseBody
    public ResultResponse addTitle(String title){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(user1.getRoleId() != 1){
            return new ResultResponse(400, "您没有添加证书的权限！请联系管理员！", null);
        }
        try {
            customerService.addTitle(title);
            logger.info("[用户:" + user1.getName() + "] 添加证书成功！证书名称为：" +title);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 添加证书失败！证书名称为：" +title);
            logger.error("[CustomerController] addTitle error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/addProfession")
    @ResponseBody
    public ResultResponse addProfession(Integer id, String profession){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(user1.getRoleId() != 1){
            return new ResultResponse(400, "您没有添加专业的权限！请联系管理员！", null);
        }
        try {
            customerService.addProfession(id, profession);
            logger.info("[用户:" + user1.getName() + "] 添加专业成功！专业名称为：" +profession);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 添加专业失败！专业名称为：" +profession);
            logger.error("[CustomerController] addProfession error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/addIdea")
    @ResponseBody
    public ResultResponse addIdea(String idea){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(user1.getRoleId() != 1){
            return new ResultResponse(400, "您没有添加专业的权限！请联系管理员！", null);
        }
        try {
            customerService.addIdea(idea);
            logger.info("[用户:" + user1.getName() + "] 添加意愿成功！意愿名称为：" +idea);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 添加意愿失败！意愿名称为：" +idea);
            logger.error("[CustomerController] addIdea error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/addSource")
    @ResponseBody
    public ResultResponse addSource(String source){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(user1.getRoleId() != 1){
            return new ResultResponse(400, "您没有添加专业的权限！请联系管理员！", null);
        }
        try {
            customerService.addSource(source);
            logger.info("[用户:" + user1.getName() + "] 添加来源成功！意愿名称为：" +source);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 添加来源失败！意愿名称为：" +source);
            logger.error("[CustomerController] addSource error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editIdea")
    @ResponseBody
    public ResultResponse editIdea(Integer id, String idea){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(user1.getRoleId() != 1){
            return new ResultResponse(400, "您没有添加专业的权限！请联系管理员！", null);
        }
        try {
            customerService.editIdea(id, idea);
            logger.info("[用户:" + user1.getName() + "] 编辑意愿成功！意愿名称为：" +idea);
            return new ResultResponse(200, "",null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑意愿失败！意愿名称为：" +idea);
            logger.error("[CustomerController] editIdea error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editSource")
    @ResponseBody
    public ResultResponse editSource(Integer id, String source){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(user1.getRoleId() != 1){
            return new ResultResponse(400, "您没有添加专业的权限！请联系管理员！", null);
        }
        try {
            customerService.editSource(id, source);
            logger.info("[用户:" + user1.getName() + "] 编辑来源成功！来源名称为：" +source);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑来源失败！来源名称为：" +source);
            logger.error("[CustomerController] editSource error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }

    @RequestMapping("/editProfession")
    @ResponseBody
    public ResultResponse editProfession(Integer id, String profession){
        Subject subject = SecurityUtils.getSubject();
        User user1 = userService.findByUsername(subject.getPrincipals() + "");
        if(user1.getRoleId() != 1){
            return new ResultResponse(400, "您没有添加专业的权限！请联系管理员！", null);
        }
        try {
            customerService.editProfession(id, profession);
            logger.info("[用户:" + user1.getName() + "] 编辑专业成功！专业名称为：" +profession);
            return new ResultResponse(200, "", null);
        }catch (Exception e){
            logger.info("[用户:" + user1.getName() + "] 编辑专业失败！专业名称为：" +profession);
            logger.error("[CustomerController] editProfession error: " + e.getMessage());
            return new ResultResponse(400, e.getMessage(), null);
        }
    }


}
