package library.borrow;

import java.time.LocalDate;

public record BorrowResponse(
    Long id,
    Long collectionId,
    String memberEmail,
    LocalDate dueDate
) {
    public static BorrowResponse from(Borrow borrow) {
        return new BorrowResponse(
            borrow.getId(),
            borrow.getCollection().getId(),
            borrow.getMember().getEmail(),
            borrow.getDueDate()
        );
    }
} 