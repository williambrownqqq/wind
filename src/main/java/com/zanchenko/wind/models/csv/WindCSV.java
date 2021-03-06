package com.zanchenko.wind.models.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class WindCSV {
    // привязка между именем столбца входных данных и полем в bean компоненте
    @CsvBindByName(column = "Число месяца")
    private int monthDay;
    @CsvBindByName(column = "T")
    private int t;
    @CsvBindByName(column = "FF")
    private int ff;
    @CsvBindByName(column = "dd")
    private String dd;
    @CsvBindByName(column = "UTC")
    private String utc;

}
