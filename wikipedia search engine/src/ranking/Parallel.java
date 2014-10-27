package ranking;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.xml.ws.handler.MessageContext.Scope;

public class Parallel extends Thread {
	
	    private String term;
	    private boolean  T;
	    private boolean  I;
	    private boolean  C;
	    private boolean  O;
	    private boolean  B;
	Parallel (String t1,boolean  t,boolean  i,boolean c,boolean  o,boolean b)
	   {
	      term=t1;
	      T=t;
	      I=i;
	      C=c;
	      O=o;
	      B=b;
	   }
 public void run ()
	   {
		            
    	             String docid=null;
    	             double tf_t,tf_i,tf_c,tf_o,tf_b;
   	                 Double y;
   	                 Map<String, String> dynamic = new HashMap<String, String>(); 
                     int x=0;
                     String[] token = new String[10000000];
                     
                     if(term!=null){
                	             String delims = "[\n\t\b\r+*/\\^;:-_~\\()#@$%&,.?{}[]	<>!='|'\'\" __`'']+";
                                 StringTokenizer pars=new StringTokenizer(term,delims);
                            	 while(pars.hasMoreTokens())
		                         token[x++]=pars.nextToken();
	                             int df_1=Integer.parseInt(token[1]);
	                             double df=df_1;
                               	 double N=9711597;                     	
	                             double idf=Math.log(N/df)/Math.log(2);
	                             /*T:10,I:7,C:4,O:2,B:1*/
                                 int w_t=1000,w_i=70,w_c=20,w_o=10,w_b=10;

                               for(int l=2;l<x;l++)
                                 {
                            	   docid=doc_id(token[l]);
                                   tf_t=tf(token[l],"T");
                                   tf_i=tf(token[l],"I");
                                   tf_c=tf(token[l],"C");
                                   tf_o=tf(token[l],"O");
                                   tf_b=tf(token[l],"B");
                              
                                   if(T){
                                      if(tf_t>0)
                                          {
   	                                          tf_t=tf_t*w_t;
   	                                       y=Retrieval_thread.score.get(docid);
   	                                       synchronized (Retrieval_thread.score)
   	                                        {
		                                        
		                                         if(y==null)
		                                               Retrieval_thread.score.put(docid, tf_t*idf);
		                                         else
		                                    	       Retrieval_thread.score.put(docid, Retrieval_thread.score.get(docid) + tf_t*idf); 
   	                                        }
   	                                       
   	                                       } 
                                        }
                              if(I){	   
                                     if(tf_i>0)
                                       {
   	                                      tf_i=tf_i*w_i;
   	                                   y=Retrieval_thread.score.get(docid);
   	                                 synchronized (Retrieval_thread.score)
	                                        {   
		                                        
		                                        if(y==null)
		                                        Retrieval_thread.score.put(docid, tf_i*idf);
		                                        else
		                            	        Retrieval_thread.score.put(docid, Retrieval_thread.score.get(docid) + tf_i*idf); 
	                                       }
	                                    } 	
                                   } 
                             
                              if(C){	     
                                    if(tf_c>0)
                                      {
   	                                    tf_c=tf_c*w_c;
   	                                    y=Retrieval_thread.score.get(docid);
   	                                     synchronized (Retrieval_thread.score)
                                           {
		                                     
		                                     if(y==null)
		                            	        Retrieval_thread.score.put(docid, tf_c*idf);
		                                     else
		                            	        Retrieval_thread.score.put(docid, Retrieval_thread.score.get(docid) + tf_c*idf); 
                                           } 
                                      }
                                  }     
                          
                             if(O){	 
                                   if(tf_o>0)
                                       {
   	                                      tf_o=tf_o*w_o;
   	                                   y=Retrieval_thread.score.get(docid);
   	                                     synchronized (Retrieval_thread.score)
	                                    {
		                                    if(y==null)
		                                	   Retrieval_thread.score.put(docid, tf_o*idf);
		                                    else
		                                	 Retrieval_thread.score.put(docid, Retrieval_thread.score.get(docid) + tf_o*idf); 
                                        } 	
                                     }
                               }  

                        
                            if(B){
                                   if(tf_b>0)
                                       {
   	                                           tf_b=tf_b*w_b;
   	                                        y=Retrieval_thread.score.get(docid);
   	                                        synchronized (Retrieval_thread.score)
   	                                        {
		                                       if(y==null)
		                                    	   Retrieval_thread.score.put(docid, tf_b*idf);
		                                       else
		                                    	   Retrieval_thread.score.put(docid, Retrieval_thread.score.get(docid) + tf_b*idf); 
   	                                       }
   	                                    } 	
                                 }
                   }  //if(key!=null)   
              }//for end
	    }
 


String doc_id(String docid)
 {
    int m;
	for( m=0;m<docid.length();m++)
       {
           if(docid.charAt(m)=='0' || docid.charAt(m)=='1' || docid.charAt(m)=='2' || docid.charAt(m)=='3' || 
	          docid.charAt(m)=='4' || docid.charAt(m)=='5' || docid.charAt(m)=='6' || docid.charAt(m)=='7'|| 
              docid.charAt(m)=='8' || docid.charAt(m)=='9'||docid.charAt(m)=='a' || docid.charAt(m)=='b' ||
              docid.charAt(m)=='c' || docid.charAt(m)=='d' ||docid.charAt(m)=='e' || docid.charAt(m)=='f')     		    		   
              continue;
          else  
        	  break;
      }
	  docid=docid.substring(0,m);
  return docid; 
}



public double tf(String token,String type)
{
     int index=token.indexOf(type);
     int m;
     if(index==-1) return 0;
     else
        {
    	   for(m=index+1;m<token.length();m++)
    	    {
               if(token.charAt(m)=='0' || token.charAt(m)=='1' || token.charAt(m)=='2' || token.charAt(m)=='3' || 
                  token.charAt(m)=='4' || token.charAt(m)=='5' || token.charAt(m)=='6' || token.charAt(m)=='7'||
				  token.charAt(m)=='8' || token.charAt(m)=='9')     		    		   
                     continue;
              else  
            	     break;
           }
   
 double tf=(double)Integer.parseInt(token.substring(index+1,m));

 return tf;       
 }
}
} //class end
 
 
 

