package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ExemploController {

    private ObjectMapper objectMapper;

    public ExemploController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping
    // @ResponseBody
    public String gerarJson(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("time") String time) {
       
        Dados dados = new Dados(nome, email, time, "Ribeirao Preto",
        LocalDateTime.now());
        try {
            return objectMapper.writeValueAsString(dados);
        } catch (Exception ex) {
            return  "{ }";
        }
    }

}
