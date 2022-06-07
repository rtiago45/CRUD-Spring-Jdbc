package io.github.rtiago;

import io.github.rtiago.domain.entity.Cliente;
import io.github.rtiago.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando Clientes");
            clientes.salvar(new Cliente("Tiago"));
            clientes.salvar(new Cliente("Outro Cliente"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando Clientes");
            todosClientes.forEach(c -> {
                    c.setNome(c.getNome() + " atualizado");
                    clientes.atualizar(c);
            });

            System.out.println("Buscando Clientes");
            clientes.buscarPorNome("Tiago atualizado").forEach(System.out::println);

            System.out.println("Deletando Cliente");
            clientes.obterTodos().forEach(c ->{
                clientes.deletar(2);
            });


            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
