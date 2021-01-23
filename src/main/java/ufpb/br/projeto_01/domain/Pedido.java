package ufpb.br.projeto_01.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

//ATENCAO: Entre pedido e cliente tem uma acessossociação de mao duplaria
//Como vou fazer um edpoint para o pedido e o pedido tem que mostrar o cliente
//Então vou deixar que o cliente de um pedido seja serializado mas não vou serializar o pedido de um cliente 

//O pedido tem que mostrar o pagamento, então permito que o pedido serialize o pagamento
//Mas não permito que o pagamento serialize o pedido
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Formatar a data
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private Date instance;
    

    @OneToOne(cascade = CascadeType.ALL, mappedBy ="pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name="clinte_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="endereco_de_entrega")
    private Endereco enderecoDeEntrega;

    //Uso o id.pedido pq do outro lado eu tenho o itemPedido que tem o obj id e esse é um obj auxiliar que tem a refereencia para o pedido  
    @OneToMany(mappedBy="id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Integer id, Date instance, Cliente cliente, Endereco enderecoDeEntrega) {
        this.id = id;
        this.instance = instance;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstance() {
        return instance;
    }

    public void setInstance(Date instance) {
        this.instance = instance;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }
    
    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
        
}
