package vn.elca.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import vn.elca.training.dom.Employee;
import vn.elca.training.dom.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>, QueryDslPredicateExecutor<Employee> {
}
