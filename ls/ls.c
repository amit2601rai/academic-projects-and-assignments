/******************************************************************************************************************************************************************
        Name: Amit Kr. Rai               Roll No: 201105582                  Course:M.TECH(CSE)

        Description: ls command with option -a,-l,-R,-t,-b and combination of each with color implementation
******************************************************************************************************************************************************************/

/*Header files*/
#include <sys/dir.h>
#include <sys/param.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <dirent.h>
#include <pwd.h>
#include <grp.h>
#include <time.h>
#include <locale.h>
#include <langinfo.h>
#include <stdio.h>
#include <stdint.h>
#include <errno.h>
#include <fcntl.h>
#include<string.h>

/*macro*/
#define FALSE 0
#define TRUE  1

/*Functions prototype*/
extern  int alphasort();
int timesort(const struct dirent **a, const struct dirent **b); 
void flag_set(char *);
void simp_ls(char *);
void opt_ls(char *);
void opt_ls_print(char *);
void opt_ls_print_r(char *);
int file_select();
int file_select_all();
int check_color(char *s,char file[]);

/*Global Variables*/
int flag[5];
int k=0;
char *pointer;
int color;//color=0 directory, color=1 file, color=2 default 

/*Main function*/
int main(int argc,char **argv)
{
int k=0,j,i=1,f=0;
int k1=0,f1=0,k2=0,f2=0;
char *abc[10000];
char s[10],s1[10];
strcpy(s,"-");
while(i<argc)
{
 //printf("s=%s\n",argv[i]);
   if(argv[i][0]=='-')
    {  j=1;
  while(argv[i][j]!='\0')
    {   
       s1[0]=argv[i][j];
       s1[1]='\0';
       strcat(s,s1);
       j++;   
       f=1;
    }
   }
else {
       if(f1==0)
           {
             k1=i;
             k2=i;
            f1=-1;
            f2++;
          }
     else {k2=i;f2++;}
   }
i++;
}
//printf("k1=%d k2=%d\n",k1,k2);
//strcpy(abc[k],"\0");
if(f==1)flag_set(s);
if(f2==0)
    {
          if(flag[0]||flag[1]||flag[2]||flag[3]||flag[4])opt_ls(".");
                 else simp_ls(".");  
    }
else
   {
       i=k1;
         while(i<=k2)
         {
                 if(flag[0]||flag[1]||flag[2]||flag[3]||flag[4])opt_ls(argv[i]);
                 else simp_ls(argv[i]);
                 i++;
        }

      }
return 0;
}     
/*function for setting flag*/
void flag_set(char *s)
{
   int len,i;
   len=strlen(s);
if(s[0]=='-')
{
   for(i=1;i<len;i++)
      {
            if(s[i]=='a')
                  flag[0]=1;
            else if(s[i]=='l')
                  flag[1]=1;
            else if(s[i]=='R')
                  flag[2]=1;
            else if(s[i]=='t')
                  flag[3]=1;
            else if(s[i]=='b')
                  flag[4]=1;
     }
}
}


/*simple ls on specified directory as well as current directory*/
void simp_ls(char *s)
{
       long long int count,i; 
     struct dirent **files;
     count=scandir(s, &files,file_select,alphasort);
     if(count <=0)
        return;
     for(i=1;i<count+1;i++) 
      {     color=check_color(s,files[i-1]->d_name);
          if(flag[4]!=1)
        {
                   //printf("color=%d",color);
                 if(color==0){
                         printf("\e[0;34m  %s", files[i-1]->d_name);
	                printf("\e[0;32m");
                             }
                else printf("  %s", files[i-1]->d_name);
	}	
             else
              {
             char string[10000];
              int x=0,l,k;
              strcpy(string,files[i-1]->d_name);
              while(string[x]!='\0')
                   {
                      if(string[x]==' ')
                        {    
                              l=strlen(string); 
                             for(k=l-1;k>=x+1;k--)
                                 string[k+1]=string[k];
                              string[l+1]='\0';
                               string[x]='\\';
                               string[x+1]=' ';
                               x+=2;
                         }
                        else x++;
                   }
                 if(color==0){
                                 printf("\e[0;34m  %s",string);
	                         printf("\e[0;32m");
                              }
                 else  printf("  %s",string);
              }
     }
   printf("\n");
}

/*ls with options on specified directory as well as current directory*/
void opt_ls(char *s)
{
      //here we will check the flags 0->3, 0->a,1->l,2->R,3->t
       
     
       if(flag[2]==1)
          opt_ls_print_r(s);
       else
          opt_ls_print(s); 
}

