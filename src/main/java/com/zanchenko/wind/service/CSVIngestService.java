//package com.zanchenko.wind.service;
//
//import com.opencsv.bean.CsvToBean;
//import com.opencsv.bean.CsvToBeanBuilder;
//import com.zanchenko.wind.mapper.WindCSVtoWindDataMapper;
//import com.zanchenko.wind.models.WindData;
//import com.zanchenko.wind.models.csv.WindCSV;
//import com.zanchenko.wind.repo.WindDataRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor // instead off constructor
//public class CSVIngestService {
//    private final WindDataRepository windDataRepository;
//    private final WindCSVtoWindDataMapper windCSVtoWindDataMapper;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void ingestCSV() throws IOException {
//        Path path = Path.of("C:\\Users\\lesha\\Desktop\\2012-12.csv");
//        List<WindCSV> result;
//        try (Reader reader = Files.newBufferedReader(path)) {
//            CsvToBean<WindCSV> cb = new CsvToBeanBuilder<WindCSV>(reader)
//                    .withType(WindCSV.class)
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .build();
//            result = cb.parse();
//        }
//        //интерполяция
//        persistRecordToDB(result);
//    }
//
//    @Transactional
//    private void persistRecordToDB(List<WindCSV> result){
//        List<WindData> mapped = windCSVtoWindDataMapper.toWindData(result);
//        windDataRepository.saveAll(mapped);
//    }
//}
