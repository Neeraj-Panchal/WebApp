package com.qwerty.webapp.repositories;

import com.qwerty.webapp.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

//here client is the model and Integer indicates the primary key i.e "id"
public interface ClientRepository extends JpaRepository<Client, Integer> {

    public Client findByEmail(String email);
}
