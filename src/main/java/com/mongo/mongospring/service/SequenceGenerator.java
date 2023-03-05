package com.mongo.mongospring.service;

import com.mongo.mongospring.entity.DbSequence;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SequenceGenerator {
    @Autowired
    private MongoOperations mongoOperations;
    //id ,seqNo is from DbSequence class in entity
    public int getSequenceNumber(String sequenceName){
        Query query=new Query(Criteria.where("id").is(sequenceName));//get seqNo
        Update update=new Update().inc("seqNo",1); //increament key by 1
        //the query to get the last id, then update it the save back the record
        DbSequence counter=mongoOperations.findAndModify(query,update, FindAndModifyOptions.options().returnNew(true).upsert(true),DbSequence.class);
        return !Objects.isNull(counter)? counter.getSeqNo() : 1;
    }
}
