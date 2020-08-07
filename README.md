# geofencing
Using geofencing to send notifications when the user enters a building, exits a building or dwells in the building
Make sure to add your API keys in the AndroidManifest.xml
Make sure the emulator is working on your side with android google maps running in the background(a bug in the android emulator) it won't send notifications
In this code, we will create and monitor geofences. We will be using google maps to create a point of interest by using long press on map, 
this will create a marker with the required radius for the geofence. Then we will be using the latest and best #GeofencingClient to create a geofence.
The geofence events will be delivered to our own BroadcastReceiver where we will handle the triggered geofence. 
The geofence events will be delivered by notifications (using notification channels) in Android 29 and +.
