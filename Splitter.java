import java.io.*;
class Splitter
{
   public static void main(String args[])throws IOException
   {
     Console con=System.console();
     FileInputStream fis=null;
     FileOutputStream fos=null; 
     File f=null;
     String fname=null;
     int choice=0;
     int ch=0;
     System.out.print("Enter File name\n");
     fname=con.readLine();
     f=new File(fname);
     if(!f.exists())
      {
        System.out.print("file does not exist");
        System.exit(0);
      }	
      System.out.print("Enter size to spilt the file in\n");
      int size=Integer.parseInt(con.readLine());
      int div=(int) (f.length()/size);
      System.out.println("filesize=" +div);
      try
      {
        fis= new FileInputStream(f);
        for(int i=0;i<=div;i++)
        {
          int count=0;
          String temp=String.valueOf(i)+"."+fname;
          System.out.println("loop=" + i);
          fos=new FileOutputStream(temp);
          while(true)
          {
              if(count>=size||(ch=fis.read())==-1)
              break;
              fos.write(ch);
              count++;   
          }
        }
        fis.close();     
        f.delete();
        System.out.println("File has been Spiltted");  
      }
      catch(Exception e)
      {
        System.out.println("File error");
        System.exit(0);
      }
      finally 
      {
       fis.close();
      }
  }
}            
   