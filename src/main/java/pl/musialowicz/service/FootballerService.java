package pl.musialowicz.service;

import pl.musialowicz.model.Footballer;

import java.util.List;

public interface FootballerService
{
    List< Footballer > getFootballers();

    void addFootballer( Footballer aFootballer );
}
