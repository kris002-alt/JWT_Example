package com.jwt.example.basicauth.service;

import com.jwt.example.basicauth.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
private List<User> store = new ArrayList<>();
public UserService() {
      store.add(new User(UUID.randomUUID().toString(),"Krishna","k159rishna@gmail.com"));
    store.add(new User(UUID.randomUUID().toString(),"Dijon","dijon@gmail.com"));
    store.add(new User(UUID.randomUUID().toString(),"Pradesh","pramesh@gmail.com"));
    store.add(new User(UUID.randomUUID().toString(),"Rocky","rocky@gmail.com"));
}

public List<User> getUsers() {

    return this.store;
}
}