/*Non recursive*/
void opt_ls_print(char *s)
{
            
              struct dirent **files;
              struct stat     statbuf;
              struct passwd  *pwd;
              struct group   *grp;
              struct tm      *tm;
              char            datestring[256];        
              long long int i,count;
				     
                                pointer=s;/*for timesort*/
                             
                             /*scandir returns the number of directories*/
                             if(flag[0]==0&&flag[3]==0)count=scandir(s, &files, file_select, alphasort);
                             if(flag[0]==0&&flag[3]==1)count=scandir(s, &files, file_select, timesort);
                             if(flag[0]==1&&flag[3]==0)count=scandir(s, &files, file_select_all, alphasort);
                             if(flag[0]==1&&flag[3]==1)count=scandir(s, &files, file_select_all, timesort);
			    /* If no files found, make a non-selectable menu item */
				if(count <= 0)
			             return;
		           
                           /* Loop through directory entries. */
                           for(i=1;i<count+1;i++) 
                                {   color=check_color(s,files[i-1]->d_name);

                                  if(flag[1]==0)
                                    { 
                                         if(flag[4]!=1)
                                               { // printf("color=%d\n",color);
                                                  if(color==0){
                                                    printf("\e[0;34m  %s", files[i-1]->d_name);
 	                                            printf("\e[0;32m");
                                                           }
                                                  else  printf("  %s", files[i-1]->d_name);
                                               }
                                            else
                                               {
                                                 char string[10000];
                                                 int x=0,l,k;
                                                 strcpy(string,files[i-1]->d_name);
                                                 while(string[x]!='\0')
                                                     {
                                                       if(string[x]==' ')
                                                        {    
                                                           l=strlen(string); 
                                                           for(k=l-1;k>=x+1;k--)
                                                              string[k+1]=string[k];
                                                            string[l+1]='\0';
                                                            string[x]='\\';
                                                            string[x+1]=' ';
                                                             x+=2;
                                                         }
                                                          else x++;
                                                     }
                                                 if(color==0)
                                                   {
                                                       printf("\e[0;34m  %s",string);
 	                                               printf("\e[0;32m");
                                                    }
                                                 else  printf("   %s",string); 
                                           }

                                     }
                                   else
                                       {
                              /* Get entry's information. */
				char sss[10000];
				strcpy(sss,s);
				strcat(sss,"/");	
				strcat(sss,files[i-1]->d_name);
				
                           if (lstat(sss, &statbuf) == -1) {
                                perror(files[i-1]->d_name);continue; }

                  /* Print  type */
                
                     switch (statbuf.st_mode & S_IFMT)
                                    {
                               case S_IFDIR:  printf("d");break;
                               case S_IFLNK:  printf("l");break;
                               case S_IFREG:  printf("-");break;
                               default:       printf("u");break;
                                            }
        
                 /*print permissions*/
 
                   switch (statbuf.st_mode & S_IRWXU) 
                             {
                              case 00400:  printf("r--");break;
                              case 00200:  printf("-w-");break;
                              case 00100:  printf("--x");break;
                              case 00600:  printf("rw-");break; 
                              case 00300:  printf("-wx");break; 
                              case 00500:  printf("r-x");break; 
                              case 00700:  printf("rwx");break; 
                              default:printf("---");break;
                             }
                  switch (statbuf.st_mode & S_IRWXG) 
                             {
                              case 00040:  printf("r--");break;
                              case 00020:  printf("-w-");break;
                              case 00010:  printf("--x");break;
                              case 00060:  printf("rw-");break; 
                              case 00030:  printf("-wx");break; 
                              case 00050:  printf("r-x");break; 
                              case 00070:  printf("rwx");break; 
                              default:printf("---");break;
                             }
                  switch (statbuf.st_mode & S_IRWXO) 
                           {
                             case 00004:  printf("r--");break;
                             case 00002:  printf("-w-");break;
                             case 00001:  printf("--x");break;
                             case 00006:  printf("rw-");break; 
                             case 00003:  printf("-wx");break; 
                             case 00005:  printf("r-x");break; 
                             case 00007:  printf("rwx");break; 
                             default:printf("---");break;
                           }
              
                 /*Print out links*/
                 printf("%4d", statbuf.st_nlink);

                  /* Print out owner's name if it is found using getpwuid(). */
                  if ((pwd = getpwuid(statbuf.st_uid)) != '\0')
                      printf(" %-8.8s", pwd->pw_name);
                  else
                      printf(" %-8d", statbuf.st_uid);

                  /* Print out group name if it is found using getgrgid(). */
                  if ((grp = getgrgid(statbuf.st_gid)) != '\0')
                      printf(" %-8.8s", grp->gr_name);
                  else
                      printf(" %-8d", statbuf.st_gid);

                  /* Print size of file. */
                  printf(" %9jd", (intmax_t)statbuf.st_size);

                  tm = localtime(&statbuf.st_mtime);

                  /* Get localized date string. */
                  strftime(datestring, sizeof(datestring), nl_langinfo(D_T_FMT), tm);

                 
                   if(flag[4]!=1)
                     {       //printf("color=%d",color);
                         if(color==0){
                                 printf(" %s \e[0;34m%s\n", datestring, files[i-1]->d_name);//check color and print
                                 printf("\e[0;32m");
                                  }
                          else printf(" %s %s\n", datestring, files[i-1]->d_name);
                        } 
                    else
                      {
                          char string1[10000];
              int x1=0,l1,k1;
              strcpy(string1,files[i-1]->d_name);
              while(string1[x1]!='\0')
                   {
                      if(string1[x1]==' ')
                        {    
                              l1=strlen(string1); 
                             for(k1=l1-1;k1>=x1+1;k1--)
                                 string1[k1+1]=string1[k1];
                              string1[l1+1]='\0';
                               string1[x1]='\\';
                               string1[x1+1]=' ';
                               x1+=2;
                         }
                        else x1++;
                   }
            if(color==0){
                                 printf(" %s \e[0;34m%s\n", datestring, string1);//check color and print
                                 printf("\e[0;32m");
                                  }
                          else printf(" %s %s\n", datestring, string1);
                                                        
                       }              
          }


     }
printf("\n");
}

