package ufpb.br.projeto_01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ufpb.br.projeto_01.domain.Categoria;
import ufpb.br.projeto_01.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
//Criamos uma classe com um controlador rest que vai responder pelo endpoint categorias
public class CategoriaResource {
//Assim, se eu for no localhost:8080/categorias vou poder ver o "Funcionou"
//Colocar esse id significa qu eo endpoint desse método listar vai ser/categoria/{id}
//Para que o spring saiba que esse id do endpoint, da URL, tenha que vir para o id da variável incluo o PathVariable

    @Autowired
    private CategoriaService service;
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Categoria obj = service.buscar(id);
        //O ResponseEntity é um objeto do spring que encapsula vários informações de uma resposta HTTP para um srerviço rest
        //Coloco a interrogação porque pode ser qualquer tipo       
        //Uma forma de falar que essa resposta ocorreu tudo bem é colocar o método ok
        // Essa resposta vai ter como corpo o objeto obj que busquei, que é a categoria 
        return ResponseEntity.ok().body(obj);
    }
    
}
