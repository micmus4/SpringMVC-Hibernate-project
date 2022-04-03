package pl.musialowicz.dao;

import pl.musialowicz.model.Footballer;

import java.util.List;

public interface FootballerDAO
{
    List< Footballer > getFootballers();

    Footballer saveFootballer( Footballer aFootballer );

    Footballer removeFootballer( Footballer aFootballer );

    Footballer updateFootballer( Footballer aFootballer );

    Footballer getFootballer( Integer aFootballerId );
}
