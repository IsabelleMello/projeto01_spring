package ufpb.br.projeto_01.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//Essa classe vai ser um aentidade do jpa
@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    // atribuitos da classe

    // Estou definindo a estrtégia de geração automática dos meus ids
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    // Inicie as coleções
    //@JsonManagedReference TRocamos pq deu erro 
    //Esse JsonManagedReference diz que ta tudo bem serializar
    //Fazemos isso no lado que queremos que venha a associação
    @ManyToMany(mappedBy = "categorias")
    //Vou falar que esse mapeamento é o outro lado de um mapeamento em cima de categorias
    private List<Produto> produtos = new ArrayList<>();
    //Atruibuições

//O optional é um objeto container que carrega um  objeto do tipo que informarmos encapsula se o objeto está instanciado ou não 
    
    public Categoria() {
    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    //get e sets

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

        //hashcode e equals para compatrar os objetos por valor 

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
        Categoria other = (Categoria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    

    
}
