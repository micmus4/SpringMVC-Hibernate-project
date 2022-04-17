package pl.musialowicz.parameter;

import lombok.Getter;
import lombok.Setter;
import pl.musialowicz.model.Footballer;

@Getter
@Setter
public class SaveOrUpdateFootballerParameter
{
    private Footballer footballer;

    private String formName;

    private String formSubmitButtonName;

    public SaveOrUpdateFootballerParameter()
    {
        System.out.println("...");
    }

    public SaveOrUpdateFootballerParameter( final Footballer aFootballer, final EventType aEventType )
    {
        footballer = aFootballer;

        if( aEventType == EventType.ADD )
        {
            formName = "Adding Footballer";
            formSubmitButtonName = "Add";
        }
        else if ( aEventType == EventType.UPDATE )
        {
            formName = "Updating Footballer (" + footballer.getFirstName() + " " + footballer.getLastName() + ")";
            formSubmitButtonName = "Update";
        }
        else
        {
            throw new UnsupportedOperationException( "Unrecognised event type" );
        }
    }

    public enum EventType
    {
        ADD,

        UPDATE;
    }
}
