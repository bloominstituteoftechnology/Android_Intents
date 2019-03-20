# Android_Intents

#### Requirements
For this project, you will be creating a multi-page app. The first page will allow the user to import images and list them by name. The second page will allow the user to view and edit details of a single image (these are details that you choose and do not need to be permanent). The third will allow the user to view the selected image in fullscreen.  

This will encompass many of the skills you have developed over the Intro to Android precourse.  
We'll give you a few tips on how to proceed.
	  
### Part 1 - Create an Android Studio Project

1. Create a new Android Studio project.
2. Name the project "Image Viewer".
3. Make sure that the target API level is below that of your testing environment.

### Part 2 - Configure the layout for the Add and List Images activity

1. Open the app's activity_main.xml file.
2. Change the parent viewgroup to a `LinearLayout`.
> Set the `orientation` attribute to `vertical` to best utilize the screen real-estate.
3. Add a `ScrollView` to list all previously viewed images. Give it a `LinearLayout` child.
4. Add a `Button` so the user can select an image to add to the list.
5. Add IDs to all the views that will need to be accessed in the code.

### Part 3 - Create an ImageData Class

1. Create a class to store desired data from the retrieved image.
> The only required data is a name and a `Uri` stored as a String.
> Convert a `Uri` to a string with `.toString()` method and back with `Uri.parse(stringUri)`.  
2. Class must contain the keywords `implements Serializable` in the class signature.
> This provides more methods for the overloaded `Intent.putExtra` method to store the class' data.
3. Make all the data members `private` and create getters and setters for them.
> The `Uri` setter should convert the `Uri` to a `String` and the getter should convert it back.
> This is because a `Uri` object can't be serialized.

### Part 4 - Write a method to generate a TextView object

1. Add a `TextView` to your layout file (activity_main.xml).
2. Manipulate its attributes until you find a design that you like.
3. Write a method that will create a `TextView` object and add those attributes to it programmatically.
4. The method must accept a `String` to be the view's text attribute and an `int` which is the index where the element is stored in the list.
5. Return the `TextView` from the method.
6. To add the `TextView` to the UI, pass it to your `ScrollView`'s `LinearLayout` child's `.addView()` method.  

### Part 5 - Create an Intent to Get an Image

1. Create a listener and event handler for the add button in MainActivity.java.  
2. In the click event method, write a `ACTION_GET_CONTENT` Implicit Event that retrieves an image from the system.  
3. Broadcast that intent with a `startActivityForResult` method call.  
4. Override the `onActivityResult` method to create the `ImageData` object, add it to an `ArrayList` class data member, and have a `TextView` generated and added to your UI.  
      
### Part 6 - Test your App

1. Thoroughly test this activity before moving on.

### Part 7 - Add a ClickListener to the items in the list

1. In your `TextView` generator give the `TextView` object a listener that will get the tag from the element, use that to pull the `ImageData` object from the `ArrayList`.
2. Use `intent.putExtra()` to add the object to the intent.

### Part 8 - Build the layout for the details activity

1. Design a layout that will display details about the file.
2. Display the image somewhere in the layout.

### Part 9 - Retrieve the Object from the Intent

1. Use `getIntent()` to get the intent used to launch this activity.
2. Use the `intent.getSerializableExtra()` method to retrieve the serialized data and then cast it to `ImageData`.
> The final line of code should look something like this `myObject = (ImageData)intent.getSerializableExtra("KEY")`.

### Part 10 - Display object

1. Show the desired data in the UI.
2. Use `.setImageURI()` to get the image for your `ImageView` to the one in your `ImageData`.

### Part 11 - Test your App

1. Thoroughly test these two activities before moving on.  
  <br />
  
  
## Challenge
### Part 12 - Build Fullscreen Layout

1. Add an activity.
> You can pick a fullscreen activity from the New Android Activity wizard and adapt it to your needs, or build an empty activity with a fullscreen `ImageView` element.
2. Adapt the generated layout to fit your needs.

### Part 13 - Build an Intent to go to the next Activity

1. Build an intent to go to the next activity, but instead of passing the whole object, just pass the `String` value for the `Uri`.

### Part 14 - Add the Image to the UI

1. Use the `intent.getStringExtra()` method to retrieve the `String` `Uri` from the `Intent`.
2. Use `.setImageURI()` to update the `Uri`.
	  
### Submit
Send your completed app to your Project Manager.
