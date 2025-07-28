Problem Statement
Starbucks is building an internal system to track in-store customer orders, manage menu items, and generate simple business analytics. You are part of the backend engineering team tasked with designing the core logic of this system. This system will be used in a single store. It must track menu offerings, customer orders, and generate operational insights from that data.

Requirements
Customers can place orders that include one or more items from the available menu. Each order should capture when it was placed and be identifiable in the system. The menu consists of various offerings—some may be food items, others beverages—and may belong to different categories. Some items may be suitable for vegetarian customers. The store operations team also wants visibility into how the store is performing throughout the day. They expect a dashboard that summarizes sales and helps them make data-driven decisions. The dashboard should include overall revenue, an average value order value, how many vegetarian items have been sold, and which category of items is ordered the most.

Example Output
==================== STARBUCKS STORE DASHBOARD ====================
💰 Total Revenue: ₹2,185.50
🧾 Average Order Value: ₹273.19
🌿 Total Vegetarian Items Sold: 9
📚 Most Popular Category: Hot Beverage
===================================================================
Expectations
Code should reflect good object-oriented design.
Organize your solution into clean, modular components.
Do not use user input (e.g., Scanner); hardcode sample data.
