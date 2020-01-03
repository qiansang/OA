package com.bonc.oa.utils;

import com.bonc.oa.wanda.bean.Record;
import com.bonc.oa.wanda.bean.dto.RemarkDto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SortUtil {

    public static List<RemarkDto> getSortRecords(List<Record> records) {
        for (int i = 0; i < records.size() - 1; i++) {
            for (int j = i+1; j < records.size(); j++) {
                if(records.get(i).getDate().getTime() > records.get(j).getDate().getTime()){
                    Date temp = records.get(i).getDate();
                    records.get(i).setDate(records.get(j).getDate());
                    records.get(j).setDate(temp);
                }
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<RemarkDto> remarks = new ArrayList<RemarkDto>();
        for (int j = 0; j < records.size(); j++) {
            RemarkDto remarkDto = new RemarkDto();
            remarkDto.setId(records.get(j).getId());
            remarkDto.setDate("[" + sdf.format(records.get(j).getDate()) + "]");
            remarkDto.setContent(records.get(j).getContent());
            remarks.add(remarkDto);
        }
        return remarks;
    }
}
