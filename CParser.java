
public class CParser{

  public String PC(String C){
    String fl = "";
    String a = "";
    String IS1 = "111";
    String IS2 = "";
    String IS3 = "";
    String IS4 = "";


    //jump inscurction ifs

    if(C.indexOf("JGT")>=0){
      IS4="001";
    }

    else if(C.indexOf("JEQ")>=0){
      IS4="010";
    }
  
    else if(C.indexOf("JGE")>=0){
      IS4="011";
    }

    else if(C.indexOf("JLT")>=0){
      IS4="100";
    }

    else if(C.indexOf("JNE")>=0){
      IS4="101";
    }

    else if(C.indexOf("JLE")>=0){
      IS4="110";
    }
  
    else if(C.indexOf("JMP")>=0){
      IS4="111";
    }
    
    else{
      IS4="000";
    }


    //d instruction ifs
    if (C.indexOf("MD")>=0){
      IS3="011";
    }

    else if (C.indexOf("AM")>=0){
      IS3="101"; 
    }

    else if (C.indexOf("AD")>=0){
      IS3="110"; 
    }

    else if (C.indexOf("AMD")>=0 ){
      IS3="111"; 
    }

    else if (C.indexOf("D")>=0  && (C.indexOf("D")<C.indexOf("="))){
      IS3="010";
    }

    else if (C.indexOf("A")>=0  && (C.indexOf("A")<C.indexOf("="))){
      IS3="100"; 
    }

    else if(C.indexOf("M")>=0  && (C.indexOf("M")<C.indexOf("="))){
      IS3="001";
    }

    else{
      IS3="000";
    }



  //A=M+D:JMP    
  //M=D  
  //M;JMP

  //Tokenize c instructions here
  String comStatement = "";

  if(C.indexOf(";")>-1 && C.indexOf("=")>-1){
    comStatement = C.substring(C.indexOf(";")+1, C.indexOf("="));  
  }

  if(!(C.indexOf(";")>-1) && (C.indexOf("=")>-1)){
    comStatement = C.substring(C.indexOf("=")+1); 
  }

  if((C.indexOf(";")>-1) && !(C.indexOf("=")>-1)){
    comStatement = C.substring(0, C.indexOf(";")); 
  }

 
    // c inscruction ifs


    if(comStatement.indexOf("D+1")>=0){
      IS2 = "011111";
      a="0";
    }

    else if(comStatement.indexOf("D+1")>=0){
      IS2 = "011111";
      a="0";
    }

    else if(comStatement.indexOf("A+1")>=0){
      IS2 = "110111";
      a="0";
    }

    else if(comStatement.indexOf("M+1")>=0){
      IS2 = "110111";
      a="1";
    }

    else if(comStatement.indexOf("D-1")>=0){
      IS2 = "001110";
      a="0";
    }

    else if(comStatement.indexOf("A-1")>=0){
      IS2 = "110010";
      a="0";
    }
    
    
    else if(comStatement.indexOf("M-1")>=0){
      IS2 = "110010";
      a="1";
    }

    
    else if(comStatement.indexOf("D+A")>=0){
      IS2 = "000010";
      a="0";
    }

    else if(comStatement.indexOf("D+M")>=0){
      IS2 = "000010";
      a="1";
    }

    else if(comStatement.indexOf("D-A")>=0){
      IS2 = "010011";
      a="0";
    }

    else if(comStatement.indexOf("D-M")>=0){
      IS2 = "010011";
      a="1";
    }

    else if(comStatement.indexOf("A-D")>=0){
      IS2 = "010011";
      a="0";
    }

    else if(comStatement.indexOf("M-D")>=0){
      IS2 = "000111";
      a="1";
    }

    else if(comStatement.indexOf("D&A")>=0){
      IS2 = "000000";
      a="0";
    }

    else if(comStatement.indexOf("D&M")>=0){
      IS2 = "000000";
      a="1";
    }

    else if(comStatement.indexOf("D|A")>=0){
      IS2 = "010101";
      a="0";
    }

    else if(comStatement.indexOf("D|M")>=0){
      IS2 = "010101";
      a="1";
    }
    
    else if(comStatement.indexOf("D")>=0){
      IS2 = "001100";
      a="0";
    }

    else if(comStatement.indexOf("A")>=0){
      IS2 = "110000";
      a="0";
    }

    else if(comStatement.indexOf("M")>=0){
      IS2 = "110000";
      a="1";
    }

    else if(comStatement.indexOf("0")>=0){
      IS2 = "101010";
      a="0";
    }

    else if(comStatement.indexOf("-1")>=0){
      IS2 = "111010";
      a="0";
    }

    else if(comStatement.indexOf("1")>=0){
      IS2 = "111111";
      a="0";
    }


        else if(comStatement.indexOf("!D")>=0){
      IS2 = "001101";
      a="0";
    }
    
    else if(comStatement.indexOf("!A")>=0){
      IS2 = "110001";
      a="0";
    }

    else if(comStatement.indexOf("!M")>=0){
      IS2 = "110001";
      a="1";
    }
    
    else if(comStatement.indexOf("-D")>=0){
      IS2 = "001111";
      a="0";
    }

    else if(comStatement.indexOf("-A")>=0){
      IS2 = "110011";
      a="0";
    }

    else if(comStatement.indexOf("-M")>=0){
      IS2 = "110011";
      a="1";
    }
    
    
    

    fl =  IS1 + a +  IS2  + IS3 + IS4 + "\n";

    return fl;



  }// end method

  
  
}