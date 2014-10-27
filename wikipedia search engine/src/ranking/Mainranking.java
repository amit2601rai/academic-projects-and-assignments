package ranking;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Mainranking {
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
            	 }//after getting the closest id we perform linear search
	    
	        	
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
            	  }//after getting the closest word perform linear search
	        	
	        	
  /****************************B:text,T:title,I:infobox,C:category,O:outlink************************************/
	            	 
	            	 Mainranking rak=new Mainranking();
            	     fin = new FileReader("input.txt");
            	     br = new BufferedReader(fin);
           	         str=br.readLine();
           	         Stemmer p=new Stemmer();
           	         while(str!=null)
           	          {
           	        	 double time;
           	             time = System.currentTimeMillis();
           	             
           	             double time_pars;
        	             time_pars = System.currentTimeMillis();
           	             
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
                                     	        	     type[j++]="A";
                                     	        	   
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
                	        	     type[j++]="A";
                	        	   
                                 }
                          }	  
           	        
           	         time_pars = System.currentTimeMillis() - time_pars;
                     System.out.println(" The query parsing took " + time_pars + " miliseconds");
           	        	
           	        	for(int k=0;k<i;k++)
                           System.out.println(term[k]+":"+type[k]);
           	     /************************ here we hav one query in structured manner*************************/          	  
           	        	Search doc =new Search();
           	        	BinarySearch b=new BinarySearch();
                    	String docid=null;
                    	int m;
                   	    double tf_t,tf_i,tf_c,tf_o,tf_b;
                   	    Double y;
                   	    Map<String, String> dynamic = new HashMap<String, String>(); 
                   	    for(int k=0;k<i;k++)
                           {
                             	   /*System.out.println(term[k]+":"+type[k]);*/
           	        	           
           	        		        //double time_post;
        	                        //time_post = System.currentTimeMillis();
                        	        
        	                        int x=0;
                        	        String[] token = new String[10000000];
                        	       // String key=p.stemming(term[k].toLowerCase());
                                      String store=p.stemming(term[k].toLowerCase());
                                      String key=dynamic.get(store);
                         		      if(key==null)
                         		    	 {
                         		    	     key=b.extract(v,store);
                         		    	    if(key!=null)dynamic.put(store,key);
                         		    	 }
             
                        	       //key=b.extract(v,key);
                                     
                                     //time_post = System.currentTimeMillis() - time_post;
                                   //  System.out.println(show+":"+"The posting list retrieval time " + time_post + " miliseconds");
                                    
                    if(key!=null){
                                      String delims = "[\n\t\b\r+*/\\^;:-_~\\()#@$%&,.?{}[]	<>!='|'\'\" __`'']+";
                                      StringTokenizer pars=new StringTokenizer(key,delims);
                                	while ( pars.hasMoreTokens() )
            		      			{
                                		   token[x++]=pars.nextToken();
                                		   
            		      			}
                                	int df_1=Integer.parseInt(token[1]);
                                	double df=df_1;
                                	//double N=29309;//total number of document it would be hard coded
                                	//double N=2930478;
                                	double N=9711597;                     	
                                	double idf=Math.log(N/df)/Math.log(2);
                                	
                                	//T:10,I:7,C:4,O:2,B:1
                              //  	int w_t=5,w_i=4,w_c=3,w_o=2,w_b=1;
                                	int w_t=1000,w_i=70,w_c=20,w_o=10,w_b=10;
                                	
                         for(int l=2;l<x;l++)
                           { 

                                docid=doc.doc_id(token[l]);
                        	 
                              if(type[k].equals("A"))
                              {
                            //	System.out.println("i m in A");  
                            	 
               
                            	      tf_t=rak.tf(token[l],"T");
                            	      tf_i=rak.tf(token[l],"I");
                            	      tf_c=rak.tf(token[l],"C");
                            	      tf_o=rak.tf(token[l],"O");
                            	      tf_b=rak.tf(token[l],"B");
                            	      
                            	      if(tf_t>0)
                            	        {
                            	    	  tf_t=tf_t*w_t;
                               		      y=score.get(docid);
                               		      if(y==null)
                               		      score.put(docid, tf_t*idf);
                               		      else
                               		      score.put(docid, score.get(docid) + tf_t*idf); 
                            	      } 	  
                            	      if(tf_i>0)
                            	      {
                            	    	  tf_i=tf_i*w_i;
                               		      y=score.get(docid);
                               		      if(y==null)
                               		      score.put(docid, tf_i*idf);
                               		      else
                               		      score.put(docid, score.get(docid) + tf_i*idf); 
                            	    } 	
                            	      if(tf_c>0)
                            	      {
                            	    	  tf_c=tf_c*w_c;
                               		      y=score.get(docid);
                               		      if(y==null)
                               		      score.put(docid, tf_c*idf);
                               		      else
                               		      score.put(docid, score.get(docid) + tf_c*idf); 
                            	    } 	
                            	      if(tf_o>0)
                            	      {
                            	    	  tf_o=tf_o*w_o;
                               		      y=score.get(docid);
                               		      if(y==null)
                               		      score.put(docid, tf_o*idf);
                               		      else
                               		      score.put(docid, score.get(docid) + tf_o*idf); 
                            	    } 	
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
                            	  
                              else if(type[k].equals("T"))
                                	{
                                     		
                                     	   tf_t=rak.tf(token[l],"T");
                                   	    
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
                             
                             else if(type[k].equals("I"))
                                	    {
                            	                 tf_i=rak.tf(token[l],"I");
                         	                    
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
                         else if(type[k].equals("C"))
                                    {
                        	               tf_c=rak.tf(token[l],"C");
                     	                 
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
                      else if(type[k].equals("O"))
                            {
                    	       tf_o=rak.tf(token[l],"O");
                 	           
                 	           if(tf_o>0)
                 	              {
                 	    	      tf_o=tf_o*w_o;
                    		      y=score.get(docid);
                    		      if(y==null)
                    		      score.put(docid, tf_o*idf);
                    		      else
                    		      score.put(docid, score.get(docid) + tf_o*idf); 
                 	           } 	
                           }
             	else if(type[k].equals("B"))
             	          {
             		           tf_b=rak.tf(token[l],"B");
       	                   
       	                       if(tf_b>0)
       	                        {
       	    	                   tf_b=tf_b*w_b;
          		                   y=score.get(docid);
          		      if(y==null)
          		      score.put(docid, tf_b*idf);
          		      else
          		      score.put(docid, score.get(docid) + tf_b*idf); 
       	           }
                                		
                             }//B end
                     }  //if(key!=null)   
                               
                 } //for end
         }//for end
           	          
                  
                      
           	         time = System.currentTimeMillis() - time;
                     System.out.println(" The test took " + time + " miliseconds");  
           	        	
           	        	
                 /*perform sorting on values on scores(Hashmap) and find title from the docid*/
           	 
                     
                 TitleSearch ts=new TitleSearch();
                 int check=0;
                 for (Iterator it = sortByValue(score).iterator(); it.hasNext(); ) 
                         {
                             if(check==10)break;
                	         String key = (String) it.next();
                             int l = Integer.valueOf(key, 16).intValue();
                             String title=ts.titlesearch(u,l);
                             System.out.println("docid:"+l+"   "+"title:"+title);
                           //  System.out.println("docid:"+ l+"score:"+score.get(key));
                             check++; 
                         }   
                
               if(check<10)
               {
            	   while(check<10)
            	   { 
            		   System.out.println("NA");
            		   check++;
            	   }
            	   
               }
            
               System.out.println("***************************");
               str=br.readLine();     
               score.clear();
        }//while I
          
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
}//class end