package com.pablovfds.backend.services.impl;

import com.pablovfds.backend.exceptions.EntityNotFoundException;
import com.pablovfds.backend.model.User;
import com.pablovfds.backend.repositories.UserRepository;
import com.pablovfds.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User edit(User user) throws EntityNotFoundException {

       User oldUser = this.findOne(user.getId());

       oldUser.setEmail(user.getEmail());
       oldUser.setFirstName(user.getFirstName());
       oldUser.setLastName(user.getLastName());
       oldUser.setUsername(user.getUsername());

        return this.userRepository.save(oldUser);
    }

    @Override
    public void remove(String id) throws EntityNotFoundException {
        User user = this.findOne(id);
        this.userRepository.delete(user);
    }

    @Override
    public User findOne(String id) throws EntityNotFoundException {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found for this id :: " + id));
    }

    @Override
    public Page<User> find(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

}
