### 🔍 **Problem Statement**

You are building a **Workload Optimizer System** for a large software consulting company. The company handles hundreds of client projects. Each project requires a set of employees to be assigned based on skill match, availability, and priority. Your job is to analyze employee allocation, project load, and generate optimization insights.

---

## 📂 **Data Model**

You’ll be working with the following entities:

### 🧑 `Employee`

* `int id`
* `String name`
* `String department`
* `List<String> skills` – e.g., `["Java", "AWS", "Docker"]`
* `Map<String, Integer> weeklyAvailabilityHours` – key is `weekNumber` (e.g., `"2025-W30"`), value is number of available hours that week

### 📁 `Project`

* `int projectId`
* `String clientName`
* `int priority` (1 = highest, 5 = lowest)
* `Set<String> requiredSkills`
* `Map<String, Integer> requiredHoursPerWeek` – same format as above

### 📋 `Assignment`

* `int employeeId`
* `int projectId`
* `Map<String, Integer> hoursPerWeek` – how many hours this employee is assigned to this project per week

---

## ✅ **Challenging Tasks & Requirements**

### 1. 🔄 **Skill Matching: Recommend Employees for a Project**

> Given a `Project`, recommend top 3 employees (by match %) who:
>
> * Are available (have at least 10 hours free per week)
> * Match the most required skills
> * Are in the same or a compatible department
>
> **Use:** Streams, filtering, sorting, collecting, optional, custom comparator
> **Bonus:** Return as `List<EmployeeMatchResult>` with fields: `employee`, `matchingSkillCount`, `availableHoursNextWeek`.

---

### 2. ⏳ **Project Load Balancer**

> For a given week:
>
> * Compute how many total hours are required across all projects.
> * Compute how many hours are assigned per employee that week.
> * Identify employees under-utilized (< 60% capacity) and over-utilized (> 100%).

> **Use:** `Map<String, List<Project>>`, Streams, `Collectors.groupingBy`, flatMaps
> **Return:** Three maps:
>
> ```java
> Map<String, Integer> totalProjectHoursPerWeek
> Map<Integer, Integer> employeeHoursPerWeek
> Map<String, List<Employee>> loadStatusToEmployees // keys: "Underloaded", "Overloaded"
> ```

---

### 3. 🧠 **Departmental Skill Intelligence**

> For each department, compute:
>
> * Set of all distinct skills.
> * Top 3 most common skills (frequency across employees).
> * Department-wide availability for next 2 weeks.

> **Use:** Streams, grouping, flatMapping, counting, sorting
> **Hint:** Build `Map<String, DepartmentSkillSummary>`

---

### 4. 🔍 **Find Critical Projects (Based on Understaffing Risk)**

> A project is at risk if:
>
> * For any week, the total assigned hours < 80% of required.
>
> Return: `List<ProjectRiskReport>` showing:
>
> * projectId
> * week
> * required hours
> * assigned hours
> * missing hours

> **Use:** Nested grouping, reduction, optional
> **Bonus:** Streamlining nested Maps

---

### 5. 🧾 **Employee Overbooking Validator**

> Detect any employee who is:
>
> * Assigned to > 2 projects in the same week **OR**
> * Assigned > 40 hours in any week
>
> Return: `Map<Integer, List<String>>` – Key: employeeId, Value: list of weekNumbers where rule was violated.

> **Use:** Complex mapping, filtering, allMatch/anyMatch

---

### 6. 🧩 **Suggest Skill Development Tracks**

> For each employee:
>
> * Compare their skills with the most in-demand skills across all projects.
> * Suggest top 2 missing skills they should learn.
>
> **Hint:** Use frequency of required skills across all projects.

> **Use:** Flattening, grouping, difference in sets, custom sorting
> **Return:** `Map<Employee, List<String>>`

---

### 7. 📦 **Immutable Planning Snapshot Generator**

> Design an **immutable** class `PlanningSnapshot` which:
>
> * Captures all employee assignments for a given week.
> * Prevents mutation.
> * Offers a method: `getUnassignedEmployees()` and `getOverbookedProjects()`

> **Focus:** Immutability via constructors, unmodifiable collections, clean design.

---

### 8. 🧪 **Write Unit Tests for All Major Scenarios**

> Use `JUnit` and `Mockito` (if applicable) to test:
>
> * Edge cases (no availability, full match, missing data)
> * Logic-heavy methods (skill matching, overbooking)
> * Data transformations (grouping and map outputs)

> **Practice:** Solid TDD, test coverage for Streams-heavy logic.

---

## 📌 Bonus Stretch Tasks

### 🚀 Task: Optimize Allocation Using Streams Only

> Attempt to assign employees to projects based on best skill match + availability, avoiding overbooking.
> Challenge: Do not use traditional loops, only Streams and Collectors.

---

### 🗺️ Task: Department Load Visualization

> Create a `Map<String, Map<String, Integer>>`:
>
> * Key 1: department
> * Key 2: week
> * Value: total assigned hours
