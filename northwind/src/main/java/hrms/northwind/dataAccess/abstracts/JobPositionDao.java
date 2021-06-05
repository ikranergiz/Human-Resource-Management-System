package hrms.northwind.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{


}
