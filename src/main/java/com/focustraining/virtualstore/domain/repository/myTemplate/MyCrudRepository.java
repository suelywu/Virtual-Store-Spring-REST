package com.focustraining.virtualstore.domain.repository.myTemplate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.focustraining.virtualstore.domain.repository.myTemplate.MyT;

public class MyCrudRepository {

    /*
    count()
    delete(T entity)
    deleteAll()
    deleteAll(Iterable<? extends T> entities)
    deleteById(int id)
    existsById(int id)
    findAll()
    findAllById(Iterable<int> ids)
    findById(int id)
    save(S entity)          (S extends T)
    saveAll(Iterable<S> entities)
     */

    List<MyT> list;

    public MyCrudRepository() {
        list = new LinkedList<>();
    }

    public int count() {
        return list.size();
    }

    public void delete(MyT entity) {
        list.remove(entity);
    }

    public void deleteById(int id) {
        list.removeIf(t -> t.equals(id));
    }

    public boolean existsById(int id) {
        return list.stream().anyMatch(t -> t.equals(id));
    }

    public List<MyT> findAll() {
        return Collections.unmodifiableList(list);
    }

    public MyT findById(int id) {
        return list.stream().filter(t -> t.equals(id)).findFirst().orElse(null);
    }
    
    public void save(MyT entity) {
        list.add(entity);
    }
    
    private void addEntity(MyT entity) {
        list.add(entity);
    }
    
    private void updateEntity(MyT entity) {
        // tiro o antigo
        // coloco o novo
        
        
    }
}
