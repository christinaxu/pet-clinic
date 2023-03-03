package com.springframework.petclinic.services.map;

import com.springframework.petclinic.models.BaseEntity;
import com.springframework.petclinic.services.CrudService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public abstract class AbstractServiceMap<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
    private Map<Long,T> map = new HashMap<Long,T>();

    public Map<Long, T> getMap() {
        return map;
    }

    @Override
    public Set<T> findAll(){
        return new HashSet(map.values());
    };

    @Override
    public T findById(ID id){
        return (T)map.get(id);
    }

    @Override
    public T save(T object){
        if(object!=null){
            if(object.getId()==null){
                object.setId(getId());
            }
            map.put(object.getId(),object);
        }else{
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    @Override
    public void delete(T object){
        map.entrySet().removeIf(entry ->entry.getValue().equals(object));
    }

    @Override
    public void deleteById(ID id){
        map.remove(id);
    }

    /*automatically generate ID*/
    public Long getId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        }catch(NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }

}
