package pl.musialowicz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.musialowicz.model.Footballer;
import pl.musialowicz.service.FootballerService;

import java.util.List;

@Controller
@RequestMapping("/")
public class FootballerController
{
    @Autowired
    private FootballerService footballerService;

    @GetMapping("/displayFootballers" )
    public String displayFootballers( Model aModel )
    {
        final List< Footballer > footballersToDisplay = footballerService.getFootballers();

        aModel.addAttribute( "footballers", footballersToDisplay );

        return "displayFootballers";
    }
}
