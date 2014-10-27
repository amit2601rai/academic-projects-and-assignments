package ranking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class Search {
	       
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
           	        
           	         time_pars = System.currentTimeMillis() - time_pars;
                     System.out.println(" The query parsing took " + time_pars + " miliseconds");
           	        	
           	        //	for(int k=0;k<i;k++)
                     //      System.out.println(term[k]+":"+type[k]);
           	     /************************ here we hav one query in structured manner*************************/          	  
                 
           	        	for(int k=0;k<i;k++)
                           {
                             	   /*System.out.println(term[k]+":"+type[k]);*/
           	        	             double time_post;
        	                        time_post = System.currentTimeMillis();
                        	        
        	                        int x=0;
                        	        String[] token = new String[1000000];
                                    String key=p.stemming(term[k].toLowerCase());
                                    String show=key;
                                    BinarySearch b=new BinarySearch();
                                   //check for stop word[if term[k] is]
                                     key=b.extract(v,key);
                                     
                                     time_post = System.currentTimeMillis() - time_post;
                                     System.out.println(show+":"+"The posting list retrieval time " + time_post + " miliseconds");
                                  
                                     //System.out.println(key);
                                    
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
                                	int w_t=1000,w_i=70,w_c=20,w_o=10,w_b=10;
                         for(int l=2;l<x;l++)
                           { 

                        
                        	 Search doc =new Search();
                        	 String docid=null;
                        	 docid=doc.doc_id(token[l]);
                        	 
                        //	 System.out.println("token[l]="+token[l]+"   "+"docid="+docid);
                              
                        	 if(type[k].equals("T"))
                                	{
                                     		 int index_t=token[l].indexOf("T");
                                 	    	 int m;
                                 	        if(index_t==-1);
                                	          else
                                	            {
                                		        for(m=index_t+1;m<token[l].length();m++)
                                		    	    {

                                     if(token[l].charAt(m)=='0' || token[l].charAt(m)=='1' || token[l].charAt(m)=='2' || token[l].charAt(m)=='3' || 
                          		        token[l].charAt(m)=='4' || token[l].charAt(m)=='5' || token[l].charAt(m)=='6' || token[l].charAt(m)=='7'||
                          		   		token[l].charAt(m)=='8' || token[l].charAt(m)=='9')     		    		   
                                                    continue;
                              	              else  
                              	            	     break;
                                                    }
                                		   //index_t+1---->m   	   
                                		   double tf=(double)Integer.parseInt(token[l].substring(index_t+1,m)); 
                                  		   tf=tf*w_t;
                                		   //now we hav tf and docid
                                		     Double y;
                                		     y=score.get(docid);
                                		         if(y==null)
                                		    	 score.put(docid, tf*idf);
                                		    	 else
                                		    	 score.put(docid, score.get(docid) + tf*idf);  		    	 
                                		   
                                          }
                                   }
                             
                             else if(type[k].equals("I"))
                                	    {
                           	        	     int index_i=token[l].indexOf("I");
                        		             int m;
                        		             if(index_i==-1);
                        		               else
                        		               {
                        		    	           for(m=index_i+1;m<token[l].length();m++)
                        		    	             {
           	                               if(token[l].charAt(m)=='0' || token[l].charAt(m)=='1' || token[l].charAt(m)=='2' || token[l].charAt(m)=='3' || 
                  		                      token[l].charAt(m)=='4' || token[l].charAt(m)=='5' || token[l].charAt(m)=='6' || token[l].charAt(m)=='7'||
                  		      				  token[l].charAt(m)=='8' || token[l].charAt(m)=='9')     		    		   
                                                   continue;
                      	                        else  
                      	                        	break;
                                                     }
                        		    	     double tf=(double)Integer.parseInt(token[l].substring(index_i+1,m));   
                        		    	     tf=tf*w_i;
                        		    	     Double y;
                                		     y=score.get(docid);
                                		     if(y==null)
                                		    	 score.put(docid, tf*idf);
                                		    	 else
                                		    	 score.put(docid, score.get(docid) + tf*idf);
                        		          }               
                                		
                                      }
                         else if(type[k].equals("C"))
                                    {
                                		   int index_c=token[l].indexOf("C");
                        		           int m;
                        		          if(index_c==-1);
                        		          else
                        		           {      		    	
                        		    	for(m=index_c+1;m<token[l].length();m++)
                        		    	    {

                  	 if(token[l].charAt(m)=='0' || token[l].charAt(m)=='1' || token[l].charAt(m)=='2' || token[l].charAt(m)=='3' || 
                  		token[l].charAt(m)=='4' || token[l].charAt(m)=='5' || token[l].charAt(m)=='6' || token[l].charAt(m)=='7'||
                  		token[l].charAt(m)=='8' || token[l].charAt(m)=='9')     		    		   
                                        continue;
                      	 else 
                      		 break;
                                             }
                        	   	   
                        		 double tf=(double)Integer.parseInt(token[l].substring(index_c+1,m));
                        		 tf=tf*w_c;
                        		 Double y;
                    		     y=score.get(docid);
                    		     if(y==null)
                    		    	 score.put(docid, tf*idf);
                    		    	 else
                    		    	 score.put(docid, score.get(docid) + tf*idf);
                        		    }
                        		         
                                		
                                }
                      else if(type[k].equals("O"))
                         {
                                		
                           		     int index_o=token[l].indexOf("O");
                        		     int m;
                        		     if(index_o==-1);
                        		     else
                        		        {
                        		    	   for(m=index_o+1;m<token[l].length();m++)
                        		    	    {

                  	 if(token[l].charAt(m)=='0' || token[l].charAt(m)=='1' || token[l].charAt(m)=='2' || token[l].charAt(m)=='3' || 
                  		     token[l].charAt(m)=='4' || token[l].charAt(m)=='5' || token[l].charAt(m)=='6' || token[l].charAt(m)=='7'||
                  		      						token[l].charAt(m)=='8' || token[l].charAt(m)=='9')     		    		   
                                                   continue;
                      	 else  break;
                                             }
                           	   
                        		 double tf=(double)Integer.parseInt(token[l].substring(index_o+1,m));
                        		 tf=tf*w_o;
                        		 Double y;
                    		     y=score.get(docid);
                    		     if(y==null)
                    		    	 score.put(docid, tf*idf);
                    		    	 else
                    		    	 score.put(docid, score.get(docid) + tf*idf);    
                        		   }
                        		   
                                		
                          }
             	else if(type[k].equals("B")){
                           		     int index_b=token[l].indexOf("B");
                        		     int m;
                        		     if(index_b==-1);
                        		     else
                        		        {
                        		    	   for(m=index_b+1;m<token[l].length();m++)
                        		    	    {

                  	 if(token[l].charAt(m)=='0' || token[l].charAt(m)=='1' || token[l].charAt(m)=='2' || token[l].charAt(m)=='3' || 
                  		     token[l].charAt(m)=='4' || token[l].charAt(m)=='5' || token[l].charAt(m)=='6' || token[l].charAt(m)=='7'||
                  		      						token[l].charAt(m)=='8' || token[l].charAt(m)=='9')     		    		   
                                                   continue;
                      	 else  break;
                                             }
                        	 	   
                        		 double tf=(double)Integer.parseInt(token[l].substring(index_b+1,m)); 
                        		 
                        		// System.out.println("i m in B="+docid);
                        		 tf=tf*w_b;
                        		 Double y;
                    		     y=score.get(docid);
                    		     if(y==null)
                    		    	 score.put(docid, tf*idf);
                    		     
                    		     else
                		    	 score.put(docid, score.get(docid) + tf*idf);  	 
                		    	 
                        		}//else end
                                		
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
                             System.out.println("docid:"+ l +"title:"+title+" "+"score:"+score.get(key));
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