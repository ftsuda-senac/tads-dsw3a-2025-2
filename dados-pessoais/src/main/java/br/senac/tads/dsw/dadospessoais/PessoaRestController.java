package br.senac.tads.dsw.dadospessoais;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PessoaRestController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public List<Pessoa> findAll() {
        return service.findAll();
    }

    // Equivalencia da annotation (forma reduzida X forma completa)
    // @RequestParam("username") == @RequestParam(value = "username")

    @GetMapping("/apelido")
    public Pessoa findByUsernameRequesParam(
            @RequestParam(value = "username", defaultValue = "fulano") String u) {
        return service.findByUsername(u);
    }

    @GetMapping("/{username}")
    public Pessoa findByUsername(@PathVariable("username") String u) {
        Pessoa resultado = service.findByUsername(u);
        if (resultado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Pessoa %s não encontrada".formatted(u));
        }
        return resultado;
    }

    @GetMapping("/tudo/{username}")
    public Map<String, Object> findExemploTudo(
        @PathVariable("username") String u,
        @RequestParam(value = "extra1", defaultValue = "xpto") String extra1,
        @RequestParam(value = "extra2", required =  false) String extra2,
        @RequestHeader("user-agent") String userAgent) {

        Map<String, Object> mapResposta = new HashMap<>();
        mapResposta.put("usuario", service.findByUsername(u));
        mapResposta.put("extra1", extra1);
        mapResposta.put("extra2", extra2);
        mapResposta.put("user-agent", userAgent);
        return mapResposta;

    }


}
