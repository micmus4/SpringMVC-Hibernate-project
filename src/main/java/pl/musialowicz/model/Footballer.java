package pl.musialowicz.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table( name = "footballers" )
@Getter
@Setter
public class Footballer implements FootballerIf
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    @Setter( value = AccessLevel.NONE )
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
}
