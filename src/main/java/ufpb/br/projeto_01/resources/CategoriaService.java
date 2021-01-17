package ufpb.br.projeto_01.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ufpb.br.projeto_01.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
//Criamos uma classe com um controlador rest que vai responder pelo endpoint categorias
public class CategoriaService {
//Assim, se eu for no localhost:8080/categorias vou poder ver o "Funcionou"
    @RequestMapping(method=RequestMethod.GET)
    public List<Categoria> listar() {
        
        Categoria cat1 = new Categoria(1, "Informática");
        Categoria cat2 = new Categoria(2, "Escritório");
       
        List<Categoria> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);
       
        return lista; 
    }
    
}
