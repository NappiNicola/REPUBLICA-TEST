package it.republica.REPUBLICA_TEST;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import api.APICaller;
import it.republica.getpageobject.PageObject;


public class App 
{
    public static void main( String[] args ) throws InterruptedException, ClientProtocolException, IOException
    {
    	
    	APICaller api = new APICaller();
       
    	PageObject.openConnection();
    	
    	PageObject.acceptCoockie();
    	
    	PageObject.printVideoDelGiorno();
    	
    	Thread.sleep(2000);
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
    	PageObject.closeConnection();
    	
    	api.call("https://jsonplaceholder.typicode.com/posts");
    	
    }
}
