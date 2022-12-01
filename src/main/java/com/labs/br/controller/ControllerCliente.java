package com.labs.br.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.labs.br.entity.Cliente;
import com.labs.br.repository.ClienteRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/formularioclientes")
    public String criarCliente(Cliente cliente) {

        return "cadastrodeclientes";
    }

    @PostMapping("/createcliente")
    public String createCliente(@Valid Cliente cliente, BindingResult result) {

        System.out.println(cliente.getClass());

        if (result.hasFieldErrors()) {
            return "redirect:/formularioclientes";
        }

        cliente.setUltimaalteracao(new Date());

        clienteRepository.save(cliente);
        return "redirect:/historicoclientes";
    }

    @GetMapping("formularioclientes/{id}")
    public String alterarCliente(Model model, @PathVariable(name = "id") int id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));

        model.addAttribute("cliente", cliente);
        return "atualizacaodecliente";
    }

    // Atualiza funcionario
    @PostMapping("updatecliente/{id}")
    public String updateCliente(@Valid Cliente cliente, BindingResult result, @PathVariable int id) {

        if (result.hasErrors()) {
            return "redirect:/formularioclientes";
        }

        cliente.setUltimaalteracao(new Date());

        clienteRepository.save(cliente);
        return "redirect:/historicoclientes";
    }

    @GetMapping("deletecliente/{id}")
    public String deleteCliente(@PathVariable(name = "id") int id, Model model) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));

        clienteRepository.delete(cliente);
        return "redirect:/historicoclientes";
    }

    @GetMapping("/historicoclientes")
    public String listarCliente(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();

        model.addAttribute("clientes", clientes);

        return "historicodocliente";
    }

}