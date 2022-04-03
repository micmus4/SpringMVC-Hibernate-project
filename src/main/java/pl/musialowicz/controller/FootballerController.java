package pl.musialowicz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.musialowicz.dao.FootballerDAO;
import pl.musialowicz.model.Footballer;

import java.util.List;

@Controller
@RequestMapping("/")
public class FootballerController
{
    @Autowired
    private FootballerDAO footballerDAO;

    @RequestMapping("/displayFootballers" )
    public String displayFootballers( Model aModel )
    {
        final List< Footballer > footballersToDisplay = footballerDAO.getFootballers();

        aModel.addAttribute( "footballers", footballersToDisplay );

        return "displayFootballers";
    }
}
