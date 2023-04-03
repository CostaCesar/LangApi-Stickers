package com.costacesar.langAPI.Repos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.costacesar.langAPI.Models.Language;

public interface LangRepo extends MongoRepository<Language, String>
{
    Optional<Language> findBytitle(String title);
    Optional<Language> deleteBytitle(String title);
}