/*Recursive*/
void opt_ls_print_r(char *s) 
              {           
                     long long int count,i; 
                     struct stat statbuf;
                     struct dirent **files;
                     struct passwd  *pwd;
                     struct group   *grp;
                     struct tm      *tm;
                     char            datestring[256];
                      pointer=s;
		  /*scandir returns the number of directories*/
                   if(flag[0]==0&&flag[3]==0)count=scandir(s, &files, file_select, alphasort);
                   if(flag[0]==0&&flag[3]==1)count=scandir(s, &files, file_select, timesort);
                   if(flag[0]==1&&flag[3]==0)count=scandir(s, &files, file_select_all, alphasort);
                   if(flag[0]==1&&flag[3]==1)count=scandir(s, &files, file_select_all, timesort);
                

                    if(k>0)
		       printf("%s:\n",s);
                             k=1;

                     if(count <= 0)
			 return;   
                    
	                      
                     
                                for(i=1;i<count+1;i++) 
                                    {    color=check_color(s,files[i-1]->d_name);
 
                                          if(flag[1]==0)
                                       { 
                                           if(flag[4]!=1)
                                              {
                                                 if(color==0){
                                                        printf("\e[0;34m  %s\n", files[i-1]->d_name);
 	                                                printf("\e[0;32m");
                                                             }
                                                  else  printf("  %s\n", files[i-1]->d_name);


                                               }
                                           else
                                          {                                 
              char string[10000];
              int x=0,l,k;
              strcpy(string,files[i-1]->d_name);
              while(string[x]!='\0')
                   {
                      if(string[x]==' ')
                        {    
                              l=strlen(string); 
                             for(k=l-1;k>=x+1;k--)
                                 string[k+1]=string[k];
                              string[l+1]='\0';
                               string[x]='\\';
                               string[x+1]=' ';
                               x+=2;
                         }
                        else x++;
                   }
             if(color==0)
         {
           printf("\e[0;34m  %s",string);
 	   printf("\e[0;32m");
         }
else  printf("   %s",string);
                                                        
                                }
                                     }
                                   else
                                       {
                              /* Get entry's information. */
				char sss[10000];
				strcpy(sss,s);
				strcat(sss,"/");	
				strcat(sss,files[i-1]->d_name);
				
                           if (lstat(sss, &statbuf) == -1) {
                                perror(files[i-1]->d_name);continue; }

                  /* Print  type */
                
                     switch (statbuf.st_mode & S_IFMT)
                                    {
                               case S_IFDIR:  printf("d");break;
                               case S_IFLNK:  printf("l");break;
                               case S_IFREG:  printf("-");break;
                               default:       printf("u");break;
                                            }
        
                 /*print permissions*/
 
                   switch (statbuf.st_mode & S_IRWXU) 
                             {
                              case 00400:  printf("r--");break;
                              case 00200:  printf("-w-");break;
                              case 00100:  printf("--x");break;
                              case 00600:  printf("rw-");break; 
                              case 00300:  printf("-wx");break; 
                              case 00500:  printf("r-x");break; 
                              case 00700:  printf("rwx");break; 
                              default:printf("---");break;
                             }
                  switch (statbuf.st_mode & S_IRWXG) 
                             {
                              case 00040:  printf("r--");break;
                              case 00020:  printf("-w-");break;
                              case 00010:  printf("--x");break;
                              case 00060:  printf("rw-");break; 
                              case 00030:  printf("-wx");break; 
                              case 00050:  printf("r-x");break; 
                              case 00070:  printf("rwx");break; 
                              default:printf("---");break;
                             }
                  switch (statbuf.st_mode & S_IRWXO) 
                           {
                             case 00004:  printf("r--");break;
                             case 00002:  printf("-w-");break;
                             case 00001:  printf("--x");break;
                             case 00006:  printf("rw-");break; 
                             case 00003:  printf("-wx");break; 
                             case 00005:  printf("r-x");break; 
                             case 00007:  printf("rwx");break; 
                             default:printf("---");break;
                           }
              
                 /*Print out links*/
                 printf("%4d", statbuf.st_nlink);

                  /* Print out owner's name if it is found using getpwuid(). */
                  if ((pwd = getpwuid(statbuf.st_uid)) != '\0')
                      printf(" %-8.8s", pwd->pw_name);
                  else
                      printf(" %-8d", statbuf.st_uid);

                  /* Print out group name if it is found using getgrgid(). */
                  if ((grp = getgrgid(statbuf.st_gid)) != '\0')
                      printf(" %-8.8s", grp->gr_name);
                  else
                      printf(" %-8d", statbuf.st_gid);

                  /* Print size of file. */
                  printf(" %9jd", (intmax_t)statbuf.st_size);

                  tm = localtime(&statbuf.st_mtime);

                  /* Get localized date string. */
                  strftime(datestring, sizeof(datestring), nl_langinfo(D_T_FMT), tm);

                  if(flag[4]!=1)
                       {
                            if(color==0){
                                    printf(" %s \e[0;34m%s\n", datestring, files[i-1]->d_name);//check color and print
                                    printf("\e[0;32m");
                               } 
                            else printf(" %s %s\n", datestring, files[i-1]->d_name);
                      }             

                        
                   else
                      {
                          char string1[10000];
              int x1=0,l1,k1;
              strcpy(string1,files[i-1]->d_name);
              while(string1[x1]!='\0')
                   {
                      if(string1[x1]==' ')
                        {    
                              l1=strlen(string1); 
                             for(k1=l1-1;k1>=x1+1;k1--)
                                 string1[k1+1]=string1[k1];
                              string1[l1+1]='\0';
                               string1[x1]='\\';
                               string1[x1+1]=' ';
                               x1+=2;
                         }
                        else x1++;
                   }
              if(color==0){
                 printf(" %s \e[0;34m%s\n", datestring, string1);//check color and print
                 printf("\e[0;32m");
                          }
              else printf(" %s %s\n", datestring, string1);
                                                        
                       }              
              }//else


        }//for
                                   
                      for(i=1;i<count+1;i++)
                                 {
                                      if(strcmp(".",files[i-1]->d_name)!=0&&strcmp("..",files[i-1]->d_name)!=0 )
                                        {
                                           char path[10000];
                                           strcpy(path,s);
                                           strcat(path,"/");
                                          strcat(path,files[i-1]->d_name);
                                        if (lstat(path, &statbuf) == -1) 
                                             {
                                                perror(files[i-1]->d_name);
                                                    continue; 
                                             }


                                          switch (statbuf.st_mode & S_IFMT)
                                            {
                                               case S_IFDIR:opt_ls_print_r(path); break;
                                               default:break;
                                            }
                                      }
                                 }
                           return;
                                     
               }



