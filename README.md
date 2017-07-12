# mercari-android-test
For Technical interview 

## Description

The App was pretty straight forward to implement

I have used MVP design patterns at activity level. Its good for readability and clarity when you are dealing with application having lot of activities and with complex activities 

BehavioralSubject 
a advantage of using BehavioralSubject is it also acts as a cache for the data received from endpoint. And it helps in making data fetch and display almost null free. 
Plus presenter just hast to subscribe to this subject if anything in the app causes the data to change presenter automatically updates the list.
It gives a nice flow to the app as it implements observable design pattern between the data and the view.

Dagger
    I had finished the app well within the given 2 hours of time. 
    I have a 2 ProductManager classes one is implemented with dagger and one without. I read that user of dagger is encouraged and thats why I added that part later.
    I did not remove the old manager and can be found in the package named managers
