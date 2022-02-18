package com.noodlesscoders.forumxbackend.repository.user;

import com.noodlesscoders.forumxbackend.repository.user.bean.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
