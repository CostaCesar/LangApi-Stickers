package com.costacesar.langAPI.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.costacesar.langAPI.Models.Language;

public interface LangRepo extends MongoRepository<Language, String>
{
    
}
