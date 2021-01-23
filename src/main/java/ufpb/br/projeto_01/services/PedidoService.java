package ufpb.br.projeto_01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufpb.br.projeto_01.domain.Pedido;
import ufpb.br.projeto_01.repositories.PedidoRepository;
import ufpb.br.projeto_01.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    } 
    
}
