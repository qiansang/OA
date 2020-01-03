package com.bonc.oa.wanda.bean.dto;

import com.bonc.oa.wanda.bean.Profession;

import java.util.List;

public class ProfessionDto {
    private Integer id;
    private String title;
    private List<Profession> professionList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Profession> getProfessionList() {
        return professionList;
    }

    public void setProfessionList(List<Profession> professionList) {
        this.professionList = professionList;
    }
}
