package pl.musialowicz.service;

import pl.musialowicz.model.Footballer;

import java.util.List;

public interface FootballerService
{
    List< Footballer > getFootballers();

    void addFootballer( Footballer aFootballer );

    void updateFootballer( Footballer aFootballer );

    Footballer getFootballer( Integer aId );

    void deleteFootballer( Footballer aFootballer );
}
