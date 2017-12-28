# SharedPrefExample
SharedPreferences allows the sharing and retrieving application data using key value pair.

There are multiple ways to store data persistently in Android. One of which is via SharedPreferences which enables storing primitive data in key value pairs. This can be achieved at either activity level or application level.

Sharedpreferences only stores primitive data types. Examples of primitive data types would be:  Integers, Strings and Boolean. 

However, with the GSON library, non-primitive data can be serialized using GSON library and converted to JSON String (primitive data) and then stored in the shared preference xml file.

Examples of non-primitive data types would be: class objects, hashmap, arraylist & generic data types.
