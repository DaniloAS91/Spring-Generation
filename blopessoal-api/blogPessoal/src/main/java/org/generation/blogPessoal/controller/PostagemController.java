package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Define ao Spring que esta classe tratasse de um Controller ou controlador
@RequestMapping("/postagens") //Essa notação indicara por onde esta classe sera acessada
@CrossOrigin("*") // indica que esta classe ira aceitar requisições de qualquer origem
public class PostagemController {
	
	@Autowired 	// <- Injeção de Dependencia do Spring
				// garante que os serviços da classe repository sejam acessados
				// a partir do Controller
	private PostagemRepository repository;//Sem new, pq interface não se instacia
	
	@GetMapping // Expõe para a api que se trata de um GET
				// Indica para quem for usar o /postagens
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")// Assim que for passado um valor com barra esse sera passado
						// para o metodo, esse metodo vai retornar a interface
	public ResponseEntity<Postagem> GetById(@PathVariable Long id){
		// pode retornar  um objeto dentro do ok ou um not found caso não
		// exista ou ocorra algum erro
		return repository.findById(id) 				 // resp é o objeto que pode conter ou não no optional
				.map(resp -> ResponseEntity.ok(resp))// -> = Lambda Expression
				.orElse(ResponseEntity.notFound().build()); // orElse caso não retorna null
	}
	
	@GetMapping("/titulo/{titulo}")	// utilizar desta forma para nao dar duplicidade
									// esse get busca por titulo
									 
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping // funciona como o metodo acima porém com o id nahora de informar o recurso que ira ser alterado
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}") //Deve ser passado o parametro id, como no get
							//Deve deletar o recurso pela id
	public void delete(@PathVariable Long id){
		repository.deleteById(id);
	}
	
}
