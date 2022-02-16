package com.zanchenko.wind.repo;
import com.zanchenko.wind.models.WindData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindDataRepository extends CrudRepository<WindData, Long> {
    // функции для работы с бд
}
