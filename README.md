# PhoneContactsApp
This is a phone book app. It allows you to add/delete/edit contacts from the database (SQL).

In the database "project" a table "contacts" should be created with the following columns:
1. id (data type: serial, not null, primary key)
2. name (data type: text, not null)
3. phone (data type: text, not null)
4. email (data type: text)

The ContactsRepository class executes SQL queries (accesses directly to the database).
The ContactController class accesses the ContactsRepository and is needed to notify the user of successful or failed changes to the database. All functions return String.
The ContactService class prompts the user for the required input, passes it to the ContactController, and receives the execution result.

This application uses the libphonenumber library from Google. The archive is attached.
