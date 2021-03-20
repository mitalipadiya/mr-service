package com.marketresearch.mits.web.repositories;

import java.util.Optional;
import com.marketresearch.mits.web.model.ERole;
import com.marketresearch.mits.web.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}

