package spring.boot.core.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 用户持久层操作接口
 *
 * Created by bysocket on 18/09/2017.
 * 用户持久层操作接口 UserRepository
 * 接口只要继承 PagingAndSortingRepository 类即可。默认会提供很多实现，比如 CRUD 相关的实现。支持的默认方法有： count(), findAll(), findOne(ID), delete(ID), deleteAll(), exists(ID), save(DomainObject), save(Iterable<DomainObject>)。
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
