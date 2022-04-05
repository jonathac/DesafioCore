package br.com.jonatha.core.soma.service;

import br.com.jonatha.core.soma.domain.Input;
import br.com.jonatha.core.soma.dto.InputDTO;
import br.com.jonatha.core.soma.repositories.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InputService {

    @Autowired
    InputRepository repo;

    //CREATE
    public Input create(Input obj){
        incremento(obj);
        return repo.save(obj);
    }

    //READ
    public Optional<Input> findById(Integer id){
        Optional<Input> obj = repo.findById(id);
        return obj;
    }

    //READ ALL
    public List<Input> findAll (){
        List<Input> list = new ArrayList<>();
        list = repo.findAll();
        return list;
    }

    //UPDATE
    public Input update (Integer id, Input obj){
       Optional<Input> newObj = findById(id);
       updateData(obj, newObj.get());
       return repo.save(newObj.get());
    }

    //Classe auxiliar para atualização de dados
    public void updateData(Input obj, Input newObj){
        newObj.setInput(obj.getInput());
        newObj = incremento(newObj);
    }

    //DELETE
    public void deleteById(Integer id){
        repo.deleteById(id);
    }
    //FROM DTO
    public Input fromDto(InputDTO objDto){
        Input obj = new Input();
        obj.setInput(objDto.getInput());
        return obj;
    }

    //Classe de incremento
    public Input incremento(Input obj){
        obj.setOutput(obj.getInput()+2);
        return obj;
    }
}
