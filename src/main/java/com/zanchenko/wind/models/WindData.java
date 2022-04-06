package com.zanchenko.wind.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data //генерация всех служебных методов, заменяет сразу команды @ToString, @EqualsAndHashCode, Getter, Setter, @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor // will generate a constructor with no parameters
@Entity
public class WindData {
    // каждая переменная внутри этого класса - это определенное поле внутри таблички
    @Id // делает поле уникальным
    @GeneratedValue(strategy = GenerationType.AUTO) // позволяет генерировать новое значение внутри этого поля при добавлении новой записи
    private Long id;
    private int monthDay;
    private int t;
    private int ff;
    private String dd;
    private String utc;
//    private Long id;
//    private int MonthDay;
//    private int T;
//    private int FF;
//    private String dd;
//    private String UTC;

//
//    public WindData(Long id, int monthDay, String UTC,int t, int FF, String dd ) {
//        this.id = id;
//        MonthDay = monthDay;
//        T = t;
//        this.FF = FF;
//        this.dd = dd;
//        this.UTC = UTC;
//    }
//
//    public WindData() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public int getMonthDay() {
//        return MonthDay;
//    }
//
//    public void setMonthDay(int monthDay) {
//        MonthDay = monthDay;
//    }
//
//    public int getT() {
//        return T;
//    }
//
//    public void setT(int t) {
//        T = t;
//    }
//
//    public int getFF() {
//        return FF;
//    }
//
//    public void setFF(int FF) {
//        this.FF = FF;
//    }
//
//    public String getDd() {
//        return dd;
//    }
//
//    public void setDd(String dd) {
//        this.dd = dd;
//    }
//
//    public String getUTC() {
//        return UTC;
//    }
//
//    public void setUTC(String UTC) {
//        this.UTC = UTC;
//    }
}

