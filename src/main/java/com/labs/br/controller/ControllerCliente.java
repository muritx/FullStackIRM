package com.labs.br.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.labs.br.entity.Cliente;
import com.labs.br.repository.ClienteRepository;

@Controller
public class ControllerCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/form")
    public String pessoasForm(Cliente cliente) {

        return "cadastrodeclientes";
    }

    @PostMapping("/add")
    public String novo(@Valid Cliente cliente, BindingResult result) {

        System.out.println(cliente.getClass());

        if (result.hasFieldErrors()) {
            return "redirect:/form";
        }

        clienteRepository.save(cliente);

        return "redirect:/inicio";
    }

    @GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable(name = "id") int id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));

        model.addAttribute("cliente", cliente);
        return "atualizaForm";
    }

    // Atualiza funcionario
    @PostMapping("update/{id}")
    public String alterarProduto(@Valid Cliente cliente, BindingResult result, @PathVariable int id) {

        if (result.hasErrors()) {
            return "redirect:/form";
        }

        clienteRepository.save(cliente);
        return "redirect:/inicio";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(name = "id") int id, Model model) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));

        clienteRepository.delete(cliente);
        return "redirect:/inicio";
    }
}
