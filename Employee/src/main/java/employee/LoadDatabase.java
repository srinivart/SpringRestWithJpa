package employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import employee.dao.EmployeeRepository;
import employee.entity.Employee;


@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Employee("Srinivas","Developer","50000")));
      log.info("Preloading " + repository.save(new Employee("Sahi", "Lead","85000")));
      log.info("Preloading " + repository.save(new Employee("Teju", "QA","75000")));
      log.info("Preloading " + repository.save(new Employee("Indira", "TeamLead","95000")));
    };
  }
}
