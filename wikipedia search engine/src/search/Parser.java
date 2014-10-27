package search;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;
import java.util.*; 

public class Parser extends DefaultHandler {

	 boolean title = false;
     boolean id = false;
     boolean text = false;
     boolean flag=false;  
     boolean flag_1=false;
     StringBuffer infobox,val,x,cate,outl;
     Page p;
 	 TreeMap<String,TreeMap<String,int[]>>treemap;
	 TreeMap<String,int[]>subtreemap; 
	 Stopwords H;
	 Stemmer check;
	 int num,num1;
	 SaxReader R;
	 BufferedWriter out1;
public void startElement (String uri, String localName,
    String qName, Attributes attributes) throws SAXException
      {    
	   
    if(qName.equals("file")){
    	                        H=new Stopwords();
    	                        H.store();
    	                        treemap=new TreeMap<String,TreeMap<String,int[]>>();
    	                        subtreemap=new TreeMap<String,int[]>();
    	                        check =new Stemmer();
    	                        R=new SaxReader();
    	                        num1=R.nam;
    	                        num=0;
    	                       
    	                        try{
    	                                out1 = new BufferedWriter(new FileWriter("forward_index",true));
    	                           }
    	                        catch(Exception e)
    	                                {
    	                        	       System.out.println("error in forward index");
    	                        	    }
                            }
	         
    	    if(qName.equals("page")){ 
                                            flag=true;
                                            p=new Page();
                                            x= new StringBuffer();
                                            infobox=new StringBuffer();
                                            cate=new StringBuffer();
                                            outl=new StringBuffer();
                                            val=new StringBuffer();
                                          
                                     }
              if (qName.equalsIgnoreCase("TITLE"))
            	      title = true;
              if (qName.equalsIgnoreCase("ID")) 
            	      id = true;
              if (qName.equalsIgnoreCase("TEXT")) 
            	     text = true;
     }

	
  public void characters(char ch[], int start, int length) throws SAXException 
              {
	                if (title)p.setTitle(new String(ch, start, length));
	                if (id&&flag) {
       	                               flag=false;
	                                   p.setId(Integer.parseInt(new String(ch, start, length)));
	                               }
                    if (text) {
	                                 x.append(new String(ch, start, length));        	                    
	                          }
               }
    
