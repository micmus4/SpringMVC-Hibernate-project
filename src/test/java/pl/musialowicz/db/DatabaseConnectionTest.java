package pl.musialowicz.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware( true );
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // retrieving hibernate configuration file from main/resources.
            final File cfgFile = new File( "src/webapp/WEB-INF/spring-mvc-servlet.xml" );
            final InputSource inputSource = new InputSource( cfgFile.getCanonicalPath() );

            // we use XPath to read XML file.
            final XPath xpath = XPathFactory.newInstance().newXPath();

            // expressions to retrieve connection data from hibernate configuration file.
            // TODO: Fix this ugly retrieving, xPath 1.0 expressions seem to suck ass and not retrieve shit.
            final XPathExpression urlExpression =
                    xpath.compile("(//@value)[4]" ); // takes value of property with name: jdbcUrl
            final XPathExpression usernameExpression =
                   xpath.compile( "(//@value)[5]" ); // takes value of property with name: user
            final XPathExpression passwordExpression =
                    xpath.compile( "(//@value)[6]" ); // takes value of property with name: password

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
            Assertions.fail( "Couldn't establish connection with database - " + aE.getClass().getName() );
        }
    }
}
