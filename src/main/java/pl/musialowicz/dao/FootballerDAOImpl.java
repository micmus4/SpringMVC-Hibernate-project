package pl.musialowicz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.musialowicz.model.Footballer;

import java.util.List;

@Repository
public class FootballerDAOImpl implements FootballerDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List< Footballer > getFootballers()
    {
        final Session session = sessionFactory.getCurrentSession();

        final Query< Footballer > getFootballersQuery = session.createQuery( "FROM Footballer", Footballer.class );
        return getFootballersQuery.getResultList();
    }

    @Override
    public void addFootballer( Footballer aFootballer )
    {
        final Session session = sessionFactory.getCurrentSession();
        session.save( aFootballer );
    }

    @Override
    public void updateFootballer( Footballer aFootballer )
    {
        final Session session = sessionFactory.getCurrentSession();

        session.update( aFootballer );
    }

    @Override
    public Footballer getFootballer( Integer aId )
    {
        final Session session = sessionFactory.getCurrentSession();

        return session.get( Footballer.class, aId );
    }

    @Override
    public void deleteFootballer( Footballer aFootballer )
    {
        final Session session = sessionFactory.getCurrentSession();

        session.delete( aFootballer );
    }
}
