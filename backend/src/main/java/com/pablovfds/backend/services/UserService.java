package com.pablovfds.backend.services;

import com.pablovfds.backend.exceptions.EntityNotFoundException;
import com.pablovfds.backend.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);
    User edit(User user) throws EntityNotFoundException;
    void remove(String id) throws EntityNotFoundException;
    User findOne(String id) throws EntityNotFoundException;
    Page<User> find(Pageable pageable);
}
