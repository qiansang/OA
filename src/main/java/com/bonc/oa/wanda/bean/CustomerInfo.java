package com.bonc.oa.wanda.bean;

import java.util.Date;

public class CustomerInfo {
    private Integer id;

    private Integer type;

    private Integer ideaId;

    private Integer sourceId;

    private Integer titleId;

    private Integer professionId;

    private String register;

    private String address;

    private Date updateDate;

    private Integer userId;

    private String customerName;

    private String customerPhone;

    private String customerCal;

    private String customerEmail;

    private String customerQq;

    private String detail;

    private String companyName;

    private String companyLegal;

    private String companyMoney;

    private String companyRegistAddress;

    private String companyAddress;

    private Date companyDate;

    private Date companySignday;

    private Integer safeId;

    private Date successData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(Integer ideaId) {
        this.ideaId = ideaId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register == null ? null : register.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public String getCustomerCal() {
        return customerCal;
    }

    public void setCustomerCal(String customerCal) {
        this.customerCal = customerCal == null ? null : customerCal.trim();
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail == null ? null : customerEmail.trim();
    }

    public String getCustomerQq() {
        return customerQq;
    }

    public void setCustomerQq(String customerQq) {
        this.customerQq = customerQq == null ? null : customerQq.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyLegal() {
        return companyLegal;
    }

    public void setCompanyLegal(String companyLegal) {
        this.companyLegal = companyLegal == null ? null : companyLegal.trim();
    }

    public String getCompanyMoney() {
        return companyMoney;
    }

    public void setCompanyMoney(String companyMoney) {
        this.companyMoney = companyMoney == null ? null : companyMoney.trim();
    }

    public String getCompanyRegistAddress() {
        return companyRegistAddress;
    }

    public void setCompanyRegistAddress(String companyRegistAddress) {
        this.companyRegistAddress = companyRegistAddress == null ? null : companyRegistAddress.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public Date getCompanyDate() {
        return companyDate;
    }

    public void setCompanyDate(Date companyDate) {
        this.companyDate = companyDate;
    }

    public Date getCompanySignday() {
        return companySignday;
    }

    public void setCompanySignday(Date companySignday) {
        this.companySignday = companySignday;
    }

    public Integer getSafeId() {
        return safeId;
    }

    public void setSafeId(Integer safeId) {
        this.safeId = safeId;
    }

    public Date getSuccessData() {
        return successData;
    }

    public void setSuccessData(Date successData) {
        this.successData = successData;
    }
}