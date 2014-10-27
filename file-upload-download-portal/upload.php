<?php 
   
 /** This file is used to  provide users to a upload facility
   * in which they have to browse the any file from their
   * hardisk and upload it.
   * 
   *@file upload.php
   * @author Amit Kumar Rai
   * @version 1.0
   */


   /*Starting the session*/

           session_start();
           session_register('logged_in');
           require('common_functions.php');
  
  
/*Show the upload success */

 function upload_success()
     { ?>

           <html>
             <head>
                 <link rel="stylesheet" type="text/css" href="success.css" />
             </head>
             <body>
               <div id="container">
                   <span class="star1">your file is successfully uploaded</span>
                   <br/><br/><a href="welcome.php"> &lt-- back to desk</a>
                   <br/><br/> <a href="upload.php"> &lt -- back to upload</a>
              </div>
            </body>
         </html>
<?php }


 
/*show the upload form*/
 
 function upload_form()
       { 
  ?>
           
             <html>
               
                 <head>
                   <link rel="stylesheet" type="text/css" href="upload.css" />
                </head>
               
               <body>
                    <div id="header"><b>Upload File</b></div>
                    <div id="container">
                       <form action="upload.php" method="post"enctype="multipart/form-data">
                           <label for="file">Filename:</label>
                           <input type="file" name="file" id="file" />
                           <br/>
                          <input class="shift" type="submit" name="submit" value="Submit" />
                      </form>
                   </div>
                  <div id="link"><a href="welcome.php">&lt--back to desk</a></div>
              </body>
         </html>
<?php 

}
  

 /**  This function in main part of this file
   *  it performs connectivity to database and
   *  add file to the database.
   */

 function upload()
  {
   
     $username=get_session('logged_in'); 
     $fileName = $_FILES["file"]["name"];
     $tmpName  = $_FILES["file"]["tmp_name"];
     $fileSize = $_FILES["file"]["size"];
     $fileType = $_FILES["file"]["type"];

    $fp= fopen($tmpName, 'r');
    $content = fread($fp, filesize($tmpName));
    $content = addslashes($content);
    fclose($fp);

    if(!get_magic_quotes_gpc())
    {
      $fileName = addslashes($fileName);
    }

    $con = mysql_connect("localhost","test_user","12345");
    $query1="select count from test_database.counter where filename='$fileName';";
     
       
   
       $result=mysql_query($query1)or die('Error,query failed'); 
        if(mysql_num_rows($result)!= 0)//means there exists the file of that name....count append and finally increase the count
               {
                 //change filename and update count   
                 $row = mysql_fetch_array($result);
                 $counter1= $row['count'];
                 $counter1=$counter1+1;
                 $query2 = "update test_database.counter  set count=$counter1 where filename='$fileName'";
               
             
                 mysql_query($query2) or die('Error, query failed');
                 $string="_";
                 $fileName=$fileName.$string;
                 $string="[";
                 $fileName=$fileName.$string;   
                 $fileName=$fileName.$counter1;
                 $string="]";
                 $fileName=$fileName.$string;
               }
        else{
                
                 $query2 = "INSERT INTO test_database.counter (filename, count) "."VALUES ('$fileName', 1)";
                 mysql_query($query2) or die('Error, query failed');

            }

      $query = "INSERT INTO test_database.upload (name, size, type, content,username ) ".
      "VALUES ('$fileName', '$fileSize', '$fileType', '$content','$username')";
     
     mysql_query($query) or die('Error, query failed');
     mysql_close($con);
     
     upload_success();
}

   
  /** Execution starts from here this fucntion
    * perform checking of session as well as 
    * control the execution of other function.
    */

 function main()
   {

         
                $username1=get_session('logged_in');
                if($username1=="")
                   {
                      redirect('login.php');
                   }
                else if(get_post('submit')=="")
                   {
                       upload_form();
                   }
                else
                   {
                      upload();
                   }
  }
main();
?> 
