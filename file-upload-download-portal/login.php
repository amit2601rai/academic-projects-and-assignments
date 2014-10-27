<?php
      
 /** This file is used to provide user to a sign-in form
   * in which they have to provide username and password 
   * for successful login.
   * If username and password is matched only then user
   * can login.
   *
   * @file login.php
   * @author Amit Kumar Rai
   * @version 1.0
   */
  

   /*Starting the session*/ 
         
          session_start();
          session_register('logged_in');
        
          require('common_functions.php');
          $message='';

     
 /** following function show the 
   * login form.
   */

  function show_login_page()
      {
              global $message;
           ?>     
                    <html>
                         <head>
                         <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
                                  <title>Login</title>
                         <link rel="stylesheet" type="text/css" href="login.css" />
                         </head>
                   <body>
                       <div id="Imagepart">
                       <img src="1.jpg" alt="image"/><br/><br/>
                       <h2><i>Welcome to File Sharing System</i></h2>
                       </div>
                      <div id="Content">
                           <form  name="form" method="post" action="login.php">
                           <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                           <b>USERNAME:</b><br/><input type="text" name="username1" value="" size="30"><br/><br/>
                           <b>PASSWORD:</b><br/><input type="password" name="password1" value=""size="30"><br/><br/>
                             <a href="register_1.php">new user</a>   &nbsp&nbsp&nbsp&nbsp&nbsp
                              <input type="submit" name="submit1" value="Login"style="width:80px"><br/>
                          </form>
                    <span class="x"><?php echo $message; ?></span>


                       </div>

                    </body>
                    </html>
        <?php
     }


  /**  Execution starts from here and first time 
    *  simply call function "show_login_page()".
    *  password and username is checked in this 
    *  function and after successful login session
    *  variable is set as username,that prevent
    *  the direct url access.
    */ 


 function main()
   {
        global $message;

 
          $username1=get_session('logged_in');
         if($username1!="")
                 redirect('welcome.php');
         else if(get_post('submit1')=="")
         {
       
               show_login_page();
         }
        else
        {
           
                $username1=get_post('username1');
                $password1=get_post('password1');
            $con = mysql_connect("localhost","test_user","12345");
            $query = "SELECT name,password FROM test_database.user where username='$username1' and password='$password1'";
            $result = mysql_query($query) or die('Error, query failed');
             mysql_query($query) or die('Error, query failed');
            if(mysql_num_rows($result) == 0)

             {
                       
                       $message="Sorry! Username and password do not match.<br/>\n";
                       show_login_page();
             }
            else
               {
                           $_SESSION['logged_in']=$username1;
                            redirect('welcome.php');
               }
            mysql_close($con);
        }

}
main();
?>

