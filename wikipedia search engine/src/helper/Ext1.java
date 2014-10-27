package helper;

import java.io.*;

public class Ext1 {
	String line="";
	public void run()
	{
		try{
			BufferedReader in = new BufferedReader(new FileReader("finalindex/result_0"));//should be hard coded name primary index
			BufferedWriter op = new BufferedWriter(new FileWriter("mainIndex"));
			while((line=in.readLine()) != null)
			{
				int pos = line.indexOf(':');
				String tempstr=line.substring( 0,pos );
				int pos1 = line.indexOf(':',pos+1);
				int df = Integer.parseInt( line.substring( pos+1, pos1) );
				if(df > 35000)
				{
					op.write(tempstr+":"+df+":");
					String []token = (line.substring(pos1+1) ).split("\\|");
					int check=0;
					for(int i=0;i<token.length;i++)
					{
						String cur=token[i];
						//System.out.println(cur);
						int count=0,len=cur.length();
						boolean dirty = false;
						for(int j=0;j<cur.length();j++)
						{
							if(token[i].charAt(j)>='A' && token[i].charAt(j)<='Z' )
							{
								count++;
								if(count == 1 && j==len-2 && cur.charAt(j) == 'B' && cur.charAt(len-1)=='1')
								{
									dirty=true;
									break;
								}
							}
						}
						if(!dirty)
						{
							if(check==0)
							{
								op.write(cur);
								check=1;
							}
						
							else		op.write("|"+cur);
							
								
						}
					}
					op.write("\n");
				}
				else
				{
					op.write(line+"\n");
				}
				
			}
			in.close();
			op.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	   {
		// TODO Auto-generated method stub
		   Ext1 e =new Ext1();
		   e.run();
	   }

}