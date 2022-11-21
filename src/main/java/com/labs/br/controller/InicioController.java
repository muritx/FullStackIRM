package com.labs.br.controller;

import java.util.List;

import com.labs.br.entity.Cliente;
import com.labs.br.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/inicio")
    public String inicio(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();

        model.addAttribute("clientes", clientes);

        return "inicio";
    }

}
