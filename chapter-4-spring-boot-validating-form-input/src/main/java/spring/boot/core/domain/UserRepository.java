package spring.boot.core.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户持久层操作接口
 *
 * Created by bysocket on 21/07/2017.
 */
// TODO: 2018/9/15  JpaRepository 是继承自 PagingAndSortingRepository
// 的针对 JPA 技术提供的接口，它在父接口的基础上，提供了其他一些方法，比如 flush()，saveAndFlush()，deleteInBatch() 等。
// 如果有这样的需求，则可以继承该接口。
public interface UserRepository extends JpaRepository<User, Long> {

}
