import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class data{
	
	
	ArrayList <String> cat;
	ArrayList <String> unit;
	ArrayList <Float> coef;
	
	public data(String c,String u, String coe) {
		try{
		FileWriter fichier = new FileWriter("fichier.txt", true);
	       fichier.write (c+";"+u+";"+coe);
	       fichier.write("\n"); 
	       
	    
	   fichier.close();}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public data(){
		
        cat =  new ArrayList <String>();
		unit = new ArrayList <String>();
		coef = new ArrayList <Float>();
        
        
        try{       
        String filePath = "fichier.txt";

                Scanner scanner = new Scanner(new File(filePath));
                
        // On boucle sur chaque champ detecté
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] line1 = line.split(";");
            
            
      	    Float c = Float.parseFloat(line1[2]);
            cat.add(line1[0]);
            unit.add(line1[1]);
            coef.add(c);
            
            
            System.out.println(line);
            //faites ici votre traitement
        }
        scanner.close();
        }catch (FileNotFoundException e) { System.out.println("kaka");
      	}
	}
	
	
	public ArrayList <String> getcat() {
		
		ArrayList <String> cattmp= new ArrayList <String>();
				
		cattmp.add(cat.get(0));	
		
		for(int i = 1 ; i <cat.size() ; i++){
	    			
	    		if(! cat.get(i).equals(cat.get(i-1)))
                {
	    			cattmp.add(cat.get(i));}
  				}
		return cattmp;
		}
	
	
	public ArrayList <String> getunit(Object cat0) {
		
		ArrayList <String> unittmp= new ArrayList <String>();
    	for (int i = 0 ; i <cat.size() ; i++){
    		if( cat.get(i).equals(cat0))
            {
    			unittmp.add(unit.get(i));}
				}
		
		return unittmp;
		}
	
	public Float getcoef(Object cat0 , Object unit0) {

		Float rtmp = (float) 0;
    	for (int i = 0 ; i <cat.size() ; i++){
			
    		if( cat.get(i).equals(cat0) &&  unit.get(i).equals(unit0))
            {
    			rtmp= coef.get(i);
				}
		}
    	return rtmp;
	}
}
