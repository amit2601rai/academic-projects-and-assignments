package ranking;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.*;

public class Retrieval {
             
	public static void main(String[] args) throws Exception 
	             {
	          
	      /*************Loading Sparse Forward Index in the main memory****************/    	 
	
	        	 TreeMap<Integer,String>u = new TreeMap<Integer,String>();
            	 FileReader fin = new FileReader("sparse_forwardindex");
       	         BufferedReader br = new BufferedReader(fin);
            	 String str=null;
            	 str=br.readLine();
            	 while(str!=null)
            	 {
                   
            		 int index=str.indexOf(":");
            		 int i = Integer.valueOf(str.substring(0,index), 16).intValue();
            		 u.put(i,str.substring(index+1));
            		 str=br.readLine();
            	 }
	    
	        	
	    /*******************Loading Sparse Index in the main memory******************/
	         	 Vector<String>v = new Vector<String>();
            	 FileReader fin1 = new FileReader("sparse_index");
       	         BufferedReader br1 = new BufferedReader(fin1);
            	 String str1=null;
            	 str1=br1.readLine();
            	 while(str1!=null)
            	 {
            		 v.add(str1);
            		 str1=br1.readLine();
            	 }
	        	
	        	
      /****************************B:text,T:title,I:infobox,C:category,O:outlink************************************/
	            	 
	            	 Retrieval rak=new Retrieval();
            	     fin = new FileReader("input.txt");
            	     br = new BufferedReader(fin);
           	         FileWriter fstream = new FileWriter("output.txt");
                     BufferedWriter out = new BufferedWriter(fstream);
                     str=br.readLine();
           	         Stemmer p=new Stemmer();
           	         
           	         while(str!=null)
           	          {
           	        	 double time;
           	             time = System.currentTimeMillis();
           	             
           	       /*creating map for storing the scores corresponding to document id*/
           	            Map<String, Double> score = new HashMap<String, Double>(); 
           	           	 
           	        	int i=0,j=0;
           	        	boolean flag=false;
           	        	String[] term = new String[100];
           	        	String[] type = new String[100];
           	        	int index=str.indexOf(":");
           	        	if(index!=-1)
           	        	{
           	        	  StringTokenizer st = new StringTokenizer(str, ":");
                          while(st.hasMoreTokens())
                               {
                        	       String s=st.nextToken();
                        	     if(s.equals("T")||s.equals("C")||s.equals("I")||s.equals("O")||s.equals("B"))
                        	       {
                        	    	    type[j++]=s;
                        	    	    flag=true;
                        	       }
                        	     else
                        	       {
                        	            StringTokenizer st1 = new StringTokenizer(s, " ");
                        	            while(st1.hasMoreTokens())
                        	              {
                        	                 String s1=st1.nextToken();
                        	                  if(s1.equals("T")||s1.equals("C")||s1.equals("I")||s1.equals("O")||s1.equals("B"))
                                  	           {
                                  	    	     type[j++]=s1;
                                  	    	     flag=true;
                                  	           }
                        	                 
                        	                else{
                        	               
                        	                      if(i==j)
                        	                      {
                        	                	     if(j==0||!flag)
                        	                	      {
                        	                		     term[i++]=s1;
                                     	        	     type[j++]="T";
                                     	        	     term[i++]=s1;
                                    	        	     type[j++]="I";
                                    	        	     term[i++]=s1;
                                     	        	     type[j++]="C";
                                     	        	     term[i++]=s1;
                                    	        	     type[j++]="O";
                                    	        	     term[i++]=s1;
                                     	        	     type[j++]="B";
                                     	        	   
                                     	              }
                        	                	    else{
                        	                     	      term[i++]=s1;
                        	                	          type[j]=type[j-1];
                        	                	          j++;
                        	                	        }
                        	                	  }
                        	                 
                        	                    else
                        	                      {
                        	                         term[i++]=s1;
                        	                      }
                        	                   }
                        	              }
                            	      }
                             }//while II
           	          }
                   else
                         {
                    	        StringTokenizer st = new StringTokenizer(str, " ");
                    	        while(st.hasMoreTokens())
                                 {
                    	        	 String s=st.nextToken();
                    	        	 term[i++]=s;
                	        	     type[j++]="T";
                	        	     term[i++]=s;
                	        	     type[j++]="I";
                	        	     term[i++]=s;
                	        	     type[j++]="C";
                	        	     term[i++]=s;
                	        	     type[j++]="O";
                	        	     term[i++]=s;
                	        	     type[j++]="B";
                	        	   
                                 }
                          }	  
           	        
           	          	        	
           	       
           	           String term2[]=new String[100];	
           	           boolean T[]=new boolean[100];	
           	           boolean I[]=new boolean[100];	
           	           boolean C[]=new boolean[100];	
           	           boolean O[]=new boolean[100];	
           	           boolean B[]=new boolean[100];		
           	           int z=0;	
           	        
           	     for(int k=0;k<i;k++)
           	         {
           	        	
           	        	if(term[k]==null)continue;
           	              term2[z]=term[k];
           	              
           	              if(type[k].equals("T"))T[z]=true;
           	              else if(type[k].equals("I"))I[z]=true;
           	              else if(type[k].equals("C"))C[z]=true;
           	              else if(type[k].equals("O"))O[z]=true;
           	              else if(type[k].equals("B"))B[z]=true;
           	        	
           	        	for(int l=k+1;l<i;l++)
           	        	{
           	        		if(term[l]==null)continue;
           	               else
           	                   {
           	        	    	  if(term[k].compareTo(term[l])==0)
           	        	    	     {
           	        	    		   term[l]=null;
           	        	    		   if(type[l].equals("T"))T[z]=true;
           	        	    		   else if(type[l].equals("I"))I[z]=true;
           	        	    		   else if(type[l].equals("C"))C[z]=true;
           	        	    		   else if(type[l].equals("O"))O[z]=true;
           	        	    		   else if(type[l].equals("B"))B[z]=true;
           	        	    	    }
           	        	       }
           	        	}
           	        	z++;
           	       }	
       
           	  
       /************************ here we hav one query in structured manner*************************/          	  
           	        	Retrieval doc =new Retrieval();
           	        	BinarySearch b=new BinarySearch();
                    	String docid=null;
                    	int m;
                   	    double tf_t,tf_i,tf_c,tf_o,tf_b;
                   	    Double y;
                   	    Map<String, String> dynamic = new HashMap<String, String>(); 
                   	    for(int k=0;k<z;k++)
                           {
                             	 
                        	          int x=0;
                        	          String[] token = new String[10000000];
                        	          String store=p.stemming(term2[k].toLowerCase());
                                      String key=dynamic.get(store);
                         		      if(key==null)
                         		    	 {  
                         		    	    key=b.extract(v,store);
                         		    	    if(key!=null)dynamic.put(store,key);
                         		    	 }
                                    
                    if(key!=null){
      
                                      String delims = "[\n\t\b\r+*/\\^;:-_~\\()#@$%&,.?{}[]	<>!='|'\'\" __`'']+";
                                      StringTokenizer pars=new StringTokenizer(key,delims);
                                	while ( pars.hasMoreTokens() )
            		      			{
                                		   token[x++]=pars.nextToken();
                                		   
            		      			}
                                	int df_1=Integer.parseInt(token[1]);
                                	double df=df_1;
                                   
                                    /*double N=2930478;for 8 GB*/
                                	double N=9711597;                     	
                                	double idf=Math.log(N/df)/Math.log(2);
                                  	
                                    /*T:1000,I:70,C:40,O:20,B:5*/
                                    int w_t=1000,w_i=70,w_c=20,w_o=10,w_b=10;
                                   
                                	
                         for(int l=2;l<x;l++)
                           { 
                                   
                                      docid=doc.doc_id(token[l]);
                        	 
                                      tf_t=rak.tf(token[l],"T");
                            	      tf_i=rak.tf(token[l],"I");
                            	      tf_c=rak.tf(token[l],"C");
                            	      tf_o=rak.tf(token[l],"O");
                            	      tf_b=rak.tf(token[l],"B");
                                  if(T[k]){
                            	      if(tf_t>0)
                            	        {
                            	    	  tf_t=tf_t*w_t;
                               		      y=score.get(docid);
                               		      if(y==null)
                               		      score.put(docid, tf_t*idf);
                               		      else
                               		      score.put(docid, score.get(docid) + tf_t*idf); 
                            	        } 
                                  }
                            if(I[k]){	   
                                  if(tf_i>0)
                            	        {
                            	    	  tf_i=tf_i*w_i;
                               		      y=score.get(docid);
                               		      if(y==null)
                               		      score.put(docid, tf_i*idf);
                               		      else
                               		      score.put(docid, score.get(docid) + tf_i*idf); 
                            	        } 	
                                 } 
                            if(C[k]){	     
                                 if(tf_c>0)
                            	      {
                            	    	  tf_c=tf_c*w_c;
                               		      y=score.get(docid);
                               		      if(y==null)
                               		      score.put(docid, tf_c*idf);
                               		      else
                               		      score.put(docid, score.get(docid) + tf_c*idf); 
                            	      } 	
                                 }     
                            if(O[k]){	 
                                     if(O[k]&&tf_o>0)
                            	       {
                            	    	  tf_o=tf_o*w_o;
                               		      y=score.get(docid);
                               		      if(y==null)
                               		      score.put(docid, tf_o*idf);
                               		      else
                               		      score.put(docid, score.get(docid) + tf_o*idf); 
                            	       } 	
                                    }  
                            
                            if(B[k]){
                            	     if(tf_b>0)
                            	      {
                            	    	  tf_b=tf_b*w_b;
                               		      y=score.get(docid);
                               		      if(y==null)
                               		      score.put(docid, tf_b*idf);
                               		      else
                               		      score.put(docid, score.get(docid) + tf_b*idf); 
                            	      } 	
                                    }
                     }  //if(key!=null)   
                               
               } //for end
       }//for end
           	          
                  
  
            
           	        	
                   	   time = System.currentTimeMillis() - time;
                       out.write("Time:"+" "+time+"ms\n");	
                 
         	 /*perform sorting on values on scores(Hashmap) and find title from the docid*/
           	 
                 TitleSearch ts=new TitleSearch();
                 int check=0;
                 for (Iterator it = sortByValue(score).iterator(); it.hasNext(); ) 
                         {
                             if(check==25)break;
                	         String key = (String) it.next();
                             int l = Integer.valueOf(key, 16).intValue();
                             String title=ts.titlesearch(u,l);
                             out.write(l+"\t"+title+"\n");
                             check++; 
                            //System.out.println("docid:"+ l+"score:"+score.get(key));
                             
                         }   
                
              if(check<25)
               {
            	   while(check<25)
            	   { 
             		   out.write("NA"+"\n");
            		   check++;
            	   }
           	   
               }
               str=br.readLine();     
               score.clear();
        }//while I
           	      out.close();  
    }//function end

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

public static List sortByValue(final Map m) {
    List keys = new ArrayList();
    keys.addAll(m.keySet());
    Collections.sort(keys, new Comparator() {
        public int compare(Object o1, Object o2) {
            Object v1 = m.get(o1);
            Object v2 = m.get(o2);
            if (v1 == null) {
                return (v2 == null) ? 0 : 1;
            }
            else if (v1 instanceof Comparable) {
                return ((Comparable) v2).compareTo(v1);
            }
            else {
                return 0;
            }
        }
    });
    return keys;
}
}