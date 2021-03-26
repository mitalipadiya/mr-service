package com.marketresearch.mits.web.repositories;

import com.marketresearch.mits.web.model.VerticalsDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerticalsRepository extends MongoRepository<VerticalsDto, String> {
    Optional<VerticalsDto> findById(String id);
}
