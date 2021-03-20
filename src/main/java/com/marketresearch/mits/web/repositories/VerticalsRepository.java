package com.marketresearch.mits.web.repositories;

import com.marketresearch.mits.web.model.VerticalsDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerticalsRepository extends MongoRepository<VerticalsDto, String> {
    VerticalsDto findBy_id(ObjectId _id);
}
