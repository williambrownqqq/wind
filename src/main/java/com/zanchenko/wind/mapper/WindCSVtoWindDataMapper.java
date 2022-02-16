package com.zanchenko.wind.mapper;

import com.zanchenko.wind.models.WindData;
import com.zanchenko.wind.models.csv.WindCSV;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WindCSVtoWindDataMapper {
    WindData toWindData(WindCSV obj);

    List<WindData> toWindData(List<WindCSV> obj);
}
