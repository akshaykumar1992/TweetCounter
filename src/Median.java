import java.io.*;
import java.util.*;


public class Median {
	private Formatter x;
    
	public void getMedian(String fileName){
		
    	 
        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        double w=0;
        try {
        	double e=0;
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            int n=0;
            String line = null;
            while((line = br.readLine()) != null){
            	n++;
            	String[] tokens = line.split( " " );
    		    
    		    ArrayList< String > items = new ArrayList< String >();

    		    items.addAll( Arrays.asList( tokens ) );

    		    double count = 0,u=0,o=items.size();
    		    

    		    for( int i = 0; i < items.size(); i++ )
    		    {
    		        
    		        for( int j = 0; j < items.size(); j++ )
    		        {
    		            if( items.get( i ).equals( items.get( j ) ) )
    		                count++;
    		            if( items.get( i ).equals( items.get( j ) ) && count > 1 )
    		                items.remove( j );                      
    		            if( j== items.size()-1 && count > 1 )
    		                u++;
    		        }  
    		          		         
    		        count = 0;
    		    } 
    		    double y = o-u;
    		    e=e+y;
    		    w = e/n;
    		    System.out.println(w);
    		       }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{if(br != null) br.close();}catch(Exception ex){}
        }
    
    }


	public static void main(String[] args) throws FileNotFoundException{
		Median median = new Median();
		median.getMedian("C:/Users/akshay/Documents/GitHub/TweetCounter/TweetCounter/tweet_input/tweets.txt");
		
	    	    
	}
}
