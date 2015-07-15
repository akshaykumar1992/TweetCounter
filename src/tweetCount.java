import java.io.*;
import java.util.*;
 
 
public class tweetCount {
 
    private String[] splitter;
    private int[] counter;
 
    public void countWords(String text){
         
        String temp = text.replaceAll("[\\n]", " ");
        splitter = temp.split(" ");
        
        counter= new int[splitter.length];
        
         for(int i =0; i< splitter.length; i++){
             temp = splitter[i];
                 for (int k=0; k< splitter.length; k++){
 
                    if(temp.equals(splitter[k]))
                    {
                        counter[k]++;
                    }
                }
        }
 
        printResults();
    }
 
 
    private void printResults()
    {
      
      HashMap map = new HashMap();
      
      for (int i=0; i< splitter.length; i++)
      {
          map.put(splitter[i], counter[i]);
      }
      Map sMap = new TreeMap(map);
      Iterator it = sMap.keySet().iterator();
      System.out.println("\tWord\t\t    Count");
        
        while(it.hasNext())
        {
            String temp =(String)it.next();
 
            System.out.print(temp);
 
            for (int i=0;i< (30 - temp.length());i++)
            {
                System.out.print(" ");
            }
 
            System.out.println(map.get(temp.toString()));					// printing the no. of occurrence of each word
        }
    }
 
 
 

    public static void main(String[] args) throws IOException{

    	
        File file = new File("C:/Users/akshay/Documents/GitHub/TweetCounter/TweetCounter/tweet_input/tweets.txt");
        Scanner in = new Scanner(file);
        
        tweetCount wc = new tweetCount();
        String sentence = "";
        while (in.hasNext()){
        	 String line = in.next();
        	 if(sentence.length()==0){
        		 
        	 }
        	 else 
        		 sentence = sentence.concat(" ");
        	     sentence = sentence.concat(line);
        	 
        }
       wc.countWords(sentence);
 
    }
 
}