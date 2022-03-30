package pl.musialowicz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class CustomerController
{
    @RequestMapping("/displayCustomers")
    public String displayCustomers( Model aModel )
    {
        return "displayCustomers";
    }
}
