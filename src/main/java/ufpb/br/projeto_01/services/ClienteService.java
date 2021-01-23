package ufpb.br.projeto_01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufpb.br.projeto_01.domain.Cliente;
import ufpb.br.projeto_01.repositories.ClienteRepository;
import ufpb.br.projeto_01.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

    //Injeção de dependência

    @Autowired
    private ClienteRepository repo;

    //Para implementar um serviço que busca uma Cliente é necessário chamar uma operação la no objeto de acesso a dados. QUe é no ClienteRepository

    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    } 
    
}
