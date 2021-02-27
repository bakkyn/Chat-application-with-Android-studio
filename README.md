# Chat application with Android studio

This project involves making the basic design for a chat application. The processes were made using Android studio. <br>
The file layout within the scope of the project is as follows. <br>

<img src="https://github.com/bakkyn/Chat-application-with-Android-studio/blob/main/results/1.png" alt="" width="200" height="200" style="float:left">


Android studio file structure is more complicated than usual .app folder module. Build contains bulild files. Libs maintain libraries. The src folder contains the Java, res, and AndroidManifest files. Build.gradle each
one for the module and one for the whole project.

This project was my first time working with Android Studio and I must say that I was dealing with errors rather than coding the project. You have to be very patient at this stage :D Take a deep breath and and turn on a long relaxing rain background music, because you may need to try to find solutions by searching for errors on all platforms you can find. 

That's why I tried to explain all the steps for beginners like me as descriptively while sharing this project.

-----------------------------------------------------------------------------------------------------------------

# Explanations 
 
In the activity_main.xml file that comes ready after opening the project, the application name in app / res / value / styles.xml file to remove the action bar, where it is written, first I changed the part from .DarkActionBar to .NoActionBar.

I have organized the activity_main.xml file that creates the application login screen design as follows. I have adjusted the color and padding, that is, the space to the edges of the page, with the background = ”“ and padding = ”” properties.

Chat header color dimension seen at the start of the application is text = "" in this section.
I have set it with the textSize = "", textColor = "" properties. Also the centering of the title and will be 35 dp further from the top of the page on the specified padding value of the page The way layout_centerHorizontal = "" and android: layout_marginTop = "" properties determined by using. The width and height values were set to wrap_content so I could resize as many objects as needed, regardless of the parent.

I have an account and create new account buttons have been created. The button's width value matches the padding value specified in the RelativeLayout block by saying match_parent.
As such, the button was positioned to cover the area horizontally or vertically within the area it is located. It will write on the button and I set the button color. I used 25dp for the distance between the buttons.

The <ImageView> tag is used for the app icon. The app icon has been downloaded as a .png file. Pasted in app / res / drawable folder. It was included in the project with src = "@ drawable / chat" line. Its width and height values  were set to 150 dp. 20 dp space was left between it and the line header and moved to the middle of the page.
 
The colors and titles used throughout the project are string.xml in app / res / values and added to colors.xml files as follows so that the project parts were made to be more readable and understandable. In addition, an id value was assigned to each of the objects used with the code layout_below = "@ + id / ...". Thus, I was able to make changes depending on these parts in other transactions.

I created the init () method to set the page controls in the MainActiviy.java file according to the ids I gave in the activity_main.xml file. In this method, I assigned the btnWelcomeLogin, btnWelcomeRegister variables according to their ids.

I switched from MainActivity to loginActivity with the setOnClickListener () method.
The same code just changed the transition page to registerActivity and the other create new account button worked.


<Include in xml files of login and register pages
layout = "@ layout / actionbar_app" android: id = "@ + id / actionBarLogin" /> I added the actionbar with the line. Except for the properties used in the activity_main.xml file,
I used the <editText> block for user input on the register and login screens. With hint = "@ string / email" feature, the input type that will direct the user has been written. With the line android: inputType = "", I set the input type according to the email or password input.
 
 I accessed the actionbar in the init () I created to add the page controls, and used setSupportActionBar () to bring the actionbar to the login screen and the getSupportActionBar () setTitle () functions to assign the actionbara title. Register the same operation
I also applied it for the screen. So I activated the action bar.

I created a new adapter class. I used it to manage data to be displayed with adapters and to create controls within the viewpager. This class created for this is derived from the FragmentPagerAdapter class. Fragments start to be sorted from 0. Starting from 0, I reached the chat and friends pages in casinos. 


Database for performing operations based on user information of the application
I did its operations. I used FireBase for this. FireBase mobile and web
applications that provide access authorization, as well as keeping the data in a synchronized manner.
A cloud that makes it easy for developers while offering many features
technology.

I used Authentication, one of the services offered by FireBase. I established the connection with Firebase from the routing window on the screen. You can find many resources on the internet for this and I recommend doing it this way.

If the user is not an active user in the application, that is, login with email and password before
If not, I set it to be directed to the Register screen. For this, I defined a private FirebaseUser currentUser in MainActivity2.java. I checked whether there is an active user in the onStart method. Active with if check
If there is no user, the application was opened with the login screen, namely MainActivity.


Containing main and laucher in app / manifests / AndroidManifest.xml file
the code block is considered the main activity. I edited it as the opening screen, MainActivity2, that is, the main screen. The application will initially present the main screen to the user, but thanks to the control we made in the onStrat method, if there is no user, it will be directed from the login screen.

I reached Firebase by adding the line mAuth = FirebaseAuth.getInstance () inside the method. Oncreate method is the first block that activit starts to work on. With the .createUserWithEmailAndPassword () method in the else block, I have edited it so that you can only register with email and password. When the OnComplete () operation is completed, it has checked the success of task.isSuccessful () operation and switched between pages in mainActivity2.java

In the init method, I defined the controls in loginActivity.java using their ids as I did the controls in registerActivity, and log in to Oncreate using .onclickListener and create a new account
I set the pages. Since it will be done with the operations to be done here, I created a method named loginUser () and made the same operations in the createNewAccount method in registerActivity in this method. Other than that, I just used signInWithEmailAndPassword instead of using .createUserWithEmailAndPassword in the else block. Into init function auth = FirebaseAuth.getInstance (); currentUser = auth.getCurrentUser (); I called the active user by adding lines.

Cannot resolve method' add OnCompletionListener () '…' error as a result of these actions
got it.

I used this in toast messages in previous if and else-if but OnCompleteListener
cannot be used in the contents. Because the createNewAccount method is activityde context
It did not give an error using this because it is a type. However, fireBase auth was used on the other side. Therefore, when writing this, the register actvity could not be detected. For this reason, I specified activity as RegisterActivity.this in these sections. After fixing this error, the account
creating new account I encountered in the creation process
task.isSuccessfull () always returns false, so username email
Password information cannot be saved. It falls to else block and "error" warning is seen.
I started investigating his mistake. That the problem is caused by a coding error
I thought and did my research in this way, but your problem is
I found out it was caused by firebase rules. When the login button was activated by creating an account with email and password via Firebase, Firebase's related applications were also accepted. The password created according to the Firebase encryption rule must be at least seven characters. Task will be seen as incomplete when it has less than seven characters.

One of the emilators offered by Android Studio can be used during the application test, but this process increases the time of opening and launching the emulator as the application becomes more complex. For this reason, conducting the study test over the phone provides convenience for the developer. In order to run the application on the device, the necessary setting to be a developer is opened in the phone's settings> about the phone build number section. The developer opened after this action
I have activated the options and activated the USB debugging option.
Thus, the application can be run over the phone. Application test images are as follows.

