import java.io.*;
class Merger
{ 
  public static void main(String args[])throws IOException     
   {  
       Console con=System.console();
       FileInputStream fis=null;
       FileOutputStream fos=null; 
       File f=null;
       String fname=null;
       int ch=0;
       System.out.println("Enter file name to merge");
       fname=con.readLine();
       f=new File(fname);
       try
       {
         int i=0;  
         String tname=i+"."+fname;
         File tf=new File(tname); 
         FileInputStream tfis=null;
         fos=new FileOutputStream(fname,true);
         while(tf.exists())
         {
            tfis=new FileInputStream(tf);
            while((ch=tfis.read())!=-1)
            {
                 fos.write(ch);
            }
            tfis.close();
           // System.out.println(tfis.read());
            if(tf.delete())
               System.out.println("File deleted");
            i++;
            tname=i+"."+fname;
            tf=new File(tname);
         } 
         System.out.println("File has been Merged");
       }   
       catch(Exception e)
       {
         System.out.println("IN CATCH");
         System.out.println("ERROR");
         System.out.println(e.getMessage());
       }
       finally 
       {
         fos.close();
       }
  }
}