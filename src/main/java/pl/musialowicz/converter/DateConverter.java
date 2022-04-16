package pl.musialowicz.converter;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class DateConverter extends PropertyEditorSupport
{
    @Override
    public void setAsText( String aText ) throws IllegalArgumentException
    {
        if( aText == null || aText.isEmpty() )
        {
            setValue( null );
        }
        else
        {
            final String[] dateParts = aText.split( "-" );

            final int year = Integer.parseInt( dateParts[ 0 ] ) - 1900; // see java.sql.Date constructor!
            final int month = Integer.parseInt( dateParts[ 1 ] );
            final int day = Integer.parseInt( dateParts[ 2 ] );

            setValue( new Date( year, month, day ) );
        }
    }

    @Override
    public String getAsText()
    {
        return ( getValue() == null ) ? null : getValue().toString();
    }
}
