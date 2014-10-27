<?php
             
          /** This file is used to provide user to download own
            *file from server.
            *
            * @file download_1.php
            * @author Amit Kumar Rai
            * @version 1.0
            */

               
         /*starting session*/
               
                  session_start();
                  session_register('logged_in');
                  require('common_functions.php');
      
         
     
       /** In this function file content is retrieved
         * from the database from id.
         */
  
function download_my()
  {

   if(isset($_GET['id']))
       {
  // if id is set then get the file with the id from database
      mysql_connect("localhost","test_user","12345");
     $id    = $_GET['id'];
     $query = "SELECT name, type, size, content " .
         "FROM test_database.upload WHERE id = '$id'";
     $result = mysql_query($query) or die('Error, query failed');
     list($name, $type, $size, $content) = mysql_fetch_array($result);
     header("Content-length: $size");
     header("Content-type: $type");
     header("Content-Disposition: attachment; filename=$name");
     echo $content;
     mysql_close($con);
exit;
     }  
}


   /**  Execution start from here its check
     *  session and control the execuion of
     *  other function.
     */

function main()
  {
     $username1=get_session('logged_in');

         if($username1=="")
               {
                 redirect('login.php');
               }
        else {
                 download_my();
             }
}

main();
?>
