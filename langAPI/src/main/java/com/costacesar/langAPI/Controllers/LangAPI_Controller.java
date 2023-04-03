package com.costacesar.langAPI.Controllers;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.costacesar.langAPI.Models.Language;
import com.costacesar.langAPI.Repos.LangRepo;

@RestController
public class LangAPI_Controller
{
    @Autowired
    private LangRepo repository;
    // private List<Language> langList =
    //     List.of(
    //         new Language("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_512x512.png", 4),
    //         new Language("C++", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/cpp/cpp_512x512.png", 6),
    //         new Language("C", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/c/c_512x512.png", 1),
    //         new Language("C#", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/csharp/csharp_512x512.png", 2),
    //         new Language("HTML", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/html/html_512x512.png", 7),
    //         new Language("CSS", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/css/css_512x512.png", 5),
    //         new Language("Python", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_512x512.png", 3)
    //     );

    @GetMapping(value="hello")
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
    
    // TODO: Get by id
    // @GetMapping(value="/LangList/{avlue}")
    // public Language getLang(@PathVariable("title") String lang)
    // {
    //     Language output = repository.findById(lang);
    //     return output;
    // }

    @PostMapping(value="/LangList")
    public Language postLangList(@RequestBody Language add)
    {   
        return repository.save(add);
    }
}
