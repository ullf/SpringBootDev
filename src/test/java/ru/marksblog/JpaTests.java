package ru.marksblog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.marksblog.entity.Company;
import ru.marksblog.repository.CompanyRepository;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=NONE)
public class JpaTests {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testAdd(){
        Company company = new Company();
        company.setCompanyName("Yandex");
        testEntityManager.persist(company);
        Company tmp = companyRepository.findByName("Yandex");
        assertTrue(tmp.getCompanyName().equals("Yandex"));
    }

    @Test
    public void testDelete(){
        Company tmp = companyRepository.findByName("Yandex");
        companyRepository.deleteById(tmp.getId());
        assertFalse(companyRepository.findAll().iterator().hasNext());
    }
}
