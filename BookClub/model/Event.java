package model;


import java.util.*;

public class Event {
    private String eventName;
    private Set<Book> books = new HashSet<>();
    private Set<Member> members = new HashSet<>();
    private boolean isEventOpen;

    public Event(String eventName, Set<Book> books, Set<Member> members, boolean isEventOpen) {
        this.eventName = eventName;
        this.books = books;
        this.members = members;
        this.isEventOpen = isEventOpen;
    }

    public void addMembers(Member member) throws UnsupportedOperationException {
        checkIfEventISOpen();
        members.add(member);
    }

    private void checkIfEventISOpen() throws UnsupportedOperationException {
        if (!isEventOpen) {
            throw new UnsupportedOperationException("Event is closed for review");
        }
    }

    public void submitReview(Member ratedBy, Book book, String comment, double rating) throws InvalidReviewException, UnsupportedOperationException {
        checkIfEventISOpen();

        if (!members.contains(ratedBy)) {
            throw new InvalidReviewException(
                    "User: " + ratedBy.getName() + " is not a part of this event: " + this.eventName);
        }

        if (!this.books.contains(book)) {
            throw new InvalidReviewException(
                    "Book: " + book.getTitle() + " is not part of the event: " + this.eventName);
        }

        Optional<Review> existingReview = book.getReviews().stream()
                        .filter(review -> review.getRatedBy().equals(ratedBy))
                                .findFirst();

        if(existingReview.isPresent()) {
            throw new InvalidReviewException("User has already reviewed this book.");
        }


        book.addReview(comment, rating, ratedBy, book);
        ratedBy.increaseReputation();

    }

    public Set<Book> getBooks() {
        return books;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public boolean isEventOpen() {
        return isEventOpen;
    }
}