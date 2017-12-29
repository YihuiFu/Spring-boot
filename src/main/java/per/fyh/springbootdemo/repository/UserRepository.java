package per.fyh.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import per.fyh.springbootdemo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int id);
}