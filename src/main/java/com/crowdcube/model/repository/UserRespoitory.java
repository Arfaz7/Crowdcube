package com.crowdcube.model.repository;

import com.crowdcube.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRespoitory extends CrudRepository<User, Long> {
}
