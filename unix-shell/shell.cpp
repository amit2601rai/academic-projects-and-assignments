/* Amit Kr. Rai
  201105582
  NOTE:To run each and evey command,arguments,redirection operator and pipes should be seperated from space.*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <wait.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>

#define BUFSIZE 200
#define ARGVSIZE 40
#define DELIM "\n\t\r>< "
#define DELIM1 "\n\t\r "

          int i;
           class cmargs{
                                 public:
                                 char *cmlargs[40];
                                 cmargs()
                                    {    for(int i=0;i<40;i++)
                                          cmlargs[i]=new char[256];
                                     }
                                }; 

int main()
{    
      int n,n1,in,out;
      int history;
      int pid;
      int j=0,count=0;
      int k=0,c=0;
      int m;//used in setting pipes for middle
      char buf[BUFSIZE+1],buf1[BUFSIZE+1];
      char *clargs[ARGVSIZE];
      char *clargs1[ARGVSIZE];
      int status,len; 
      char *c1="\n";

  
                 cmargs *z;
    history=open("history",O_CREAT|O_WRONLY|O_APPEND,500); 
       
 while(1)
     {
            count=0;
            z=new cmargs[10];
          
           /*starting shell*/
          printf("~~~Myshell>>");
       
         /*storing command line argument in buffer*/
          gets(buf);
              /*history module*/
            len=strlen(buf);
           char k11[15]="cat -b ";
         if(strcmp(buf,"history")==0)
           {  
                strcat(k11,buf);
                   j=0;
              while(k11[j]!='\0')
                 {
                    buf[j]=k11[j];
                    j++;
                 }     
              buf[j]='\0';      
           }
   
         write(history,buf,len);
	 write(history,c1,2);
    

                j=0;
              while(buf[j]!='\0')
                 {
                    buf1[j]=buf[j];
                    j++;
                 }     
              buf1[j]='\0';
            
          
        /*counting the number of redirection operators without pipes*/         
                  int p,p1=0,p2=0,p3=0;
                for(p=0;buf[p]!='\0';p++)
                   { 
                       if(buf[p]=='<')
                         { 
                          p1++;
                         }  
                      if(buf[p]=='>')
                           {
                           p2++;
                           }     
                  }
            if(p1==1&&p2==1)
               p3++;         
       
     /*find the number of pipes*/
               j=0;
              while(buf[j]!='\0')
                 {
                    if(buf[j]=='|')
                        count++;    //count contain the number of pipes
                    j++;
                 }     

    /*comparison from exit string to exit*/
          if(!strcmp(buf,"exit\0"))    
                exit(0);
         if(!strcmp(buf,"cd"))
            chdir(clargs[1]);
              
          /*parsing from strtok*/
                n=1;n1=1;
        clargs[0]=strtok(buf,DELIM);      
        while((clargs[n]=strtok(NULL,DELIM))!=NULL)
               n++;
       clargs[n]=NULL;
       
      /* change directory module*/
         if(!strcmp(clargs[0],"cd"))
            chdir(clargs[1]);
        
    
      /* for redirection purpose to find out the redirection operator */    
             clargs1[0]=strtok(buf1,DELIM1);      
        while((clargs1[n1]=strtok(NULL,DELIM1))!=NULL)
               n1++;
          clargs1[n1]=NULL;
              int k1=0,k2=0; 
       while(clargs1[k2] && clargs1[k2][0]!='>')
                    k2++;
           while(clargs1[k1] && clargs1[k1][0]!='<')
                    k1++;
                if(p3==1) 
                 k2--;
   //  printf("k1=%d k2=%d",k1,k2);
        
      /*cretaing array of stucture of array of pointer to string*/   
       
                    k=0;
                    c=0; 
                    j=0;
                while(clargs[k]!=NULL)
                    {                    
			if(strcmp(clargs[k],"|")==0)
                           { 
                             z[c].cmlargs[j]=NULL;
                               c++;
                               j=0;    
                            }
                        else
                            strcpy(z[c].cmlargs[j++],clargs[k]);
                             
                               k++;      
                     }
                  z[c].cmlargs[j]=NULL;
                
           //  printf("%s %s %s",z[0].cmlargs[0],z[0].cmlargs[1],z[0].cmlargs[2]);  
              
      /*dynamically creates the pipe*/      
       //count is no of pipes
   int *pipefd=(int*)malloc(sizeof(int)*2*count);
	   int a=0;
                 while(a<count)
                 {
                   pipe(pipefd+a*2);
                    a++;
                 }
   /*when > at the end  
   int k6=0,flag=0,k7=0,flag1=0;
     while(clargs1[k6][0]!='\0'&&clargs1[k6])
         {   
          printf("WHILE KE BAAD\n");
          if(clargs1[k6][0]=='|')
          flag=k6;
         printf("flag=%d\n",flag);  
           k6++;
     }  
flag1=flag+1;           
   while(clargs1[flag1][0]!='>'&&clargs1[flag1])
         {
          flag1++;
         }        

     
flag1=flag1-flag;*/

     /*cretaion of child processes and core part of program*/
                   int x,x1=0;
                   x=count+1;  /*no of child process to be created and count is number of process*/
		
                  while(x1<x)
                   {
                             pid=fork();    
                          if(pid==0)//child process
                            {         
                                 if(count==0)
                                   {
                                       if(p3==1)  /*means both operators are present eg.grep Villanova < scores > out*/
                                          {
                                         in=open(z[0].cmlargs[k1], O_RDONLY);
                                  out=open(z[0].cmlargs[k2], O_WRONLY | O_TRUNC | O_CREAT, S_IRUSR | S_IRGRP | S_IWGRP | S_IWUSR);
                                                       dup2(in, 0);
                                                       dup2(out, 1);
                                                       close(in);
                                                       close(out);
                                          execvp(z[0].cmlargs[0], z[0].cmlargs);
                                           }
                                               if(p1==1)
                                                  {
                                                    in = open(z[0].cmlargs[k1], O_RDONLY);
                                                        dup2(in, 0);
                                                        close(in);
                                                   execvp(z[0].cmlargs[0], z[0].cmlargs); 
                                                    }
                                         else
                                           {
                                                  if(p2==1)
                                                  {
           
                                  out = open(z[0].cmlargs[k2], O_WRONLY | O_TRUNC | O_CREAT, S_IRUSR | S_IRGRP | S_IWGRP | S_IWUSR);
                                                       dup2(out, 1);
                                                       close(out);
                                              execvp(z[0].cmlargs[0], z[0].cmlargs); 

                                                  }
                                                else
                                             execvp(z[0].cmlargs[0],z[0].cmlargs);
                                           
                                        } 
                                   }/* means single command without pipes */
                                  
                                else
                                    {     
                                        if(x1==0)   //first command
                                           {        //printf("this is the first command\n");
                                                   
                                                     //redirection with piping
                                                            int k5=0;
                                                      // printf("k5=%d---------\n",k5);
                                                  while(clargs1[k5] && clargs1[k5][0]!='<')
                                                           k5++;
                                                     // printf("k5=%d----\n",k5);
                                                       
                                                  
                                                     
                                                      if(p1==1)
                                                         {    //printf("p1=%d----\n",p1);
                                                            in = open(z[0].cmlargs[k5], O_RDONLY);
                                                                 dup2(in, 0);
                                                                 close(in);
                                                               dup2(pipefd[1],1);
                                                      for (i = 0; i < 2*count; i++)
                                                         close(pipefd[i]);
                                                              execvp(z[0].cmlargs[0], z[0].cmlargs); 
                                                          }
                                                    else 
                                                    {   dup2(pipefd[1],1);
                                                      for (i = 0; i < 2*count; i++)
                                                         close(pipefd[i]);
                                                     execvp(z[x1].cmlargs[0],z[x1].cmlargs);}
                                                        }
                                     
                                          else
                                            {
                                                 if(x1==x-1)//last command
                                                    {  //printf("i m in last command\n");
                                                      
                                              
                                                              dup2(pipefd[2*count-2],0);
                                                              for (i = 0; i < 2*count; i++)
                                                              close(pipefd[i]);
                                                              execvp(z[x1].cmlargs[0],z[x1].cmlargs);
                                                       }
                                         
                                                
                                                else
                                                    {                 //middle commands
                                                         if(x1==1)
                                                            m=0;
                                                          else m--;
                                                       dup2(pipefd[m],0);
                                                       dup2(pipefd[m+3],1);
							for (i = 0; i < 2*count; i++)
							    close(pipefd[i]);                                                      
     							     m=m+3;
                                                        
                                                       execvp(z[x1].cmlargs[0],z[x1].cmlargs); 
                                                               
                                                    }
                                             }    
                                   } 
                          exit(0);
                           }
                  x1++;
                  }
                  
                   
                 for (i =0;i < 2*count;i++)
                      close(pipefd[i]);
                   int a1;
               for(a1=1;a1<=count+1;a1++)
                      wait(&status);
           // printf("waiting:%d:",wait(&status));
         
          
                    for(i=0;i<=n;i++)       // initiaizing both for next command 
                     clargs[i]=NULL;
                  for(i=0;i<BUFSIZE+1;i++)
                     buf[i]='\0';    
   }
} 
