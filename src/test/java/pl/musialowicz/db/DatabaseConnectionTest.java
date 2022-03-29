package pl.musialowicz.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnectionTest
{
    @Test
    public void testConnectionWithDatabase()
    {
        try
        {
            // retrieving hibernate configuration file from main/resources.
            final File hibernateCfgFile = new File( "src/main/resources/hibernate.cfg.xml" );
            final InputSource inputSource = new InputSource( hibernateCfgFile.getCanonicalPath() );

            // we use XPath to read XML file.
            final XPath xpath = XPathFactory.newInstance().newXPath();

            // expressions to retrieve connection data from hibernate configuration file.
            final XPathExpression urlExpression =
                    xpath.compile("hibernate-configuration/session-factory/property[@name=\"connection.url\"]/text()" );
            final XPathExpression usernameExpression =
                   xpath.compile( "hibernate-configuration/session-factory/property[@name=\"connection.username\"]/text()" );
            final XPathExpression passwordExpression =
                    xpath.compile( "hibernate-configuration/session-factory/property[@name=\"connection.password\"]/text()" );

            final String url = ( (Node)urlExpression.evaluate( inputSource, XPathConstants.NODE ) ).getTextContent();
            final String username = ( (Node)usernameExpression.evaluate( inputSource, XPathConstants.NODE ) ).getTextContent();
            final String password = ( (Node)passwordExpression.evaluate( inputSource, XPathConstants.NODE ) ).getTextContent();

            // building login properties.
            final Properties properties = new Properties();
            properties.setProperty( "user", username );
            properties.setProperty( "password", password );

            // checking whether connection is established.
            final Connection connection = DriverManager.getConnection( url, properties );
            Assertions.assertFalse( connection.isClosed() );
            connection.close();
        }
        catch ( Exception aE )
        {
            Assertions.fail( "Couldn't establish connection with database." );
        }
    }
}
