//Comments
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*; 
import java.util.*;



//Class declaration
class Main {

  
private static int toBinary(int decimal){    
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

     int foutput = Integer. valueOf(output);

     return foutput;
} //end this method

  
  //Main Method:
  public static void main(String[] args) {

    //Step 0: setup some variables
    ArrayList<String> instructions = new ArrayList<String>();

    //symbol arraylist 
    ArrayList<Symbol> symbols = new ArrayList<Symbol>();

  


    //Step 1: Ask the user which file we are opening within the project
    Scanner input = new Scanner(System.in);
    System.out.println("Enter which file we are opening within the project");
    String fileName = input.nextLine();

    //Get file name from input
    int num = fileName.indexOf(".");
    String name = fileName.substring(0,num);



    //Step 2: Pull the contents of the file and place them into a string and arraylist

    //TODO: ADD THE ARRAYLIST
    try{ //try catch notation to avoid crashes

     

      //read specified file contents
      File assemblyLanguageFile = new File(fileName);




      Scanner myReader = new Scanner(assemblyLanguageFile);
      String contents = ""; 
      while (myReader.hasNextLine()) {
            String data = myReader.nextLine();         
            if(data.indexOf("/") > -1){ 
              data = data.substring(0,data.indexOf("/"));
            }
              instructions.add(data);
              contents = contents + data + "\n";
            
      }
      myReader.close();
      
    //print contents
    System.out.println(contents);

    }
    //protocol for file reading failure
    catch(Exception e){
      System.out.println("Unable to find file or open it.");
      System.out.println(e);
    }
    
    //Create final file
      String finalname = name + ".hack";
      File machineCode = new File(finalname); 
      System.out.println("file created");

    try{
      //clear file contents
      new FileWriter(finalname, false).close();
    }
    catch(Exception e){
      System.out.println("unable to clear file contents");
    }

/*
    for(int i = 0; i<instructions.size(); i++){
        if(instructions.get(i).equals("") || instructions.get(i).equals(null)){
          instructions.remove(i);
        }
    }
        while (instructions.remove(null)) { 
        } 

    System.out.println("-" + instructions.get(2) + "-");
    if(instructions.get(2).equals("")){
      System.out.println("java is not crazy");
      instructions.remove(2);
    }
    
    System.out.println(instructions);
    instructions.removeAll(null);
    instructions.remove("");
    instructions.remove(null);
    instructions.remove("\n");
    System.out.println(instructions);

    System.out.println("ArrayList Before : " + numbers);

*/  
    

System.out.println(instructions);
System.out.println("removing whitespace...");

Iterator<String> itr = instructions.iterator();

// remove all even numbers
while (itr.hasNext()) {
    String thing = itr.next();

       if (thing.equals("")) {
       itr.remove();
    }

}

System.out.println(instructions);

//scan through current insructions and look for ()
int scount = 0;
for (String x: instructions){
  if (x.contains("(")){
     String sname = x.substring(1,x.length()-1);
     String svalue = String.valueOf(scount);
     Symbol newSymbol = new Symbol(sname,svalue);
     symbols.add(newSymbol);
  }
  scount++;
}



int symbolCount = 0;
for(Symbol s: symbols){
  System.out.println();
  String sname2 = "@" + s.GN();
    System.out.println("Detected symbol name: " + sname2);
  String svalue2 = Integer.toString(symbolCount);
    System.out.println("symbol number in symbolist: " + svalue2);


    System.out.println("symbol number in insructions: " + s.GL());

  int deciValue = Integer.valueOf(s.GL()) + 1 - Integer.valueOf(svalue2);
  System.out.println("symbol decimal  value: " + deciValue);





  int binvalue = toBinary(deciValue);

    System.out.println("symbol binary  value: " + deciValue);


  String bv = "@" + deciValue;
  Collections.replaceAll(instructions,sname2, bv); 
  symbolCount++;
  System.out.println();
}

// take what is insiece () and the place of the instruciton within the arraylist and place it into a new symbol objects


//add symbol object to arraylist


//replace all instances of symbol with correct number




    //write to file
    try{
    FileWriter vr = new FileWriter(machineCode, true);
    BufferedWriter bp = new BufferedWriter(vr);

    
    //create parser objects
    AParser AP = new AParser();
    CParser CP = new CParser();


    //Arraylist for variables
    ArrayList<Variable> Variables = new ArrayList<Variable>();


           

              Collections.replaceAll(instructions,"@R0","@0"); 
              Collections.replaceAll(instructions,"@R1","@1"); 
              Collections.replaceAll(instructions,"@R2","@2"); 
              Collections.replaceAll(instructions,"@R3","@3"); 
              Collections.replaceAll(instructions,"@R4","@4"); 
              Collections.replaceAll(instructions,"@R5","@5"); 
              Collections.replaceAll(instructions,"@R6","@6"); 
              Collections.replaceAll(instructions,"@R7","@7"); 
              Collections.replaceAll(instructions,"@R8","@8"); 
              Collections.replaceAll(instructions,"@R9","@9"); 
              Collections.replaceAll(instructions,"@R10","@10"); 
              Collections.replaceAll(instructions,"@R11","@11"); 
              Collections.replaceAll(instructions,"@R12","@12"); 
              Collections.replaceAll(instructions,"@R13","@13"); 
              Collections.replaceAll(instructions,"@R14","@14"); 
              Collections.replaceAll(instructions,"@R15","@15"); 
              Collections.replaceAll(instructions,"@SCREEN","@16384");
              Collections.replaceAll(instructions,"@KBD","@24576"); 
              Collections.replaceAll(instructions,"@SP","@0"); 
              Collections.replaceAll(instructions,"@LCL","@1");
              Collections.replaceAll(instructions,"@ARG","@2"); 
              Collections.replaceAll(instructions,"@THIS","@3"); 
              Collections.replaceAll(instructions,"@THAT","@4"); 
            
            

   //CATALOGING Variables LOOP
   int b = 0;
    for(String x:instructions){
      boolean isCreated = false;
      //indentifying A vs c instructions
      
      try{
        boolean isVar = false;
        
        if (x.charAt(0)=='@'){
          //determine if the @ instruction is actaully a variable
          try{
  

          String decinumber = x.substring(1);
          decinumber = decinumber.replaceAll("\\s", "");
          int val =Integer.parseInt(decinumber);
          }
          catch(Exception e){

           
            
              isVar = true;
            
          }

          if(isVar == true){
          //we need to check the name against our list/catalog to make sure we haven't already created an etry for this variable
            for(int i =0; i<Variables.size(); i++){
              String n=(Variables.get(i)).GN();
              if (x.indexOf(n)>-1){
                isCreated=true;
              }
              
            } //end if
           // end loop
          
          

          //assuming there is no entry, we need to create a new one. If there is an existing entry, we need to modify this instruction to be the number associated with said entry
          if(isCreated == false){
            String nameR = x.substring(1);
            int valR = Variables.size() + 16;
            String value = Integer.toString(valR);
            Variable v = new Variable(nameR, value);
            Variables.add(v);


            //now replace this line of code in the asm instruction list
              String replacenum = "";
              for(Variable p:Variables){
                String nameR2 = x.substring(1);
                if(p.GN().contains(nameR2)){
                  replacenum  = p.GV();
                }
              }
              String replacer = "@" + replacenum;
              instructions.set(b,replacer);


          }
          else{
              String replacenum = "";
              for(Variable p:Variables){
                String nameR = x.substring(1);
                if(p.GN().contains(nameR)){
                  replacenum  = p.GV();
                }
              }
              String replacer = "@" + replacenum;
              instructions.set(b,replacer);

          }



        }

        }
        
        else if (x.contains("=")||x.contains(";")){ }}catch(Exception e){} b++;}








    //simple translation loop
    for(String x:instructions){
      //indentifying A vs c instructions
      try{
        if (x.charAt(0)=='@'){
          //add variable processing here
          String translation = AP.PA(x);
          bp.write(translation);
        }
        else if (x.contains("=")||x.contains(";")){
          String translation = CP.PC(x);
          bp.write(translation);
        }

        //another else if to handle symbol processing
      }
      catch(Exception e){


      }
    }




    bp.close();
    vr.close();
    System.out.println("file written");
    }
    catch(Exception e){
      System.out.println("unable to write to file");
      System.out.println(e);
    }


  }
}