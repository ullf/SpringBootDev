package ru.marksblog.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.marksblog.entity.Company;

@Repository
@Transactional
public interface CompanyRepository extends CrudRepository<Company,Integer> {

    @Query("SELECT company FROM Company company WHERE company.companyName=:name")
    Company findByName(@Param("name") String name);
}
