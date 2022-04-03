package pl.musialowicz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.musialowicz.model.Footballer;

import java.util.List;

@Repository
public class FootballerDAOImpl implements FootballerDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Footballer> getFootballers()
    {
        final Session session = sessionFactory.getCurrentSession();

        final Query< Footballer > getFootballersQuery = session.createQuery( "from Footballer", Footballer.class );
        return getFootballersQuery.getResultList();
    }

    @Override
    public Footballer saveFootballer( Footballer aFootballer )
    {
        return null;
    }

    @Override
    public Footballer removeFootballer( Footballer aFootballer )
    {
        return null;
    }

    @Override
    public Footballer updateFootballer( Footballer aFootballer )
    {
        return null;
    }

    @Override
    public Footballer getFootballer( Integer aFootballerId )
    {
        return null;
    }
}
