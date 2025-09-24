package br.senac.tads.dsw.dadospessoais;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interesses")
@CrossOrigin(origins = "*")
public class InteressesRestController {

    @GetMapping
    public List<String> findAll() {
        return List.of("Java", "Spring Boot",
        "Javascript", "CSharp", "CSS", "HTML");
    }

}
