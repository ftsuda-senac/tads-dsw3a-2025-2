package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExemploController {

     GeradorSaida gerador = new GeradorSaidaJson();

    @GetMapping
    @ResponseBody
    public String gerarJson(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email) {
       
        Dados dados = new Dados(nome, email, LocalDateTime.now());
        return gerador.gerarSaida(dados);
    }

}
