//package com.project.Dao;
//
//
//import com.project.model.Token;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@EnableJpaRepositories
//public interface TokenRepository extends JpaRepository<Token, Long> {
//
//    @Query("""
//   select t from Token t inner join Employee u on t.employee.id = u.id
//   where t.employee.id = :userId and t.loggedOut = false
//   """)
//
//    List<Token> findAllTokensByEmployee(Long userId);
//
//    Optional<Token> findByToken(String token);
//}
