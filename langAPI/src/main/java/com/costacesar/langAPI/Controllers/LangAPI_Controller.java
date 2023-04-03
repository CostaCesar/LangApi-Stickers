package com.costacesar.langAPI.Controllers;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.costacesar.langAPI.Models.Language;
import com.costacesar.langAPI.Repos.LangRepo;

@RestController
public class LangAPI_Controller
{
    @Autowired
    private LangRepo repository;

    @GetMapping(value="/hello")
    public String getTest()
    {
        return "Hello, Spring!";
    }

    @GetMapping(value="/LangList")
    public List<Language> getLangList()
    {
        List<Language> output = repository.findAll();
        Collections.sort(output, (x, y) -> x.getRanking() - y.getRanking());
        return output;
    }
    
    @GetMapping(value="/LangList/{title}")
    public Language getLang(@PathVariable String title)
    {
        Optional<Language> output = repository.findBytitle(title);
        return output.get();
    }

    @PutMapping(value="/LangList")
    public List<Language> updateLangList(@RequestBody Language updated)
    {   
        repository.save(updated);
        List<Language> output = repository.findAll();
        Collections.sort(output, (x, y) -> x.getRanking() - y.getRanking());
        return output;
    }


    @DeleteMapping(value="/LangList/{title}")
    public List<Language> deleteLangList(@PathVariable String title)
    {   
        repository.deleteBytitle(title);
        List<Language> output = repository.findAll();
        Collections.sort(output, (x, y) -> x.getRanking() - y.getRanking());
        return output;
    }

    @PostMapping(value="/LangList")
    public Language postLangList(@RequestBody Language add)
    {   
        return repository.save(add);
    }
}
