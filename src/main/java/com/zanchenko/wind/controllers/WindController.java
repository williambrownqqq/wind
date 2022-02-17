package com.zanchenko.wind.controllers;

import com.zanchenko.wind.models.WindData;
import com.zanchenko.wind.repo.WindDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WindController {

    @Autowired
    private WindDataRepository windDataRepository;

    @GetMapping("/windInfo")
    public String windInfo(Model model){
        //parseDataFromExcelToDB();
        Iterable<WindData> windy = windDataRepository.findAll();
        model.addAttribute("windInfo", windy); // передаем по имени винд инфо  массив записей
        return "windInfo";
    }

//    public void parseDataFromExcelToDB() {
//        String excelPath = "C:\\Users\\lesha\\Desktop\\2012-12.xlsx";
//        String sheetName = "2012-12";
//        try {
//            ExcelTake excel = new ExcelTake(excelPath, sheetName);
//            int rowNum = excel.getRowcCount();
//            for (int i = 1; i < rowNum; i++){
//
//                Long id = (long)i;
//
//                String MD = excel.getCellData(i,0); // число месяца
//                int month_day = Integer.parseInt(MD);
//                //System.out.println("MD: " + month_day);
//
//                String utc = excel.getCellData(i,1); //utc
//                //System.out.println("utc: " + utc);
//
//                String tt = excel.getCellData(i,2);
//                //System.out.println("T: "+ tt);
//                int t =Integer.parseInt(tt);
//
//
//                String fff = excel.getCellData(i,4);
//                //System.out.println("FF: "+ fff);
//                    int ff = Integer.parseInt(fff);;
//
//                String dd = excel.getCellData(i,3); // dd
//                //System.out.println("dd: "+ dd);
//
//                WindData windobj = new WindData(id,month_day,utc, t, ff, dd);
//                windDataRepository.save(windobj);
//            }
//            System.out.println("data successfully inserted row numbers.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}
