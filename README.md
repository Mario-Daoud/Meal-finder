# Meal App
<h4>Re-exam Android Development 2022-2023</h4>

## Assignment
You create an app where you can look up recipes. We use the API: https://www.themealdb.com/api/json/v1/1/search.php?f=\(startletter)

We start with a login screen.
Since we don't use a DB, you have to create an array of users at the start that you can use to check if you are logged in correctly.

In the Array you provide the following users:
Username: admin
Password: admin

You can store the array in a single barrel and have it available everywhere.
You show an error message I leave a field empty or when username/password is not correct.

After logging in you will see the next screen where you can enter the first letter of the recipe and call the API.
You can show the result in a recycler view on the same screen.
Make use of data binding, also in your adapter class when you click a recipe you get the details on another screen.
The back button returns you to the previous screen

## Preview
### Splash screen & Login page
<img src="https://github.com/Mario-Daoud/s_meals/assets/113902874/da5edfe1-c41f-480d-9bcf-506eff6ea0f1" alt="screen" width="200px" height="auto">
<img src="https://github.com/Mario-Daoud/s_meals/assets/113902874/7b223023-5d2b-42ee-85eb-a5157584b329" alt="screen" width="200px" height="auto">

### Search page
<img src="https://github.com/Mario-Daoud/s_meals/assets/113902874/11eefc29-c1b9-431f-89dd-207d26fa9c0a" alt="screen" width="200px" height="auto">

### Recipe page
<img src="https://github.com/Mario-Daoud/s_meals/assets/113902874/a8ac464b-fd0a-4c0b-ad9e-0ec68660d8b3" alt="screen" width="200px" height="auto">
