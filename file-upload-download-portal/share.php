<?php
                      
          /** This file is used to provide user to share own
            *file on server.
            *
            * @file share.php
            * @author Amit Kumar Rai
            * @version 1.0
            */
      

                  
         /*Starting session*/
           session_start();
           session_register('logged_in');
           require('common_functions.php');

       /**  Following function take the filename
         *  and username and send it to other
         *  php file for sharing.  
         */
function share()
{
 ?>
 <html>
        <head>
               <meta http-equiv="Content-type" conitent="text/html;charset=UTF-8" />
               <title>Sharing of file</title>
               <link rel="stylesheet" type="text/css" href="share.css" />
       </head>
        <body>
                    
              <?php
                  
                       $username=get_session('logged_in');
                       $con = mysql_connect("localhost","test_user","12345");
                       $query1="select name from test_database.upload where username='$username'";  
                       $query2="select username from test_database.user";
              ?>

            <div id="header">
                   <span class="zz">Share your files</span>
            </div>
               
           <form  name="form" method="post" action="share1.php">
               <div id="left">
                    <span class="yy">files</span><br/></br>  
                         <?php  
                                     $result=mysql_query($query1);
                                     while($row=mysql_fetch_array($result)) {?>
            <input type="checkbox" name="files[]" value="<?php echo "{$row['name']}";?>"/><?php echo "{$row['name']}";?><br/>
                        <?php } ?>
               </div>
                         
               <div id="right">
                    <span class="xy">users</span><br/></br> 
                        <?php 
                                   $result=mysql_query($query2);
                             while($row=mysql_fetch_array($result)) { if("{$row['username']}"!="$username") { ?>
        <input type="checkbox" name="users[]" value="<?php echo "{$row['username']}";?>"/><?php echo "{$row['username']}";?><br/>
                        <?php }  }  ?>
               </div>
                       
                <div>
                    <span class="xx"><input type="submit" name="submit" value="share"></span>
                </div>
         </form>
   <?php mysql_close($con);?>
<div id="link"><a href="welcome.php">&lt-- back to desk</a></div>
    </body>
</html>
<?php 
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
                 share();
             }
}
main();
?>