/*filter1: which dont give . and ..*/
int file_select(struct direct   *entry)
    {
       if ((strcmp(entry->d_name, ".") == 0)||(strcmp(entry->d_name, "..") == 0)|| (entry->d_name[0]=='.'))
						 return (FALSE);
				      else
				                 return (TRUE);
    }


/*filter2: which give all*/
int file_select_all(struct direct   *entry)
    {
       if ((strcmp(entry->d_name, ".") == 0)||(strcmp(entry->d_name, "..") == 0))
						 return (TRUE);
				      else
				                 return (TRUE);
    }

/*sorting on the last modification time*/
int timesort(const struct dirent **a, const struct dirent **b) 
       {
               struct stat statbuf1,statbuf2;
                 char path1[10000],path2[10000];
	           strcpy(path1,pointer);
		   strcat(path1,"/");	
		  strcat(path1,(*a)->d_name);
                  strcpy(path2,pointer);
		   strcat(path2,"/");	
		  strcat(path2,(*b)->d_name);
               lstat(path1,&statbuf1);
               lstat(path2,&statbuf2);
                 if(statbuf1.st_mtime>statbuf2.st_mtime)
                      return 0;
                  else
                      return 1;
       }  
/*color function for checking the regular files or directory*/
int check_color(char *s,char file[])
  {          int color;
            struct stat statbuf;
              char path[10000];
                strcpy(path,s);
                strcat(path,"/");
                strcat(path,file);
            lstat(path,&statbuf);
            switch(statbuf.st_mode & S_IFMT)
                                    {
                               case S_IFDIR:color=0;break;
                               case S_IFREG:color=1;break;
                               default:color=2;break; 
                                     }
      return color;
 }
