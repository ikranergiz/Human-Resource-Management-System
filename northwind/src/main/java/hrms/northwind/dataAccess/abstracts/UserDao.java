package hrms.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);
}
