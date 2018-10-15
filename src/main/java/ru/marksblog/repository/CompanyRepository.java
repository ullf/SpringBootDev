package ru.marksblog.repository;

import org.springframework.data.repository.CrudRepository;
import ru.marksblog.entity.Company;

public interface CompanyRepository extends CrudRepository<Company,Integer> {
}
