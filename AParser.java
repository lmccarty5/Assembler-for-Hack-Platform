public class AParser{

private String toBinary(int decimal){    
     int binary[] = new int[15];    
     int index = 0;    
     while(decimal > 0){    
       binary[index++] = decimal%2;    
       decimal = decimal/2;    
     } 
     String output = "";   
     for(int i = index-1;i >= 0;i--){    
        output += binary[i];    
     }  

     int size = output.length();

     while(size<15){
        output = "0" + output;
        size++;
     }

     return output;
} //end this method


public String PA(String decimal){
  try{
  String decinumber = decimal.substring(1);
  decinumber = decinumber.replaceAll("\\s", "");
  int num =Integer.parseInt(decinumber);
  String binary = toBinary(num);
  String aInstruction = "0" + binary + "\n";
  return aInstruction;
  }
  catch(Exception e){
    return "";
  }
  
}



} //end class