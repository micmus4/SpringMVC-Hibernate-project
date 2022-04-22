package pl.musialowicz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.musialowicz.converter.DateConverter;
import pl.musialowicz.model.Footballer;
import pl.musialowicz.parameter.SaveOrUpdateFootballerParameter;
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

    @GetMapping("/addOrUpdateFootballer" )
    public String showAddFootballerForm( @RequestParam( name = "eventType" ) String aEventType,
                                         @RequestParam( name = "footballerId", required = false) Integer footballerId,
                                         Model aModel )
    {
        final SaveOrUpdateFootballerParameter parameter;

        if( aEventType.equals( "add" ) )
        {
            parameter = new SaveOrUpdateFootballerParameter( new Footballer(),
                    SaveOrUpdateFootballerParameter.EventType.ADD );
        }
        else if ( aEventType.equals( "update" ) )
        {
            parameter = new SaveOrUpdateFootballerParameter( footballerService.getFootballer( footballerId ),
                    SaveOrUpdateFootballerParameter.EventType.UPDATE );
        }
        else
        {
            throw new UnsupportedOperationException( "Unrecognised event type." );
        }

        aModel.addAttribute( "parameter", parameter );

        return "addOrUpdateFootballer";
    }

    @PostMapping("/addOrUpdateFootballer" )
    public String addFootballer( @RequestParam( name = "eventType" ) String aEventType,
                                 @ModelAttribute( "parameter" ) SaveOrUpdateFootballerParameter aParameter )
    {
        final Footballer footballer = aParameter.getFootballer();

        if( aEventType.equals( "add" ) )
        {
            footballerService.addFootballer( footballer );
        }
        else if( aEventType.equals( "update" ) )
        {
            footballerService.updateFootballer( footballer );
        }
        else
        {
            throw new UnsupportedOperationException( "Unrecognised event type" );
        }


        return "redirect:/displayFootballers";
    }

    @GetMapping("/deleteFootballer")
    public String deleteFootballer( @RequestParam( name = "footballerId" ) Integer aFootballerId )
    {
        final Footballer footballer = footballerService.getFootballer( aFootballerId );
        footballerService.deleteFootballer( footballer );

        return "redirect:/displayFootballers";
    }

    @DeleteMapping("/deleteFootballer")
    public String deleteFootballer2( @RequestParam( name = "footballerId" ) Integer aFootballerId )
    {
        final Footballer footballer = footballerService.getFootballer( aFootballerId );
        footballerService.deleteFootballer( footballer );

        return "redirect:/displayFootballers";
    }

    @InitBinder
    protected void initBinder( WebDataBinder aBinder )
    {
        aBinder.registerCustomEditor( Date.class, new DateConverter() );
    }
}
