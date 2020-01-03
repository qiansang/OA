package com.bonc.oa.wanda.bean.dto;

import java.util.Date;
import java.util.List;

public class CustomerInfoDto {
    private Integer id;

    private Integer ideaId;

    private int type;

    private String idea;

    private Integer sourceId;

    private String source;

    private Integer titleId;

    private String title;

    private String bookType;

    private String book;

    private Integer professionId;

    private String profession;

    private String bookPro;

    private String register;

    private String contact;

    private String provinces;

    private String phone;

    private String phone1;

    private String phone2;

    private String qq;

    private String email;

    private String companyName;

    private String call;

    private Date updateDate;

    private String update;

    private Integer userId;

    private String user;

    private List<RemarkDto> remark;

    private String detail;

    private String companyLegal;

    private String companyMoney;

    private String companyRegistAddress;

    private String companyAddress;

    private Date companyDate;

    private Date companySignday;

    private Integer safeId;

    private String safe;

    private Date successData;

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public List<RemarkDto> getRemark() {
        return remark;
    }

    public void setRemark(List<RemarkDto> remark) {
        this.remark = remark;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdeaId() {
        return ideaId;
    }

    public String getTitle() {
        return title;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIdeaId(Integer ideaId) {
        this.ideaId = ideaId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public String getBookPro() {
        return bookPro;
    }

    public void setBookPro(String bookPro) {
        this.bookPro = bookPro;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCompanyLegal() {
        return companyLegal;
    }

    public void setCompanyLegal(String companyLegal) {
        this.companyLegal = companyLegal;
    }

    public String getCompanyMoney() {
        return companyMoney;
    }

    public void setCompanyMoney(String companyMoney) {
        this.companyMoney = companyMoney;
    }

    public String getCompanyRegistAddress() {
        return companyRegistAddress;
    }

    public void setCompanyRegistAddress(String companyRegistAddress) {
        this.companyRegistAddress = companyRegistAddress;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
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

    public String getSafe() {
        return safe;
    }

    public void setSafe(String safe) {
        this.safe = safe;
    }

    public Date getSuccessData() {
        return successData;
    }

    public void setSuccessData(Date successData) {
        this.successData = successData;
    }

    @Override
    public String toString() {
        return "CustomerInfoDto{" +
                "id=" + id +
                ", ideaId=" + ideaId +
                ", type=" + type +
                ", idea='" + idea + '\'' +
                ", sourceId=" + sourceId +
                ", source='" + source + '\'' +
                ", titleId=" + titleId +
                ", title='" + title + '\'' +
                ", bookType='" + bookType + '\'' +
                ", book='" + book + '\'' +
                ", professionId=" + professionId +
                ", profession='" + profession + '\'' +
                ", bookPro='" + bookPro + '\'' +
                ", register='" + register + '\'' +
                ", contact='" + contact + '\'' +
                ", provinces='" + provinces + '\'' +
                ", phone='" + phone + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", call='" + call + '\'' +
                ", updateDate=" + updateDate +
                ", update='" + update + '\'' +
                ", userId=" + userId +
                ", user='" + user + '\'' +
                ", remark=" + remark +
                ", detail='" + detail + '\'' +
                ", companyLegal='" + companyLegal + '\'' +
                ", companyMoney='" + companyMoney + '\'' +
                ", companyRegistAddress='" + companyRegistAddress + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyDate=" + companyDate +
                ", companySignday=" + companySignday +
                ", safeId=" + safeId +
                ", safe='" + safe + '\'' +
                ", successData=" + successData +
                '}';
    }
}
