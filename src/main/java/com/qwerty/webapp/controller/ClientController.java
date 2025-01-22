package com.qwerty.webapp.controller;


import com.qwerty.webapp.models.Client;
import com.qwerty.webapp.models.ClientDto;
import com.qwerty.webapp.repositories.ClientRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping({"","/"})
    public String getClients(Model model) {     //model used to pass the data from controller to view

        //here sorting the list of clients using "Sort.by(Sort.Direction.DESC,"id")"
        var client = clientRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        model.addAttribute("clients", client);
        return "clients/index";
    }

    @GetMapping("/create")
    public String createClient(Model model) {
        ClientDto clientDto = new ClientDto();
        model.addAttribute("clientDto",clientDto);
        return "clients/create";
    }

    //here @Valid siignifies the validation errors
    @PostMapping("/create")
    public String createClient(@Valid @ModelAttribute ClientDto clientDto,
                               BindingResult result) {

        if(clientRepository.findByEmail(clientDto.getEmail()) != null){
            result.addError(
                    new FieldError("clientDto", "email", "Email already exists")
            );
        }
        if(result.hasErrors()) {
            return "clients/create";
        }

        Client client = new Client();
        client.setFirstname(clientDto.getFirstName());
        client.setLastname(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAddress(clientDto.getAddress());
        client.setStatus(clientDto.getStatus());
        client.setCreatedAt(new Date());
        clientRepository.save(client);

        return "redirect:/clients";
    }


    @GetMapping("/edit")
    public String editClient(Model model,@RequestParam int id ) {

    Client client = clientRepository.findById(id).orElse(null);

    if(client == null){
        return "redirect:/clients";
    }

    ClientDto clientDto = new ClientDto();

    clientDto.setFirstName(client.getFirstname());
    clientDto.setLastName(client.getLastname());
    clientDto.setEmail(client.getEmail());
    clientDto.setPhone(client.getPhone());
    clientDto.setAddress(client.getAddress());
    clientDto.setStatus(client.getStatus());
    model.addAttribute("client",client);
    model.addAttribute("clientDto",clientDto);

    return "/clients/edit";

    }

    @PostMapping("/edit")
    public String editClient(Model model  ,@RequestParam int id ,@Valid @ModelAttribute ClientDto clientDto, BindingResult result) {

        Client client = clientRepository.findById(id).orElse(null);
        if(client == null){
            return "redirect:/clients";
        }

        model.addAttribute("client",client);



        if(result.hasErrors()) {
            model.addAttribute("clientDto", clientDto);
            return "clients/edit";
        }

        //updating the clients detail
        client.setFirstname(clientDto.getFirstName());
        client.setLastname(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAddress(clientDto.getAddress());
        client.setStatus(clientDto.getStatus());

        try{
            //if email is duplicate then it may show an exception (email should be unique in database)
            clientRepository.save(client);
        }catch(Exception e){
            result.addError(
                    new FieldError("clientDto", "email", clientDto.getEmail(),false ,null ,null ,"Email already exists")
            );
            return "clients/edit";
        }

        return "redirect:/clients";
    }

    @GetMapping("/delete")
    public String deleteClient(@RequestParam int id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            clientRepository.delete(client);
        }
        return "redirect:/clients";
    }

}
