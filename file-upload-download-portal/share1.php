<?php

          /** This file is used to add the sharing
            * in the database.
            *
            * @file share1.php
            * @author Amit Kumar Rai
            * @version 1.0
            */

     /*starting session*/
         session_start();
         session_register('logged_in');
         require('common_functions.php');



/*Add sharing record to the database*/

function share_add()
 { ?>
<html>
<head>
<link rel="stylesheet" type="text/css" href="share2.css" />
</head>
<body>
<div id="header">Share Result</div>
<div id="print">
<?php   

       
  $username=get_session('logged_in');
  $files1='';
  $users1='';
   
       $files1 = $_POST['files'];
       $users1 = $_POST['users'];
  if(empty($files1))
       {
         // echo("You didn't select any file.");
           redirect('sharefail.php');
         //    share_fail();
       }
   else if(empty($users1))
      {
         // echo("You didn't select any user.");
           redirect('sharefail.php');
         //   share_fail();
      }

    else{
       $con = mysql_connect("localhost","test_user","12345");
          
      $N = count($users1);
      $M = count($files1);


    for($i=0; $i < $N; $i++)
     {
 
      for($j=0; $j < $M; $j++)
        {
           $query1="select *from test_database.share where filename='$files1[$j]' and user='$users1[$i]'";
           $result=mysql_query($query1);
           if(!mysql_fetch_array($result))
               {
                  $query="INSERT INTO test_database.share values('$username','$files1[$j]','$users1[$i]')";    
                   mysql_query($query);
                  echo "$files1[$j] successfully shared to $users1[$i]<br><br> ";

               }
          else    
               { 
                 
                 echo "$files1[$j] already shared to $users1[$i]<br><br> ";
              }
        }
     }

   mysql_close($con);
 }
?>

</div>
<div id="link"><a href="share.php">&lt--back to share</a></div>
</body>
</html>
<?php
}

   /**  Execution start from here its check
     *  session and control the execuion of
     *  other functions.
     */

function main()
  {
     $username1=get_session('logged_in');

         if($username1=="")
               {
                 redirect('login.php');
               }
        else {
                 share_add();
             }
}
main();
?>
