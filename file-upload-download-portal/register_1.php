<?php          
                
 /** This file is used to provide new user to a sign-up form
   * in which they can fill information  according to given 
   * constraints for successful registeration.In this file
   * data filled by user for registration is validated and 
   * verified at server side,which provide elegant registration.
   *
   *
   *
   * @file register_1.php
   * @author Amit Kumar Rai
   * @version 1.0
   */
        


  /*Including the "common_functions.php" */
   require('common_functions.php');
     
     
  
  


      global  $msg1;
      global  $msg2;
      global  $msg3;
      global  $msg4;
     
      $msg1='';
      $msg2='';
      $msg3='';
      $msg4='';

 


 /** Following function is used to show the registration form
   * it contains some fields,user should fill all fields with
   * satisfying the constraints mentioned in the form.
   */   
  
function show_reg_page()
      {   
              global  $msg1;
              global  $msg2;
              global  $msg3;
              global  $msg4;
         ?>
                          <html>
                                   <head>
                                          <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
                                          <title>Register</title>
                                         <link rel="stylesheet" type="text/css" href="register.css" >
                              
                                  </head>
                                
                                  <body>
                                      <div id="stylized" class="myform">
                                        <form  name="form" method="post" action="register_1.php">
                                                <h1>Sign-up form</h1>
                                             <p>Fill the details to register</p>

                                             <label>Username<span class="star1">*</span> 
                                                <span class="small">Add your username</span>
                                             </label>
                                              <input type="text" name="username"/>
                                                                                                                                                 
                                                                                                                                                                                                                                                               

                                             <label>Password<span class="star1">*</span> 
                                                  <span class="small">Min. size 6 chars</span>
                                             </label>
                                             <input type="password" name="password"/>
                                      
                                             
                        
                                            <label>Retype Password<span class="star1">*</span> 
                                                 <span class="small"></span>
                                            </label>
                                            <input type="password" name="password1"/>
                                                 
                                                  

                                               
                                             <label>Name<span class="star1">*</span> 
                                                 <span class="small">Add your name</span>
                                            </label>
                                            <input type="text" name="name"/>
                          
                                            <label>Email<span class="star1">*</span> 
                                                 <span class="small">Add a valid address</span>
                                            </label>
                                            <input type="text" name="email" />
                              
                                           <button type="submit" >Sign-up</button>
                                    
                                       <input type="hidden" value="submit" name="submit1"/>
                                           <div class="spacer"></div>
                                      
            <span class="star"> <?php echo "$msg4";?><?php echo "$msg1";?><?php echo "$msg2";?><?php echo "$msg3";?> 
                             </span>
                                      </form>
                            <span class="star2">  <a href="login.php">&lt--Back to Home</a> </span> 
                               </div>
                          </body>
                   </html>
        <?php
  }



   /* Following function show registeration success
    * and provide a link to login page.
    */
   
   function show_reg_success()
        { ?>   
          
               <html>
                  <head>
                  <link rel="stylesheet" type="text/css" href="success.css" />
                  </head>
               <body>
                  <div id="container">
                  <span class="star1">congratualation!!!!! you are successfully registered</span>
                  <br/><br/> <a href="login.php">&lt-- back to login</a>
                  </div>
               </body>
              </html>

 <?php  }  




/** Execution starts from here first it checks that
   *  form opened first time if yes  then simply show 
   *  the sign-up page otherwise other part of function 
   *  is executed and data filled by user is validated
   *  and after successful validation it is added to
   *  the database.
   */

function main()
    {
      global  $msg1;
      global  $msg2;
      global  $msg3;
      global  $msg4;

 if(get_post('submit1')=="")
           {
  
               show_reg_page();
           }

    else{       
            
                $username=get_post('username');
                $password=get_post('password');
                $password1=get_post('password1');
                $name=get_post('name');
                $email=get_post('email');
             
           if($username!=""&&$password!=""&&$password1!=""&&$name!=""&&$email!="")
               { 
                          $con = mysql_connect("localhost","test_user","12345");
                          $query="select *from test_database.user where username='$username'";
                          $result=mysql_query($query);
                         if(mysql_fetch_array($result))  
                           {
                                 $msg1="Username is not available";             
                           }

         else if(strlen($password)<6)
                            {
                                     $msg2="password should be more than 5 character";
                            }
                else  
                     {
                        if($password!=$password1)
                          {
                              $msg3="password not matched";                                 
                           }
  
                     }
           if($msg1=='' && $msg2=='' && $msg3=='')
             {
       $query = "INSERT INTO test_database.user (username, password,name,email) "."VALUES ('$username', '$password', '$name', '$email')";
       mysql_query($query) or die('Error, query failed');
            // redirect('regsuccess.php');
               show_reg_success();
             }

           else
               {
                       show_reg_page();

               }
       
         }
         
       else
             { 
                   $msg4="All fields are mandatory"; 
                   show_reg_page(); 
             }
   }       
}
main();
?>
