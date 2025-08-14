Interstellar Cargo Network:

The system must be capable of:
Managing multiple types of cargo ships with different capabilities and constraints.
Handling incoming cargo deliveries, each with its own weight, priority, and description.
Scheduling cargo to suitable ships based on capacity, availability, and priority.
Keeping track of pending deliveries and completed shipments.
Providing a search feature to filter cargo records based on flexible, custom conditions.
Tracking operational metrics such as total deliveries completed.
Handling error conditions when resources or deliveries cannot be found.
The solution should:
Support different ship categories with shared core behaviors and unique features.
Make the design choice of how to represent ships so the system is both extensible and maintainable.
Manage cargo and ships using appropriate data structures.
Process deliveries in a way that respects priority levels and resource constraints.
Be robust enough to handle exceptional cases gracefully.

classes:
ship - capacity, availability, priority
cargo - weight, priority, description, ispending

manager deliveryQueue, completedDeliveries
