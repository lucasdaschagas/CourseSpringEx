package com.educandoweb.course.services;


import com.educandoweb.course.entities.User;
import com.educandoweb.course.exception.ControllerNotFoundException;
import com.educandoweb.course.exception.DataBaseException;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById (Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ControllerNotFoundException(id));
    }

    public User insert (User obj){
        return repository.save(obj);
    }
    public void delete( Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e)
        {throw new  ControllerNotFoundException(id);
    }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }
    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity,obj);
        return repository.save(entity);

    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getName());
        entity.setPhone(obj.getName());
    }
}
