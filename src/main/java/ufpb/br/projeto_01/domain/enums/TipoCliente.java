package ufpb.br.projeto_01.domain.enums;


public enum TipoCliente {


    //posso definir qual o código numérico corresponde a cada numeração e atribuir um nome
    //Preciso criar um construtor para atribuir esses valores
    
    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Juridica");

    private int cod;
    private String descricao;

    private TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    //Colocamos só o get, pois uma vez que instanciamos um tipo enumerado não mudamos o nome dele

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }


    //toEnum converyte pra enum
    public static TipoCliente toEnum(Integer cod){
        if(cod==null){
            return null;
        }

        //Esse for percorre todos os valores possíveis do meu tipo enumerado
        for (TipoCliente x : TipoCliente.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + cod);
    } 
}
    