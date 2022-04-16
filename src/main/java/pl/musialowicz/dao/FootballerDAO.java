package pl.musialowicz.dao;

import pl.musialowicz.model.Footballer;

import java.util.List;

public interface FootballerDAO
{
    List< Footballer > getFootballers();

    void addFootballer( Footballer aFootballer );
}
