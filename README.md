# Hotel-Booking-App
A Java (Swing) based project to build a hotel booking app. The app lets users create accounts, book hotel tooms in various cities across India and cancel/modify their bookings. Built using Java (Swing) + a mySQL Database towards partial credit towards CS F213, the Object Oriented Programming Course. Made by me, @vamsin and @shantanu23gupta. Was mostly a last minute job.

# Possible Improvements/Fixes

These are thing that could be done to improve the app:

- There might be a bug in the checkAvailability() function that checks to see if rooms are available between the given dates
- Check all user input for special characters to prevent SQL Injection attacks. 
- The cancellation policy is that if it's <=2 day before check_in_date, 50% money should be detected. The popup showing this message doesn't work. 
- Implement a better reviews system that does not recalculate every single time. 
- User Account page: Add exception handling to prevent errors from happening when users try to click cancel/modify functions without selecting an option.
