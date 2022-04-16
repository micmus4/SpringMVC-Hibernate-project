package pl.musialowicz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.musialowicz.converter.DateConverter;
import pl.musialowicz.model.Footballer;
import pl.musialowicz.service.FootballerService;

import java.sql.Date;

@Controller
@RequestMapping("/")
public class FootballerController
{
    @Autowired
    private FootballerService footballerService;

    @GetMapping("/displayFootballers" )
    public String displayFootballers( Model aModel )
    {
        aModel.addAttribute( "footballers", footballerService.getFootballers() );

        return "displayFootballers";
    }

    @GetMapping("/addFootballer" )
    public String showAddFootballerForm( Model aModel )
    {
        aModel.addAttribute( "newFootballer", new Footballer() );

        return "addFootballer";
    }

    @PostMapping("/addFootballer" )
    public String addFootballer( @ModelAttribute( "newFootballer" ) Footballer aNewFootballer )
    {
        footballerService.addFootballer( aNewFootballer );

        return "redirect:/displayFootballers";
    }

    @InitBinder
    protected void initBinder( WebDataBinder aBinder )
    {
        aBinder.registerCustomEditor( Date.class, new DateConverter() );
    }
}
