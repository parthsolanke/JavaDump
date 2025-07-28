## 🧠 Problem Statement: **The Secret Book Club**

### 🌟 Narrative

You're building a backend system for an invite-only **secret book club** that runs monthly events. Each event involves book reviews, member invitations, book rankings, and a member reputation system.

The club has rules:

1. A **member** can be invited only once per event.
2. A **book** can be reviewed only once per event per member.
3. Members can **rank** books, and the **ranking list must always be sorted naturally** (alphabetical by title).
4. Members build **reputation** based on their participation, and reputation scores must be **uniquely stored and quickly queried**.
5. If a member submits an invalid review (e.g., reviewing a book not part of the event), a **custom checked exception** must be thrown.
6. Event results are **immutable** after the event is closed.
7. You must provide **stream-based reports**, such as:

    * Top N members by reputation
    * Books ranked above a certain threshold
    * Flat list of all reviews from all members across all events

---

## 🛠️ Core Classes (You design them!)

### Entities to model:

* `Member`
* `Book`
* `Review`
* `Event`
* `BookClub` (manager class)

---

### 📌 Functional Requirements:

#### ✅ 1. Add/Invite Members to Events

* No duplicate members per event (`HashSet`)
* Preserve order of invitation (use `LinkedHashSet` maybe?)

#### ✅ 2. Submit Book Reviews

* Members review books during events.
* Ensure no duplicate book reviews by same member.
* Throw custom `InvalidReviewException` if rules are violated.

#### ✅ 3. Maintain Book Rankings

* Rankings stored in `TreeSet<Book>` (sorted by natural title order).
* Books must implement `Comparable` correctly.

#### ✅ 4. Reputation Tracker

* Use a `Map<Member, Integer>` to store and update reputation scores.
* Must override `equals()` and `hashCode()` properly for `Member`.

#### ✅ 5. Locking Event After Completion

* After an event is closed, its collections become **unmodifiable**.
* Any further modification attempts must result in `UnsupportedOperationException`.

---

### 🧪 Reports & Queries Using Streams

* `List<Member>` → Top 5 members by reputation.
* `List<Book>` → All books with average rating > 4.5.
* `List<String>` → Flat list of all review comments from all events.
* `Map<Book, List<Review>>` → Group reviews by book.

---

### 💡 Advanced Extras (Optional)

* Use wildcards (`<? extends Book>`) in a method like `printTopBooks(List<? extends Book>)`.
* Serialize and deserialize an event's report (use `transient` for sensitive fields).
* Support different `Comparator`s to sort books by rating or by review count.

---

## 📋 Sample Scenario

```java
BookClub club = new BookClub();
Event julyEvent = club.createEvent("July 2025");

Member alice = new Member("Alice");
Member bob = new Member("Bob");
club.inviteMember(julyEvent, alice);
club.inviteMember(julyEvent, bob);

Book book1 = new Book("The Time Machine", "H.G. Wells");
Book book2 = new Book("1984", "George Orwell");

club.addBookToEvent(julyEvent, book1);
club.addBookToEvent(julyEvent, book2);

club.submitReview(julyEvent, alice, book1, 5, "Loved it!");
club.submitReview(julyEvent, bob, book1, 4, "Great read.");
club.submitReview(julyEvent, alice, book2, 5, "Timeless classic.");

club.closeEvent(julyEvent); // Now immutable!

club.printTopReviewers();
club.printHighlyRatedBooks();
```

---

## 🎯 What You'll Practice Deeply

| Concept                   | How You’ll Use It                           |
| ------------------------- | ------------------------------------------- |
| `Comparable`              | Sorting `Book` naturally in rankings        |
| `Comparator`              | Optional: Sort by rating, review count      |
| `equals()` + `hashCode()` | `Member` and `Book` in collections          |
| `HashSet`                 | Unique members and reviews                  |
| `TreeSet`                 | Auto-sorted book list                       |
| Custom Exception          | `InvalidReviewException`                    |
| Generics + Wildcards      | In utility/reporting methods                |
| Stream API                | Reports like top N members, grouped reviews |
| Immutability              | Locking event after completion              |
| Java Modifiers            | Use of `final`, `transient`, etc.           |

---
