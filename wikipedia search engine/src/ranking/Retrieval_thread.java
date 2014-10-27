package ranking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Retrieval_thread {
                      public static Map<String, Double> score;
                     
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
	            	 
	            	 Retrieval_thread rak=new Retrieval_thread();
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
           	            score = new HashMap<String, Double>(); 
           	           	 
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
           	        	Retrieval_thread doc =new Retrieval_thread();
           	        	BinarySearch b=new BinarySearch();
                    	String docid=null;
                    	int m;
                   	    double tf_t,tf_i,tf_c,tf_o,tf_b;
                   	    Double y;
                   	    Map<String, String> dynamic = new HashMap<String, String>(); 
                   	    Parallel [] th=new Parallel[100];
                   	    int num=0;
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
                                	            	th[num]=new Parallel (key,T[k],I[k],C[k],O[k],B[k]);
                   	        	      	            th[num].start();
                                                    num++;
                                                 }
                            }
                   	    
                   	       for(int k=0;k<num;k++)
                              th[k].join();
     	    
                     time = System.currentTimeMillis() - time;
                     
                     out.write("Time:"+" "+time+"ms\n");
                 
                /*perform sorting on values on scores(Hashmap) and find title from the docid*/
           	 
                     
                 TitleSearch ts=new TitleSearch();
                 int check=0;
                 for (Iterator it = sortByValue(score).iterator(); it.hasNext(); ) 
                         {
                             if(check==10)break;
                	         String key = (String) it.next();
                             int l = Integer.valueOf(key, 16).intValue();
                             String title=ts.titlesearch(u,l);
                            
                          //System.out.println("docid:"+l+"   "+"title:"+title+"score:"+score.get(key));
                           out.write(l+"\t"+title+"\n");
                           check++; 
                             
                         }   
                
               if(check<10)
               {
            	   while(check<10)
            	   { 
            		   out.write("\n");
            		   check++;
            	   }
            	   
               }
               str=br.readLine();     
               score.clear();
        }//while I
          out.close();
    }//function end


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