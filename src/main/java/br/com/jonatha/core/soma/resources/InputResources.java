package br.com.jonatha.core.soma.resources;

import br.com.jonatha.core.soma.domain.Input;
import br.com.jonatha.core.soma.dto.InputDTO;
import br.com.jonatha.core.soma.service.InputService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/input")
public class InputResources {

    @Autowired
    InputService service;

    //CREATE
    @ApiOperation("Inserir transiação")
    @PostMapping()
    public ResponseEntity<Input> create(@RequestBody InputDTO objDto) {
        Input obj = service.fromDto(objDto);
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        ResponseEntity<Input> body = ResponseEntity.created(uri).body(obj);
        return body;
    }

    //READ
    @ApiOperation("Buscar transição por ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Input> obj = service.findById(id);
        if (obj.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(obj.get());
    }

    @ApiOperation("Buscar todas as transições")
    @GetMapping()
    public ResponseEntity<List<Input>> findAll() {
        List<Input> list = new ArrayList<>();
        list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //UPDATE
    @ApiOperation("Atualizar transação por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id,@RequestBody InputDTO objDto) {
        Input obj = service.fromDto(objDto);
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        obj.setId(id);
        service.update(id, obj);
        return ResponseEntity.noContent().build();
    }

    //DELETE
    @ApiOperation("Excluir transição por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}