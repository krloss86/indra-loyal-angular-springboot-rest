package ar.com.loyalindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.loyalindra.models.User;

@Repository
public interface AuthRepository extends JpaRepository<User, Long>{

	//dentro de spring jpa
	public User findByUsername(String username);
	//select * from user where username=username
}
