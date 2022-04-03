package pl.musialowicz.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table( name = "footballers" )
public class Footballer implements FootballerIf
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer id;

    @Column( name = "first_name" )
    private String firstName;

    @Column( name = "last_name" )
    private String lastName;

    @Column( name = "weekly_wage" )
    private Double weeklyWage;

    @Column( name = "height" )
    private Integer height;

    @Column( name = "weight" )
    private Integer weight;

    @Column( name = "contract_expiration_date" )
    private Date contractExpirationDate;

    @Column( name = "club" )
    private String club;

    public Footballer()
    {
        // for Hibernate purpose.
    }

    public Footballer( String aFirstName, String aLastName, Double aWeeklyWage, Integer aHeight, Integer aWeight,
                       Date aContractExpirationDate, String aClub )
    {
        firstName = aFirstName;
        lastName = aLastName;
        weeklyWage = aWeeklyWage;
        height = aHeight;
        weight = aWeight;
        contractExpirationDate = aContractExpirationDate;
        club = aClub;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public String getFirstName()
    {
        return firstName;
    }

    @Override
    public void setFirstName( String aFirstName )
    {
        firstName = aFirstName;
    }

    @Override
    public String getLastName()
    {
        return lastName;
    }

    @Override
    public void setLastName( String aLastName )
    {
        lastName = aLastName;
    }

    @Override
    public Date getContractExpirationDate()
    {
        return contractExpirationDate;
    }

    @Override
    public void setContractExpirationDate( Date aContractExpirationDate )
    {
        contractExpirationDate = aContractExpirationDate;
    }

    @Override
    public Double getWeeklyWage()
    {
        return weeklyWage;
    }

    @Override
    public void setWeeklyWage( Double aWeeklyWage )
    {
        weeklyWage = aWeeklyWage;
    }

    @Override
    public Integer getHeight()
    {
        return height;
    }

    @Override
    public void setHeight( Integer aHeight )
    {
        height = aHeight;
    }

    @Override
    public Integer getWeight()
    {
        return weight;
    }

    @Override
    public void setWeight( Integer aWeight )
    {
        weight = aWeight;
    }

    @Override
    public String getClub()
    {
        return club;
    }

    @Override
    public void setClub( String aClub )
    {
        club = aClub;
    }
}
