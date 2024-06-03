package it.republica.REPUBLICA_TEST;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;

import api.APICaller;
import it.republica.getpageobject.PageObject;


public class App 
{
    public static void main( String[] args ) throws InterruptedException, ClientProtocolException, IOException, ParseException
    {
    	
    	APICaller api = new APICaller();
       
    	PageObject.openConnection();
    	
    	PageObject.acceptCoockie();
    	
    	PageObject.printVideoDelGiorno();
    	
    	PageObject.printH1();
    	PageObject.printH2();
    	
    	Thread.sleep(2000);
    	PageObject.getMenuObjectSectionList();
    	Thread.sleep(2000);
    	PageObject.scrollMenu();
    	Thread.sleep(2000);
    	PageObject.closeMenù();
    	
    	Thread.sleep(2000);
    	PageObject.scrollFull();
    	
    	PageObject.findInSearchBar("Informatica");
    	Thread.sleep(1000);
    	
    	PageObject.goToHomePage();
    	Thread.sleep(2000);
    	PageObject.highlight();
    	
    	PageObject.closeConnection();
    	
    	api.call("https://jsonplaceholder.typicode.com/posts");
    	
    }
}
