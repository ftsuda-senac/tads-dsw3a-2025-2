package br.senac.tads.dsw.dadospessoais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaRestController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public List<Pessoa> findAll() {
        return service.findAll();
    }

    // @RequestParam("username") == @RequestParam(value = "username")

    @GetMapping("/apelido")
    public Pessoa findByUsernameRequesParam(
            @RequestParam(value = "username", defaultValue = "fulano") String u) {
        return service.findByUsername(u);
    }

    @GetMapping("/{username}")
    public Pessoa findByUsername(@PathVariable("username") String u) {
        return service.findByUsername(u);
    }

}
