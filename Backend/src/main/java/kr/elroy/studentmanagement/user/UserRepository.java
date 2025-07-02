package kr.elroy.studentmanagement.user;

import kr.elroy.studentmanagement.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
