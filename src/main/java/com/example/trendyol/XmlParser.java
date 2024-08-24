package com.example.trendyol;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {

    private static final String DB_URL = "jdbc:h2:mem:test";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";

    public void parseXml(String xmlFile) {
        try {
            // Load the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document document = factory.newDocumentBuilder().parse(xmlFile);

            // Get the root element
            Element root = document.getDocumentElement();

            // Get the database connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Create a prepared statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO mytable (name, value) VALUES (?, ?)");

            // Iterate over the elements
            NodeList elements = root.getChildNodes();
            for (int i = 0; i < elements.getLength(); i++) {
                Node node = elements.item(i);
                if (node instanceof Element) {
                    Element element = (Element) node;
                    String name = element.getTagName();
                    String value = element.getTextContent();

                    // Set the values
                    stmt.setString(1, name);
                    stmt.setString(2, value);

                    // Execute the statement
                    stmt.executeUpdate();
                }
            }

            // Close the statement and connection
            stmt.close();
            conn.close();
        } catch (ParserConfigurationException | SAXException | SQLException e) {
            // Handle the exception
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}