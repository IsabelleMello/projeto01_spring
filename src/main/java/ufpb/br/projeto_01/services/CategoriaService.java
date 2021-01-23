package ufpb.br.projeto_01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufpb.br.projeto_01.domain.Categoria;
import ufpb.br.projeto_01.repositories.CategoriaRepository;
import ufpb.br.projeto_01.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

    //Injeção de dependência

    @Autowired
    private CategoriaRepository repo;

    //Para implementar um serviço que busca uma categoria é necessário chamar uma operação la no objeto de acesso a dados. QUe é no CategoriaRepository

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    } 
    
}
