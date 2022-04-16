package pl.musialowicz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.musialowicz.dao.FootballerDAO;
import pl.musialowicz.model.Footballer;

import java.util.List;

@Service
public class FootballerServiceImpl implements FootballerService
{
    @Autowired
    private FootballerDAO footballerDAO;

    @Override
    @Transactional
    public List< Footballer > getFootballers()
    {
        return footballerDAO.getFootballers();
    }

    @Override
    @Transactional
    public void addFootballer( Footballer aFootballer )
    {
        footballerDAO.addFootballer( aFootballer );
    }
}
