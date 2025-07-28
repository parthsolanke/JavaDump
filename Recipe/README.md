# 📄 Recipe Management System - Design Document

## 🔍 Problem Statement

The goal is to **design and implement a recipe management system** using **Object-Oriented Programming (OOP)** principles in **Java**. This system should efficiently **store**, **organize**, and **recommend** recipes based on available ingredients and user-defined tags.

The solution must adhere to **clean code principles**, utilize **Java Collections**, enforce **modular design**, and demonstrate solid application of **OOP concepts** such as:

* **Abstraction**
* **Encapsulation**
* **Inheritance**
* **Interfaces**

---

## 🧩 Functional Requirements

The system should support the following **core functionalities**:

### 1. Recipe Typing

* Support multiple **types of recipes**:

  * Vegetarian
  * Non-Vegetarian
* Each type should exhibit **distinct behaviors**, leveraging polymorphism.

### 2. Recipe Metadata Tracking

Each recipe must store the following details:

* **Name** of the recipe
* **Preparation time** (in minutes)
* **Ingredients list** (collection of strings)
* **Descriptive tags** (collection of strings)

### 3. Healthiness Evaluation

* Include logic to **evaluate the healthiness** of a recipe.
* Classification examples (based on internal logic):

  * Healthy
  * Moderate
  * Unhealthy

### 4. Recipe Recommendations

* Recommend recipes based on a **given set of available ingredients**.
* A recipe is recommended if:

  * **Ingredient match ≥ 70%** of its ingredients with the available ingredients.

### 5. Search & Sort Functionality

* Support **searching recipes** based on tags (e.g., "gluten-free").
* Provide a **sorted summary** of all recipes:

  * Sorting criteria to be defined (e.g., alphabetically, by prep time, etc.)

### 6. Output Formatting

* Ensure the system outputs recipe information in a **clean and structured format**, e.g.:

```
Recipe: Vegetable Stir Fry
Type: Vegetarian
Prep Time: 20 mins
Ingredients: [Broccoli, Carrot, Soy Sauce, Garlic]
Tags: [gluten-free, low-calorie]
Healthiness: Healthy
```

---

## 🧱 Technical Requirements

### ➤ Java-Specific Constraints

* Do **not use Scanner** or any form of runtime user input.
* Leverage **Java's Collection Framework** for managing:

  * Recipes
  * Ingredients
  * Tags

### ➤ OOP Design Requirements

The design must reflect:

* **Encapsulation**: Data should be privately held and accessible via public methods.
* **Abstraction**: High-level abstractions should be used for recipe handling.
* **Inheritance & Interfaces**:

  * Use interfaces or abstract classes where behavior needs to be shared or overridden.
  * Implement type-specific logic in derived classes.

---

## 🗃️ Suggested Class Structure (Guideline Only)

> ⚠️ **Do not implement the code here—this is purely structural.**

### 1. `Recipe` (Abstract Class or Interface)

* Common fields: name, prepTime, ingredients, tags
* Common methods:

  * `getHealthiness()`
  * `matchesIngredients(List<String>)`
  * `toString()`

### 2. `VegetarianRecipe` / `NonVegetarianRecipe` (Derived Classes)

* Extend/Implement `Recipe`
* Define specific health logic and behaviors

### 3. `RecipeManager` (Coordinator Class)

* Stores a list of all recipes
* Methods to:

  * Add new recipes
  * Recommend based on ingredients
  * Search by tag
  * Display sorted recipe summary

---

## 📊 Example Output

Below is a sample expected console output based on system behavior:

```
Recipe: Vegetable Stir Fry
Type: Vegetarian
Prep Time: 20 mins
Ingredients: [Broccoli, Carrot, Soy Sauce, Garlic]
Tags: [gluten-free, low-calorie]
Healthiness: Healthy

Recipe: Chicken Alfredo
Type: Non-Vegetarian
Prep Time: 40 mins
Ingredients: [Chicken, Cream, Pasta, Garlic]
Tags: [high-protein]
Healthiness: Moderate

--- Recipe Recommendations based on: [Chicken, Pasta, Garlic, Broccoli] ---
Chicken Alfredo

--- Recipes tagged with 'gluten-free' ---
Vegetable Stir Fry
```

---

## 🧪 Testing Guidelines

Ensure the following test cases are handled:

* Add and store recipes of different types
* Tag-based recipe filtering
* Ingredient-based recommendation (match ≥ 70%)
* Output formatting validation
* Sorting mechanism accuracy
* Health assessment logic correctness
* Behavior variation across recipe types
