package com.zanchenko.wind.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.zanchenko.wind.mapper.WindCSVtoWindDataMapper;
import com.zanchenko.wind.models.WindData;
import com.zanchenko.wind.models.csv.WindCSV;
import com.zanchenko.wind.repo.WindDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component // is an annotation that allows Spring to automatically detect our custom beans.
@RequiredArgsConstructor // instead off constructor - generates a constructor with 1 parameter for each field that requires special handling. создание конструктора включающего все final поля
public class CSVIngestService {
    private final WindDataRepository windDataRepository;
    private final WindCSVtoWindDataMapper windCSVtoWindDataMapper;

    @EventListener(ApplicationReadyEvent.class)
    public void ingestCSV() throws IOException {
        Path path = Path.of("C:\\Users\\lesha\\Desktop\\2012-12.csv");
        List<WindCSV> result;
        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<WindCSV> cb = new CsvToBeanBuilder<WindCSV>(reader)
                    .withType(WindCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            result = cb.parse();
        }
        //интерполяция
        interpol(result);
        persistRecordToDB(result);
    }

    @Transactional
    private void persistRecordToDB(List<WindCSV> result){
        List<WindData> mapped = windCSVtoWindDataMapper.toWindData(result);
        windDataRepository.saveAll(mapped);
    }
    void interpol(List<WindCSV> result){
        int qualityPercent = 0;
        System.out.println(result.size());
        int counter = 0;
        for (WindCSV w : result) {
            if(w.getDd() ==""){w.setDd("undetermined"); qualityPercent++;}
            else if(w.getDd().equals("Южный")){w.setDd("southern");}
            else if(w.getDd().equals("Ю-З")){w.setDd("southwestern");}
            else if(w.getDd().equals("Западный")){w.setDd("western");}
            else if(w.getDd().equals("Северный")){w.setDd("north");}
            else if(w.getDd().equals("С-З")){w.setDd("northwest");}
            else if(w.getDd().equals("С-В")){w.setDd("northeast");}
            else if(w.getDd().equals("Ю-В")){w.setDd("southeast");}
            else if(w.getDd().equals("Восточный")){w.setDd("eastern");}
            else if(w.getDd().equals("Переменный")){w.setDd("alternating");}

            counter++;

        }
        //System.out.println(qualityPercent);
        int damage = qualityPercent * 100 / result.size();
        System.out.println("damage: " + damage + "%");

    }
}
