package pl.musialowicz.model;

import java.sql.Date;

public interface FootballerIf
{
    Integer getId();

    String getFirstName();

    void setFirstName( String aFirstName );

    String getLastName();

    void setLastName( String aLastName );

    Date getContractExpirationDate();

    void setContractExpirationDate( Date aContractExpirationDate );

    Double getWeeklyWage();

    void setWeeklyWage( Double aWeeklyWage );

    Integer getHeight();

    void setHeight( Integer aHeight );

    Integer getWeight();

    void setWeight( Integer aWeight );

    String getClub();

    void setClub( String aClub );
}
