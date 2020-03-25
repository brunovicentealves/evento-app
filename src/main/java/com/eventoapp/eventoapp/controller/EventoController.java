package com.eventoapp.eventoapp.controller;

import com.eventoapp.eventoapp.model.Evento;
import com.eventoapp.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastrarEvento")
public class EventoController {
    @Autowired
    private EventoRepository er;


    @GetMapping
    public String form(){

    return "formEvento";
    }


    @PostMapping
    public String form(Evento evento){
        er.save(evento);
        return "redirect:/cadastrarEvento";
    }


    @GetMapping("/")
    public ModelAndView listaEventos(){
    ModelAndView mv = new ModelAndView("templates/formEvento.html");

    mv.addObject("eventos",er.findAll());

    return mv;

    }



}
