package pl.musialowicz.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
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
            final InputSource inputSource = new InputSource( hibernateCfgFile.getPath() );

            // we use XPath to read XML file.
            final XPath xpath = XPathFactory.newInstance().newXPath();

            // expressions to retrieve connection data from hibernate configuration file.
            final String urlExpression =
                    "hibernate-configuration/session-factory/property[@name=\"connection.url\"]/text()";
            final String usernameExpression =
                    "hibernate-configuration/session-factory/property[@name=\"connection.username\"]/text()";
            final String passwordExpression =
                    "hibernate-configuration/session-factory/property[@name=\"connection.password\"]/text()";

            final String url =
                    ((NodeList) xpath.evaluate( urlExpression, inputSource, XPathConstants.NODESET) )
                            .item( 0 ).getNodeValue();
            final String username =
                    ((NodeList) xpath.evaluate(usernameExpression, inputSource, XPathConstants.NODESET ) )
                            .item( 0 ).getNodeValue();
            final String password =
                    ((NodeList) xpath.evaluate(passwordExpression, inputSource, XPathConstants.NODESET ) )
                            .item( 0 ).getNodeValue();

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
