package com.work.spring_project.models.services;

import com.work.spring_project.models.Role;
import com.work.spring_project.models.User;
import com.work.spring_project.models.repositories.RoleRepo;
import com.work.spring_project.models.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean saveUser(User user, int role){
        User other = userRepo.findByUsername(user.getUsername());

        if (other != null){
            return false;
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(role == 1) {
            user.setRoles(Collections.singleton(new Role(1L, "USER")));
        } else if(role == 2) {
            user.setRoles(Collections.singleton(new Role(2L, "MANAGER")));
        }
        userRepo.save(user);

        return true;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername((username));

        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }

        return user;
    }
}
