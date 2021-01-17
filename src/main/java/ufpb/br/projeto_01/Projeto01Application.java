package ufpb.br.projeto_01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ufpb.br.projeto_01.domain.Categoria;
import ufpb.br.projeto_01.repositories.CategoriaRepository;

@SpringBootApplication
public class Projeto01Application implements CommandLineRunner {

	//Esse comandLineRunner é uma interface que me permite implementar um método auxiliar para executar alguma ação quando a aplicação começar
	
	//Para salvar esses objetos no banco de dados, uso o categoriaRepository

	@Autowired
	private CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(Projeto01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "escritório");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 

	}

}
