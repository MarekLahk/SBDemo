package ml.SBDemo.SBDemo.repository;

import ml.SBDemo.SBDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<Integer> {


}