  public void endElement(String uri, String localName,
	    	String qName) throws SAXException
	      {
	         if(qName.equals("text"))  
	                p.setText(x);
	    
	          if(qName.equals("page"))
	                     {
		                              //System.out.println("title:"+ p.getTitle());
			                          //System.out.println("id:"+p.getId());
	        	   
	        	                        /*forward index formation*/
	        	                        String hex = Integer.toHexString(p.getId());
	        	                      try{
	        	                            out1.write(hex+":"+p.getTitle()+"\n");
	        	                         }
	        	                       catch(Exception e)
	        	                       { 
	        	                    	   System.out.println("error in write in forward index");
	        	                       }
	        	                        
	        	                        val=p.getText();
	                 	     	       
			        /*category extraction*/  
	                 		{
			                  int k=0;
                              int index=val.indexOf("[[Category:");
                              while(index!=-1){
                            	                // System.out.println("category");
                            	                  k=val.indexOf("]]",index);
                            	                 if(k==-1){val.replace(index,index+11,"");} 
                            	                 else{
                            	                	    cate.append(val.substring(index+11,k));
                            	                        cate.append(" ");
                            	                        val.replace(index,k+2,"");
                            	                     }   
                            	                   index=val.indexOf("[[Category:");
                                              }
                
	                     	 };
	         /*System.out.println("**************END OF CATEGORY***********************");*/   	
              
	                     	 
	            /*Infobox extraction*/  
	                 		{
	                 			 int k=0;
	                             int index=val.indexOf("{{Infobox");
	                             while(index!=-1)
	                             {    
	                            	  //System.out.println("info");
	                            	  k=val.indexOf("}}\n\n",index);
	                            	  if(k!=-1){ 
	                            		           flag_1=true;
	                            	               infobox.append(val.substring(index,k));
                                                   infobox.append(" ");
                                                   val.replace(index,k+4,"");
                                                   index=val.indexOf("{{Infobox");
                                               }
	                            	  else{
	                            		      val.replace(index,index+9,"");
	                            		      index=val.indexOf("{{Infobox");
	                            		  }
	                            	  
	                           }
	                	};
	         /*System.out.println("**************END OF INFOBOX***********************");*/
	                    Remove r=new Remove();
		                val=r.remov(val);
		                infobox=r.remov(infobox);
	         /*outlinks extraction*/     
	                     {
	                    	 /*extraction from text*/
	                            int k=0;
                                int index=val.indexOf("[[");
                       while(index!=-1){
                    	                  //System.out.println("outlink1");
                                        k=val.indexOf("]]",index);
                                        if(k!=-1)
                                         {
                                	              String s= val.substring(index,k+2);
            	                	              if(s.indexOf(":")==-1&&s.indexOf(".")==-1)
            	                	            	  {
            	                	            	    outl.append(val.substring(index+2,k)); 
            	                	            	    outl.append(" ");
            	                	            	  }
                                        	     val.replace(index,k+2,"");
                                        	     index=val.indexOf("[[");
                                          }
                                       else {
                                        	    val.replace(index,index+2,"");
                                        	    index=val.indexOf("[[");
                                        	 }
                                   }
	                    	  
                 //System.out.println("*****Outlink Extracted from Infobox:********");    	 
	                    	 
	                    	 /*extraction from Infobox*/
            StringBuffer infobox_1=infobox;    
            if(flag_1){
             
                                k=0;
                                index=infobox_1.indexOf("[[");
                             while(index!=-1){
                            	                // System.out.println("outlink2");
                                                  k=infobox_1.indexOf("]]",index);
                        	                    if(k!=-1){
                        	                	               String s= infobox_1.substring(index,k+2);
                        	                	               if(s.indexOf(":")==-1&&s.indexOf(".")==-1)
                        	                	           	   {
                        	                	        	      outl.append(infobox_1.substring(index+2,k));
                        	                	        	      outl.append(" ");
                        	                	        	   }
                        	                	          infobox_1.replace(index,k+2,"");
                                                          index=infobox_1.indexOf("[[");
                                                      
                        	                         }
                        	                 else {
                                        	            infobox_1.replace(index,index+2,"");
                                        	            index=infobox_1.indexOf("[[");
                                        	       }
                                           }
                                flag_1=false;
                          }  
                     
	            };

	   //Now we have to remove some extra characters of val (String Buffer) and infobox also
	           
	                val=r.removal(val);
	                infobox=r.removal(infobox);
	      
	               
	   
	     
	       /****************************INDEXING***********************************/    
	                String delims = "_-~`[\n\t+*/\\^;:\\()#@$%&,.?{}<>!='|'\'\" ]+0123456789";
	            /*Final Words of Text*/      
	            {
	            	//System.out.println("Text");
	                	
	                    String tempStr;
		                StringTokenizer pars=new StringTokenizer(val.toString(),delims);
		      			int count = 0;
		      	while ( pars.hasMoreTokens() )
		      			{
		      			  tempStr = pars.nextToken();
		      			  int i=0;
		      			  boolean tok=true;
		      			if(StringUtils.isPureAscii(tempStr));
		      			else tok=false;
		      	if(tok&&tempStr.length()>2)
		      			         {  
		      		                tempStr=tempStr.toLowerCase();
		      	                 	if(H.getHSet().contains(tempStr));
		      	                 	else { 
		      	                 		      String word=check.stemming(tempStr);
		      	                 		   if(H.getHSet().contains(word));
		      	                 		   
		      	                 		   else if(word.length()>0){ 
		      	                 	                     subtreemap=treemap.get(word);
		      	                 	               if(subtreemap==null){  
		      	                 	                                   TreeMap<String,int[]>y=new TreeMap<String,int[]>();
		      		                                                   treemap.put(word,y);
		      		                                                   int[] q = new int[5];
		                                                               q[0]=1;
		      		                                                   q[1]=0;
		      		                                                   q[2]=0;
		      		                                                   q[3]=0;
		      		                                                   q[4]=0;
		      	                 	        	                       y.put(hex,q);
		      	                 	        	  
		      	                 	                             }
		      	                 	          else{
		      	                 	        	             int[] l;
		      	                 	        	             l=subtreemap.get(hex);    
		      	                 	        	             if(l==null){
		      	                 	        	                          int[] q = new int[5];
	                                                                      q[0]=1;
	   		                                                              q[1]=0;
	   		                                                              q[2]=0;
	   		                                                              q[3]=0;
	   		                                                              q[4]=0;
	   	                 	        	                                   subtreemap.put(hex,q);
		      	                 	        	            	         }
		      	                 	         	             else{
		      	                 	        	            	    l[0]++;
		      	                 	        	            	  }
		      	                 	        	  }
		      	                 	}          
		      	                 	      }
		      	                 	  count++;
		      			         }
		      			}
		      	
	            };// Indexing of words of text
	     
	
	        /*Final words of category*/       
	     	           {
	              
	     	        	 // System.out.println("Category");
	     	         	    String tempStr;
	     	                StringTokenizer pars=new StringTokenizer(cate.toString(),delims);
	     	      			int count = 0;
	     	      	while ( pars.hasMoreTokens() )
	     	      			{
	     	      	          tempStr = pars.nextToken();
	     	      			  int i=0;
	     	      			  boolean tok=true;
	     	      	       	 if(StringUtils.isPureAscii(tempStr));
			      			 else tok=false;
	     	      	if(tok&&tempStr.length()>2)
	     	      			         { 
	     	      		                tempStr=tempStr.toLowerCase();
	     	      	                 	if(H.getHSet().contains(tempStr));
	     	      	                 	else { 
	     	      	                 	  	     String word=check.stemming(tempStr);
	     	      	                 		     if(H.getHSet().contains(word));
	     	      	                             else if(word.length()>0){  
	     	      	                 		                               subtreemap=treemap.get(word);
	     	      	                 	          if(subtreemap==null){ 
	     	      	                 	                                 TreeMap<String,int[]>y=new TreeMap<String,int[]>();
	     	      		                                                 treemap.put(word,y);
	     	      		                                                 int[] q = new int[5];
	     	                                                             q[0]=0;
	     	      		                                                 q[1]=1;
	     	      		                                                 q[2]=0;
	     	      		                                                 q[3]=0;
	     	      		                                                 q[4]=0;
	     	      	                 	        	                     y.put(hex,q);
	     	      	                 	        	  
	     	      	                 	                             }
	     	      	                 	          else{
	     	      	                 	        	             int[] l;
	     	      	                 	        	             l=subtreemap.get(hex);    
	     	      	                 	        	             if(l==null){
	     	      	                 	        	                              int[] q = new int[5];
	                                                                              q[0]=0;
	        		                                                              q[1]=1;
	        		                                                              q[2]=0;
	        		                                                              q[3]=0;
	        		                                                              q[4]=0;
	        	                 	        	                                   subtreemap.put(hex,q);
	     	      	                 	        	            	         }
	     	      	                 	        	             else{
	     	      	                 	        	            	    l[1]++;
	     	      	                 	        	            	  }
	     	      	                 	        	  }
	     	      	                 }          
	     	      	                 	      }
	     	      	                 	  count++;
	     	      			         }
	     	      			}
	     	      
	             };//Indexing of words of Category

	 	        /*Final words of Infobox*/       
	 	     	           {
	 	     	        	  // System.out.println("Infobox");
	            	                String tempStr;
	                                StringTokenizer pars=new StringTokenizer(infobox.toString(),delims);
	      			                int count = 0;
	      	         while ( pars.hasMoreTokens() )
	      			        { 
	      	        	             tempStr = pars.nextToken();
	      			                 int i=0;
	      			                 boolean tok=true;
	      			if(StringUtils.isPureAscii(tempStr));
	      			else tok=false;
	      	if(tok&&tempStr.length()>2)
	      			         {    
	      		                  tempStr=tempStr.toLowerCase();
	      	                 	if(H.getHSet().contains(tempStr));
	      	                 	else { 
	      	                 	        
	      	                 		     String word=check.stemming(tempStr);
	      	                 		     if(H.getHSet().contains(word));
	      	                 		     else if(word.length()>0){   
	      	                 		     subtreemap=treemap.get(word);
	      	                 	         if(subtreemap==null){  
	      	                 	                                 TreeMap<String,int[]>y=new TreeMap<String,int[]>();
	      		                                                 treemap.put(word,y);
	      		                                                 int[] q = new int[5];
	                                                             q[0]=0;
	      		                                                 q[1]=0;
	      		                                                 q[2]=1;
	      		                                                 q[3]=0;
	      		                                                 q[4]=0;
	      	                 	        	                     y.put(hex,q);
	      	                 	        	  
	      	                 	                             }
	      	                 	          else{
	      	                 	        	             int[] l;
	      	                 	        	             l=subtreemap.get(hex);    
	      	                 	        	             if(l==null){
	      	                 	        	                          int[] q = new int[5];
                                                                      q[0]=0;
   		                                                              q[1]=0;
   		                                                              q[2]=1;
   		                                                              q[3]=0;
   		                                                              q[4]=0;
   		                                                             
   	                 	        	                                   subtreemap.put(hex,q);
	      	                 	        	            	         }
	      	                 	        	             else{
	      	                 	        	            	    l[2]++;
	      	                 	        	            	  }
	      	                 	        	  }
	      	                 		 }   
	      	                 	      }
	      	                 	  count++;
	      			         }
	      			}
	     
            };//Indexing of words of Infobox
            
	        
	            
	            /*Final words of Outlinks*/       
	             {
	                    
	                   //	System.out.println("Outlinks");
	     	      		    String tempStr;
	     	                StringTokenizer pars=new StringTokenizer(outl.toString(),delims);
	     	      			int count = 0;
	     	      	while ( pars.hasMoreTokens() )
	     	      			{	     	      			  
	     	      		      tempStr = pars.nextToken();
	     	      			  int i=0;
	     	      			  boolean tok=true;
	     	      			if(StringUtils.isPureAscii(tempStr));
			      			else tok=false;
	     	      	if(tok&&tempStr.length()>2)
	     	      			         {    
	     	      		                tempStr=tempStr.toLowerCase();
	     	      	                 	if(H.getHSet().contains(tempStr));
	     	      	                 	else { 
	     	      	                 		      String word=check.stemming(tempStr);
	     	      	                 	     	  if(H.getHSet().contains(word));
	     	      	                 		    else if(word.length()>0){ 
	     	      	                 	                subtreemap=treemap.get(word);
	     	      	                 	             if(subtreemap==null){ 
	     	      	                 	                                 TreeMap<String,int[]>y=new TreeMap<String,int[]>();
	     	      		                                                 treemap.put(word,y);
	     	      		                                                 int[] q = new int[5];
	     	                                                             q[0]=0;
	     	      		                                                 q[1]=0;
	     	      		                                                 q[2]=0;
	     	      		                                                 q[3]=1;
	     	      		                                                 q[4]=0;
	     	      	                 	        	                     y.put(hex,q);
	     	      	                 	        	  
	     	      	                 	                             }
	     	      	                 	          else{
	     	      	                 	        	             int[] l;
	     	      	                 	        	             l=subtreemap.get(hex);    
	     	      	                 	        	             if(l==null){
	     	      	                 	        	                          int[] q = new int[5];
	                                                                              q[0]=0;
	        		                                                              q[1]=0;
	        		                                                              q[2]=0;
	        		                                                              q[3]=1;
	        		                                                              q[4]=0;
	        	                 	        	                                 subtreemap.put(hex,q);
	     	      	                 	        	            	         }
	     	      	                 	        	             else{
	     	      	                 	        	            	    l[3]++;
	     	      	                 	        	            	  }
	     	      	                 	        	  }
	     	      	                 		  }
	     	      	                 	      }
	     	      	                 	  count++;
	     	      			         }
	     	      			}
	     	      	
	            };//indexing of words of outlinks
	            
	            
	      /*Final words of Title*/       
	            {
	            	//System.out.println("Title");
                    String tempStr;
	                StringTokenizer pars=new StringTokenizer(p.getTitle(),delims);
	      			int count = 0;
	      	while ( pars.hasMoreTokens() )
	      			{
	      	       	//System.out.println("Title in loop");
	      		      tempStr = pars.nextToken();
	      			  int i=0;
	      			  boolean tok=true;
	      		      if(StringUtils.isPureAscii(tempStr));
	      			  else tok=false;
	      	if(tok&&tempStr.length()>2)
	      			         {     
	      		                 tempStr=tempStr.toLowerCase();
	      	                 	if(H.getHSet().contains(tempStr));
	      	                 	else { 
	      	                 		   String word=check.stemming(tempStr);
	      	                 		   if(H.getHSet().contains(word));
	      	                 		   else if(word.length()>0){
	      	                 	          subtreemap=treemap.get(word);
	      	                 	          if(subtreemap==null){  
	      	                 	                                 TreeMap<String,int[]>y=new TreeMap<String,int[]>();
	      		                                                 treemap.put(word,y);
	      		                                                 int[] q = new int[5];
	                                                             q[0]=0;
	      		                                                 q[1]=0;
	      		                                                 q[2]=0;
	      		                                                 q[3]=0;
	      		                                                 q[4]=1;
	      	                 	        	                     y.put(hex,q);
	      	                 	        	  
	      	                 	                             }
	      	                 	          else{
	      	                 	        	             int[] l;
	      	                 	        	             l=subtreemap.get(hex);    
	      	                 	        	             if(l==null){
	      	                 	        	                          int[] q = new int[5];
                                                                      q[0]=0;
   		                                                              q[1]=0;
   		                                                              q[2]=0;
   		                                                              q[3]=0;
   		                                                              q[4]=1;
   	                 	        	                                   subtreemap.put(hex,q);
	      	                 	        	            	         }
	      	                 	        	             else{
	      	                 	        	            	    l[4]++;
	      	                 	        	            	  }
	      	                 	        	  }
	      	                 		   } 
	      	                 	      }
	      	                 	  count++;
	      			         }
	      			}
	      	
            
	      };//Indexing of Words of Title  
	            
//Now spiliting the treemap	            
	      try{
	    	  
	    	  if(treemap.size()>100000)
	              {
	    		  
	                //System.out.println("printing map");
	               BufferedWriter out = new BufferedWriter(new FileWriter("finalindex/Index_"+num1+"_"+num));
	            	        	Set<Map.Entry<String,TreeMap<String,int[]>>> st = treemap.entrySet();
	                            for (Map.Entry<String,TreeMap<String,int[]>> curr : st){
	            	        	   	
	                            	            //  System.out.print(curr.getKey()+" ");
	                            	                String f=curr.getKey();
	                            	                f=f+":";
	            	        	   	TreeMap<String,int[]> tm;
	            	        	   	
	            	        	   	tm = curr.getValue();
	            	        	   	
	            	        	   	Set<Map.Entry<String,int[]>> currSet = tm.entrySet();
	            	        	   	int c=currSet.size();
	            	        	   	int counter=0;
	            	        	   	f=f+c+":";
	            	        	   	for (Map.Entry<String,int[]> curr1 : currSet)
	            	        	   	{
	            	        	   		String docid = curr1.getKey();
	            	        	   		int l[] = curr1.getValue();
                                        f=f+docid;
	            	              /*B:Text,C:Category,I:Infobox,O:Outlink,T:Title*/      	   		                         
	            	        	   		                     
	            	        	 if(l[0]!=0){
	            	        		                    String l0=Integer.toString(l[0]);
	            	        		                    f=f+"B"+l0;
	            	        		         }  		                         
	            	        	 if(l[1]!=0){
	        		                                    String l1=Integer.toString(l[1]);
	        		                                     f=f+"C"+l1;
	        		                         }   		     
	            	        	 if(l[2]!=0){
	                                                    String l2=Integer.toString(l[2]);
	                                                      f=f+"I"+l2;
	                                        }   
	            	        	 if(l[3]!=0){
	                                                     String l3=Integer.toString(l[3]);
	                                                     f=f+"O"+l3;
	                                          }   		     
	        	                 if(l[4]!=0){
                                                       String l4=Integer.toString(l[4]);
                                                       f=f+"T"+l4;
                                           }      
	            	        	   		                    
	            	        	   		              counter++;              
	            	        	   		              if(c==counter);
	            	        	   		              else  f=f+"|";             
	                        	                          
	            	        	   	 }
	            	        	    out.write(f+"\n");
	                   }
	            	   out.close();
	            	   num++;
	            	   treemap.clear();
	            	
	    	         }   
	           }catch(IOException e) {System.out.println("Exception in printing treemap 1");}
} //page end     
	            
	              /****************************END INDEXING***********************************/
/*Extraction of Elements from Index*/
	        try{
	                if(qName.equals("file")&&treemap.size()!=0)
	                          {  
	                	        //    System.out.println("printing map 2");
	                                BufferedWriter out = new BufferedWriter(new FileWriter("finalindex/Index"+"_"+num1+"_"+num));
	                              //  System.out.println("printing map 2_1");
	            	            	Set<Map.Entry<String,TreeMap<String,int[]>>> st = treemap.entrySet();
	                                 for (Map.Entry<String,TreeMap<String,int[]>> curr : st){
	                                //	 System.out.println("printing map 2_3");
	                            	                String f=curr.getKey();
	                            	                f=f+":";
	            	        	   	TreeMap<String,int[]> tm;
	            	     
  	   	
	            	        	   	tm = curr.getValue();
	            	        	   	
	            	        	   	Set<Map.Entry<String,int[]>> currSet = tm.entrySet();
	            	        	   	int c=currSet.size();
	            	        	   	int counter=0;
	            	        	   	f=f+c+":";
	            	        	    /*B:Text,C:Category,I:Infobox,O:Outlink,T:Title*/ 
	            	        	   	for (Map.Entry<String,int[]> curr1 : currSet)
	            	        	   	{
	            	        	   		String docid = curr1.getKey();
	            	        	   		int l[] = curr1.getValue();
                                                               
	            	        	   		              //   String doc=Integer.toString(docid);
	            	        	   		                 f=f+docid;
	            	
	            	        	 if(l[0]!=0){
	            	        		                    String l0=Integer.toString(l[0]);
	            	        		                    f=f+"B"+l0;
	            	        		         }  		                         
	            	        	 if(l[1]!=0){
	        		                                    String l1=Integer.toString(l[1]);
	        		                                     f=f+"C"+l1;
	        		                         }   		     
	            	        	 if(l[2]!=0){
	                                                    String l2=Integer.toString(l[2]);
	                                                      f=f+"I"+l2;
	                                        }   
	            	        	 if(l[3]!=0){
	                                                     String l3=Integer.toString(l[3]);
	                                                     f=f+"O"+l3;
	                                          }   		     
	        	                 if(l[4]!=0){
                                                         String l4=Integer.toString(l[4]);
                                                         f=f+"T"+l4;
                                             }      
	            	        	   		                    
	            	        	   		              counter++;              
	            	        	   		              if(c==counter);
	            	        	   		              else  f=f+"|";             
	                        	                          
	            	        	   	 }
	            	        	    out.write(f+"\n");
	                      }
	            	      out.close();    
	            	      treemap.clear();
	            	   
	                }
	       
	           
	            }
	           catch(IOException e) {
	        	                      System.out.println("Exception in printing treemap 2");
	        	                     }
	            
	             if(qName.equals("text")) text = false;
		         if(qName.equals("title")) title = false;
		         if(qName.equals("id")) id = false;
		         try{
		               if(qName.equals("file"))out1.close();
		           }
		          catch(Exception e){
		        	                  System.out.print("error!!!");
		        	                }
       }
}

